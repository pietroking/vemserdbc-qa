public class Endereco {

    public int tipo; //(1- residencial, 2- comercial)
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais){
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco() {
        if (this.tipo == 1){
            System.out.println("Endereço residencial: \n"
                    +this.logradouro+", "+this.numero+", "+complemento+", CEP: "+this.cep+
                    "\n"+this.cidade+", "+estado+", "+pais);
        }else {
            System.out.println("Endereço comercial: \n"
                    +this.logradouro+", "+this.numero+", "+complemento+", CEP: "+this.cep+
                    "\n"+this.cidade+", "+estado+", "+pais);
        }
    }
}
