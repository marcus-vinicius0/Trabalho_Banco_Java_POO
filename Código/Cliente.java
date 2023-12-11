package exercicioBanco;
import java.util.ArrayList;

public class Cliente extends Pessoa implements ImpressaoDados {
    //private Agencia banco;
    //private Conta conta;
    private String escolaridade;
    private ArrayList<Conta> listaContas;
    private ArrayList<String> listaNomesAgencia;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }

    public Cliente(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil, String escolaridade) {
        super(nome, cpf, endereco, dataNascimento, estadoCivil);
        this.escolaridade = escolaridade;
        this.listaContas = new ArrayList<>();
        listaNomesAgencia = new ArrayList<>();
    }
    public Cliente(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil, ArrayList<Conta> listaContas) {
        super(nome, cpf, endereco, dataNascimento, estadoCivil);
        this.listaContas = listaContas;
    }

    /*public Cliente(String nome, String cpf, String endereco, String dataNascimento, String estadoCivil, Conta conta) {
        super(nome, cpf, endereco, dataNascimento, estadoCivil);
        this.conta = conta;
    }*/

    /*public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }*/

    public void adicionarConta(Conta conta){
        this.listaContas.add(conta);
    }
    public void adicionarNomesAgencia(String nome){
        this.listaNomesAgencia.add(nome);
    }

    public void mostrarNomesAgencia(){
        for (int i = 0; i < listaNomesAgencia.size(); i++){
            String nomes = listaNomesAgencia.get(i);
            System.out.println(nomes);
        }
    }

    public void mostrarContas(){
        for (int i = 0; i < listaContas.size(); i++){
            Conta contas = listaContas.get(i);
            System.out.println(contas.toString());
        }
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' + ", escolaridade='"
                + escolaridade + '\'' +
                '}';
    }

    @Override
    public void imprimirDados(){
        System.out.println(toString());
    }

    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(ArrayList<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public ArrayList<String> getListaNomesAgencia() {
        return listaNomesAgencia;
    }

    public void setListaNomesAgencia(ArrayList<String> listaNomesAgencia) {
        this.listaNomesAgencia = listaNomesAgencia;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
}
