package Models;

import Enums.EStatus;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public Result() {

        errors = new ArrayList<>();
        alerts = new ArrayList<>();
        informations = new ArrayList<>();

    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public boolean isReadingDone() {
        return readingDone;
    }

    public void setReadingDone(boolean readingDone) {
        this.readingDone = readingDone;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<String> alerts) {
        this.alerts = alerts;
    }

    public List<String> getInformations() {
        return informations;
    }

    public void setInformations(List<String> informations) {
        this.informations = informations;
    }

    private EStatus status;
    private boolean readingDone;
    private List<String> errors;
    private List<String> alerts;
    private List<String> informations;
}


