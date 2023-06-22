package exercicioBanco;

public class ContaPoupanca extends Conta{
    private float rendimentoDoMesAtual;

    public ContaPoupanca(int nroConta, String senha, float rendimentoDoMesAtual) {
        super(nroConta, senha);
        this.rendimentoDoMesAtual = rendimentoDoMesAtual;
    }

    public float getRendimentoDoMesAtual() {
        return rendimentoDoMesAtual;
    }

    public void setRendimentoDoMesAtual(float rendimentoDoMesAtual) {
        this.rendimentoDoMesAtual = rendimentoDoMesAtual;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "rendimentoDoMesAtual=" + rendimentoDoMesAtual +
                ", nroConta=" + nroConta +
                ", saldoAtual=" + saldoAtual +
                ", dataAbertura='" + dataAbertura + '\'' +
                ", dataUltimaMovimentacao='" + dataUltimaMovimentacao + '\'' +
                ", senha='" + senha + '\'' +
                ", estado=" + estado +
                ", listaClientes=" + listaClientes +
                '}';
    }
}
