package FileModels;

public class BankData {
    public void fillData(String value){
        this.bank = value.substring(3,13);
        this.ag = value.substring(14,18);
        this.account = value.substring(14,18);
    }
    private String bank;
    private String ag;
    private String account;
}
