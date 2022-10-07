public enum Comida {
    JAPONESA("Japonesa"),
    FAST_FOOD("Fast Food"),
    TRADICIONAL("Tradicional");

    private String tipo;

    Comida(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
