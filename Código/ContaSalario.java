package exercicioBanco;

public class ContaSalario extends Conta{
    private float limiteSaque;
    private float limiteTransferencia;


    public ContaSalario(int nroConta, String senha, float limiteSaque, float limiteTransferencia) {
        super(nroConta, senha);
        this.limiteSaque = limiteSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

    public float getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(float limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public float getLimiteTransferencia() {
        return limiteTransferencia;
    }

    public void setLimiteTransferencia(float limiteTransferencia) {
        this.limiteTransferencia = limiteTransferencia;
    }

    @Override
    public String toString() {
        return "ContaSalario{" +
                "limiteSaque=" + limiteSaque +
                ", limiteTransferencia=" + limiteTransferencia +
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
