public class Main {
    public static void main(String[] args) {
        Contato dbc = new Contato("DBC", "3330-7777",2);
        Contato socio = new Contato("Socio", "4444-5555",1);
        Contato teste = new Contato("teste", "teste",1);

        Endereco trabalho = new Endereco(2,"Tv. São José",455,"00","90240-200","Porto Alegre","RS","Brasil");
        Endereco casa = new Endereco(1,"Vicente",2512,"3","90420-000","Porto Alegre","RS","Brasil");

        Cliente pietro = new Cliente("Pietro","005.667.830-45", dbc, socio, trabalho, casa);
        Cliente mae = new Cliente("Mae","000.000.000-22", socio, null, casa, null);

        ContaCorrente contaPietro = new ContaCorrente(pietro,"000001","0040",5000,1000);
        ContaCorrente contaMae = new ContaCorrente(mae,"000002","0065",7500,1500);

        ContaPoupanca poupancaPietro = new ContaPoupanca(pietro, "101010", "0041",5000);
        ContaPoupanca poupancaMae = new ContaPoupanca(mae, "000002", "0065",7500);


//        -----TESTES DE METODOS-----
        dbc.imprimirContato();
        socio.imprimirContato();

        trabalho.imprimirEndereco();
        casa.imprimirEndereco();

        pietro.imprimirCliente();
        mae.imprimirCliente();

        contaPietro.imprimir();
        contaMae.imprimir();
        poupancaPietro.imprimir();
        contaPietro.depositar(1600.96);
        contaPietro.sacar(378.24);
////        contaPietro.imprimirContaCorrente();
//        contaPietro.transferir(contaMae,7000);
////        contaPietro.transferir(contaPietro,7000);
        contaPietro.sacar(-378.24);
        contaPietro.depositar(-1600.96);
        poupancaPietro.depositar(645);
        poupancaPietro.creditarTaxa();
        poupancaPietro.sacar(329);
        poupancaPietro.transferir(contaPietro,8000);
        poupancaPietro.transferir(contaPietro,3000);
        contaPietro.transferir(poupancaPietro,11000);
        poupancaPietro.imprimir();

    }
}