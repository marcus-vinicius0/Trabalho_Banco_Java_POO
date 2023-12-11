package exercicioBanco;

import java.io.Serializable;

import static exercicioBanco.ValidadorCPF.validarCPF;

public abstract class Pessoa implements Serializable {
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String dataNascimento;
    protected String estadoCivil;
    private static final long serialVersionUID = 1l;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;

        boolean valido = validarCPF(cpf);
        if (valido) {
            System.out.println("CPF válido.");
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido.");
            this.cpf = ".";
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        boolean valido = validarCPF(cpf);
        if (valido) {
            System.out.println("CPF válido.");
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido.");
            this.cpf = ".";
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}
