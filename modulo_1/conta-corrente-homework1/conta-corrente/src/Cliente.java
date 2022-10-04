public class Cliente {

    public String nome;
    public String cpf;
    public Contato contatos[] = new Contato[2];
    public Endereco enderecos[] = new Endereco[2];

    public Cliente(String nome, String cpf, Contato contato1, Contato contato2, Endereco endereco1, Endereco endereco2){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contato1;
        this.contatos[1] = contato2;
        this.enderecos[0] = endereco1;
        this.enderecos[1] = endereco2;
    }

    public void imprimirContatos() {
        if (contatos!=null) {
            for (int i = 0; i < contatos.length; i++) {
                if (contatos[i] != null) {
                    this.contatos[i].imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (contatos!=null) {
            for (int i = 0; i < enderecos.length; i++) {
                if (enderecos[i] != null) {
                    this.enderecos[i].imprimirEndereco();
                }
            }
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
