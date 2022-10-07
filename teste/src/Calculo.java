import java.util.function.Function;

public class Calculo {
    public static void main(String[] args) {

        Calculo1 soma = (valor1, valor2) -> (valor1 + valor2);

        Calculo1 multiplicacao = (valor1, valor2) -> (valor1*valor2);

        System.out.println(soma.calcular(15,5));
        System.out.println(multiplicacao.calcular(5,5));
    }
}
