import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] classe = new double[5][4];
        double mediaNotasFinais=0;
//
//                {0000, 9, 10, x},
//                {0001, 9, 10, x},
//                {0002, 5, 5, x},
//                {0003, 6, 10, x},
//                {0004, 9, 6, x}
//

        for (int i=0;i<5;i++){
                System.out.println("Digite o numero de matricula do aluno:");
                classe[i][0]=sc.nextDouble();
                System.out.println("Digite a média das provas do aluno:");
                classe[i][1]=sc.nextDouble();
                System.out.println("Digite a média dos trabalhos do aluno:");
                classe[i][2]=sc.nextDouble();
                classe[i][3]=(classe[i][1]*0.6)+(classe[i][2]*0.4);
                mediaNotasFinais+=classe[i][3];
        }

        double maior = classe[0][3];
        int aux =0; //variavel auxiliar para saber a linha do maior valor
        for (int i=0;i<5;i++){
            if (maior<classe[i][3]){
                maior = classe[i][3];
                aux = i;
            }
        }

        System.out.println("Matricula que obteve a maior nota final: "+classe[aux][0]);
        System.out.println("Media das notas finais: "+(mediaNotasFinais/5));
    }
}
