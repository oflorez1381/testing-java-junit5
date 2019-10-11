package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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
}
