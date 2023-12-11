package exercicioBanco;

public class ContaCorrente extends Conta{
    private float limiteChequeEspecial;
    private float valorTaxaAdministrativa;


    public ContaCorrente(int nroConta, String senha, float limiteChequeEspecial, float valorTaxaAdministrativa) {
        super(nroConta, senha);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.valorTaxaAdministrativa = valorTaxaAdministrativa;
    }

    public float getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(float limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public float getValorTaxaAdministrativa() {
        return valorTaxaAdministrativa;
    }

    public void setValorTaxaAdministrativa(float valorTaxaAdministrativa) {
        this.valorTaxaAdministrativa = valorTaxaAdministrativa;
    }

    /*@Override
    public String toString() {
        return "ContaCorrente{" +
                "limiteChequeEspecial=" + limiteChequeEspecial +
                ", valorTaxaAdministrativa=" + valorTaxaAdministrativa +
                ", nroConta=" + nroConta +
                ", saldoAtual=" + saldoAtual +
                ", dataAbertura='" + dataAbertura + '\'' +
                ", dataUltimaMovimentacao='" + dataUltimaMovimentacao + '\'' +
                ", senha='" + senha + '\'' +
                ", estado=" + estado +
                '}';
    }*/

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limiteChequeEspecial=" + limiteChequeEspecial +
                ", valorTaxaAdministrativa=" + valorTaxaAdministrativa +
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
