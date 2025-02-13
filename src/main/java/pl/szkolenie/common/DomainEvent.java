package pl.szkolenie.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

import static java.time.OffsetDateTime.now;
import static pl.szkolenie.common.EventId.generate;

@Getter
@ToString
@EqualsAndHashCode
public abstract class DomainEvent {

    private final EventId eventId;

    private final OffsetDateTime occurredOn;

    public DomainEvent() {
        this.eventId = generate();
        this.occurredOn = now();
    }
}
