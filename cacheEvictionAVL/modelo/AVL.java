package cacheEvictionAVL.modelo;

import cacheEvictionAVL.entity.Ordem;
import cacheEvictionAVL.servidor.Servidor;



public class AVL {
    public Node raiz = null;
    public int tam = 0;

    public Node buscar(int ch){
        return this.buscar(raiz,ch);
    }
    private Node buscar(Node arv,int ch){
        if(arv ==  null){
            return null;
        }
        if(ch < arv.chave){
           return this.buscar(arv.esq, ch);
        }
        else if(ch > arv.chave){
            return this.buscar(arv.dir, ch);
        }
        else{
            return arv;
        }
    }  


    public void inserir(int ch, Ordem o){
        raiz = inserir(raiz,ch,o);
        tam++;
    }

    private Node inserir(Node arv, int ch, Ordem o){
        if(arv == null){
            return new Node(ch,o);
        }
        if(ch < arv.chave){
            arv.esq = inserir(arv.esq, ch, o);
        }
        else if(ch > arv.chave){
            arv.dir = inserir(arv.dir,ch,o);
        }
        else{
            return arv;
        }
        
        arv.alturaNo = 1 + maior(altura(arv.esq), altura(arv.dir));

        int fb = obterFB(arv);
        int fbArvEsq = obterFB(arv.esq);
        int fbArvDir = obterFB(arv.dir);

        //rotacao direita 
        if(fb > 1){
            
            if(fbArvEsq >=0){ // simples
                //return rds();    
                Servidor.log("Rotação direita simples ao inserir nó de chave " + ch);
                return rotacaoDireitaSimples(arv);
            }
            else if(fbArvEsq < 0){ // dupla
                //return rdd();
                Servidor.log("Rotação direita dupla ao inserir nó de chave " + ch);
                arv.esq = rotacaoEsquerdaSimples(arv.esq);
                return rotacaoDireitaSimples(arv);
            }
            
        }
        //rotacao esquerda 
        if(fb < -1 && fbArvDir <= 0){
            if(fbArvDir <= 0){ // simples
                //return res();
                Servidor.log("Rotação esquerda simples ao inserir nó de chave " + ch);
                return rotacaoEsquerdaSimples(arv);
            }
            else{ //dupla
                //return red();
                Servidor.log("Rotação esquerda dupla ao inserir nó de chave " + ch);
                arv.dir = rotacaoDireitaSimples(arv.dir);
                return rotacaoEsquerdaSimples(arv);
            }
            
        }
        //rotacao esquerda dupla
        return arv;
    }

    public void remover(int ch, Ordem o){
        raiz = remover(raiz,ch,o);
    }

    private Node remover(Node arv,int ch, Ordem o){
        if(arv == null){
            return arv;
        }
        if( ch < arv.chave){
            arv.esq = remover(arv.esq, ch, o);
        }
        else if(ch > arv.chave){
            arv.dir = remover(arv.dir, ch, o);
        }
        else{
            tam--;
            // caso 1 nó sem filjo
            if(arv.esq == null && arv.dir == null){
                arv = null;
            }
            //caso 2 nó só com filho a direita
            else if(arv.esq == null){
                Node temp = arv;
                arv = temp.dir;
                temp = null;
            }
            // caso 2 nó só com filho a esquerda
            else if(arv.dir == null){
                Node temp = arv;
                arv = temp.esq;
                temp = null;
            }
            // caso 3 nó com dois filhos: pegar sucessor do percurso em ordem * menor chave da subárvore direita
            else{
                Node temp = menorChave(arv.dir);
                arv.chave = temp.chave;
                temp.chave = ch;
                arv.dir = remover(arv.dir, ch, o);
            }
        }
        if(arv == null){
            return arv;
        }

        arv.alturaNo = 1 + maior(altura(arv.esq), altura(arv.dir));

        int fb = obterFB(arv);
        int fbArvEsq = obterFB(arv.esq);
        int fbArvDir = obterFB(arv.dir);

         //rotacao direita 
         if(fb > 1){
            
            if(fbArvEsq >=0){ // simples
                Servidor.log("Rotação direita simples ao remover nó de chave " + ch);
                return rotacaoDireitaSimples(arv);   
            }
            else if(fbArvEsq < 0){ // dupla
                Servidor.log("Rotação direita dupla ao remover nó de chave " + ch);
                arv.esq = rotacaoEsquerdaSimples(arv.esq);
                return rotacaoDireitaSimples(arv);
            }
            
        }
        //rotacao esquerda 
        if(fb < -1 ){
            if(fbArvDir <= 0){ // simples
                Servidor.log("Rotação esquerda simples ao remover nó de chave " + ch);
                return rotacaoEsquerdaSimples(arv);
            }
            else{ //dupla
                Servidor.log("Rotação esquerda dupla ao remover nó de chave " + ch);
                arv.dir = rotacaoDireitaSimples(arv.dir);
                return rotacaoEsquerdaSimples(arv);
            }
            
        }
        
        return arv;
    }

    private int altura(Node arv){

        if(arv == null){
            return -1;
        }
        return arv.alturaNo;
    }


    private int maior(int a,int b){
        return (a>b) ? a : b;
    }

    private int obterFB(Node arv){
        if(arv == null)
            return 0;
        return altura(arv.esq) - altura(arv.dir);
    }

    private Node menorChave(Node arv){
        Node temp = arv;
        if(temp == null){
            return null;
        }
        while (temp.esq != null) {
            temp = temp.esq;
        }
        return temp;
    }


    private Node rotacaoEsquerdaSimples(Node x){
        Node  y = x.dir; // guarda subarvore direita de x em y(arvore guardada)
        Node z = y.esq; // subarvore esquerda da arvore guardada, y, é guardad
        
        y.esq = x;
        x.dir = z;

        x.alturaNo = maior(altura(x.esq), altura(x.dir)) + 1;
        y.alturaNo = maior(altura(y.esq),altura(y.dir)) + 1;
        return y;
    }

    private Node rotacaoDireitaSimples(Node y){
        Node x = y.esq;
        Node z = x.dir;

        x.dir = y;
        y.esq = z;

        y.alturaNo = maior(altura(y.esq), altura(y.dir)) + 1;
        x.alturaNo = maior(altura(x.esq), altura(x.dir)) + 1;
        return x;
    }

    public void ordem(){
        this.ordem(raiz);
    }

    private void ordem(Node arv){
        if(arv != null){
            ordem(arv.esq);
            System.out.println( "| "  + " Codigo :" + arv.chave + "| " + "Nome: " + arv.os.getNome() + "| " + "Descricao: " + arv.os.getDescricao() + "| " + "Hora de solicitacao: " + arv.os.getHora() + "|");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            ordem(arv.dir);
        }
    }

    

}
