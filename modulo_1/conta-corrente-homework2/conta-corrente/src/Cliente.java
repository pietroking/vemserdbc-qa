public class Cliente {

    private String nome;
    private String cpf;
    private Contato contatos[] = new Contato[2];
    private Endereco enderecos[] = new Endereco[2];

    public Cliente(String nome, String cpf, Contato contato1, Contato contato2, Endereco endereco1, Endereco endereco2){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contato1;
        this.contatos[1] = contato2;
        this.enderecos[0] = endereco1;
        this.enderecos[1] = endereco2;
    }

    public void imprimirContatos() {
        if(getContatos()!=null) {
            for (int i = 0; i < getContatos().length; i++) {
                if (getContatos()[i] != null) {
                    this.getContatos()[i].imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (getContatos()!=null) {
            for (int i = 0; i < getEnderecos().length; i++) {
                if (getEnderecos()[i] != null) {
                    this.getEnderecos()[i].imprimirEndereco();
                }
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("Cliente "+this.getNome()+"\n"+
                "CPF: "+this.getCpf()+"\n\nContatos: ");
        this.imprimirContatos();
        System.out.println("\nEndereços: ");
        this.imprimirEnderecos();
        System.out.println("--------------------------------");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
}
