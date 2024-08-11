package entity;


public class Ordem {
    
    private int id;
    private String nome;
    private String descricao;
    private String hora;
    

    public Ordem(){
        
    }
    public Ordem(int id,String nome, String descricao,String hora) throws Exception{
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setHora(hora);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome == ""){
            throw new Exception("nome da ordem de servico nao pode ser vazio");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception {
        if(descricao == ""){
            throw new Exception("descricao da ordem nao pode ser vazio");
        }
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    

    
}
