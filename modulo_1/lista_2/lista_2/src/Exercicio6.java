public class Exercicio6 {
    public static void main(String[] args) {

        double[][] classe = {
                {8, 9, 10, 10},
                {8, 9, 10, 6},
                {8, 5, 5, 7},
                {3, 6, 10, 9},
                {6, 9, 6, 10}
        };

        double[] mediaDisciplinas = {0, 0, 0, 0, 0};
        double mediaAluno = 0;
        int x = 0;
        for (int i=0; i<5; i++){
            for (int j=0; j<4; j++){
                mediaDisciplinas[x] += classe[i][j];
            }
            x++;
        }
        for (int j=0;j<5;j++){
            mediaAluno += mediaDisciplinas[j];
            System.out.println("Media da disciplina: "+(mediaDisciplinas[j]/4));
        }
        System.out.println("Media geral do aluno: "+(mediaAluno/20));
    }
}
