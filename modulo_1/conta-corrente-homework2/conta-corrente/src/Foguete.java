public class Foguete {
    //atributos
    private  String cor;
    private String fabricante;
    private double nivelCombustivel;

    //metodos
    public void decolar(double combustivelGasto) { //0.5
        nivelCombustivel-=combustivelGasto;
        System.out.println("decolando...");
    }

    public void pousar() {
        System.out.println("pousar...");
    }

    public void ligarMusica() {
        System.out.println("ligarMusica...");
    }

    public void desligar(){
        System.out.println("desligar...");
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        this.nivelCombustivel = nivelCombustivel;
    }
}