package exercicioBanco;

import java.io.Serializable;
import java.time.LocalDate;

public class Transacao implements Serializable {
    //saque, depósito, consultar saldo e efetuar pagamento
    private String tipoTransacao;
    private LocalDate dataTransacao;
    private float valorTransacao;
    private String canalTransacao;  // internet banking, caixa eletrônico ou caixa físico
    private Conta conta;
    private static final long serialVersionUID = 1l;

    public Transacao(Conta conta) {
        this.dataTransacao = LocalDate.now();
        this.conta = conta;
        this.tipoTransacao = "";
        this.canalTransacao = "";
    }

    public int saque(float valor) {
        try {
            if ((0 < valor) && (valor <= this.conta.getSaldoAtual())) {
                this.conta.setSaldoAtual(this.conta.getSaldoAtual() - valor);
                this.valorTransacao = valor;
                this.tipoTransacao = "Saque";
                return 0;
            } else if (valor <= 0) {
                throw new ValidaTransacaoException("Valor menor ou igual a 0");
            } else {
                throw new ValidaTransacaoException("Valor ultrapassa o saldo");
            }
        } catch (ValidaTransacaoException ex) {
            System.out.println("Ocorreu um erro durante o saque: " + ex.getMessage());
        }
        return 1;
    }

    public void consultarSaldo(){
        System.out.println(this.conta.getSaldoAtual());
    }

    public int deposito(float valor){
        try {
            if (valor > 0) {
                this.conta.setSaldoAtual(this.conta.getSaldoAtual() + valor);
                this.valorTransacao = valor;
                this.tipoTransacao = "Deposito";
                return 0;
            } else if (valor <= 0) {
                throw new ValidaTransacaoException("Valor menor ou igual a 0");
            }
        } catch (ValidaTransacaoException ex) {
            System.out.println("Ocorreu um erro durante o deposito: " + ex.getMessage());
        }
        return 1;
    }

    public int pagamento(float valor){
        try {
            if ((0 < valor) && (valor <= this.conta.getSaldoAtual())) {
                this.conta.setSaldoAtual(this.conta.getSaldoAtual() - valor);
                this.valorTransacao = valor;
                this.tipoTransacao = "Pagamento";
                return 0;
            } else if (valor <= 0) {
                throw new ValidaTransacaoException("Valor menor ou igual a 0");
            } else {
                throw new ValidaTransacaoException("Valor ultrapassa o saldo");
            }
        } catch (ValidaTransacaoException ex) {
            System.out.println("Ocorreu um erro durante o pagamento: " + ex.getMessage());
        }
        return 1;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public float getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(float valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public String getCanalTransacao() {
        return canalTransacao;
    }

    public void setCanalTransacao(String canalTransacao) {
        this.canalTransacao = canalTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "tipoTransacao='" + tipoTransacao + '\'' +
                ", dataTransacao=" + dataTransacao +
                ", valorTransacao=" + valorTransacao +
                '}';
    }
}
