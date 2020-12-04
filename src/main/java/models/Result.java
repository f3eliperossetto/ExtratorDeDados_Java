package models;

import enums.EStatus;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public Result() {

        errors = new ArrayList<>();
        alerts = new ArrayList<>();
        information = new ArrayList<>();

    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public void setReadingDone(boolean readingDone) {
        this.readingDone = readingDone;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getAlerts() {
        return alerts;
    }

    public List<String> getInformation() {
        return information;
    }

    public boolean getIsReadingDone() {
        return readingDone;
    }

    public EStatus getStatus() {
        return status;
    }

    private EStatus status;
    private boolean readingDone;
    private final List<String> errors;
    private final List<String> alerts;
    private final List<String> information;
}


