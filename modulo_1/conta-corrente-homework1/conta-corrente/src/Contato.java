public class Contato {

    public String descricao;
    public String telefone;
    public int tipo;//(1- residencial, 2- comercial)

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato() {
        System.out.println("Descriçao: "+this.descricao);
        if (this.tipo == 1){
            System.out.println("Telefone residencial: "+this.telefone);
        }else {
            System.out.println("Telefone comercial: "+this.telefone);
        }
    }
}
