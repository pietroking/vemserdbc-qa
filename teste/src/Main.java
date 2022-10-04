public class Main {
    public static void main(String[] args) {

        Foguete meuFoguete = new Foguete();

        meuFoguete.setCor("Azul");
        meuFoguete.setFabricante("SpaceX");
        meuFoguete.setNivelCombustivel(1000);
        System.out.println("cor: "+meuFoguete.getCor());
        System.out.println("fabricante: "+meuFoguete.getFabricante());
        System.out.println("Nivel Combustivel: "+meuFoguete.getNivelCombustivel());

//        System.out.println("Hello world!");
    }
}