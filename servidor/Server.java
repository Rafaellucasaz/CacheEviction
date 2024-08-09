package servidor;

import entity.Ordem;
import modelo.AVL;
import java.util.List;
import java.util.ArrayList;
public class Server {
    private AVL base;
    private List<Ordem> cache;
    
    public Server(){
        base = new AVL();
        cache = new ArrayList<Ordem>();


    }

    

}
