package pl.szkolenie;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("the patient {string} has an account in the system")
    public void thePatientHasAnAccountInTheSystem(String patientName) {
    }

    @Given("the internist {string} has an available appointment on {string} at {string}")
    public void theInternistHasAnAvailableAppointment(String doctorName, String date, String time) {
    }

    @When("the patient books an appointment with the internist on {string} at {string}")
    public void thePatientBooksAnAppointment(String date, String time) {
    }

    @Then("the system should confirm the appointment booking")
    public void theSystemShouldConfirmTheBooking() {
    }

    @Then("the selected time slot should be marked as unavailable")
    public void theSelectedTimeSlotShouldBeMarkedAsUnavailable() {
    }
}
