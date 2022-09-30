import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String produto;
        double valor, desconto = 0.95;

        System.out.println("Digite o produto: ");
        produto = sc.nextLine();
        System.out.println("Valor do produto:");
        valor = sc.nextDouble();

        System.out.printf("Produto: %s\n" +
                "Preço: R$ %.2f\n" +
                "Promoção: %s\n-------------------\n",produto, valor, produto);
        for (int i=1;i<=10;i++){
            System.out.printf("%d x R$ %.2f = %.2f\n",i, valor*desconto,valor*desconto*i);
            desconto-=0.05;
        }
    }
}
