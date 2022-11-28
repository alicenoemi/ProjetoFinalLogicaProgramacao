import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Post {
	String data;
	String hora;
	String conteudo;
	
	static Scanner entrada = new Scanner(System.in); 
	private static final String LocalDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private static final String LocalHour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));;
	static final int TAM = 100;
	static Post[] posts = new Post[TAM];
	static int qtdeposts = 0;
	
	static void post() {
		try {
			Post p = new Post();
			System.out.println("===== CRIANDO UM POST =====");	
			p.data = LocalDate;
			p.hora = LocalHour;						
			System.out.print("Deixe aqui sua mensagem: ");
			p.conteudo = entrada.nextLine();
			
			if (p.data.isEmpty() || p.data.isBlank() || p.hora.isEmpty() || p.hora.isBlank() || p.conteudo.isEmpty() || p.conteudo.isBlank()) {
                throw new EmptyFieldException();   	
            }	
			
			System.out.println("Post criado com sucesso!");
			posts[qtdeposts] = p;
			qtdeposts++;			
			
		} catch (EmptyFieldException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	static void timeline() {
		if (qtdeposts == 0) {
			System.out.println("Opss .. você ainda não criou nenhum post!");
			Perfil.menuUsuario();
		} else {
			System.out.println("===== TIMELINE =====");
			System.out.println("Aqui estão suas últimas postagens:");
			for (int j = 0; j < qtdeposts; j++) {
				System.out.printf("%s às %s - '%s' \n", posts[j].data, posts[j].hora, posts[j].conteudo);
			}
		}
	}
}
