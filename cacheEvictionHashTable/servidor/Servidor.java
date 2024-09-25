package servidor;


import modelo.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

import entity.Ordem;
public class Servidor {
    private BaseDados base;
    private Cache cache;

    
    static String logPath = "log/log.txt";
    
    


    public Servidor(){
        limparLog();
        base = new BaseDados(127);
        cache = new Cache(20);
        try {
            Ordem o = new Ordem(125, "Impressora Epson", "Trocar cartucho de tinta");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(18, "Notebook Dell", "Reinstalar sistema operacional");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(972, "Scanner Canon", "Atualizar firmware");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(184, "PC Gamer", "Verificar superaquecimento");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(651, "Roteador TP-Link", "Configurar rede Wi-Fi");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(359, "Monitor Samsung", "Reparar entrada HDMI");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(717, "Smartphone LG", "Substituir tela quebrada");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(292, "Impressora Brother", "Verificar falha na impressão");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(503, "Notebook Acer", "Trocar bateria");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(864, "Smart TV Sony", "Ajustar configurações de rede");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(342, "PC HP", "Instalar novo SSD");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(221, "Tablet Samsung", "Atualizar sistema operacional");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(608, "Câmera Sony", "Limpeza de lente");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(738, "Impressora Canon", "Trocar cabeçote de impressão");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(167, "Notebook Lenovo", "Ajustar teclado com defeito");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(409, "Console PlayStation", "Reparar leitor de disco");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(581, "Monitor AOC", "Ajustar brilho e contraste");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(312, "Smartphone Motorola", "Substituir bateria");
            cadastrar(o);
            cache.inserir(o);

            o = new Ordem(690, "Impressora HP", "Reinstalar drivers de impressão");
            cadastrar(o);
            cache.inserir(o);


            cadastrar(new Ordem(946, "Notebook Asus", "Verificar falha de boot"));
            cadastrar(new Ordem(88, "Roteador D-Link", "Atualizar firmware"));
            cadastrar(new Ordem(852, "PC Dell", "Trocar placa de vídeo"));
            cadastrar(new Ordem(194, "Tablet Huawei", "Reparar conector de carregamento"));
            cadastrar(new Ordem(433, "Impressora Samsung", "Verificar alimentação de papel"));
            cadastrar(new Ordem(41, "Notebook Toshiba", "Limpeza geral e manutenção"));
            cadastrar(new Ordem(911, "Smart TV LG", "Ajustar recepção de sinal Wi-Fi"));
            cadastrar(new Ordem(537, "PC Acer", "Instalar placa de som"));
            cadastrar(new Ordem(385, "Câmera Nikon", "Atualizar firmware"));
            cadastrar(new Ordem(753, "Monitor Dell", "Trocar base de suporte"));
            cadastrar(new Ordem(279, "Notebook HP", "Substituir teclado danificado"));
            cadastrar(new Ordem(596, "Impressora Lexmark", "Verificar impressão borrada"));
            cadastrar(new Ordem(888, "Roteador Linksys", "Configurar segurança da rede"));
            cadastrar(new Ordem(445, "PC Gamer Alienware", "Reparar sistema de refrigeração"));
            cadastrar(new Ordem(238, "Console Xbox", "Verificar falha de conexão à internet"));
            cadastrar(new Ordem(329, "Smartphone Xiaomi", "Atualizar sistema operacional"));
            cadastrar(new Ordem(784, "Impressora Brother", "Verificar problema no scanner"));
            cadastrar(new Ordem(181, "Notebook MSI", "Trocar placa-mãe"));
            cadastrar(new Ordem(2, "Smart TV Samsung", "Configurar controle remoto universal"));
            cadastrar(new Ordem(547, "PC Lenovo", "Instalar sistema de backup"));
            cadastrar(new Ordem(962, "Câmera Canon", "Reparar mecanismo de foco"));
            cadastrar(new Ordem(140, "Monitor LG", "Trocar fonte de alimentação"));
            cadastrar(new Ordem(688, "Notebook Huawei", "Verificar falha no touchpad"));
            cadastrar(new Ordem(306, "Impressora Epson", "Ajustar alinhamento de impressão"));
            cadastrar(new Ordem(728, "PC Asus", "Limpeza de componentes internos"));
            cadastrar(new Ordem(34, "Smartphone Samsung", "Reparar conector de fone de ouvido"));
            cadastrar(new Ordem(884, "Tablet Lenovo", "Substituir vidro quebrado"));
            cadastrar(new Ordem(246, "Impressora HP", "Trocar toner"));
            cadastrar(new Ordem(123, "Notebook Dell", "Atualizar drivers"));
            cadastrar(new Ordem(569, "Console Nintendo Switch", "Reparar falha nos Joy-Cons"));
            cadastrar(new Ordem(218, "PC HP", "Reparar fonte de alimentação"));
            cadastrar(new Ordem(977, "Monitor BenQ", "Verificar falha de imagem"));
            cadastrar(new Ordem(366, "Câmera Panasonic", "Limpar sensor de imagem"));
            cadastrar(new Ordem(709, "Smartphone Apple", "Trocar bateria"));
            cadastrar(new Ordem(321, "Notebook Asus", "Substituir disco rígido"));
            cadastrar(new Ordem(105, "Impressora Lexmark", "Verificar problema de conectividade"));
            cadastrar(new Ordem(897, "Roteador Netgear", "Configurar rede para convidados"));
            cadastrar(new Ordem(478, "PC Dell", "Trocar memória RAM"));
            cadastrar(new Ordem(550, "Smart TV Panasonic", "Verificar falha no áudio"));
            cadastrar(new Ordem(58, "Notebook Acer", "Atualizar BIOS"));
            cadastrar(new Ordem(211, "Tablet Apple", "Reparar falha no microfone"));
            cadastrar(new Ordem(387, "Impressora Samsung", "Verificar qualidade de impressão"));
            cadastrar(new Ordem(772, "PC HP", "Instalar novo sistema operacional"));
            cadastrar(new Ordem(148, "Câmera Sony", "Reparar falha no obturador"));
            cadastrar(new Ordem(633, "Smartphone OnePlus", "Substituir conector de carregamento"));
            cadastrar(new Ordem(290, "Notebook Toshiba", "Reparar ventilador de refrigeração"));
            cadastrar(new Ordem(986, "Impressora Canon", "Ajustar bandeja de entrada de papel"));
            cadastrar(new Ordem(1, "Impressora bacana", "Limpar cabeçote de impressão"));
            cadastrar(new Ordem(89, "Notebook bacana", "Trocar disco rígido"));
            cadastrar(new Ordem(3, "Roteador bacana", "Atualizar firmware"));
            cadastrar(new Ordem(4, "Smartphone bacana", "Reparar tela quebrada"));


            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    
    public Boolean cadastrar(Ordem o){
        
        
        boolean resultado = base.inserir(o);
        if(resultado){
            log("Cadastro de chave " + o.getId(),true);
            log("Tabela após inserção: ",true);
            base.imprimirTabelaHashLog();
            return true;
        }
        return false;
        
    }

    

    public Ordem buscar(int ch){
       Ordem os = buscarCache(ch);
       if(os == null){
            System.out.println("ordem de servico nao encontrada na cache... Procurando na base de dados");
            No no = base.buscar(ch);
            if(no != null){
                os = no.getOs();
                adicionarCache(os);
            }
            return os;
       }
       System.out.println("ordem de servico encontrada na cache");
       return os;
    }

    public No alterar(int ch){
        return base.buscar(ch);
    }

   

    public boolean remover(int id){
        
        boolean resultado = base.remover(id);
        if(resultado){
            removerCache(id);
            log("Remoção de chave: " + id,true);
            log("Tabela após remoção: ",true);
            base.imprimirTabelaHashLog();
            return true;
        }
        return false;
    }

    public void listarBase(){
        System.out.println("Listando ordens da base");
        base.imprimirTabelaHash();
    }


    public Ordem buscarCache(int ch){
      return cache.buscar(ch);
    }

    public void adicionarCache(Ordem o ){
        if(cache.n == 20){
            Random random = new Random();
            removerCacheRandom(random.nextInt(20));
            cache.inserir(o);
        }
        else{
            cache.inserir(o);
        }
    }

    public void listarCache(){
       cache.imprimirTabelaHash();
    }

    public void removerCacheRandom(int i){
        cache.removerRandom(i);
    }

    public void removerCache(int id){
        cache.remover(id);
    }


    public int tamanho(){
        base.contarElementos();
        return base.n;
    }

    public static void log(String texto,boolean pularLinha){
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(logPath,true));
            w.append(texto);
            if(pularLinha){
                w.newLine();
            }
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
