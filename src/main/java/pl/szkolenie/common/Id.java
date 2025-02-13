package pl.szkolenie.common;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class Id {

    private final String id;

    public Id(String value) {
        //TODO: add validation
        this.id = value;
    }

    @Override
    public String toString() {
        return id;
    }
}
