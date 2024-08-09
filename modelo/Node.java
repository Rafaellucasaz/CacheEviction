package modelo;

import entity.Ordem;

public class Node {
    public int chave;
    public Ordem os;
    public Node esq,dir;
    public int alturaNo;

    public Node(int k,Ordem o){
        chave = k;
        os = o;
        esq = null;
        dir = null;
    }

    public Node(int k, Node l, Node r){
        this.chave = k;
        this.esq = l;
        this.dir = r;
    }
}
