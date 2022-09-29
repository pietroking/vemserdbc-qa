import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name, city, state;
        int age;

        System.out.println("Digite seu nome:");
        name = sc.nextLine();
        System.out.println("Digite sua idade:");
        age = sc.nextInt();		//nextLine para ler o enter da quebra de linha
        sc.nextLine();
        System.out.println("Digite sua cidade:");
        city = sc.nextLine();
        System.out.println("Digite seu estado:");
        state = sc.nextLine();

        System.out.println("Olá seu nome é " + name + ", você tem "+ age +
                " anos, é da cidade de " + city + ", situada no estado de "+ state +".");

    }
}
