public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo){
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean sacar(double valor) {
        if (valor<0){
            System.out.println("Voce não pode faze retirada de um valor negativo.");
            System.out.println("--------------------------------");
            return false;
        }
        if ((valor>0) && (this.getSaldo()-valor>=0)){
            this.setSaldo(getSaldo()-valor);
            System.out.println("Saque: R$ "+valor);
//            this.imprimirContaCorrente();
            System.out.println("Cliente: "+this.getCliente().getNome()+
                    "\nConta: "+this.getNumeroConta()+
                    "\nAgencia: "+this.getAgencia()+
                    "\nSaldo: R$ "+this.getSaldo());
            System.out.println("--------------------------------");
            return true;
        }else{
            System.out.println("Saque: R$ "+valor);
            System.out.println("Voce não possui saldo na sua conta para esta retirada.");
//            this.imprimirContaCorrente();
            System.out.println("Cliente: "+this.getCliente().getNome()+
                    "\nConta: "+this.getNumeroConta()+
                    "\nAgencia: "+this.getAgencia()+
                    "\nSaldo: R$ "+this.getSaldo());
            System.out.println("--------------------------------");
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        if (valor>0){
            this.setSaldo(getSaldo()+valor);
            System.out.println("Depósito: R$ "+valor);
//            this.imprimirContaCorrente();
            System.out.println("Cliente: "+this.getCliente().getNome()+
                    "\nConta: "+this.getNumeroConta()+
                    "\nAgencia: "+this.getAgencia()+
                    "\nSaldo: R$ "+this.getSaldo());
            System.out.println("--------------------------------");
            return true;
        }else {
            System.out.println("Este valor não pode ser depositado.");
            System.out.println("--------------------------------");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            System.out.println("A tranferencia não pode ser completada.");
            System.out.println("--------------------------------");
            return false;
        }
    }
}
