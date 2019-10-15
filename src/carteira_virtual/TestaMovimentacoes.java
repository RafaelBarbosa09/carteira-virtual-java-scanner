package carteira_virtual;

import java.util.Scanner;


public class TestaMovimentacoes{

	public static void main(String[] args) {
		
		int opcaoEntrada = 0;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Bem vindo � carteira virtual!");
			
			System.out.println("Escolha uma op��o:");
			System.out.println("1 - Cadastre-se");
			System.out.println("2 - Fa�a login");
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
				System.out.println("Escolha uma op��o v�lida!");
				
				break;
			}
		}while(opcaoEntrada != 3);
	}
}
