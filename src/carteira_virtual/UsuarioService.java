package carteira_virtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface UsuarioService{

	public static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public static void cadastrarUsuario(){

		Scanner sc = new Scanner(System.in);
		Usuario novoUsuario = new Usuario();
		Carteira novaCarteira = new Carteira();
		
		System.out.println("----------------------------");
		System.out.println("      CADASTRAR USUÁRIO     ");
		System.out.println("----------------------------");
		
		System.out.println("Nome: ");
		novoUsuario.setNome(sc.nextLine());
		
		System.out.println("Sobrenome: ");
		novoUsuario.setSobrenome(sc.nextLine());
		
		System.out.println("CPF: ");
		novoUsuario.setCpf(sc.nextLine());
		
		System.out.println("Informe seu saldo inicial: ");
		novaCarteira.setSaldo(sc.nextDouble());
		
		novaCarteira.setTitular(novoUsuario);
		novoUsuario.setCarteira(novaCarteira);
		
		listaUsuarios.add(novoUsuario);
		
		int idUsuario = listaUsuarios.indexOf(novoUsuario) + 1;
		novoUsuario.setId(idUsuario);
		
		for (Usuario usuario : listaUsuarios) {
			System.out.println("Id: " + usuario.getId());
			System.out.println("Nome Completo: " + usuario.getNome() + usuario.getSobrenome());
			System.out.println("Cpf: " + usuario.getCpf());
			System.out.println("Saldo: " + novaCarteira.getSaldo());
			System.out.println();
		}

		System.out.println("Tecle enter para continuar...");
		sc.nextLine();
		
//		System.out.println("Usuario cadastrado com sucesso!");
//		System.out.println("Usuário: " + novoUsuario.getNome() + " " + novoUsuario.getSobrenome());
//		System.out.println("Cpf: " + novoUsuario.getCpf());
//		
//		System.out.println("Dono da carteira: " + novaCarteira.getTitular().getNome());
//		System.out.println("Saldo da carteira: " + novaCarteira.getSaldo());

	}
	
	public static void buscaSaldo(){

		for (Usuario usuario : listaUsuarios) {
			System.out.println(usuario.getId() + " - "+ usuario.getNome() + " " + usuario.getSobrenome() +  " " + usuario.getCarteira().getSaldo() );
		}
	}
	
	public static void deposita(){
		
		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : listaUsuarios) {
			System.out.println("Informe o valor que deseja depositar: ");
			double valor = sc.nextDouble();
			usuario.getCarteira().setSaldo(usuario.getCarteira().getSaldo() + valor);
			System.out.println(usuario.getId() + " - "+ usuario.getNome() + " " + usuario.getSobrenome() +  " " + usuario.getCarteira().getSaldo() );
		}
	}
	
	public static void saca(){
		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : listaUsuarios) {
			System.out.println("Informe o valor que deseja sacar: ");
			double valor = sc.nextDouble();
			usuario.getCarteira().setSaldo(usuario.getCarteira().getSaldo() - valor);
			System.out.println(usuario.getId() + " - "+ usuario.getNome() + " " + usuario.getSobrenome() +  " " + usuario.getCarteira().getSaldo() );
		}
	}
	
	public static void menuUsuarioLogado(){
		
		int opcao = 0;
		Scanner sc = new Scanner(System.in);
		boolean usuarioLogado = true;
		
		do{
			if(usuarioLogado){
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
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Insira uma opção válida!");
					break;
				}
			} else{
				System.out.println("Faça login na aplicação. ");
			}
		}while(opcao != 3);
	}
	
	public static void fazLogin(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----------------------------");
		System.out.println("            LOGIN           ");
		System.out.println("----------------------------");
		
		System.out.println("Cpf: ");
		
		System.out.println("Senha: ");
		sc.nextLine();
	}
	
	public static void realizaOperacao(){
		int operacao = 0;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Informe a operação desejada.");
			System.out.println("1 - Saque");
			System.out.println("2 - Depósito");
			System.out.println("3 - movimentações");
			System.out.println("4 - sair");
			operacao = sc.nextInt();
			
			switch (operacao) {
			case 1:
				saca();
				break;
			case 2:
				deposita();
				break;
			case 3:
				System.out.println("Realizando movimentação...");
				break;
			case 4:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Escolha uma opção válida!");
				break;
			}
		}while(operacao != 4);
	}
}
