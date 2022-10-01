public class Cliente {

    public String nome;
    public String cpf;
    public Contato contatos[];
    public Endereco enderecos[];

    public Cliente(String nome, String cpf, Contato contatos[], Endereco enderecos[]){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }


    public void imprimirContatos() {
        for (int i=0;i<contatos.length;i++){
            this.contatos[i].imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (int i=0;i<enderecos.length;i++){
            this.enderecos[i].imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println("Cliente "+this.nome+"\n"+
                "CPF: "+this.cpf+"\n\nContatos: ");
        this.imprimirContatos();
        System.out.println("\nEndereços: ");
        this.imprimirEnderecos();
        System.out.println("--------------------------------");
    }
}
