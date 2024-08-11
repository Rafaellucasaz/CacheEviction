package servidor;

import entity.Ordem;
import modelo.AVL;
import modelo.Node;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Server {
    private AVL base;
    private List<Ordem> cache;

    // caminho para o log
    static String logPath = "log/log.txt";
    
    public AVL getBase() {
        return base;
    }


    public void setBase(AVL base) {
        this.base = base;
    }


    public List<Ordem> getCache() {
        return cache;
    }


    public void setCache(List<Ordem> cache) {
        this.cache = cache;
    }


    public Server(){
        base = new AVL();
        cache = new ArrayList<Ordem>(20);
        try {
            cadastrar( new Ordem(91,"Impressora HP", "Substituir cartucho de tinta", "08:00"));
        cadastrar(new Ordem(1,"Servidor Dell", "Atualizar sistema operacional", "09:00"));
        cadastrar( new Ordem(17,"Ar-Condicionado LG", "Reparar vazamento de gás", "10:00"));
        cadastrar( new Ordem(94,"Roteador Cisco", "Resetar configurações de rede", "11:00"));
        cadastrar( new Ordem(69,"Monitor Samsung", "Ajustar configurações de cor", "12:00"));
        cadastrar( new Ordem(63,"Notebook Lenovo", "Substituir teclado", "13:00"));
        cadastrar( new Ordem(54,"Impressora Epson", "Limpar cabeçote de impressão", "14:00"));
        cadastrar( new Ordem(63,"Servidor HP", "Checar falhas no disco rígido", "15:00"));
        cadastrar( new Ordem(75,"Ar-Condicionado Samsung", "Trocar filtro de ar", "16:00"));
        cadastrar( new Ordem(15,"Roteador TP-Link", "Atualizar firmware", "17:00"));
        cadastrar( new Ordem(77,"Monitor LG", "Verificar conexão HDMI", "18:00"));
        cadastrar( new Ordem(85,"Switch Netgear", "Substituir portas danificadas", "19:00"));
        cadastrar( new Ordem(23,"Impressora Brother", "Realinhar cabeçote de impressão", "20:00"));
        cadastrar( new Ordem(17,"Servidor IBM", "Revisar sistema de backup", "08:30"));
        cadastrar( new Ordem(63,"Ar-Condicionado Fujitsu", "Checar termostato", "09:30"));
        cadastrar( new Ordem(98,"Roteador D-Link", "Restaurar configurações de fábrica", "10:30"));
        cadastrar( new Ordem(40,"Monitor Dell", "Calibrar tela", "11:30"));
        cadastrar( new Ordem(91,"Notebook HP", "Substituir bateria", "12:30"));
        cadastrar( new Ordem(67,"Impressora Canon", "Substituir rolo de papel", "13:30"));
        cadastrar( new Ordem(76,"Servidor Lenovo", "Atualizar drivers de rede", "14:30"));
        cadastrar( new Ordem(93,"Ar-Condicionado Midea", "Reabastecer gás refrigerante", "15:30"));
        cadastrar( new Ordem(53,"Roteador Asus", "Verificar conectividade de Wi-Fi", "16:30"));
        cadastrar( new Ordem(45,"Monitor Acer", "Corrigir problema de flicker", "17:30"));
        cadastrar( new Ordem(36,"Notebook Asus", "Atualizar BIOS", "18:30"));
        cadastrar( new Ordem(50,"Impressora Xerox", "Reparar scanner", "19:30"));
        cadastrar( new Ordem(58,"Servidor Supermicro", "Verificar fontes de alimentação", "20:30"));
        cadastrar( new Ordem(29,"Ar-Condicionado Panasonic", "Substituir ventilador interno", "08:15"));
        cadastrar( new Ordem(88,"Roteador Linksys", "Resetar senha de administrador", "09:15"));
        cadastrar( new Ordem(94,"Monitor Philips", "Ajustar brilho automático", "10:15"));
        cadastrar( new Ordem(60,"Notebook Toshiba", "Substituir módulo de memória RAM", "11:15"));
        cadastrar( new Ordem(38,"Impressora Ricoh", "Trocar toner", "12:15"));
        cadastrar( new Ordem(52,"Servidor Fujitsu", "Verificar logs de erro", "13:15"));
        cadastrar( new Ordem(86,"Ar-Condicionado Electrolux", "Limpar condensadora", "14:15"));
        cadastrar( new Ordem(22,"Roteador Ubiquiti", "Configurar nova VLAN", "15:15"));
        cadastrar( new Ordem(31,"Monitor BenQ", "Corrigir problemas de resolução", "16:15"));
        cadastrar( new Ordem(22,"Notebook Samsung", "Reparar teclado", "17:15"));
        cadastrar(new Ordem(8,"Impressora Kyocera", "Revisar sistema de alimentação de papel", "18:15"));
        cadastrar( new Ordem(51,"Servidor Oracle", "Testar sistema de redundância", "19:15"));
        cadastrar( new Ordem(23,"Ar-Condicionado Daikin", "Trocar termostato", "20:15"));
        cadastrar( new Ordem(19,"Roteador Mikrotik", "Atualizar sistema RouterOS", "08:45"));
        cadastrar( new Ordem(93,"Monitor ViewSonic", "Verificar conectores VGA", "09:45"));
        cadastrar( new Ordem(21,"Notebook MSI", "Atualizar drivers de vídeo", "10:45"));
        cadastrar( new Ordem(26,"Impressora Lexmark", "Reparar bandeja de papel", "11:45"));
        cadastrar( new Ordem(33,"Servidor Cisco", "Atualizar software de segurança", "12:45"));
        cadastrar( new Ordem(11,"Ar-Condicionado Consul", "Limpar filtros", "13:45"));
        cadastrar( new Ordem(18,"Roteador Huawei", "Configurar acesso remoto", "14:45"));
        cadastrar( new Ordem(62,"Monitor AOC", "Reparar entrada de energia", "15:45"));
        cadastrar( new Ordem(36,"Notebook Dell", "Reparar porta USB", "16:45"));
        cadastrar( new Ordem(53,"Impressora Sharp", "Substituir tambor", "17:45"));
        cadastrar( new Ordem(78,"Servidor EMC", "Verificar sistema de armazenamento", "18:45"));
        cadastrar( new Ordem(20,"Ar-Condicionado Carrier", "Verificar compressor", "19:45"));
        cadastrar( new Ordem(89,"Roteador Zyxel", "Configurar QoS", "20:45"));
        cadastrar( new Ordem(35,"Monitor NEC", "Calibrar cores", "08:10"));
        cadastrar( new Ordem(76,"Notebook Alienware", "Substituir placa gráfica", "09:10"));
        cadastrar( new Ordem(32,"Impressora Toshiba", "Reparar conexão de rede", "10:10"));
        cadastrar( new Ordem(47,"Servidor QNAP", "Revisar sistema RAID", "11:10"));
        cadastrar( new Ordem(91,"Ar-Condicionado York", "Trocar ventilador", "12:10"));
        cadastrar( new Ordem(90,"Roteador Netgear", "Atualizar configurações de firewall", "13:10"));
        cadastrar( new Ordem(71,"Monitor HP", "Verificar defeito no backlight", "14:10"));
        cadastrar( new Ordem(19,"Notebook Sony Vaio", "Reparar trackpad", "15:10"));
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    
    public void cadastrar(Ordem o){
        
        log("Cadastro de chave " + o.getId());
        base.inserir(o.getId(),o);
        log("altura pós insercao: " + base.raiz.alturaNo);
        log("------------------------------------------------");

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

    public void remover(Ordem o){
        log("Remoção");
        base.remover(o.getId(),o);
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
        for (Ordem ordem : cache) {
            System.out.println(cache.indexOf(ordem) + ":");
            System.out.println("Codigo:" + ordem.getId());
            System.out.println("Nome: " + ordem.getNome());
            System.out.println("Descricao: " + ordem.getDescricao());
            System.out.println("hora de solicitacao: " + ordem.getHora());
        }
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

    

}
