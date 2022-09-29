import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;

        System.out.println("1 - Rio Grande do Sul\n" +
                "2 - Rio de Janeiro\n" +
                "3 - Santa Catarina\n" +
                "4 - Parana");

        System.out.println("Digite o numero para seleção do estado:");
        opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao) {
            case 1:
                System.out.println("1 - Porto Alegre\n" +
                        "2 - Caxias do Sul\n" +
                        "3 - Gramado");

                System.out.println("Digite o numero para seleção da cidade:");
                opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao) {
                    case 1:
                        System.out.println("PORTO ALEGRE/RS\n" +
                                "População: 1.492.530 hab\n" +
                                "PIB: R$ 68.117.224,43 mil\n" +
                                "IDH: 0,805");
                        break;

                    case 2:
                        System.out.println("CAXIAS DO SUL/RS\n" +
                                "População: 517.451 hab\n" +
                                "PIB: R$ 21.717.020,24 mil\n" +
                                "IDH: 0,782");
                        break;

                    default:
                        System.out.println("GRAMADO/RS\n" +
                                "População: 35.875 hab\n" +
                                "PIB: R$ 1.540.150,717 mil\n" +
                                "IDH: 0,764");
                        break;
                }
                break;

            case 2:
                System.out.println("1 - Rio de Janeiro\n" +
                        "2 - Niterói\n" +
                        "3 - Petrópolis");

                System.out.println("Digite o numero para seleção da cidade:");
                opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao) {
                    case 1:
                        System.out.println("RIO DE JANEIRO/RJ\n" +
                                "População: 6.775.561 hab\n" +
                                "PIB: R$ 364.052.058,23 mil\n" +
                                "IDH: 0,799");
                        break;

                    case 2:
                        System.out.println("NITERÓI/RJ\n" +
                                "População: 513.584 hab\n" +
                                "PIB: R$ 23.003.343,34 mil\n" +
                                "IDH: 0,837");
                        break;

                    default:
                        System.out.println("PETRÓPOLIS/RJ\n" +
                                "População: 305.687 hab\n" +
                                "PIB: R$ 12.690.966,89 mil\n" +
                                "IDH: 0,745");
                        break;
                }
                break;

            case 3:
                System.out.println("1 - Florianópolis\n" +
                        "2 - Blumenau\n" +
                        "3 - Joinville");

                System.out.println("Digite o numero para seleção da cidade:");
                opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao) {
                    case 1:
                        System.out.println("FLORIANÓPOLIS/SC\n" +
                                "População: 516.524 hab\n" +
                                "PIB: R$ 18.636.407,20 mil\n" +
                                "IDH: 0,847");
                        break;

                    case 2:
                        System.out.println("BLUMENAU/SC\n" +
                                "População: 361.855 hab\n" +
                                "PIB: R$ 16.000.000 mil\n" +
                                "IDH: 0,806");
                        break;

                    default:
                        System.out.println("JOINVILLE/SC\n" +
                                "População: 604.708 hab\n" +
                                "PIB: R$ 30.785.682 mil\n" +
                                "IDH: 0,809");
                        break;
                }
                break;

            default:
                System.out.println("1 - Curitiba\n" +
                        "2 - Londrina\n" +
                        "3 - Maringá");

                System.out.println("Digite o numero para seleção da cidade:");
                opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao) {
                    case 1:
                        System.out.println("CURITIBA/PR\n" +
                                "População: 1.963.726 hab\n" +
                                "PIB: R$ 87.151.950,10 mil\n" +
                                "IDH: 0,823");
                        break;

                    case 2:
                        System.out.println("LONDRINA/PR\n" +
                                "População: 580.870 hab\n" +
                                "PIB: R$ 21.599.786,12 mil\n" +
                                "IDH: 0,778");
                        break;

                    default:
                        System.out.println("MARINGÁ/PR\n" +
                                "População: 436.472 hab\n" +
                                "PIB: R$ 18.532.976,71 mil\n" +
                                "IDH: 0,808");
                        break;
                }
                break;
        }
    }
}
