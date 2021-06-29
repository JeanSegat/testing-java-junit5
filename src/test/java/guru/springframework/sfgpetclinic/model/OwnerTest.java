package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Utrecht");
        owner.setTelephone("998659865");

        assertAll(
                () -> assertAll("Person properties",
                        () -> assertEquals("Joe", owner.getFirstName()),
                        () -> assertEquals("Buck", owner.getLastName())
                ),
                () -> assertAll("Owner properties",
                        () -> assertEquals("Utrecht", owner.getCity()),
                        () -> assertEquals("998659865", owner.getTelephone())
                ));
    }

    @ParameterizedTest
    @ValueSource(strings = {"spring", "framework", "Guru"})
    void testParameterized(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnum(OwnerType type) {
        System.out.println(type);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1 , 1",
            "OH, 2 , 2",
            "MI, 3 , 3"
    })
    void testCSVSource(String name, int val1, int val2) {
        System.out.println("Name: " + name + "- Values: " + val1 + " - " + val2);
    }

    @DisplayName("CSV from Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/testResource.csv", numLinesToSkip = 1)
    void testCSVFromSource(String name, int val1, int val2) {
        System.out.println("Name: " + name + "- Values: " + val1 + " - " + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void testFromMethodProvider(String name, int val1, int val2) {
        System.out.println("Name: " + name + "- Values: " + val1 + " - " + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(Arguments.of("FL", 10 , 10),
                Arguments.of("OH", 11 , 11),
                Arguments.of("MI", 12 , 12));
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void testArgumentsProvider(String name, int val1, int val2) {
        System.out.println("Name: " + name + "- Values: " + val1 + " - " + val2);
    }
}