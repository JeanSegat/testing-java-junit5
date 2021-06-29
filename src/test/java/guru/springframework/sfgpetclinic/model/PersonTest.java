package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGroupAssertions() {
        //given
        Person person = new Person(1l, "FirstName", "LastName");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("FirstName", person.getFirstName()),
                () -> assertEquals("LastName", person.getLastName()));
    }

    @Test
    @Disabled
    void testExampleToDescribeBetterTheTestedProp() {
        //given
        Person person = new Person(1l, "FirstName", "LastName");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("FirstNameXX", person.getFirstName(), "First name failed"),
                () -> assertEquals("LastNameXX", person.getLastName(), "Last name failed"));
    }

}