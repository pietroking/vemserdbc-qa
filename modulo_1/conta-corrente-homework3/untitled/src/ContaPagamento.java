public class ContaPagamento extends Conta implements Impressao {

    static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: "+this.getCliente().getNome()+
                "\nConta: "+this.getNumeroConta()+
                "\nAgencia: "+this.getAgencia()+
                "\nSaldo: R$ "+this.getSaldo());
        System.out.println("--------------------------------");
    }

    public boolean sacar(double valor){
        if (valor<0){
            System.out.println("Voce não pode faze retirada de um valor negativo.");
            System.out.println("--------------------------------");
            return false;
        }
        if ((valor+TAXA_SAQUE) <= this.getSaldo()){
            this.setSaldo(this.getSaldo()-valor-TAXA_SAQUE);
            System.out.println("Saque: R$ "+valor);
            this.imprimir();
            return true;
        }else{
            System.out.println("Saque: R$ "+valor);
            System.out.println("Voce não possui saldo na sua conta para esta retirada.");
            System.out.println("--------------------------------");
            this.imprimir();
            return false;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor<0){
            System.out.println("Voce não pode faze retirada de um valor negativo.");
            return false;
        }
        if ((valor) <= this.getSaldo()){
            this.setSaldo(this.getSaldo()-valor);
            System.out.println("Saque: R$ "+valor);
            this.imprimir();
            conta.setSaldo(conta.getSaldo()+valor);
            System.out.println("Depósito: R$ "+valor);
            System.out.println("Cliente: "+conta.getCliente().getNome()+
                    "\nConta: "+conta.getNumeroConta()+
                    "\nAgencia: "+conta.getAgencia()+
                    "\nSaldo: R$ "+conta.getSaldo());
            System.out.println("--------------------------------");
            return true;
        }else{
            System.out.println("A tranferencia não pode ser completada.");
            System.out.println("--------------------------------");
            return false;
        }
    }
}
