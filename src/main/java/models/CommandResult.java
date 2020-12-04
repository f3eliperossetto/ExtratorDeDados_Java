package models;

import java.util.ArrayList;
import java.util.List;

public class CommandResult<T> {

    public CommandResult() {
        result = new Result();
        data = new ArrayList<>();
    }

    public Result getResult() {
        return result;
    }

    public List<T> getData() {
        return data;
    }

    private List<T> data;

    public void setData(List<T> data) {
        this.data = data;
    }

    private final Result result;

}