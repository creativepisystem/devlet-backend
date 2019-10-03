package br.com.creative.devlet.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;

public class CpfValidator implements
        ConstraintValidator<Cpf, Object> {

    private String regex = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)";
    @Override
    public void initialize(Cpf email) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null && value instanceof  String){

            String s = ((String) value).replaceAll("[^0-9]", "");
            // considera-se erro CPF's formados por uma sequencia de numeros iguais
            if (s.equals("00000000000") ||
                    s.equals("11111111111") ||
                    s.equals("22222222222") || s.equals("33333333333") ||
                    s.equals("44444444444") || s.equals("55555555555") ||
                    s.equals("66666666666") || s.equals("77777777777") ||
                    s.equals("88888888888") || s.equals("99999999999") ||
                    (s.length() != 11))
                return(false);

            char dig10, dig11;
            int sm, i, r, num, peso;

            // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 10;
                for (i=0; i<9; i++) {
                    // converte o i-esimo caractere do CPF em um numero:
                    // por exemplo, transforma o caractere '0' no inteiro 0
                    // (48 eh a posicao de '0' na tabela ASCII)
                    num = (int)(s.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                    dig10 = '0';
                else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for(i=0; i<10; i++) {
                    num = (int)(s.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                    dig11 = '0';
                else dig11 = (char)(r + 48);

                // Verifica se os digitos calculados conferem com os digitos informados.
                if ((dig10 == s.charAt(9)) && (dig11 == s.charAt(10)))
                    return(true);
                else return(false);
            } catch (InputMismatchException erro) {
                return (false);
            }
        }else{
            return value != null;
        }
    }

}