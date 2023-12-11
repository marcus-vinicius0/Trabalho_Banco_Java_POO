package exercicioBanco;

public class ValidaTransacaoException extends IllegalStateException {
    public ValidaTransacaoException(String mensagem) {
        super(mensagem);
    }
}