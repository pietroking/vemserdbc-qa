
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Contato dbc = new Contato("DBC", "3330-7777",2);
        Contato socio = new Contato("Socio", "4444-5555",1);
        Contato teste = new Contato("teste", "teste",1);

        Endereco trabalho = new Endereco(2,"Tv. São José",455,"00","90240-200","Porto Alegre","RS","Brasil");
        Endereco casa = new Endereco(1,"Vicente",2512,"3","90420-000","Porto Alegre","RS","Brasil");

        Cliente pietro = new Cliente("Pietro","005.667.830-45", List.of(dbc, socio), List.of(trabalho, casa));
        Cliente mae = new Cliente("Mae","000.000.000-22", List.of(socio), List.of(casa));

        ContaCorrente contaPietro = new ContaCorrente(pietro,"000001","0040",5000,1000);
        ContaCorrente contaMae = new ContaCorrente(mae,"000002","0065",7500,1500);

        ContaPoupanca poupancaPietro = new ContaPoupanca(pietro, "101010", "0041",6000);
        ContaPoupanca poupancaMae = new ContaPoupanca(mae, "000002", "0065",8000);

        ContaPagamento pagamentoPietro = new ContaPagamento(pietro, "101010", "0041",2500);
        ContaPagamento pagamentoMae = new ContaPagamento(mae, "000002", "0065",3000);


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
        pagamentoMae.imprimir();
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
//        poupancaPietro.imprimir();
        pagamentoMae.sacar(3000);
        pagamentoMae.sacar(500);
        pagamentoPietro.sacar(500);
        pagamentoPietro.depositar(500);
        pagamentoMae.depositar(500);
        pagamentoPietro.transferir(poupancaPietro, 2501);
        pagamentoPietro.transferir(poupancaMae, 2495.75);
    }
}