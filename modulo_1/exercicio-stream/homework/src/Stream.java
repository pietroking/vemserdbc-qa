import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
//        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));


        //1- listar todas as pessoas
        System.out.println("-------------------------------------");
        System.out.println("1- listar todas as pessoas\n");
        lista.stream()
                .forEach(x -> System.out.println(x.toString()));
        System.out.println("-------------------------------------");

        //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)
        System.out.println("2- filtrar todas as pessoas com salario maior do que 5 mil (filter)\n");
        List<Pessoa> listaFiltrada = lista.stream()
                .filter(x -> x.getSalario() > 5000)
                .toList();
        System.out.println(listaFiltrada);
        System.out.println("-------------------------------------");

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)
        System.out.println("3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)\n");
        List<Pessoa> listaFiltrada2 = lista.stream()
                .filter(x -> x.getCargo().equals("Desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .toList();
        System.out.println(listaFiltrada2);
        System.out.println("-------------------------------------");

        //4- fazer a média salarial de todos
        System.out.println("4- fazer a média salarial de todos\n");
        Double mediaSalario = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println(mediaSalario);
        System.out.println("-------------------------------------");

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        System.out.println("5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil\n");
        boolean listaAny = lista.stream()
                .anyMatch(x -> x.getSalario() > 20000);
        System.out.println(listaAny);
        System.out.println("-------------------------------------");

        //6- retornar uma lista de todos os ids das pessoas
        System.out.println("6- retornar uma lista de todos os ids das pessoas\n");
        List<Integer> listaFiltradaID = lista.stream()
                .map(x -> {return x.getId();})
                .toList();
        System.out.println(listaFiltradaID);
        System.out.println("-------------------------------------");

        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        System.out.println("7- criar uma nova classe Salario com ID e Salário, utilizando a função \"map\" do stream, retornar uma lista desse novo objeto\n");
        List<Salario> listSalario = lista.stream()
                .map(x -> {
                    return new Salario(x.getId(), x.getSalario());
                })
                .toList();
        System.out.println(listSalario);
        System.out.println("-------------------------------------");

        //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores
        System.out.println("8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores\n");
        Map<Integer, String> listaHash = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(listaHash);
        System.out.println("-------------------------------------");

        //9- com o mapa da 8, retornar o nome com o id=2
        System.out.println("9- com o mapa da 8, retornar o nome com o id=2\n");
        System.out.println(listaHash.get(2));
        System.out.println("-------------------------------------");

        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        System.out.println("10- verificar se tem alguém que contenha o nome \"Paulo\" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).\n");
        Optional<Pessoa> listFirst = lista.stream()
                .filter(x -> x.getNome().toLowerCase().contains("paulo"))
                .findFirst();
        System.out.println(listFirst);
        System.out.println("-------------------------------------");

        //    Imprimir o nome e salário dessa pessoa
        System.out.println("Imprimir o nome e salário dessa pessoa\n");
        if(listFirst.isPresent()){
            Pessoa paulo = listFirst.get();
            System.out.println(paulo.getNome());
            System.out.println(paulo.getSalario());
        }
        System.out.println("-------------------------------------");
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id= " + id +
                    ", nome= " + nome +
                    ", salario= " + salario +
                    ", cargo= " + cargo +
                    '}';
        }
    }

    static class Salario{
        private int id;
        private double salario;

        public Salario(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }
        @Override
        public String toString() {
            return "Salario{" +
                    "id= " + id +
                    ", salario= " + salario +
                    '}';
        }
    }
}