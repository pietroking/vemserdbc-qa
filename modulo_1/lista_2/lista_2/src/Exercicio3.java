import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = "", nomeVelho = "", nomePesado = "";
        int idade=0, cont=0;
        double peso=0, altura=0, mediaAltura=0, maior=0, velho=0, pesado=0;

        System.out.println("Digite o nome do jogador:");
        nome=sc.nextLine();
        if (!nome.equals("SAIR")){
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
                nomeVelho = nome;
            }
            System.out.println("Peso do jogador:");
            peso=sc.nextDouble();
            if (pesado<peso){
                pesado = peso;
                nomePesado = nome;
            }
            cont++;
            sc.nextLine();
            System.out.println("Digite o nome do jogador:");
            nome=sc.nextLine();
        }while(!nome.equals("SAIR"));}
        System.out.println("Quantidade de jogadores: "+cont+
            "\nAltura do maior jogadores: "+maior+
            "\nJogador mais velho: "+nomeVelho+ " com "+velho+" anos"+
            "\nJogador mais pesado: "+nomePesado+ " com "+pesado+" kg"+
            "\nMédia das alturas: "+(mediaAltura/cont));
    }
}
