package carteira_virtual;

import java.util.Scanner;


public class TestaMovimentacoes{

	public static void main(String[] args) {
		
		int opcaoEntrada = 0;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Bem vindo à carteira virtual!");
			
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastre-se");
			System.out.println("2 - Faça login");
			System.out.println("3 - Sair");
			System.out.println("4 - Teste");
			opcaoEntrada = sc.nextInt();
			
			switch (opcaoEntrada) {
			case 1:
				UsuarioService.cadastrarUsuario();
				//UsuarioService.fazLogin();
				break;
			case 2:
				UsuarioService.fazLogin();
				break;
			case 3:
				System.out.println("Saindo...");
				break;
				
			case 4:
				UsuarioService.menuUsuarioLogado();
				
				break;
			default:
				System.out.println("Escolha uma opção válida!");
				
				break;
			}
		}while(opcaoEntrada != 3);
	}
}
