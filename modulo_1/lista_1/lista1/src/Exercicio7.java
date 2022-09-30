import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String codigo;
        int quantidade;

        System.out.println("Digite o código do produto:");
        codigo = sc.nextLine();
        System.out.println("Digite a quantidade comprada desse produto:");
        quantidade = sc.nextInt();
        sc.nextLine();

        switch(codigo.toUpperCase()) {
            case "ABCD" -> {
                //System.out.println("O preço total é: R$" + (quantidade*5.30));
                System.out.printf("O preço total é: R$ %.2f\n", (quantidade*5.30));
            }
            case  "XYPK"-> {
                //System.out.println("O preço total é: R$" + (quantidade*6.00));
                System.out.printf("O preço total é: R$ %.2f\n", (quantidade*6.00));
            }
            case  "KLMP"-> {
                //System.out.println("O preço total é: R$" + (quantidade*3.20));
                System.out.printf("O preço total é: R$ %.2f\n", (quantidade*3.20));
            }
            case  "QRST"-> {
                //System.out.println("O preço total é: R$" + (quantidade*2.50));
                System.out.printf("O preço total é: R$ %.2f\n", (quantidade*2.50));
            }
            default -> {
                System.out.println("Código inválido");
            }
        }
    }
}
