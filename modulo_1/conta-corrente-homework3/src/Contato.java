public class Contato {

    private String descricao;
    private String telefone;
    private int tipo;//(1- residencial, 2- comercial)

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato() {
        System.out.println("Descriçao: "+this.getDescricao());
        if (this.tipo == 1){
            System.out.println("Telefone residencial: "+this.getTelefone());
        }else {
            System.out.println("Telefone comercial: "+this.getTelefone());
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
