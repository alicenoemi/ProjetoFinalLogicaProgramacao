public class UserNotFoundException extends Exception {
	public String getMessage() {
        return "Usuário nao encontrado. Tente novamente.";
    }
}
