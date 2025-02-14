package pl.szkolenie.common;

import lombok.NoArgsConstructor;

import java.util.Collection;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Validation {

    public static void ensureThat(boolean condition, String validationError) {
        if (!condition) {
            throwError(validationError);
        }
    }

    public static void ensureNotNull(Object object, String validationError) {
        if (isNull(object)) {
            throwError(validationError);
        }
    }

    public static void ensureNotEmpty(String string, String validationError) {
        if (isNull(string) || string.isBlank()) {
            throwError(validationError);
        }
    }

    public static void ensureNotEmpty(Collection<?> collection, String validationError) {
        if (isNull(collection) || collection.isEmpty()) {
            throwError(validationError);
        }
    }

    private static void throwError(String validationError) {
        throw new ValidationException(validationError);
    }
}
