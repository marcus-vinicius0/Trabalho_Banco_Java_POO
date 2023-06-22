package exercicioBanco;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private String nroCarteiraTrabalho;
    private String rg;
    private String sexo;
    private String cargo;
    private float salario;
    private int anoIngresso;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil, String nroCarteiraTrabalho, String rg, String sexo, String cargo, float salario, int anoIngresso) {
        super(nome, cpf, endereco, dataNascimento, estadoCivil);
        this.nroCarteiraTrabalho = nroCarteiraTrabalho;
        this.rg = rg;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.anoIngresso = anoIngresso;
    }
    public Funcionario(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil, String nroCarteiraTrabalho, String rg, String sexo, float salario, int anoIngresso) {
        super(nome, cpf, endereco, dataNascimento, estadoCivil);
        this.nroCarteiraTrabalho = nroCarteiraTrabalho;
        this.rg = rg;
        this.sexo = sexo;
        this.cargo = "Gerente";
        this.salario = salario;
        this.anoIngresso = anoIngresso;
    }

    public String getNroCarteiraTrabalho() {
        return nroCarteiraTrabalho;
    }

    public void setNroCarteiraTrabalho(String nroCarteiraTrabalho) {
        this.nroCarteiraTrabalho = nroCarteiraTrabalho;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nroCarteiraTrabalho='" + nroCarteiraTrabalho + '\'' +
                ", rg='" + rg + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", anoIngresso=" + anoIngresso +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }

    public float calcularSalario(){
        float salarioCalculado = 0;
        if (LocalDate.now().getYear()-anoIngresso > 15){
            salarioCalculado = (float) (this.salario * 1.10);
        }
        return salarioCalculado;
    }
}
