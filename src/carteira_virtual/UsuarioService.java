package carteira_virtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface UsuarioService{

	public static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	List<Double> listaSaque = new ArrayList<Double>();
	List<Double> listaDeposito = new ArrayList<Double>();
	
	public static void cadastrarUsuario(){

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Usuario novoUsuario = new Usuario();
		Carteira novaCarteira = new Carteira();
		
		System.out.println("--------------CADASTRAR USUÁRIO-------------");
		
		System.out.print("Nome: ");
		novoUsuario.setNome(sc.nextLine());
		
		System.out.print("Sobrenome: ");
		novoUsuario.setSobrenome(sc.nextLine());
		
		System.out.print("CPF: ");
		novoUsuario.setCpf(sc.nextLine());
		
		System.out.print("Senha: ");
		novoUsuario.setSenha(sc.nextLine());
		
		System.out.print("Informe seu saldo inicial: R$ ");
		novaCarteira.setSaldo(sc.nextDouble());
		
		novaCarteira.setTitular(novoUsuario);
		novoUsuario.setCarteira(novaCarteira);
		
		listaUsuarios.add(novoUsuario);
		
		int idUsuario = listaUsuarios.indexOf(novoUsuario) + 1;
		novoUsuario.setId(idUsuario);
		
		for (Usuario usuario : listaUsuarios) {
			System.out.println("Usuário cadastrado com sucesso!");
			System.out.println("Id: " + usuario.getId());
			System.out.println("Nome Completo: " + usuario.getNome() + " " + usuario.getSobrenome());
			System.out.println("Cpf: " + usuario.getCpf());
			System.out.println("Saldo Atual: " + usuario.getCarteira().getSaldo() + "(s)");
			System.out.println();
		}		
	}
	
	public static void fazLogin(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------LOGIN-------------");
		System.out.print("Cpf: ");
		String verificaCpf = sc.nextLine();
		System.out.print("Senha: ");
		String verificaSenha = sc.nextLine();
		
		for (Usuario usuario : listaUsuarios) {
			if(verificaCpf.equals(usuario.getCpf()) && verificaSenha.equals(usuario.getSenha())){
				menuUsuarioLogado();
			} 
		}
			System.out.println("!!!!!!!!!!!!!!!Usuário ou senha Inválidos!!!!!!!!!!!!!!!");
	}
	
	public static void menuUsuarioLogado(){
		
		int opcao = 0;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Verificar Saldo");
			System.out.println("2 - Realizar Operação");
			System.out.println("3 - Sair");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				buscaSaldo();
				break;
			case 2:
				realizaOperacao();
				break;
			case 3:
				System.out.println("");
				break;
			default:
				System.out.println("Insira uma opção válida!");
				break;
			}
		}while(opcao != 3);
	}
	
	public static void realizaOperacao(){
		int operacao = 0;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("Informe a operação desejada.");
			System.out.println("1 - Saque");
			System.out.println("2 - Depósito");
			System.out.println("3 - movimentações");
			System.out.println("4 - voltar");
			operacao = sc.nextInt();
			
			switch (operacao) {
			case 1:
				saca();
				break;
			case 2:
				deposita();
				break;
			case 3:
				exibeMovimentacoes();
				break;
			case 4:
				System.out.println("");
				break;

			default:
				System.out.println("Escolha uma opção válida!");
				break;
			}
		}while(operacao != 4);
	}
	
	public static void buscaSaldo(){

		for (Usuario usuario : listaUsuarios) {
			System.out.println("Saldo Atual: " + usuario.getCarteira().getSaldo() + "(s)");
		}
	}
	
	public static void deposita(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : listaUsuarios) {
			System.out.print("Informe o valor que deseja depositar: R$ ");
			double valor = sc.nextDouble();
			usuario.getCarteira().setSaldo(usuario.getCarteira().getSaldo() + valor);
			System.out.println("Depósito realizado no valor de: R$ " + valor );
			listaDeposito.add(valor);
		}
	}
	
	public static void saca(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : listaUsuarios) {
			System.out.print("Informe o valor que deseja sacar: R$ ");
			double valor = sc.nextDouble();
			if(usuario.getCarteira().getSaldo() >= valor){
				usuario.getCarteira().setSaldo(usuario.getCarteira().getSaldo() - valor);
				System.out.println("Saque realizado no valor de: R$ " + valor);
				listaSaque.add(valor);
			} else{
				System.out.println("Saldo insuficiente.");
			}
		}
	}
	
	public static void exibeMovimentacoes(){

		System.out.println("---------MOVIMENTAÇÃO FINANCEIRA---------");
		
		for (Double valorDeposito : listaDeposito) {
				System.out.println("Depósito:                    " + valorDeposito + "(+)");
		}
		for (Double valorSaque : listaSaque) {
			System.out.println("Saque:                       " + valorSaque + "(-)");
		}
		for (Usuario usuario : listaUsuarios) {
			System.out.println("-----------------------------------------");
			System.out.println("Saldo Atual:                 " + usuario.getCarteira().getSaldo() + "(s)");
			System.out.println("-----------------------------------------");
		}

	}
}
