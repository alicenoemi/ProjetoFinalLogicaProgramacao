public class UserNotFoundException extends Exception {
	public String getMessage() {
        return "Usu�rio nao encontrado. Tente novamente.";
    }
}
