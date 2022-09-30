import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vet = new int[20];
        System.out.println("Digite os valores:");
        for (int i=0;i<20;i++){
            vet[i]=sc.nextInt();
        }
        for (int i=19;i>=0;i--){
            System.out.println(vet[i]);
        }
    }
}
