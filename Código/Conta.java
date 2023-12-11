package exercicioBanco;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Conta implements Serializable {
    protected int nroConta;
    protected float saldoAtual;
    protected LocalDate dataAbertura;
    protected LocalDate dataUltimaMovimentacao;
    protected String senha;
    protected Boolean estado;   // Estado da Conta, 1 Ativa, 0 Desativada
    protected ArrayList<Cliente> listaClientes;
    private static final long serialVersionUID = 1l;
    private ArrayList<Transacao> listaTransacao;

    public Conta(int nroConta, String senha) {
        this.nroConta = nroConta;
        this.saldoAtual = 0;
        this.dataAbertura = LocalDate.now(); // Obtém a data atual do sistema;
        this.dataUltimaMovimentacao = null;
        this.senha = senha;
        this.estado = true;
        this.listaClientes = new ArrayList<>();
        this.listaTransacao = new ArrayList<>();
    }

    //protected Cliente[] clientes = new Cliente[2];
    //protected int controle = 0;
    //protected Agencia banco;

    /*public Conta(int nroConta, float saldoAtual, String dataAbertura, String senha, Agencia bancos) {
        this.nroConta = nroConta;
        this.saldoAtual = saldoAtual;
        this.dataAbertura = dataAbertura;
        this.senha = senha;
        dataUltimaMovimentacao = "";
        estado = 1;
        this.banco = bancos;
    }*/

    public Conta(int nroConta, float saldoAtual, String senha) {
        this.nroConta = nroConta;
        this.saldoAtual = saldoAtual;
        this.dataAbertura = LocalDate.now(); // Obtém a data atual do sistema
        this.senha = senha;
        dataUltimaMovimentacao = null;
        estado = true;
    }

    /*public void addCliente(Cliente cliente){
        if(controle == 0){
            this.clientes[0] = cliente;
            controle++;
        }
        else if (controle == 1) {
            this.clientes[1] = cliente;
            controle++;
        }
        else System.out.println("Número máximo de clientes atingido");
    }*/

    public Cliente buscarCLiente(String cpf){
        for (int i = 0; i < listaClientes.size(); i++){
            Cliente clien = listaClientes.get(i);
            if (clien.getCpf().equals(cpf)){
                //System.out.println(clien.getNome());
                //System.out.println(clien.getEndereco());
                return clien;
            }
        }
        return null;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }

    public float getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public LocalDate getDataUltimaMovimentacao() {
        return dataUltimaMovimentacao;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /*public Agencia getBanco() {
        return banco;
    }

    public void setBanco(Agencia banco) {
        this.banco = banco;
    }*/

    @Override
    public String toString() {
        return "Conta{" +
                "nroConta=" + nroConta +
                ", saldoAtual=" + saldoAtual +
                ", dataAbertura='" + dataAbertura + '\'' +
                ", dataUltimaMovimentacao='" + dataUltimaMovimentacao + '\'' +
                ", senha='" + senha + '\'' +
                ", estado=" + estado +
                '}';
    }

    public void adicionarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }

    public void adicionarTransacao(Transacao transacao){
        this.listaTransacao.add(transacao);
    }

    public void addNomeAgenciaCliente(String nome){
        for (int i = 0; i < listaClientes.size(); i++){
            Cliente pessoa = listaClientes.get(i);
            pessoa.adicionarNomesAgencia(nome);
        }
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void mostrarListaTransacao(){
        System.out.println("Extrato:");
        for (int i = 0; i < listaTransacao.size(); i++){
            Transacao temp = listaTransacao.get(i);
            System.out.println(temp.toString());
        }
        System.out.println();
    }

    public void mostrarListaCliente(){
        System.out.println("Clientes:");
        for (int i = 0; i < listaClientes.size(); i++){
            Cliente temp = listaClientes.get(i);
            temp.imprimirDados();
        }
        System.out.println();
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataUltimaMovimentacao(LocalDate dataUltimaMovimentacao) {
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
    }

    public ArrayList<Transacao> getListaTransacao() {
        return listaTransacao;
    }

    public void setListaTransacao(ArrayList<Transacao> listaTransacao) {
        this.listaTransacao = listaTransacao;
    }
}
