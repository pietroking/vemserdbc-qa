import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero, chute;
        System.out.println("Digite o numero a ser adivinhado:");
        numero = sc.nextInt();
        System.out.println("Tente advinhar o numero:");

        do {
            chute = sc.nextInt();
            if (chute == numero){
                System.out.println("VOCE ACERTOU O NUMERO");
            } else if (chute < numero) {
                System.out.println("MAIS ALTO :D");
            }else {
                System.out.println("mais baixo (:");
            }
        }while (chute != numero);
    }
}
