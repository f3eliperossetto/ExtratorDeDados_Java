package FileModels;

public class BankData {
    public void fillData(String value){
        this.banco = value.substring(3,13);
        this.ag = value.substring(14,18);
        this.conta = value.substring(14,18);
    }
    private String banco;
    private String ag;
    private String conta;
}
