package models;

import enums.StatusImport;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public Result() {
        messages = new ArrayList<>();
        status = StatusImport.SUCCESS;
        readingDone = true;
    }

    public void setStatus(StatusImport status) {
        this.status = status;
    }

    public void setReadingDone(boolean readingDone) {
        this.readingDone = readingDone;
    }

    public List<String> getMessages() {
        return messages;
    }

    public boolean getIsReadingDone() {
        return readingDone;
    }

    public StatusImport getStatus() {
        return status;
    }

    private StatusImport status;
    private boolean readingDone;
    private final List<String> messages;
}


