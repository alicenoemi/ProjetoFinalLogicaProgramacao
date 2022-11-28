import java.util.Scanner;

public class Perfil {
	String nome;
	String login;
	String senha;
	
	static Scanner entrada = new Scanner(System.in); 
	static final int TAM = 100;
	static Perfil[] usuarios = new Perfil[TAM];
	static int qtdeusers = 0;
	
	public static void cadastrarUsuario(){
		try {
			Perfil p1 = new Perfil();
			System.out.println("===== CADASTRO DE USUARIOS =====");	
			System.out.print("Digite seu nome: ");
			p1.nome = entrada.nextLine();
			System.out.print("Crie seu login: ");
			p1.login = entrada.nextLine().toLowerCase();		
			for (int i = 0; i < qtdeusers; i++) {
				if (p1.login.equals(usuarios[i].login)) {
					System.out.println("Usuário já cadastrado, tente novamente.");
					RedeSocial.menuInicial();
				}
			}	
			System.out.print("Crie sua senha: ");
			p1.senha = entrada.nextLine().toLowerCase();	
			
			if (p1.nome.isEmpty() || p1.nome.isBlank() || p1.login.isEmpty() || p1.login.isBlank() || p1.senha.isEmpty() || p1.senha.isBlank()) {
	            throw new EmptyFieldException();
	        }
			
			System.out.println("Perfil criado com sucesso!!!");
			usuarios[qtdeusers] = p1;
			qtdeusers++;		
			
		} catch (EmptyFieldException e) {
			System.out.println(e.getMessage());
			cadastrarUsuario();
		}
	}
	
	static void fazerLogin() {
		try {
			if (qtdeusers == 0) {
				System.out.println("Opss .. nenhum perfil cadastrado!");
				RedeSocial.menuInicial();
			} else {
				System.out.println("===== LOGIN =====");	
				System.out.println("Entre com seu login e senha para acessar a Rede Social.");
				System.out.print("Login: ");
				String login = entrada.next().toLowerCase();
				System.out.print("Senha: ");
				String senha = entrada.next().toLowerCase();
				
				for (int i = 0; i < usuarios.length; i++) {
					if(usuarios[i].login.equals(login)) {
						if(usuarios[i].senha.equals(senha)) {
							System.out.println("Olha quem chegou!!");
							System.out.println("	^..^       /");
							System.out.println("	/_/\\_____/     Oi, " + usuarios[i].nome + "!!");
							System.out.println("	   /\\   /\\");
							System.out.println("	  /  \\ /  \\");
							System.out.println("É um prazer te ver por aqui!");
							menuUsuario();
						} else {
							throw new InvalidPasswordException();	
						}
					} else {
						throw new UserNotFoundException();	
					}
				}
			}
		} catch (InvalidPasswordException e) {
			System.out.println(e.getMessage());
			fazerLogin();
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
			fazerLogin();
		}		
	}
	
	static void menuUsuario() {
		try {
			System.out.println("===== MENU DO USUARIO =====");
			System.out.println("O que deseja fazer?");
			System.out.println("P - Postar");
			System.out.println("T - Timeline");
			System.out.println("L - Logout");
			System.out.println("S - Sair");
			String opcao = entrada.nextLine().toUpperCase();
			switch (opcao){
	            case "P": 
	        		Post.post();
	        		menuUsuario();
	        	break;
	            case "T":
	            	Post.timeline();
	            	menuUsuario();
	            break;            	
	            case "L": 
	            	System.out.println("Você será redirecionado para o Menu Inicial.");
	            	RedeSocial.menuInicial();
	            break;
	            case "S": 
	            	System.out.println("Saindo... até logo!");
	            	RedeSocial.menuInicial();
	            break;       
	            default:
	            	System.out.printf("Opss... Operação inválida. \n");
	            	menuUsuario(); 
	            break;
		}
			
		} catch (Exception e) {
			System.out.println("Opss .. algo deu errado. Tente novamente.");
			menuUsuario();
		}		
	}
	
	static void usersList() {
		if (qtdeusers == 0) {
			System.out.println("Opss .. nenhum perfil cadastrado!");
			RedeSocial.menuInicial();
		} else {
			System.out.println("===== LISTA DE USUARIOS =====");
			System.out.println("Aqui esta a lista de usuarios:");
			for (int j = 0; j < qtdeusers; j++) {
				System.out.printf("Nome: %s Login: %s  Senha: %s \n", usuarios[j].nome, usuarios[j].login, usuarios[j].senha);
			}
		}
	}
}
