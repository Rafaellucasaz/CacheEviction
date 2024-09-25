package modelo;

import entity.Ordem;

public class Cache {
	public int tam,n;
	private Ordem tabela[];

    public Cache(int tam) {
		
		this.tam = tam;
		this.tabela = new Ordem[this.tam];
		
	}

    public int hash(int ch){
        // double A = 0.6180339887;
		// double temp = ch * A;
		// temp = temp - (int) temp;
		// return (int) (tam * temp);
		return ch % this.tam;

    }

    public boolean inserir(Ordem os) {
		int id = os.getId();
		int h = this.hash(id);
		
		while(tabela[h] != null) {
			
			if (tabela[h].getId() == id) {
				return false;
			}	
			h = (h+1) % tam;
		}
		
		if (tabela[h] == null) {
			
			tabela[h] = os;
			n++;
			
		}
		return true;
		
	}

	public Ordem buscar(int id) {
		
		int h = this.hash(id);
		int i = 0;
		while(i < tam) {
			if(tabela[h] == null){
				return null;
			}

			if (tabela[h].getId() == id) {
				return tabela[h];
			}	
			 h = (h + 1) % tam;
			 i++;
		}
		return null;
		
	}

	public void removerRandom(int i){
		tabela[i] = null;
		n--;
	}
	
	public void remover(int id){
		int h = this.hash(id);
		int i = 0;
		while(i < tam) {
			if(tabela[h] == null){
				break;
			}

			if (tabela[h].getId() == id) {
				tabela[h] = null;
				n--;
				break;
			}	
			 h = (h + 1) % tam;
			 i++;
		}
		
	}


	public void imprimirTabelaHash() {
		
		Ordem os;
		
		for(int i = 0; i < this.tam; i++) {
			
			os = this.tabela[i];
			
			System.out.print(i);
			
			if(os!= null){
				System.out.println("| Codigo: " +  os.getId() + "| Nome: "  + os.getNome() + "| Descricao: " + os.getDescricao() + "| Hora de solicitacao: " + os.getHora() + "|" );
			}
			else{
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			
		}
		
	}
}
