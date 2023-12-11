package exercicioBanco;

public abstract class ValidadorCPF {
    public static boolean validarCPF(String cpf) {
        cpf = cpf.replace(".", "").replace("-", ""); // Remove caracteres de formatação

        final String cpfFinal = cpf; // Cria uma cópia final de cpf

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (CPF inválido)
        boolean digitosIguais = cpf.chars().allMatch(c -> c == cpfFinal.charAt(0));
        if (digitosIguais) {
            return false;
        }


        // Verifica os dígitos verificadores
        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            numeros[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Verifica o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = resto < 2 ? 0 : 11 - resto;
        if (numeros[9] != digitoVerificador1) {
            return false;
        }

        // Verifica o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += numeros[i] * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = resto < 2 ? 0 : 11 - resto;
        if (numeros[10] != digitoVerificador2) {
            return false;
        }

        // CPF válido
        return true;
    }

    /*public static void main(String[] args) {
        String cpf = "523.221.280-07";
        boolean valido = validarCPF(cpf);
        if (valido) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }
    }*/
}
