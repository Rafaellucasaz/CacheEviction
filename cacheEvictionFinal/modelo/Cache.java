package modelo;

import entity.Ordem;

public class Cache {

	No head = null;
	No tail = null;

	int tam;
	int cap;

	public Cache(int c){
		cap = c;
		tam = 0;
	}


	public void inserir(Ordem os){

		No no = new No(os);

		if(head == null){
			head = no;
			tail = no;
			tam++;
			return;
		}
		
		if(tam == cap){
			//cache eviction politica LRU
			tail = tail.ant;
			tail.prox = null;
			
			head.ant = no;
			no.prox = head;
			head = no;
			return;
		}


		head.ant = no;
		no.prox = head;
		head = no;
		tam++;
			
	}


	
	public Ordem buscar(int id){

		No no = head;

		while(no != null){
			if(no.getOs().getId() == id ){
				if(head!= no){
					moveForward(no);

				}
				return no.getOs();
			}
			no = no.prox;
		}

		return null;
		
	}

	public void moveForward(No no){

		if(tail == no){
			tail = tail.ant;
			tail.prox = null;
		}
		else{
			no.ant.prox = no.prox;
			no.prox.ant = no.ant;
		}

		head.ant = no;
		no.prox = head;
		head = no;
	}


	public boolean remover(int id){

		if(head == null){
			return false;
		}

		No no = head;
		
		while(no!= null){

			if(no.getOs().getId() == id){
				break;
			}
			no = no.prox;
		}

		if(no == null){
			return false;
		}
		

		if(head == tail){
			head = null;
			tail = null;
		}
		else if(head == no){

			head.prox.ant = null;
			head = head.prox;
		}
		else if(tail == no){
			tail = tail.ant;
			tail.prox = null;
		}
		else{
			no.ant.prox = no.prox;
			no.prox.ant = no.ant;

		}
		tam--;
		return true;
	}

	public void imprimirCache(){
		No no = head;
		Ordem os;
		int i = 1;
		while(no != null){
			os = no.getOs();

			System.out.print(i);
			i++;
			
			if(os!= null){
				System.out.println("| Codigo: " +  os.getId() + "| Nome: "  + os.getNome() + "| Descricao: " + os.getDescricao() + "| Hora de solicitacao: " + os.getHora() + "|" );
			}
			else{
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			
			no = no.prox;
		}
	}
}
