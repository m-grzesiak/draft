package pl.szkolenie.common;

import static java.util.UUID.randomUUID;

public class EventId extends Id {

    public EventId(String value) {
        super(value);
    }

    public static EventId generate() {
        String uuid = randomUUID().toString();
        return new EventId(uuid);
    }
}
