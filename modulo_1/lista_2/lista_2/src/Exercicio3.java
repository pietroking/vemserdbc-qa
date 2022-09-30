import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = "";
        int idade=0, cont=0;
        double peso=0, altura=0, mediaAltura=0, maior=0, velho=0, pesado=0;

        System.out.println("Digite o nome do jogador:");
        nome=sc.nextLine();
        do {
            System.out.println("Altura do jogador:");
            altura=sc.nextDouble();
            mediaAltura+=altura;
            if (altura>maior){
                maior = altura;
            }
            System.out.println("Idade do jogador:");
            idade=sc.nextInt();
            if (velho<idade){
                velho = idade;
            }
            System.out.println("Peso do jogador:");
            peso=sc.nextDouble();
            if (pesado<peso){
                pesado = peso;
            }
            cont++;
            sc.nextLine();
            System.out.println("Digite o nome do jogador:");
            nome=sc.nextLine();
        }while(!nome.equals("SAIR"));
        System.out.println("Quantidade de jogadores: "+cont+
            "\nAltura do maior jogadores: "+maior+
            "\nJogador mais velho: "+velho+
            "\nJogador mais pesado: "+pesado+
            "\nMédia das alturas: "+(mediaAltura/cont));
    }
}
