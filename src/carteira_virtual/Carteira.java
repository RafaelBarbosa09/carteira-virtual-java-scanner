package carteira_virtual;

public class Carteira{

	private double saldo;
	private double movimentacoes;	
	private double salario;
	private Usuario usuario;
	

	public void saca(double valor){
		if(this.saldo < valor){
			System.out.println("Saldo insuficiente");
		} else{
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
		}
	}
	
	public void deposita(double valor){
		this.saldo += valor;
	}

	public void transferePara(Carteira destino, double valor){
		if(this.saldo < valor){
			System.out.println("Saldo insuficiente");
		} else{
			this.saca(valor);
			destino.deposita(valor);
		}
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getMovimentacoes() {
		return movimentacoes;
	}
	
	public void setMovimentacoes(double movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Usuario getTitular() {
		return usuario;
	}

	public void setTitular(Usuario usuario) {
		this.usuario = usuario;
	}
}
