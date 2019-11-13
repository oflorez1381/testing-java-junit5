package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // Given
        Person person = new Person(1L, "Joe", "Buck");

        // Then
        assertAll("Test props set",
                () -> assertEquals(person.getFirstName(),"Joe", "First Name Failed"),
                () -> assertEquals(person.getLastName(),"Buck", "Last Name Failed")
        );
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        System.out.println("Repeated Test");
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(String.format("%s : %d", testInfo.getDisplayName(), repetitionInfo.getCurrentRepetition()));
    }
}
