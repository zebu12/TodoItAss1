package se.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppUserTest {

    @Test
    void testAppUser() {

        AppUser user = new AppUser("Zebu1", "One123",AppRole.ROLE_APP_USER);
        assertNotNull(user);
    }

}
