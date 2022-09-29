import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroIdentificacao;
        double nota1, nota2, nota3, mediaExercicios, mediaAproveitamento;

        System.out.println("Digite o numero de identificaçao:");
        numeroIdentificacao = sc.nextInt();
        sc.nextLine();
        System.out.println("Nota 1:");
        nota1 = sc.nextDouble();
        System.out.println("Nota 2:");
        nota2 = sc.nextDouble();
        System.out.println("Nota 3:");
        nota3 = sc.nextDouble();
        System.out.println("Média de Exercicios:");
        mediaExercicios = sc.nextDouble();
        mediaAproveitamento = (nota1+(nota2*2)+(nota3*3)+mediaExercicios)/7;

        if (mediaAproveitamento < 4){
            System.out.println("Numero de identificação:"+ numeroIdentificacao +"\nNota 1:"+ nota1 +"\nNota 2:"+ nota2 +
                    "\nNota 3:"+ nota3 +"\nMédia de Exercicios:"+ mediaExercicios +"\nMédia de Aproveitamento:"+ String.format("%.2f", mediaAproveitamento) +
                    "\nConceito: E \nREPROVADO");
        } else if (mediaAproveitamento < 6) {
            System.out.println("Numero de identificação:"+ numeroIdentificacao +"\nNota 1:"+ nota1 +"\nNota 2:"+ nota2 +
                    "\nNota 3:"+ nota3 +"\nMédia de Exercicios:"+ mediaExercicios +"\nMédia de Aproveitamento:"+ String.format("%.2f", mediaAproveitamento) +
                    "\nConceito: D \nREPROVADO");
        } else if (mediaAproveitamento < 7.5) {
            System.out.println("Numero de identificação:"+ numeroIdentificacao +"\nNota 1:"+ nota1 +"\nNota 2:"+ nota2 +
                    "\nNota 3:"+ nota3 +"\nMédia de Exercicios:"+ mediaExercicios +"\nMédia de Aproveitamento:"+ String.format("%.2f", mediaAproveitamento) +
                    "\nConceito: C \nAPROVADO");
        } else if (mediaAproveitamento < 9) {
            System.out.println("Numero de identificação:"+ numeroIdentificacao +"\nNota 1:"+ nota1 +"\nNota 2:"+ nota2 +
                    "\nNota 3:"+ nota3 +"\nMédia de Exercicios:"+ mediaExercicios +"\nMédia de Aproveitamento:"+ String.format("%.2f", mediaAproveitamento) +
                    "\nConceito: B \nAPROVADO");
        } else {
            System.out.println("Numero de identificação:"+ numeroIdentificacao +"\nNota 1:"+ nota1 +"\nNota 2:"+ nota2 +
                    "\nNota 3:"+ nota3 +"\nMédia de Exercicios:"+ mediaExercicios +"\nMédia de Aproveitamento:"+ String.format("%.2f", mediaAproveitamento) +
                    "\nConceito: A \nAPROVADO");
        }
    }
}
