package carteira_virtual;

public class Carteira{

	private double saldo;
	private double movimentacoes;	
	private double salario;
	private Usuario usuario;
	
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
