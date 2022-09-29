public class Exercicio4 {
    public static void main(String[] args) {
        int a = 10, b = 20, c;

        System.out.println("Valor inicial de A:" + a);
        System.out.println("Valor inicial de B:" + b);

//        a = a^b;
//        b = b^a;
//        a = a^b;
        c = a;
        a = b;
        b = c;

        System.out.println("Valor final de A:" + a);
        System.out.println("Valor final de B:" + b);
    }
}
