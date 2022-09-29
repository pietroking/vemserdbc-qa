import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String palavra;
        System.out.println("Digite uma palavra para ver a tradução:");
        palavra = sc.nextLine();

        switch (palavra.toLowerCase()) { //independente de como foi escrita na entrada, deixa todos caracteres minusculos para faze a comparaçao ENTRADA -> Cachorro/CACHORRO/cachorro -> SAIDA -> Dog
            case "cachorro" -> {
                System.out.println("Dog");
            }
            case "tempo" -> {
                System.out.println("Time");
            }
            case "amor" -> {
                System.out.println("Love");
            }
            case "cidade" -> {
                System.out.println("City");
            }
            case "feliz" -> {
                System.out.println("Happy");
            }
            case "triste" -> {
                System.out.println("Sad");
            }
            case "deveria" -> {
                System.out.println("Should");
            }
            case "poderia" -> {
                System.out.println("Could");
            }
            case "dog" -> {
                System.out.println("Cachorro");
            }
            case "time" -> {
                System.out.println("Tempo");
            }
            case "love" -> {
                System.out.println("Amor");
            }
            case "city" -> {
                System.out.println("Cidade");
            }
            case "happy" -> {
                System.out.println("Feliz");
            }
            case "sad" -> {
                System.out.println("Triste");
            }
            case "should" -> {
                System.out.println("Deveria");
            }
            case "could" -> {
                System.out.println("Poderia");
            }
            default -> {
                System.out.println("Essa palavra não é válida");
            }
        }
    }
}
