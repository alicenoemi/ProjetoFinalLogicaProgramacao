import java.util.Scanner;

public class RedeSocial {
	static Scanner entrada = new Scanner(System.in); 
	
	public static void main(String[] args) {
		System.out.println("============== Seja Bem-Vindo A Rede Social ===========");
		System.out.println("");
		System.out.println("	^..^       /");
		System.out.println("	/_/\\_____/    #Dev-Makers2");
		System.out.println("	   /\\   /\\");
		System.out.println("	  /  \\ /  \\");
		System.out.println("			Esse é o makerzinho, o nosso mascote! o/");
		System.out.println("");
		menuInicial();
	}

	static void menuInicial(){
		try {
			System.out.println("==============    MENU INICIAL   ================");
			System.out.println("Qual operação você deseja realizar:\n"
					+ "C - Cadastrar perfil \n"
					+ "E - Entrar na sua conta \n"
					+ "L - Lista de usuarios \n"
					+ "S - Sair");
			
			String opcao = entrada.nextLine().toUpperCase();		
			switch (opcao){
	            case "C": 
	        		Perfil.cadastrarUsuario();
	        		menuInicial();
	        		break;
	            case "E":
	            	Perfil.fazerLogin();
	            	break;
	            case "L":
	            	Perfil.usersList();
	            	menuInicial();
	            	break;
	            case "S": 
	            	System.out.println("Opa, já vai?? ");
	            	System.out.println("	^..^      /");
	        	System.out.println("	/_/\\_____/    #tchAUtchAU");
	        	System.out.println("	   /\\   /\\");
	        	System.out.println("	  /  \\ /  \\");
	        	System.out.println("			  Esperamos de te ver em breve! o/");          	
	            	System.exit(0);
	            	break;           	
	            default:
	            	System.out.println("Operação inválida. Tente novamente.");
	            	menuInicial(); 
	            	break;
			}
		} catch (Exception e) {
			System.out.println("Opss .. algo deu errado! Tente novamente.");
			menuInicial();
		}	
	}
}
