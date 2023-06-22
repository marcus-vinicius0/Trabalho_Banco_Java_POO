package exercicioBanco;

import java.io.Serializable;
import java.time.LocalDate;

public class Gerente extends Funcionario{
    private boolean cursoDeFormacao;        // false se Não, true se sim
    private String nomeAgencia;
    private static float comissao = 10;

    public Gerente() {
    }

    public Gerente(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil, String nroCarteiraTrabalho, String rg, String sexo, float salario, int anoIngresso, boolean cursoDeFormacao, String nomeAge) {
        super(nome, cpf, endereco, dataNascimento, estadoCivil, nroCarteiraTrabalho, rg, sexo, salario, anoIngresso);
        this.cursoDeFormacao = cursoDeFormacao;
        this.nomeAgencia = nomeAge;
    }

    public boolean isCursoDeFormacao() {
        return cursoDeFormacao;
    }

    public void setCursoDeFormacao(boolean cursoDeFormacao) {
        this.cursoDeFormacao = cursoDeFormacao;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public static float getComissao() {
        return comissao;
    }

    public static void setComissao(float comissao) {
        Gerente.comissao = comissao;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "cursoDeFormacao=" + cursoDeFormacao +
                ", nomeAgencia='" + nomeAgencia + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }

    @Override
    public float calcularSalario(){
        float salarioCalculado = 0;
        salarioCalculado = this.getSalario()*comissao;
        return salarioCalculado;
    }
}
