package main;

import Cliente.Cliente;
import servidor.Server;
import entity.Ordem;
import modelo.AVL;
import modelo.Node;
import java.util.InputMismatchException;
import java.lang.Thread;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Server servidor = new Server();
        Cliente cliente = new Cliente(servidor);
        int menu = 0;
        
        
        while (menu!= 7) {
            System.out.println("------------------------------------------------");
            System.out.println("1-Cadastrar ordem de servico");
            System.out.println("2-Alterar ordem de servico existente");
            System.out.println("3-Remover ordem de servico existente");
            System.out.println("4-Listar ordens de servicos");
            System.out.println("5-Buscar ordem de servico");
            System.out.println("6-Acessar quantidade de registros");
            System.out.println("7-sair");
            System.out.println("------------------------------------------------");
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    try {
                        cliente.CadastrarOrdem();
                        servidor.listarCache();
                    } catch (InputMismatchException e) {
                        System.out.println("codigo da ordem deve ser um numero inteiro");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                
                case 2:
                    try {
                        cliente.alterarOrdem();
                        servidor.listarCache();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    cliente.removerOrdem();
                    servidor.listarCache();
                    break;
                case 4:
                    servidor.listarBase();
                    break;
                case 5:
                    cliente.buscarOrdem();
                    servidor.listarCache();
                    break;
                case 6:
                    System.out.println("Quantidade de registros atual: " + servidor.tamanho());
                case 7:
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }
       
    
    }
}
