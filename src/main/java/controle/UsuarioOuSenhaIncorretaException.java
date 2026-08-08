package controle;

public class UsuarioOuSenhaIncorretaException extends Exception {

    public UsuarioOuSenhaIncorretaException() {
    }

    public UsuarioOuSenhaIncorretaException(String msg) {
        super(msg);
    }
}
