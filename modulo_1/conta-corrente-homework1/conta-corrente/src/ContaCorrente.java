public class ContaCorrente {

    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial){
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente(){
        System.out.println("Cliente: "+this.cliente.nome+
                           "\nConta: "+this.numeroConta+
                           "\nAgencia: "+this.agencia+
                           "\nSaldo: R$ "+this.saldo+
                           "\nCheque Especial: R$ "+this.chequeEspecial);
        System.out.println("--------------------------------");
    }

    public boolean sacar(double valor){
        if (valor<0){
            System.out.println("Voce não pode faze retirada de um valor negativo.");
            return false;
        }
        if ((valor>0) && (this.retornarSaldoComChequeEspecial()-valor>=0)){
            this.saldo-=valor;
            return true;
        }else{
            System.out.println("Voce não possui saldo na sua conta para esta retirada.");
            return false;
        }
    }

    public boolean depositar(double valor){
        if (valor>0){
            this.saldo+=valor;
            return true;
        }else {
        System.out.println("Este valor não pode ser depositado.");
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return (this.saldo+this.chequeEspecial);
    }

    public boolean transferir(ContaCorrente conta, double valor){
        if (this.sacar(valor)){
            conta.depositar(valor);
            this.imprimirContaCorrente();
            conta.imprimirContaCorrente();
            return true;
        }else {
            System.out.println("A tranferencia não pode ser completada.");
            return false;
        }
    }
}
