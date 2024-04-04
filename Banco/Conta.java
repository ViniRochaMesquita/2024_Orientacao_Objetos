
public class Conta {
	//Atributos =================================================================================================================================
	private String  numeroAgencia;
	private String  numeroConta;
	private Cliente titular;
	private double  saldo;
	private double  limite;
	
	//Construtor ================================================================================================================================
	public Conta(String  numeroAgencia, String  numeroConta, Cliente titular){
		this.numeroAgencia = numeroAgencia;
		this.numeroConta   = numeroConta;
		this.titular       = titular;
		this.saldo         = 100;
		this.limite        = 0;
	}

	public Conta(String  numeroAgencia, String  numeroConta, Cliente titular, double limite){
		this.numeroAgencia = numeroAgencia;
		this.numeroConta   = numeroConta;
		this.titular       = titular;
		this.saldo         = 100;
		this.limite        = limite;
	}

	//Getters ==================================================================================================================================
	public String getNumeroAgencia(){ return this.numeroAgencia;}
    public String getnumeroConta(){   return this.numeroConta;}
    public double getSaldo(){         return this.saldo;}
    public double getLimite(){        return this.limite;}

	//Metodos ===================================================================================================================================
	public boolean transferir(double valor, Conta destino) {
		if(this.sacar(valor)){
			destino.depositar(valor);
			return true;
		}
		return false;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public boolean sacar(double valor) {
		if(this.saldo >= valor){
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public boolean investir(double valor, String tipo) {
		if(this.sacar(valor)) return true;
		return false;
	
	}

	public String get_Relatorio(){
		String relatorio = "" + 
		    "==================================================================="+
			"\nNumero da Agencia:..."+this.numeroAgencia+
			"\nNumero da Conta:....."+this.numeroConta+
			"\nTitular:............."+this.titular.get_relatorio()+
			"\nSaldo:..............."+String.format("%.2f R$",this.saldo)+
			"\nLimite:.............."+String.format("%.2f R$",this.limite);

		return relatorio;
	}
}
