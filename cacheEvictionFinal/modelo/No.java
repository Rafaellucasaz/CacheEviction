package modelo;
import entity.Ordem;

public class No {
    private Ordem os;
	public No prox;
    public No ant;
    
    public No(Ordem os){
        this.os = os;
        prox = null;
        ant = null;
    }
    public Ordem getOs() {
        return os;
    }
    public void setOs(Ordem os) {
        this.os = os;
    }
}
