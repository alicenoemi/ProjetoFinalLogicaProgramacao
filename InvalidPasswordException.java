public class InvalidPasswordException extends Exception {
	public String getMessage() {
        return "Senha inv�lida. Tente novamente.";
    }
}
