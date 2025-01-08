//package se.lexicon;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class PesrsonTest {
//
//    @Test
//    public void testPesrson() {
//
//        Person person = new Person("Jean-Pierre", "Salum", "jeanpierre@lexicon.se");
//        assertNotNull(person);
//    }
//
//    @Test
//    void nullFirstNameTestPerson() {
//
//
//        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
//            Person person = new Person(null, "Salum", "salum@lexicon.se");
//        });
//
//    }
//
//    @Test
//    void getFirstNameTestPerson() {
//
//        Person person = new Person("Jean-Pierre", "Salum", "jeanpierre@lexicon.se");
//        assertEquals("Jean-Pierre", person.getFirstName());
//
//    }
//}
