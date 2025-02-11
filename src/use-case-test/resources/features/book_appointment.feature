Feature: Booking an appointment with an internist

  Scenario: User successfully books an available appointment
    Given the patient "John Smith" has an account in the system
    And the internist "Dr. Nowak" has an available appointment on "2025-02-15" at "10:00 AM"
    When the patient books an appointment with the internist on "2025-02-15" at "10:00 AM"
    Then the system should confirm the appointment booking
    And the selected time slot should be marked as unavailable