package Models;

import java.util.ArrayList;
import java.util.List;

public class CommandResult<TFileRegistry> {

    public CommandResult() {
        result = new Result();
        data = new ArrayList<>();
    }

    public Result getResult() {
        return result;
    }

    public List<TFileRegistry> getData() {
        return data;
    }

    private List<TFileRegistry> data;

    public void setData(List<TFileRegistry> data) {
        this.data = data;
    }

    private final Result result;

}