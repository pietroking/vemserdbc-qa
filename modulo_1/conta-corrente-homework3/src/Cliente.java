import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf, List<Contato> contato, List<Endereco> endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contato;
        this.enderecos = endereco;
    }

    public void imprimirContatos() {
        if(getContatos()!=null) {
            for (int i = 0; i < getContatos().size(); i++) {
                if (getContatos().get(i)!= null) {
                    this.getContatos().get(i).imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (getContatos()!=null) {
            for (int i = 0; i < getEnderecos().size(); i++) {
                if (getEnderecos().get(i) != null) {
                    this.getEnderecos().get(i).imprimirEndereco();
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
