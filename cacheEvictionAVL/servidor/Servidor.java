package cacheEvictionAVL.servidor;

import java.util.List;

import cacheEvictionAVL.entity.Ordem;
import cacheEvictionAVL.modelo.AVL;
import cacheEvictionAVL.modelo.Node;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Servidor {
    private AVL base;
    private List<Ordem> cache;

    
    static String logPath = "log/log.txt";
    
    


    public Servidor(){
        limparLog();
        base = new AVL();
        cache = new ArrayList<Ordem>(20);
        try {
            Ordem o = new Ordem(4, "Impressora HP", "Substituir cartucho de tinta");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(1, "Servidor Dell", "Atualizar sistema operacional");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(17, "Ar-Condicionado LG", "Reparar vazamento de gás");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(94, "Roteador Cisco", "Resetar configurações de rede");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(69, "Monitor Samsung", "Ajustar configurações de cor");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(63, "Notebook Lenovo", "Substituir teclado");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(54, "Impressora Epson", "Limpar cabeçote de impressão");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(87, "Servidor HP", "Checar falhas no disco rígido");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(35, "Ar-Condicionado Samsung", "Trocar filtro de ar");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(22, "Roteador TP-Link", "Atualizar firmware");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(75, "Monitor LG", "Verificar conexão HDMI");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(10, "Switch Netgear", "Substituir portas danificadas");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(33, "Impressora Brother", "Realinhar cabeçote de impressão");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(58, "Servidor IBM", "Revisar sistema de backup");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(29, "Ar-Condicionado Fujitsu", "Checar termostato");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(90, "Roteador D-Link", "Restaurar configurações de fábrica");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(6, "Monitor Dell", "Calibrar tela");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(47, "Notebook HP", "Substituir bateria");
            cadastrar(o);
            cache.add(o);

            o = new Ordem(18, "Impressora Canon", "Substituir rolo de papel");
            cadastrar(o);
            cache.add(o);

            cadastrar(new Ordem(37, "Servidor Lenovo", "Atualizar drivers de rede"));
            cadastrar(new Ordem(41, "Ar-Condicionado Midea", "Reabastecer gás refrigerante"));
            cadastrar(new Ordem(60, "Roteador Asus", "Verificar conectividade de Wi-Fi"));
            cadastrar(new Ordem(3, "Monitor Acer", "Corrigir problema de flicker"));
            cadastrar(new Ordem(53, "Notebook Asus", "Atualizar BIOS"));
            cadastrar(new Ordem(92, "Impressora Xerox", "Reparar scanner"));
            cadastrar(new Ordem(28, "Servidor Supermicro", "Verificar fontes de alimentação"));
            cadastrar(new Ordem(71, "Ar-Condicionado Panasonic", "Substituir ventilador interno"));
            cadastrar(new Ordem(9, "Roteador Linksys", "Resetar senha de administrador"));
            cadastrar(new Ordem(20, "Monitor Philips", "Ajustar brilho automático"));
            cadastrar(new Ordem(88, "Notebook Toshiba", "Substituir módulo de memória RAM"));
            cadastrar(new Ordem(14, "Impressora Ricoh", "Trocar toner"));
            cadastrar(new Ordem(13, "Servidor Fujitsu", "Verificar logs de erro"));
            cadastrar(new Ordem(38, "Ar-Condicionado Electrolux", "Limpar condensadora"));
            cadastrar(new Ordem(100, "Roteador Ubiquiti", "Configurar nova VLAN"));
            cadastrar(new Ordem(70, "Monitor BenQ", "Corrigir problemas de resolução"));
            cadastrar(new Ordem(21, "Notebook Samsung", "Reparar teclado"));
            cadastrar(new Ordem(97, "Impressora Kyocera", "Revisar sistema de alimentação de papel"));
            cadastrar(new Ordem(11, "Servidor Oracle", "Testar sistema de redundância"));
            cadastrar(new Ordem(55, "Ar-Condicionado Daikin", "Trocar termostato"));
            cadastrar(new Ordem(73, "Roteador Mikrotik", "Atualizar sistema RouterOS"));
            cadastrar(new Ordem(56, "Monitor ViewSonic", "Verificar conectores VGA"));
            cadastrar(new Ordem(26, "Notebook MSI", "Atualizar drivers de vídeo"));
            cadastrar(new Ordem(81, "Impressora Lexmark", "Reparar bandeja de papel"));
            cadastrar(new Ordem(7, "Servidor Cisco", "Atualizar software de segurança"));
            cadastrar(new Ordem(46, "Ar-Condicionado Consul", "Limpar filtros"));
            cadastrar(new Ordem(67, "Roteador Huawei", "Configurar acesso remoto"));
            cadastrar(new Ordem(84, "Monitor AOC", "Reparar entrada de energia"));
            cadastrar(new Ordem(31, "Notebook Dell", "Reparar porta USB"));
            cadastrar(new Ordem(16, "Impressora Sharp", "Substituir tambor"));
            cadastrar(new Ordem(39, "Servidor EMC", "Verificar sistema de armazenamento"));
            cadastrar(new Ordem(62, "Ar-Condicionado Carrier", "Verificar compressor"));
            cadastrar(new Ordem(48, "Roteador Zyxel", "Configurar QoS"));
            cadastrar(new Ordem(93, "Monitor NEC", "Calibrar cores"));
            cadastrar(new Ordem(68, "Notebook Alienware", "Substituir placa gráfica"));
            cadastrar(new Ordem(64, "Impressora Toshiba", "Reparar conexão de rede"));
            cadastrar(new Ordem(85, "Servidor QNAP", "Revisar sistema RAID"));
            cadastrar(new Ordem(27, "Ar-Condicionado York", "Trocar ventilador"));
            cadastrar(new Ordem(15, "Roteador Netgear", "Atualizar configurações de firewall"));
            cadastrar(new Ordem(44, "Monitor HP", "Verificar defeito no backlight"));
            cadastrar(new Ordem(83, "Notebook Sony Vaio", "Reparar trackpad"));

            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    
    public void cadastrar(Ordem o){
        
        log("Cadastro de chave " + o.getId());
        base.inserir(o.getId(),o);
        log("altura pós insercao: " + base.raiz.alturaNo + "\n------------------------------------------------");
    }

    

    public Ordem buscar(int ch){
       Ordem os = buscarCache(ch);
       if(os == null){
            System.out.println("ordem de servico nao encontrada na cache... Procurando na base de dados");
            Node node = base.buscar(ch);
            if(node != null){
                os = node.os;
                adicionarCache(os);
            }
            return os;
       }
       System.out.println("ordem de servico encontrada na cache");
       return os;
    }

   

    public void remover(Ordem o){
        log("Remoção");
        base.remover(o.getId(),o);
        removerCache(o.getId());
        log("Altura pós remoção: " + base.raiz.alturaNo);
        log("------------------------------------------------");
    }

    public void listarBase(){
        System.out.println("Listando ordens da base");
        base.ordem();
    }


    public Ordem buscarCache(int ch){
        for (Ordem ordem : cache) {
            if(ordem.getId() == ch)
                return ordem;
        }
        return null;
    }

    public void adicionarCache(Ordem o ){
        if(cache.size() == 20){
            cache.remove(19);
            cache.add(0,o);
        }
        else{
            cache.add(0,o);
        }
    }

    public void listarCache(){
        System.out.println("\nStatus da cache");
        if(cache.size() <1){
            System.out.println("vazio");
        }
        else{
            for (Ordem ordem : cache) {
                System.out.println((cache.indexOf(ordem) + 1) + "| "  + " Codigo :" + ordem.getId() + "| " + "Nome: " + ordem.getNome() + "| " + "Descricao: " + ordem.getDescricao() + "| " + "Hora de solicitacao: " + ordem.getHora() + "|");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
            }
        }
        
    }

    public void removerCache(int ch){
        Ordem o = buscarCache(ch);
        if(o != null){
            cache.remove(o);
        }

    }
    public Ordem buscarAux(int ch){
        Ordem os = buscarCache(ch);
       if(os == null){
           
            Node node = base.buscar(ch);
            if(node != null){
                os = node.os;
                
            }
            return os;
       }
       return os;
    }


    public int tamanho(){
        return base.tam;
    }

    public static void log(String texto){
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(logPath,true));
            w.append(texto);
            w.newLine();
            w.close();
        } catch (Exception e) {
            System.out.println("erro ao escrever no log");
        }
    }

    public static void limparLog(){
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(logPath));
            w.append("");
            w.close();
        
        } catch (Exception e) {
            System.out.println("erro ao limpar log");
        }
        
    }

    

}
