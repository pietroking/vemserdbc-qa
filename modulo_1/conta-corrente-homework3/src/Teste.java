import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Teste {
    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){//: não dar certo o valor do saque (saque > saldo + ce)

        ContaCorrente contaTest = new ContaCorrente();
        contaTest.setSaldo(1000);
        contaTest.setChequeEspecial(500);

        boolean test = contaTest.sacar(2000);

        Assertions.assertFalse(test);
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){//: deve creditar taxa antes(){}

        ContaPoupanca contaTest = new ContaPoupanca();
        contaTest.setSaldo(1000);

        boolean test = contaTest.sacar(800);

        Assertions.assertTrue(test);
        Assertions.assertEquals(200, contaTest.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo(){//: não dar certo o valor do saque (saque > saldo){}

        ContaPoupanca contaTest = new ContaPoupanca();
        contaTest.setSaldo(1000);

        boolean test = contaTest.sacar(1800);

        Assertions.assertFalse(test);
        Assertions.assertEquals(1000, contaTest.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
        ContaPagamento contaTest = new ContaPagamento();
        double TAXA_SAQUE = 4.25;
        contaTest.setSaldo(1000);

        boolean test = contaTest.sacar(800);

        Assertions.assertTrue(test);
        Assertions.assertEquals(200-TAXA_SAQUE, contaTest.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){//: não dar certo o valor do saque (saque > saldo){}
        ContaPagamento contaTest = new ContaPagamento();
        double TAXA_SAQUE = 4.25;
        contaTest.setSaldo(1000);

        boolean test = contaTest.sacar(1000);

        Assertions.assertFalse(test);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        ContaCorrente contaTest = new ContaCorrente();
        ContaPagamento contaTest2 = new ContaPagamento();

        contaTest.setSaldo(1000);
        contaTest.setChequeEspecial(500);
        contaTest2.setSaldo(100);

        boolean test = contaTest.transferir(contaTest2,400);

        Assertions.assertTrue(test);
        Assertions.assertEquals(600, contaTest.getSaldo());
        Assertions.assertEquals(500, contaTest2.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaSemSaldo(){//: não dar certo o valor do saque (saque > saldo){}
        ContaCorrente contaTest = new ContaCorrente();
        ContaPagamento contaTest2 = new ContaPagamento();

        contaTest.setSaldo(1000);
        contaTest.setChequeEspecial(500);
        contaTest2.setSaldo(100);

        boolean test = contaTest.transferir(contaTest2,1600);

        Assertions.assertFalse(test);
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        ContaPoupanca contaTest = new ContaPoupanca();
        contaTest.setSaldo(1000);

        boolean test = contaTest.depositar(1800);

        Assertions.assertTrue(test);
        Assertions.assertEquals(2800, contaTest.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativo(){
        ContaPoupanca contaTest = new ContaPoupanca();
        contaTest.setSaldo(1000);

        boolean test = contaTest.depositar(-1800);

        Assertions.assertFalse(test);
        Assertions.assertEquals(1000, contaTest.getSaldo());
    }
}
