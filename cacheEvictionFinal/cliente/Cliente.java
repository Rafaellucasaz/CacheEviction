package cliente;
import java.util.Scanner;

import entity.Ordem;
import modelo.No;
import servidor.Servidor;

public class Cliente {
    
    private Servidor servidor;
    public static Scanner sc = new Scanner(System.in);
    

    public Cliente(Servidor s){
        setServidor(s);
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public void CadastrarOrdem() throws Exception{
        Servidor servidor = getServidor();
        System.out.println("digite o codigo da ordem de servico");
        int id = sc.nextInt();
        Ordem os = new Ordem();
        os.setId(id);
        sc.nextLine();
        System.out.println("digite o nome do equipamento:");
        os.setNome(sc.nextLine());
        System.out.println("digite a descricao da ordem de servico: ");
        os.setDescricao(sc.nextLine());
        os.setHora();    
        Boolean resultado = servidor.cadastrar(os);
        if(resultado){
            System.out.println("cadastro feito com sucesso!");
        }
        else{
            System.out.println("ja existe uma ordem com esse codigo");
        }
    }

    public void alterarOrdem() throws Exception{
        
        System.out.println("digite o codigo da ordem de servico a ser alterada: ");
        int id = sc.nextInt();
        sc.nextLine();
        No no = servidor.alterar(id);
        if(no == null){
            System.out.println("Ordem nao encontrada");
        }
        else{
            System.out.println("Informacoes da ordem: ");
            System.out.println("Nome: " + no.getOs().getNome());
            System.out.println("Descricao: " + no.getOs().getDescricao());
            System.out.println("Hora da solicitacao: " + no.getOs().getHora());
            System.out.println("digite os novos valores da ordem ");
            System.out.println("Nome: ");
            no.getOs().setNome(sc.nextLine());
            System.out.println("Descricao: ");
            no.getOs().setDescricao(sc.nextLine());
            

            System.out.println("ordem de servico alterada com sucesso!");
        }
    }

    public void removerOrdem(){
    
        System.out.println("digite o codigo da ordem a ser removida: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean resultado = servidor.remover(id);
        if(resultado){
            System.out.println("ordem de servico removida com sucesso!");
           
        }
        else{
            System.out.println("ordem de servico nao encontrada");
        }
    }

    public void buscarOrdem(){
        
        System.out.println("digite o codigo da ordem a ser buscada: ");
        int id = sc.nextInt();
        sc.nextLine();
        Ordem os = servidor.buscar(id);
        if(os == null){
            System.out.println("ordem de servico nao encontrada");
        }
        else{
            System.out.println("Ordem de servico encontrada... exibindo informacoes");
            System.out.println("Codigo:" + os.getId());
            System.out.println("Nome: " + os.getNome());
            System.out.println("Descricao: " + os.getDescricao());
            System.out.println("Hora de solicitacao:" + os.getHora());
        }

    }
    
}
