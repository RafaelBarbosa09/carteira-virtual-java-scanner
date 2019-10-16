package carteira_virtual;

public class Carteira{

	private double saldo;
	private Usuario usuario;
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Usuario getTitular() {
		return usuario;
	}

	public void setTitular(Usuario usuario) {
		this.usuario = usuario;
	}
}
