import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] mercados = {
                {10.9,10.8,10.9},
                {6,8,9},
                {6.7,5.8,4.9},
                {8.6,8,7.9},
                {5.6,4.8,4.9},
                {6,5.8,5.9},
                {4.2,3.8,3.9},
                {9,9,9},
                {12,15,14},
                {17,10,11}
    };
        double[] totalmercado = {0,0,0};

        for (int j=0;j<3;j++){
            for (int i=0;i<10;i++){
                totalmercado[j] += mercados[i][j];
            }
        }
        double menor = totalmercado[0];
        for (int j=0;j<3;j++){
            if (menor>totalmercado[j]){
                menor = totalmercado[j];
            }
        }
        System.out.println("O preço no mercado mais barato é de R$ "+menor);
    }
}
