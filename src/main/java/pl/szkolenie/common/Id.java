package pl.szkolenie.common;

import static pl.szkolenie.common.Validation.ensureNotEmpty;

public abstract class Id {

    private final String id;

    public Id(String value) {
        ensureNotEmpty(value, "id cannot be empty");
        this.id = value;
    }

    @Override
    public String toString() {
        return id;
    }
}
