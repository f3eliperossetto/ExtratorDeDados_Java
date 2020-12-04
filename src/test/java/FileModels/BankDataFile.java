package FileModels;

import java.util.ArrayList;
import java.util.List;

public class BankDataFile {

    public BankDataFile() {
        document = new Document();
        financial = new ArrayList<>();
    }

    private String name;
    private String age;
    private String birthDate;
    private Document document;
    private List<BankData> financial;


    public Document getDocument() {
        return document;
    }

    public void fillData(String value) {
        this.name = value.substring(3, 26);
        this.age = value.substring(27, 29);
        this.birthDate = value.substring(29, 37);
    }

    public void addFinancialData(String value) {
        BankData bank = new BankData();
        bank.fillData(value);
        financial.add(bank);
    }
}

