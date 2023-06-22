package exercicioBanco;

import java.io.Serializable;

import java.util.ArrayList;
public class Agencia implements ImpressaoDados, Serializable{
    private int numero;
    private String nomeDoBanco;
    private String endereco;
    private String cidade;
    private String estado;
    private String bairro;
    ArrayList<Conta> listaContas = new ArrayList<>();
    ArrayList<Funcionario> listaFuncionarios;
    private Gerente gerente;
    private static final long serialVersionUID = 1l;

    public Agencia(int numero, String nomeDoBanco, String endereco, String cidade, String estado, String bairro, Gerente gerente) {
        this.numero = numero;
        this.nomeDoBanco = nomeDoBanco;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.gerente = gerente;
        gerente.setNomeAgencia(nomeDoBanco);
    }

    public Agencia(int numero, String nome, String endereco, String cidade, String estado, String bairro) {
        this.numero = numero;
        this.nomeDoBanco = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.listaFuncionarios = new ArrayList<>();
        this.listaContas = new ArrayList<>();
        this.gerente = null;
    }
    public void adicionaContas(Conta conta1){
        this.listaContas.add(conta1);
        conta1.addNomeAgenciaCliente(this.nomeDoBanco);
    }

    public void adicionaFuncionarios(Funcionario funcionario){
        this.listaFuncionarios.add(funcionario);
    }

    public void mostrarContas(){
        System.out.println(nomeDoBanco + " Contas:");
        for (int i = 0; i < listaContas.size(); i++){
            Conta con = listaContas.get(i);
            System.out.println(con.toString());
        }
        System.out.println();
    }

    public void mostrarFuncionarios(){
        System.out.println(nomeDoBanco + " Funcionarios:");
        for (int i = 0; i < listaFuncionarios.size(); i++){
            Funcionario func = listaFuncionarios.get(i);
            System.out.println(func.toString());
        }
        System.out.println();
    }

    public Conta buscarSoConta(int nroConta){
        for (int i = 0; i < listaContas.size(); i++){
            Conta cont = listaContas.get(i);
            if (cont.getNroConta() == nroConta){
                return cont;
            }
        }
        return null;
    }
    //busca Cliente
    public Cliente buscarConta(int nroConta, String cpf){
        for (int i = 0; i < listaContas.size(); i++){
            Conta cont = listaContas.get(i);
            if (cont.getNroConta() == nroConta){
                Cliente cli = cont.buscarCLiente(cpf);
                return cli;
            }
        }
        return null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(String nome) {
        this.nomeDoBanco = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    /*public void imprimirContas(ArrayList<Conta> listaContas){
        for (int i = 0; i < listaContas.size(); i++){
            Conta continha = listaContas.get(i);
            System.out.println(continha.toString());
        }
    }*/

    public void imprimirNomeGerente() {
        System.out.println(gerente.toString());
    }

    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(ArrayList<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "numero=" + numero +
                ", nomeDoBanco='" + nomeDoBanco + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' + '}';
    }
    @Override
    public void imprimirDados(){
        System.out.println(toString());
    }
}
