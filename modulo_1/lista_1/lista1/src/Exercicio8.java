import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cargo;
        double salario;

        System.out.println("Digite seu salário:");
        salario = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite seu cargo ou código:");
        cargo = sc.nextLine();



        switch(cargo) {
            case "Gerente" : case "101":
                System.out.printf("Salário antigo: R$ %.2f\n", (salario));
                System.out.printf("Salário novo: R$ %.2f\n", (salario*1.1));
                System.out.printf("Diferença de salários: R$ %.2f\n", ((salario*1.1)-salario));
                break;

            case "Engenheiro" : case "102":
                System.out.printf("Salário antigo: R$ %.2f\n", (salario));
                System.out.printf("Salário novo: R$ %.2f\n", (salario*1.2));
                System.out.printf("Diferença de salários: R$ %.2f\n", ((salario*1.2)-salario));
                break;

            case "Tecnico" : case "103":
                System.out.printf("Salário antigo: R$ %.2f\n", (salario));
                System.out.printf("Salário novo: R$ %.2f\n", (salario*1.3));
                System.out.printf("Diferença de salários: R$ %.2f\n", ((salario*1.3)-salario));
                break;

            default:
                System.out.printf("Salário antigo: R$ %.2f\n", (salario));
                System.out.printf("Salário novo: R$ %.2f\n", (salario*1.4));
                System.out.printf("Diferença de salários: R$ %.2f\n", ((salario*1.4)-salario));
                break;
        }
    }
}
