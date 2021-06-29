package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()));
    }

    @Disabled
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100),
        () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled
    @Test
    void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(5000);
                    System.out.println("I got here 1234234234");
                });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("Guru".equals(System.getenv("GURU_RUNTIME")));
        System.out.println("True Assumption");
    }

    @Test
    void testAssumptionFalse() {
        assumeFalse("Guru".equals(System.getenv("GURU_RUNTIME")));
        System.out.println("False Assumption");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMac() {
        System.out.println("I am on Mac");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {
        System.out.println("I am on Windows");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testMeOnLinux() {
        System.out.println("I am on Linux");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8() {
        System.out.println("I am on Windows");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11() {
        System.out.println("I am on Linux");
    }
}