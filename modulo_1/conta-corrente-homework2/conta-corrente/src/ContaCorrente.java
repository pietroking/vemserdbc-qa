public class ContaCorrente extends Conta implements Impressao{

    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial){
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

//    public void imprimirContaCorrente(){
//        System.out.println("Cliente: "+this.getCliente().getNome()+
//                           "\nConta: "+this.getNumeroConta()+
//                           "\nAgencia: "+this.getAgencia()+
//                           "\nSaldo: R$ "+this.getSaldo()+
//                           "\nCheque Especial: R$ "+this.chequeEspecial);
//        System.out.println("--------------------------------");
//    }

    public boolean sacar(double valor){
        if (valor<0){
            System.out.println("Voce não pode faze retirada de um valor negativo.");
            return false;
        }
        if ((valor>0) && (this.retornarSaldoComChequeEspecial()-valor>=0)){
            this.setSaldo(getSaldo()-valor);
            System.out.println("Saque: R$ "+valor);
            this.imprimir();
            return true;
        }else{
            System.out.println("Saque: R$ "+valor);
            System.out.println("Voce não possui saldo na sua conta para esta retirada.");
            this.imprimir();
            return false;
        }
    }

//    public boolean depositar(double valor){
//        if (valor>0){
//            this.setSaldo(getSaldo()+valor);
//            System.out.println("Depósito: R$ "+valor);
//            this.imprimirContaCorrente();
//            return true;
//        }else {
//        System.out.println("Este valor não pode ser depositado.");
//            return false;
//        }
//    }

    public double retornarSaldoComChequeEspecial(){
        return (this.getSaldo()+this.chequeEspecial);
    }

//    public boolean transferir(ContaCorrente conta, double valor) {
//        if (this.sacar(valor)) {
//            conta.depositar(valor);
//            return true;
//        } else {
//            System.out.println("A tranferencia não pode ser completada.");
//            return false;
//        }
//    }

//    public double getChequeEspecial() {
//        return chequeEspecial;
//    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: "+this.getCliente().getNome()+
                "\nConta: "+this.getNumeroConta()+
                "\nAgencia: "+this.getAgencia()+
                "\nSaldo: R$ "+this.getSaldo()+
                "\nCheque Especial: R$ "+this.chequeEspecial);
        System.out.println("--------------------------------");
    }
}
