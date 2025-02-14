package pl.szkolenie.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.szkolenie.common.Validation.ensureNotEmpty;
import static pl.szkolenie.common.Validation.ensureNotNull;
import static pl.szkolenie.common.Validation.ensureThat;

class ValidationTest {

    @Test
    void shouldNotThrowValidationExceptionWhenConditionIsMet() {
        assertThatCode(() -> ensureThat(true, "Validation failed"))
                .doesNotThrowAnyException();
    }

    @Test
    void shouldThrowValidationExceptionWhenConditionIsNotMet() {
        assertThatThrownBy(() -> ensureThat(false, "Validation failed"))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Validation failed");
    }

    @Test
    void shouldNotThrowValidationExceptionWhenObjectIsNotNull() {
        Object object = new Object();
        assertThatCode(() -> ensureNotNull(object, "Object must not be null"))
                .doesNotThrowAnyException();
    }

    @Test
    void shouldThrowValidationExceptionWhenObjectIsNull() {
        assertThatThrownBy(() -> ensureNotNull(null, "Object must not be null"))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Object must not be null");
    }

    @Test
    void shouldNotThrowValidationExceptionWhenStringIsNotEmpty() {
        String nonEmpty = "Hello World";
        assertThatCode(() -> ensureNotEmpty(nonEmpty, "String must not be empty"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "input: \"{0}\"")
    @NullSource
    @ValueSource(strings = {"", "   "})
    void shouldThrowValidationExceptionWhenStringIsEmpty(String input) {
        assertThatThrownBy(() -> ensureNotEmpty(input, "String must not be empty"))
                .isInstanceOf(ValidationException.class)
                .hasMessage("String must not be empty");
    }

    @Test
    void shouldNotThrowValidationExceptionWhenCollectionIsNotEmpty() {
        List<Integer> list = asList(1, 2, 3);
        assertThatCode(() -> ensureNotEmpty(list, "Collection must not be empty"))
                .doesNotThrowAnyException();
    }

    @Test
    void shouldThrowValidationExceptionWhenCollectionIsNull() {
        assertThatThrownBy(() -> ensureNotEmpty((List<?>) null, "Collection must not be empty"))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Collection must not be empty");
    }

    @Test
    void shouldThrowValidationExceptionWhenCollectionIsEmpty() {
        assertThatThrownBy(() -> ensureNotEmpty(emptyList(), "Collection must not be empty"))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Collection must not be empty");
    }
}
