package pl.szkolenie.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IdTest {

    @Test
    void shouldCreateIdWhenValueIsValid() {
        String expectedIdValue = "12345";

        Id actualId = new TestId(expectedIdValue);

        assertThat(actualId.toString()).isEqualTo(expectedIdValue);
    }

    @ParameterizedTest(name = "input: \"{0}\"")
    @NullSource
    @ValueSource(strings = {"", "   "})
    void shouldThrowValidationExceptionWhenIdIsInvalid(String invalidId) {
        assertThatThrownBy(() -> new TestId(invalidId))
                .isInstanceOf(ValidationException.class)
                .hasMessage("id cannot be empty");
    }

    private static class TestId extends Id {

        TestId(String value) {
            super(value);
        }
    }
}