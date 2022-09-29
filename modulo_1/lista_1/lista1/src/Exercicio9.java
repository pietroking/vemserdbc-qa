import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int horaInicio, minutoInicio, horaFinal, minutoFinal, horasJogo, minutosJogo;

        System.out.println("Digite a hora do inicio do jogo:");
        horaInicio = sc.nextInt();
        if (horaInicio > 23){
            System.out.println("VALOR INVALIDO\nDigite a hora do inicio do jogo valida: (0-23)");
            horaInicio = sc.nextInt();
        }
        System.out.println("Digite o minuto do inicio do jogo:");
        minutoInicio = sc.nextInt();
        if (minutoInicio > 59){
            System.out.println("VALOR INVALIDO\nDigite o minuto do inicio do jogo valido: (0-59)");
            minutoInicio = sc.nextInt();
        }
        System.out.println("Digite a hora do final do jogo:");
        horaFinal = sc.nextInt();
        if (horaFinal > 23){
            System.out.println("VALOR INVALIDO\nDigite a hora do final do jogo valida: (0-23)");
            horaFinal = sc.nextInt();
        }
        System.out.println("Digite o minuto do final do jogo:");
        minutoFinal = sc.nextInt();
        if (minutoFinal > 59){
            System.out.println("VALOR INVALIDO\nDigite o minuto do inicio do jogo valido: (0-59)");
            minutoFinal = sc.nextInt();
        }

        if (horaInicio>horaFinal){
            horasJogo = horaFinal - horaInicio + 24;
        } else {
            horasJogo = horaFinal - horaInicio;
        }
        if (minutoInicio>minutoFinal){
            minutosJogo = minutoFinal - minutoInicio + 60;
        } else {
            minutosJogo = minutoFinal - minutoInicio;
        }

        System.out.println("A duraçao do jogo foi de "+ horasJogo + "h" + minutosJogo + "min");
    }
}
