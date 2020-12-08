package models;

import enums.StatusImport;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class CommandResult<T> {

    public CommandResult() {
        data = new HashSet<>();
        messages = new HashSet<>();
        status = StatusImport.SUCCESS;
        readingDone = true;
    }

    public Collection<T> getData() {
        return data;
    }

    private Collection<T> data;

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public void setStatus(StatusImport status) {
        this.status = status;
    }

    public void setReadingDone(boolean readingDone) {
        this.readingDone = readingDone;
    }

    public Collection<String> getMessages() {
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
    private final Collection<String> messages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandResult)) return false;
        CommandResult<?> that = (CommandResult<?>) o;
        return readingDone == that.readingDone && data.equals(that.data) && status == that.status && messages.equals(that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, status, readingDone, messages);
    }
}