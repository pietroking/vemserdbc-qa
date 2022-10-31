public class ContaPoupanca extends Conta implements Impressao{

    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }
    public ContaPoupanca(){}

    @Override
    public void imprimir() {
        System.out.println("Cliente: "+this.getCliente().getNome()+
                "\nConta: "+this.getNumeroConta()+
                "\nAgencia: "+this.getAgencia()+
                "\nSaldo: R$ "+this.getSaldo());
        System.out.println("--------------------------------");
    }

    public void creditarTaxa(){
        this.setSaldo(getSaldo()*JUROS_MENSAL);
    }
}
