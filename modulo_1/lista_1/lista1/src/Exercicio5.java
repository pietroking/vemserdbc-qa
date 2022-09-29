import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base, altura;
        System.out.println("Digite o valor da base do retangulo:");
        base = sc.nextDouble();
        System.out.println("Digite o valor da altura do retangulo:");
        altura = sc.nextDouble();

        System.out.println("O valor da área do retangulo é: "+ base*altura);
    }
}
