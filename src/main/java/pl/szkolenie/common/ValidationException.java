package pl.szkolenie.common;

class ValidationException extends RuntimeException {

    ValidationException(String message) {
        super(message);
    }
}
