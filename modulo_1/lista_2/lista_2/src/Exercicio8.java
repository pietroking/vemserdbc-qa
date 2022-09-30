import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vet = {6,8,9,4,7,8,3,6,8,1};
        int num, cont=0, maior=0, menor=0;

        System.out.println("Digite um numero:");
        num = sc.nextInt();
        for (int i=0;i<10;i++){
            if (num == vet[i]){
                cont++;
            } else if (num < vet[i]) {
                menor++;
            }else {
                maior++;
            }
        }
        System.out.println("O numero aparece "+cont+" no vetor\n" +
                "Existem "+menor+" numeros menores\n" +
                "Existem "+maior+" numeros maiores");
    }
}
