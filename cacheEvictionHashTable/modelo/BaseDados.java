package modelo;
import entity.Ordem;
import servidor.Servidor;

public class BaseDados {
    public int tam,n;
    private No tabela[];

    public BaseDados(int tam) {
		
		this.tam = tam;
		this.tabela = new No[this.tam];
		
	}

    public int hash(int ch){
        double A = 0.6180339887;
		double temp = ch * A;
		temp = temp - (int) temp;
		return (int) (tam * temp);
    }

    public boolean inserir(Ordem os) {
		examinarCarga();
		int id = os.getId();
		int h = this.hash(id);
		No no = this.tabela[h];
		
		while(no != null) {
			
			if (no.getOs().getId() == id) {
				return false;
			}	
			no = no.prox;

		}
		
		if (no == null) {
			
			no = new No(os);
			no.prox = this.tabela[h];
			this.tabela[h] = no;
			
		}
		return true;
		
	}

	public No buscar(int id) {
		
		int h = this.hash(id);
		No no = this.tabela[h];
		while(no != null) {
			
			if (no.getOs().getId() == id) {
				return no;
			}	
			
			no = no.prox;
		}
		return null;
		
	}

	public boolean remover(int id){
		examinarCarga();
		int h = this.hash(id);
		No no = this.tabela[h];
		No anterior = null;
		while(no != null) {
			
			if (no.getOs().getId() == id) {
				if(anterior == null){
					tabela[h] = no.prox;
					no = null;
					return true;
				}

				anterior.prox = no.prox;
				no = null;
				return true;
			}	
			
			anterior = no;
			no = no.prox;
		}
		return false;
	}

	void examinarCarga() {
		contarElementos();
		float fatorCarga = (float) n / tam;
		if(fatorCarga >= 0.90){
			Servidor.log("houve redimensionamento para cima",true);
			reorganizar(tam * 2);
		}
		else if(fatorCarga < 0.10){
			Servidor.log("houve redimensionamento para baixo",true);
			reorganizar(maior(tam / 2, 7));
		}
		
	}
		
	public void contarElementos() {
		No no;
		n = 0;
		for(int i = 0; i < tam; i++) {
			no = tabela[i];
			while(no != null) {
				no = no.prox;
				n++;
			}	
		}
	}

	void reorganizar(int tamanhoNovo) {
		No temp[] = tabela;
		tam = tamanhoNovo;
		tabela = new No[tam];
		
		for (No no : temp) {
			while(no != null) {
				reinserir(no.getOs());
				no = no.prox;
			}
		}
		temp = null;
	}

	void reinserir(Ordem os) {
		int id = os.getId();
		int h = hash(id);
		No no = tabela[h];
		while(no != null) {
			if(no.getOs().getId() == id) {
				break;
			}
			no = no.prox;
		}
		if (no == null) {
			no = new No(os);
			no.prox = tabela[h];
			tabela[h] = no;
		}
	}
			
			


	public void imprimirTabelaHash() {
		
		No no;
		
		for(int i = 0; i < this.tam; i++) {
			
			no = this.tabela[i];
			
			System.out.print(i);
			
			while (no != null) {
				System.out.print(" --> " + no.getOs().getNome());
				no = no.prox;
				
			}
			System.out.println();
			
		}
		
	}

	public void imprimirTabelaHashLog() {
		
		No no;
		
		for(int i = 0; i < this.tam; i++) {
			
			no = this.tabela[i];
			
			Servidor.log("" + i,false);
			
			while (no != null) {
				Servidor.log(" --> " + no.getOs().getId(),false);
				no = no.prox;
				
			}
			Servidor.log("",true);
			
		}
		Servidor.log("|----------------------------------------------------------------------------------------------------------|",true);
	}

	public int maior(int a,int b){
		return a > b ? a:b;
	}


}
