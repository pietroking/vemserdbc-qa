import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDeEleitores, votosBrancos, votosNulos;
        double percentBranco, percentNulo, percentValidos;
        System.out.println("Digite a quantidade total de eleitores do município:");
        totalDeEleitores = sc.nextInt();
        System.out.println("Digite a quantidade de votos em branco:");
        votosBrancos = sc.nextInt();
        percentBranco = (float)(100*votosBrancos)/totalDeEleitores;
        System.out.println("Digite a quantidade de votos nulos:");
        votosNulos = sc.nextInt();
        percentNulo = (float)(100*votosNulos)/totalDeEleitores;
        percentValidos = 100 - percentBranco - percentNulo;

        System.out.println("Os percentuais da votação são:");
        System.out.printf("Votos Válidos: %.2f%%\n", percentValidos);
        System.out.printf("Votos Brancos: %.2f%%\n", percentBranco);
        System.out.printf("Votos Nulos: %.2f%%\n", percentNulo);
    }
}
