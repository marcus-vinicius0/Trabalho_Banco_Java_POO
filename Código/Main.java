package exercicioBanco;


import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

import static exercicioBanco.ValidadorCPF.validarCPF;

public class Main {
    public static void main(String[] args) {

        String cpfParaRemover;
        Cliente continha;
        ObjectOutputStream objectOutput;

        ArrayList<Agencia> listaBancos = new ArrayList<>();

        // Cadastro Bancos
        /*
        Agencia banco01 = new Agencia(123, "Itau", "Rua das Couves", "Uberlandia", "MG", "São Jorge");
        Agencia banco02 = new Agencia(456, "Nubank", "Rua das Andorinhas", "Uberaba", "MG", "São João");
        Agencia banco03 = new Agencia(789, "Bradesco", "Avenida José Alves", "Araguari", "MG", "Jardim Botânico");

        listaBancos.add(banco01);
        listaBancos.add(banco02);
        listaBancos.add(banco03);

        objectOutput = null;
        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream("bancos.bytej"));
            objectOutput.writeObject(listaBancos);
            objectOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        // Leitura dos bancos

        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("bancos.bytej"))) {
            listaBancos = (ArrayList<Agencia>) objectInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < listaBancos.size(); i++){
            Agencia bancoTemp = listaBancos.get(i);
            bancoTemp.imprimirDados();
        }

        Scanner ler = new Scanner(System.in);

        System.out.println();
        int opcao = -1;
        while (opcao != 0){
            System.out.print("=== Digite a opcao que vc deseja: === \n\n");
            System.out.print("0 - Para sair.\n");
            System.out.print("1 - Cadastro\n");
            System.out.print("2 - Imprimir Dados\n");
            System.out.print("3 - Fazer uma Operação Bancária\n");
            System.out.print("4 - Funções Adicionais\n");
            //System.out.print("5 - Remover Clientes\n");

            opcao = ler.nextInt();
            switch(opcao){
                case 0:
                    break;
                case 1:
                    System.out.print("=== Digite a opcao que vc deseja: === \n\n");
                    System.out.print("1 - Cadastrar Clientes\n");
                    System.out.print("2 - Cadastrar Funcionários\n");

                    opcao = ler.nextInt();
                    switch (opcao){
                        case 1:
                            System.out.println("Cadastrando Cliente");

                            System.out.println("Digite uma opção de banco:");
                            System.out.printf("1 - Banco Itau\n");
                            System.out.printf("2 - Banco Nubank\n");
                            System.out.printf("3 - Banco Bradesco\n");
                            opcao = ler.nextInt();

                            String nome = "";
                            String cpf = "";
                            String endereco = "";
                            String dataNascimento = "";
                            String estadoCivil = "";
                            String escolaridade = "";

                            ler.nextLine();
                            System.out.println("Digite o nome: ");
                            nome = ler.nextLine();

                            System.out.println("Digite o cpf: ");
                            cpf = ler.next();
                            ler.nextLine();

                            System.out.println("Digite o endereço: ");
                            endereco = ler.nextLine();

                            System.out.println("Digite a Data de Nascimento(DD/MM/YYYY): ");
                            dataNascimento = ler.next();
                            ler.nextLine();

                            System.out.println("Digite o Estado Civil: ");
                            estadoCivil = ler.next();
                            ler.nextLine();

                            System.out.println("Digite a escolaridade: ");
                            escolaridade = ler.nextLine();

                            Cliente cliente = new Cliente(nome, cpf, endereco, dataNascimento, estadoCivil, escolaridade);

                            String nomeEscolhido = "";
                            if (opcao == 1){
                                nomeEscolhido = "Itau";
                            }
                            else if (opcao == 2){
                                nomeEscolhido = "Nubank";
                            }
                            else if (opcao == 3){
                                nomeEscolhido = "Bradesco";
                            }

                            System.out.println("Digite a opção desejada:");
                            System.out.print("1 - Criar uma Conta Nova\n");
                            System.out.print("2 - Conectar a uma Conta já existente\n");
                            opcao = ler.nextInt();
                            switch (opcao){
                                case 1:
                                    cliente.adicionarNomesAgencia(nomeEscolhido);
                                    System.out.println("Digite uma opção de conta para criar: ");
                                    System.out.print("1 - Conta Corrente\n");
                                    System.out.print("2 - Conta Poupança\n");
                                    System.out.print("3 - Conta Salario\n");
                                    opcao = ler.nextInt();

                                    int nroConta;
                                    String senha;

                                    System.out.println("Digite o número da Conta: ");
                                    nroConta = ler.nextInt();

                                    System.out.println("Digite a senha: ");
                                    senha = ler.next();

                                    if(opcao == 1){

                                        float limiteChequeEsp = 0;
                                        float taxaAdm = 0;

                                        System.out.println("Digite o Limite do Cheque Especial: ");
                                        limiteChequeEsp = ler.nextFloat();

                                        System.out.println("Digite o Valor da Taxa Administrativa: ");
                                        taxaAdm = ler.nextFloat();

                                        ContaCorrente conta01 = new ContaCorrente(nroConta, senha, limiteChequeEsp, taxaAdm);
                                        conta01.adicionarCliente(cliente);
                                        cliente.adicionarConta(conta01);


                                        for (Agencia agencia : listaBancos){
                                            if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                                agencia.adicionaContas(conta01);
                                            }
                                        }
                                    }
                                    else if(opcao == 2){
                                        float rendimento;   // rendimento do mês atual

                                        System.out.println("Digite o rendimento do Mês Atual: ");
                                        rendimento = ler.nextFloat();
                                        ler.nextLine();

                                        ContaPoupanca conta01 = new ContaPoupanca(nroConta, senha, rendimento);
                                        conta01.adicionarCliente(cliente);
                                        cliente.adicionarConta(conta01);

                                        for (Agencia agencia : listaBancos){
                                            if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                                agencia.adicionaContas(conta01);
                                            }
                                        }
                                    }
                                    else if(opcao == 3){
                                        float limiteSaque = 0;
                                        float limiteTrans = 0;

                                        System.out.println("Digite o Limite de Saque: ");
                                        limiteSaque = ler.nextFloat();
                                        ler.nextLine();

                                        System.out.println("Digite o Valor do Limite de transferência: ");
                                        limiteTrans = ler.nextFloat();

                                        ContaSalario conta01 = new ContaSalario(nroConta, senha, limiteSaque, limiteTrans);
                                        conta01.adicionarCliente(cliente);
                                        cliente.adicionarConta(conta01);

                                        for (Agencia agencia : listaBancos){
                                            if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                                agencia.adicionaContas(conta01);
                                            }
                                        }
                                    }

                                    break;
                                case 2:
                                    cliente.adicionarNomesAgencia(nomeEscolhido);

                                    System.out.println("Digite o Número da Conta: ");
                                    int nro = ler.nextInt();
                                    ler.nextLine();

                                    for (Agencia agencia : listaBancos){
                                        if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                            Conta conTempor = agencia.buscarSoConta(nro);
                                            conTempor.adicionarCliente(cliente);
                                        }
                                    }


                                    break;
                                default:
                                    System.out.println("Opção inválida");
                            }

                            break;
                        case 2:
                            // Cadastrando Funcionario
                            System.out.println("Digite o Banco do Funcionario: ");
                            System.out.println("1 - Itau");
                            System.out.println("2 - Nubank");
                            System.out.println("3 - Bradesco");
                            nomeEscolhido = "";
                            opcao = ler.nextInt();
                            switch (opcao){
                                case 1:
                                    nomeEscolhido = "Itau";
                                    break;
                                case 2:
                                    nomeEscolhido = "Nubank";
                                    break;
                                case 3:
                                    nomeEscolhido = "Bradesco";
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                            }

                            if (!nomeEscolhido.equals("")){
                                System.out.println("Digite o tipo do cargo do Funcionário:");
                                System.out.println("1 - Função Geral");
                                System.out.println("2 - Gerente");

                                opcao = ler.nextInt();

                                String nroCarteiraTrabalho = "";
                                String rg = "";
                                String sexo = "";
                                String cargo = "";
                                float salario = 0;
                                int anoIngresso = 0;

                                ler.nextLine();
                                System.out.println("Digite o nome: ");
                                nome = ler.nextLine();

                                System.out.println("Digite o cpf: ");
                                cpf = ler.next();
                                ler.nextLine();

                                System.out.println("Digite o endereço: ");
                                endereco = ler.nextLine();

                                System.out.println("Digite a Data de Nascimento(DD/MM/YYYY): ");
                                dataNascimento = ler.next();
                                ler.nextLine();

                                System.out.println("Digite o Estado Civil: ");
                                estadoCivil = ler.next();
                                ler.nextLine();

                                System.out.println("Digite o Número da Carteira de Trabalho: ");
                                nroCarteiraTrabalho = ler.next();
                                ler.nextLine();

                                System.out.println("Digite o RG: ");
                                rg = ler.next();
                                ler.nextLine();

                                System.out.println("Digite o sexo: ");
                                sexo = ler.nextLine();
                                ler.nextLine();

                                System.out.println("Digite o salario:");
                                salario = ler.nextFloat();

                                System.out.println("Digite o ano de Ingresso:");
                                anoIngresso = ler.nextInt();
                                switch (opcao){
                                    case 1:
                                        System.out.println("Digite o Cargo:");
                                        cargo = ler.nextLine();
                                        ler.nextLine();

                                        Funcionario funcionario = new Funcionario(nome, cpf, endereco, dataNascimento, estadoCivil, nroCarteiraTrabalho, rg, sexo, cargo, salario, anoIngresso);

                                        for (Agencia agencia : listaBancos) {
                                            if (agencia.getNomeDoBanco().equals(nomeEscolhido)) {
                                                agencia.adicionaFuncionarios(funcionario);
                                                System.out.println("Funcionário adicionado com Sucesso");
                                            }
                                        }
                                        break;
                                    case 2:
                                        boolean cursoDeFormacao;
                                        ler.nextLine();
                                        System.out.println("Digite se o gerente tem curso de formação ou não(false p/ não, true p/ sim)");
                                        cursoDeFormacao = ler.nextBoolean();

                                        Gerente gerente = new Gerente(nome, cpf, endereco, dataNascimento, estadoCivil, nroCarteiraTrabalho, rg, sexo, salario, anoIngresso, cursoDeFormacao, nomeEscolhido);

                                        for (Agencia agencia : listaBancos) {
                                            if (agencia.getNomeDoBanco().equals(nomeEscolhido)) {
                                                agencia.setGerente(gerente);
                                                System.out.println("Gerente adicionado com Sucesso");
                                            }
                                        }

                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                }
                            }


                            break;
                        default:
                            System.out.println("Tente um valor valido. De 1 a 2.");
                    }

                    objectOutput = null;
                    try {
                        objectOutput = new ObjectOutputStream(new FileOutputStream("bancos.bytej"));
                        objectOutput.writeObject(listaBancos);
                        objectOutput.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.print("=== Digite a opcao que vc deseja: === \n\n");
                    System.out.print("1 - Imprimir todos os Clientes existentes\n");
                    System.out.print("2 - Imprimir os dados de determinado cliente\n");
                    System.out.print("3 - Imprimir todos os Funcionarios Gerais existentes\n");
                    System.out.print("4 - Imprimir todos os Gerentes existentes\n");
                    System.out.print("5 - Imprimir a Lista de Clientes de uma determinada Conta\n");
                    System.out.print("6 - Imprimir a Lista de Contas de um determinado Cliente\n");
                    System.out.print("7 - Voltar Início\n");
                    opcao = ler.nextInt();

                    switch (opcao){
                        case 1:
                            System.out.printf("Imprimindo todos os Clientes existentes\n");
                            for (Agencia agencia : listaBancos){
                                agencia.mostrarContas();
                            }
                            break;
                        case 2:
                            System.out.println("Digite o Banco do cliente: ");
                            System.out.println("1 - Itau");
                            System.out.println("2 - Nubank");
                            System.out.println("3 - Bradesco");
                            opcao = ler.nextInt();

                            String nomeEscolhido = "";
                            if (opcao == 1){
                                nomeEscolhido = "Itau";
                            }
                            else if (opcao == 2){
                                nomeEscolhido = "Nubank";
                            }
                            else if (opcao == 3){
                                nomeEscolhido = "Bradesco";
                            }

                            System.out.println("Digite o Número da Conta do Cliente: ");
                            int nro = ler.nextInt();
                            ler.nextLine();

                            System.out.println("Digite o Cpf do Cliente: ");
                            String cpf = ler.next();
                            ler.nextLine();

                            for (Agencia agencia : listaBancos){
                                if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                    Cliente tem = agencia.buscarConta(nro, cpf);
                                    if (tem != null) tem.imprimirDados();
                                }
                            }
                        case 3:
                            // Imprimindo todos os Funcionários existentes
                            for (Agencia agencia : listaBancos){
                                agencia.mostrarFuncionarios();
                            }

                            break;
                        case 4:
                            // Imprimindo todos os Gerentes existentes
                            for (Agencia agencia : listaBancos){
                                if (agencia.getGerente() != null){
                                    System.out.println(agencia.getGerente().toString());
                                }
                            }

                            break;
                        case 5:
                            // Imprimindo lista de Clientes de uma Conta
                            System.out.println("Digite o Banco do cliente: ");
                            System.out.println("1 - Itau");
                            System.out.println("2 - Nubank");
                            System.out.println("3 - Bradesco");
                            opcao = ler.nextInt();

                            nomeEscolhido = "";
                            if (opcao == 1){
                                nomeEscolhido = "Itau";
                            }
                            else if (opcao == 2){
                                nomeEscolhido = "Nubank";
                            }
                            else if (opcao == 3){
                                nomeEscolhido = "Bradesco";
                            }

                            System.out.println("Digite o Número da Conta do Cliente: ");
                            nro = ler.nextInt();
                            ler.nextLine();

                            for (Agencia agencia : listaBancos){
                                if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                    Conta conTemp = agencia.buscarSoConta(nro);
                                    conTemp.mostrarListaCliente();
                                }
                            }

                            break;
                        case 6:
                            System.out.println("Digite o Banco do cliente: ");
                            System.out.println("1 - Itau");
                            System.out.println("2 - Nubank");
                            System.out.println("3 - Bradesco");
                            opcao = ler.nextInt();

                            nomeEscolhido = "";
                            if (opcao == 1){
                                nomeEscolhido = "Itau";
                            }
                            else if (opcao == 2){
                                nomeEscolhido = "Nubank";
                            }
                            else if (opcao == 3){
                                nomeEscolhido = "Bradesco";
                            }

                            System.out.println("Digite o Número da Conta do Cliente: ");
                            nro = ler.nextInt();
                            ler.nextLine();

                            System.out.println("Digite o Cpf do Cliente: ");
                            cpf = ler.next();
                            ler.nextLine();

                            for (Agencia agencia : listaBancos){
                                if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                    Cliente tem = agencia.buscarConta(nro, cpf);
                                    if (tem != null) tem.mostrarContas();
                                }
                            }
                            break;
                        case 7:
                            System.out.println("Voltando para o início...\n");
                            break;
                        default:
                            System.out.println("Tente um valor valido. De 1 a 5.");
                    }

                    break;
                case 3:
                    // Fazer Operações Bancárias
                    System.out.println("Digite o Banco do cliente: ");
                    System.out.println("1 - Itau");
                    System.out.println("2 - Nubank");
                    System.out.println("3 - Bradesco");
                    String nomeEscolhido = "";
                    opcao = ler.nextInt();
                    switch (opcao){
                        case 1:
                            nomeEscolhido = "Itau";
                            break;
                        case 2:
                            nomeEscolhido = "Nubank";
                            break;
                        case 3:
                            nomeEscolhido = "Bradesco";
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }

                    if (!nomeEscolhido.equals("")){
                        System.out.println("Digite o Número da Conta do Cliente: ");
                        int nro = ler.nextInt();
                        ler.nextLine();

                        Conta contaTemporaria = null;

                        for (Agencia agencia : listaBancos){
                            if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                contaTemporaria = agencia.buscarSoConta(nro);
                            }
                        }

                        if (contaTemporaria != null){
                            String senha = "";

                            for (int i=0; i<3; i++){
                                System.out.println("Digite a senha para realizar uma operação: ");
                                senha = ler.nextLine();
                                if (Objects.equals(senha, contaTemporaria.getSenha())){
                                    i = 3;
                                    System.out.print("=== Digite a opcao que vc deseja: === \n\n");
                                    System.out.print("1 - Sacar\n");
                                    System.out.print("2 - Depositar\n");
                                    System.out.print("3 - Pagar Conta\n");
                                    System.out.print("4 - Consultar Saldo\n");
                                    System.out.print("5 - Consultar Extrato\n");
                                    opcao = ler.nextInt();

                                    Transacao transacao;
                                    transacao = new Transacao(contaTemporaria);
                                    float valor = 0;
                                    int parametro = -1;
                                    switch (opcao){
                                        case 1:
                                            System.out.println("Digite o valor para Sacar:");
                                            valor = ler.nextFloat();
                                            parametro = transacao.saque(valor);
                                            if(parametro == 0){
                                                contaTemporaria.adicionarTransacao(transacao);
                                                contaTemporaria.setDataUltimaMovimentacao(transacao.getDataTransacao());
                                            }

                                            break;
                                        case 2:
                                            System.out.println("Digite o valor para Depositar:");
                                            valor = ler.nextFloat();
                                            parametro = transacao.deposito(valor);
                                            if(parametro == 0){
                                                contaTemporaria.adicionarTransacao(transacao);
                                                contaTemporaria.setDataUltimaMovimentacao(transacao.getDataTransacao());
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Digite o valor para Pagar a Conta:");
                                            valor = ler.nextFloat();
                                            parametro = transacao.pagamento(valor);
                                            if(parametro == 0){
                                                contaTemporaria.adicionarTransacao(transacao);
                                                contaTemporaria.setDataUltimaMovimentacao(transacao.getDataTransacao());
                                            }
                                            break;
                                        case 4:
                                            transacao.consultarSaldo();
                                            break;
                                        case 5:
                                            contaTemporaria.mostrarListaTransacao();
                                            break;
                                        default:
                                            System.out.println("Opção inválida");
                                            break;
                                    }
                                }
                                else if(i == 2) System.out.println("Número de Tentativas excedido");
                            }


                        } else System.out.println("Erro: Conta não encontrada!");
                    }
                    else System.out.println("Opção inválida");

                    break;
                case 4:
                    // Funções adicionais
                    System.out.println("Digite a opção Desejada: ");
                    System.out.println("1 - Criar uma nova Conta para um Cliente");
                    System.out.println("2 - Calcular o salário de um funcionário");
                    System.out.println("3 - Editar um atributo");

                    opcao = ler.nextInt();
                    switch (opcao){
                        case 1:
                            // Criando uma conta nova
                            System.out.println("Buscando Cliente...");
                            System.out.println("Digite o Banco do cliente: ");
                            System.out.println("1 - Itau");
                            System.out.println("2 - Nubank");
                            System.out.println("3 - Bradesco");
                            opcao = ler.nextInt();

                            nomeEscolhido = "";
                            if (opcao == 1){
                                nomeEscolhido = "Itau";
                            }
                            else if (opcao == 2){
                                nomeEscolhido = "Nubank";
                            }
                            else if (opcao == 3){
                                nomeEscolhido = "Bradesco";
                            }

                            System.out.println("Digite o Número da Conta do Cliente: ");
                            int nro = ler.nextInt();
                            ler.nextLine();

                            System.out.println("Digite o Cpf do Cliente: ");
                            String cpf = ler.next();
                            ler.nextLine();

                            Cliente temp = null;

                            for (Agencia agencia : listaBancos){
                                if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                    temp = agencia.buscarConta(nro, cpf);
                                }
                            }
                            if (temp != null){
                                temp.adicionarNomesAgencia(nomeEscolhido);

                                System.out.println("Digite o Banco que você deseja criar uma Conta nova: ");
                                System.out.println("1 - Itau");
                                System.out.println("2 - Nubank");
                                System.out.println("3 - Bradesco");
                                opcao = ler.nextInt();

                                nomeEscolhido = "";
                                if (opcao == 1){
                                    nomeEscolhido = "Itau";
                                }
                                else if (opcao == 2){
                                    nomeEscolhido = "Nubank";
                                }
                                else if (opcao == 3){
                                    nomeEscolhido = "Bradesco";
                                }
                                System.out.println("Digite uma opção de conta para criar: ");
                                System.out.print("1 - Conta Corrente\n");
                                System.out.print("2 - Conta Poupança\n");
                                System.out.print("3 - Conta Salario\n");
                                opcao = ler.nextInt();

                                int nroConta;
                                String senha;

                                System.out.println("Digite o número da Conta: ");
                                nroConta = ler.nextInt();

                                System.out.println("Digite a senha: ");
                                senha = ler.next();

                                if(opcao == 1){

                                    float limiteChequeEsp = 0;
                                    float taxaAdm = 0;

                                    System.out.println("Digite o Limite do Cheque Especial: ");
                                    limiteChequeEsp = ler.nextFloat();

                                    System.out.println("Digite o Valor da Taxa Administrativa: ");
                                    taxaAdm = ler.nextFloat();

                                    ContaCorrente conta01 = new ContaCorrente(nroConta, senha, limiteChequeEsp, taxaAdm);
                                    conta01.adicionarCliente(temp);
                                    temp.adicionarConta(conta01);


                                    for (Agencia agencia : listaBancos){
                                        if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                            agencia.adicionaContas(conta01);
                                        }
                                    }
                                }
                                else if(opcao == 2){
                                    float rendimento;   // rendimento do mês atual

                                    System.out.println("Digite o rendimento do Mês Atual: ");
                                    rendimento = ler.nextFloat();
                                    ler.nextLine();

                                    ContaPoupanca conta01 = new ContaPoupanca(nroConta, senha, rendimento);
                                    conta01.adicionarCliente(temp);
                                    temp.adicionarConta(conta01);

                                    for (Agencia agencia : listaBancos){
                                        if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                            agencia.adicionaContas(conta01);
                                        }
                                    }
                                }
                                else if(opcao == 3){
                                    float limiteSaque = 0;
                                    float limiteTrans = 0;

                                    System.out.println("Digite o Limite de Saque: ");
                                    limiteSaque = ler.nextFloat();
                                    ler.nextLine();

                                    System.out.println("Digite o Valor do Limite de transferência: ");
                                    limiteTrans = ler.nextFloat();

                                    ContaSalario conta01 = new ContaSalario(nroConta, senha, limiteSaque, limiteTrans);
                                    conta01.adicionarCliente(temp);
                                    temp.adicionarConta(conta01);

                                    for (Agencia agencia : listaBancos){
                                        if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                            agencia.adicionaContas(conta01);
                                        }
                                    }
                                }
                            }
                            else System.out.println("Erro - Cliente não encontrado");
                            break;
                        case 2:
                            System.out.println("Digite a opção Desejada: ");
                            System.out.println("1 - Calcular o salário de um Funcionário Geral");
                            System.out.println("2 - Calcular o salário de um Gerente");

                            opcao = ler.nextInt();
                            switch (opcao){
                                case 1:
                                    System.out.println("Digite o Banco do Funcionário: ");
                                    System.out.println("1 - Itau");
                                    System.out.println("2 - Nubank");
                                    System.out.println("3 - Bradesco");
                                    opcao = ler.nextInt();

                                    nomeEscolhido = "";
                                    if (opcao == 1){
                                        nomeEscolhido = "Itau";
                                    }
                                    else if (opcao == 2){
                                        nomeEscolhido = "Nubank";
                                    }
                                    else if (opcao == 3){
                                        nomeEscolhido = "Bradesco";
                                    }

                                    System.out.println("Digite o cpf do funcionario: ");
                                    cpf = ler.next();

                                    for (Agencia agencia : listaBancos){
                                        if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                            for (Funcionario funcionario : agencia.listaFuncionarios){
                                                if (funcionario.getCpf().equals(cpf)){
                                                    System.out.println(funcionario.calcularSalario());
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Digite o Banco do Gerente: ");
                                    System.out.println("1 - Itau");
                                    System.out.println("2 - Nubank");
                                    System.out.println("3 - Bradesco");
                                    opcao = ler.nextInt();

                                    nomeEscolhido = "";
                                    if (opcao == 1){
                                        nomeEscolhido = "Itau";
                                    }
                                    else if (opcao == 2){
                                        nomeEscolhido = "Nubank";
                                    }
                                    else if (opcao == 3){
                                        nomeEscolhido = "Bradesco";
                                    }

                                    for (Agencia agencia : listaBancos){
                                        if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                            System.out.println(agencia.getGerente().calcularSalario());
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Opção Inválida");

                                }
                                break;
                        case 3:
                            // Editando um atributo
                            System.out.println("Buscando Cliente...");
                            System.out.println("Digite o Banco do cliente: ");
                            System.out.println("1 - Itau");
                            System.out.println("2 - Nubank");
                            System.out.println("3 - Bradesco");
                            opcao = ler.nextInt();

                            nomeEscolhido = "";
                            if (opcao == 1){
                                nomeEscolhido = "Itau";
                            }
                            else if (opcao == 2){
                                nomeEscolhido = "Nubank";
                            }
                            else if (opcao == 3){
                                nomeEscolhido = "Bradesco";
                            }

                            System.out.println("Digite o Número da Conta do Cliente: ");
                            nro = ler.nextInt();
                            ler.nextLine();

                            System.out.println("Digite o Cpf do Cliente: ");
                            cpf = ler.next();
                            ler.nextLine();

                            Cliente tempo = null;

                            for (Agencia agencia : listaBancos){
                                if (agencia.getNomeDoBanco().equals(nomeEscolhido)){
                                    tempo = agencia.buscarConta(nro, cpf);
                                }
                            }
                            if (tempo != null){
                                System.out.println("Digite o novo Cpf:");
                                cpf = ler.nextLine();

                                tempo.setCpf(cpf);
                            }
                            else System.out.println("Erro - Cliente não encontrado");
                            }
                            break;

                default:
                    System.out.println("Tente um valor valido. De 1 a 4.");
            }
        }

        objectOutput = null;
        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream("bancos.bytej"));
            objectOutput.writeObject(listaBancos);
            objectOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
