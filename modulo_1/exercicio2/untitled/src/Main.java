import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DivideByZeroException, InputMismatchException {
        teste();
    }

    public static double teste(){
        Scanner sc = new Scanner(System.in);
        boolean test = false;
        try{
            funcao(sc);
            test = true;
            }catch (InputMismatchException ex){
//            ex.printStackTrace();
                System.out.println("Voce informou valores nao numericos");
                teste();
            }catch (DivideByZeroException exception){
//            exception.printStackTrace();
                System.out.println(exception.getMessage());
                teste();
            }finally {
                if (test){
                System.out.println("Operação realizada com sucesso");
                sc.close();
                }
            }return 0;
    }

    private static void funcao(Scanner sc) throws DivideByZeroException, InputMismatchException {
        int n1;
        int n2;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        dividir(n1,n2);
    }


    public static double dividir(int n1, int n2) throws DivideByZeroException{
        try {
            System.out.println(n1/n2);
            return n1/n2;
        }catch (ArithmeticException ex){
            throw new DivideByZeroException("Não é possivel dividir nenhum número por zero, tente novamente");
        }
    }
}