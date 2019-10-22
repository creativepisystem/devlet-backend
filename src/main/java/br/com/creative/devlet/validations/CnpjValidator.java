package br.com.creative.devlet.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;

public class CnpjValidator implements
        ConstraintValidator<Cnpj, Object> {

    private String regex = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)";
    @Override
    public void initialize(Cnpj s) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null && value instanceof  String){

            String s = ((String) value).replaceAll("[^0-9]", "");
            // considera-se erro s's formados por uma sequencia de numeros iguais
            if (s.equals("00000000000000") || s.equals("11111111111111") ||
                    s.equals("22222222222222") || s.equals("33333333333333") ||
                    s.equals("44444444444444") || s.equals("55555555555555") ||
                    s.equals("66666666666666") || s.equals("77777777777777") ||
                    s.equals("88888888888888") || s.equals("99999999999999") ||
                    (s.length() != 14))
                return(false);

            char dig13, dig14;
            int sm, i, r, num, peso;

            // "try" - protege o código para eventuais erros de conversao de tipo (int)
            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 2;
                for (i=11; i>=0; i--) {
                    // converte o i-ésimo caractere do s em um número:
                    // por exemplo, transforma o caractere '0' no inteiro 0
                    // (48 eh a posição de '0' na tabela ASCII)
                    num = (int)(s.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso + 1;
                    if (peso == 10)
                        peso = 2;
                }

                r = sm % 11;
                if ((r == 0) || (r == 1))
                    dig13 = '0';
                else dig13 = (char)((11-r) + 48);

                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 2;
                for (i=12; i>=0; i--) {
                    num = (int)(s.charAt(i)- 48);
                    sm = sm + (num * peso);
                    peso = peso + 1;
                    if (peso == 10)
                        peso = 2;
                }

                r = sm % 11;
                if ((r == 0) || (r == 1))
                    dig14 = '0';
                else dig14 = (char)((11-r) + 48);

                // Verifica se os dígitos calculados conferem com os dígitos informados
                if ((dig13 == s.charAt(12)) && (dig14 == s.charAt(13)))
                    return(true);
                else return(false);
            } catch (InputMismatchException erro) {
                return(false);
            }
        }else{
            return false;
        }
    }

}