import org.junit.Test;

import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void multipleConditionTest() {
        RuntimeException e;
        List<String> allUsers = new ArrayList<String>();
        

        User user = new User("test1", "password1", "test1@test2.com");
        
        assertTrue(SILab2.function(user, allUsers));

        allUsers.add("test1");

        e = assertThrows(RuntimeException.class, SILab2.function(user, allUsers));
        assertTrue(e.getMessage().contains("User already exists!"));

        allUsers.clear();
        user.setUsername(null);
        e = assertThrows(RuntimeException.class, SILab2.function(user, allUsers));
        assertTrue(e.getMessage().contains("User already exists!"));

        user.setUsername("test1");

        assertTrue(SILab2.function(user, allUsers));

        user.setEmail("testtest2.com");
        assertFalse(SILab2.function(user, allUsers));

        user.setEmail("test@test2com");
        assertFalse(SILab2.function(user, allUsers));
        
    }

    @Test
    public void everyStatement() {
        RuntimeException e;
        List<String> allUsers = new ArrayList<String>();

        User user = new User("test", "password1", "test@test2.com");

        assertTrue(SILab2.function(user, allUsers));

        e = assertThrows(RuntimeException.class, SILab2.function(null, allUsers));
        assertTrue(e.getMessage().contains("The user argument is not initialized!"));

        user.setUsername(null);
        e = assertThrows(RuntimeException.class, SILab2.function(user, allUsers));
        assertTrue(e.getMessage().contains("User already exists!"));

        user.setUsername("test");
        user.setEmail(null);
        assertFalse(SILab2.function(user, allUsers));

        user.setEmail("testtest2.com");
        assertFalse(SILab2.function(user, allUsers));

        user.setEmail("test@test2com");
        assertFalse(SILab2.function(user, allUsers));

    }

}