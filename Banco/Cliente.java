public class Cliente{
    private String nome;
    private String cpf;
    private String telefone;

    //Construtor
    public Cliente(String nome, String cpf, String telefone){
        this.nome     = nome;
        this.cpf      = cpf;
        this.telefone = telefone;        
    }

    //Getters =========================================
    public String getNome(){ return this.nome;}
    public String getCpf(){ return this.cpf;}
    public String getTelefone(){ return this.telefone;}

    public String get_relatorio(){
        String relatorio = "" + 
            "\nRelatorio do Cliente =============\n"+
            "\nNome:......."+this.nome+
            "\nCPF:........"+this.cpf+
            "\nTelefone:..."+this.telefone+"\n"+
            "=====================================\n";
            return relatorio;
    }
    





}