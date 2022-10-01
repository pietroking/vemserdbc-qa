public class Main {
    public static void main(String[] args) {
        Contato DBC = new Contato("DBC", "3330-7777",2);
        Contato socio = new Contato("Socio", "4444-5555",1);

        Endereco trabalho = new Endereco(2,"Tv. São José",455,"00","90240-200","Porto Alegre","RS","Brasil");
        Endereco casa = new Endereco(1,"Vicente",2512,"3","90420-000","Porto Alegre","RS","Brasil");

        Cliente pietro = new Cliente("Pietro","005.667.830-45", (new Contato[]{DBC, socio}), (new Endereco[]{trabalho, casa}));
        Cliente mae = new Cliente("Mae","000.000.000-22", new Contato[]{socio}, new Endereco[]{casa});

        ContaCorrente contaPietro = new ContaCorrente(pietro,"000001",0040,5000,1000);
        ContaCorrente contaMae = new ContaCorrente(mae,"000002",0065,7500,1500);


//        firma.imprimirContato();
//        socio.imprimirContato();

//        trabalho.imprimirEndereco();
//        casa.imprimirEndereco();

//        pietro.imprimirCliente();
//        mae.imprimirCliente();
        contaPietro.imprimirContaCorrente();
        contaPietro.depositar(1600.96);
        contaPietro.sacar(378.24);
        contaPietro.imprimirContaCorrente();
//        contaPietro.transferir(contaMae,7000);
        contaPietro.sacar(-378.24);
        contaPietro.depositar(-1600.96);
    }
}