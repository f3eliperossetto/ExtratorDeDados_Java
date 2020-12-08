package filemodels;

public class Document {

    public  void fillData(String value){
        this.cpf = value.substring(3,14);
        this.rg = value.substring(15,24);
    }

    private String cpf;
    private String rg;

}
