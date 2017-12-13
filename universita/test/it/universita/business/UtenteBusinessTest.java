package it.universita.business;

import it.universita.model.Persona;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by roberto on 13/12/2017.
 */
public class UtenteBusinessTest {

    //FIXTURE
    String username;
    String password;
    String fakePassword;

    @Before
    public void setUp() throws Exception {

        username = "mario.rossi";
        password="Passw0rd1";
        fakePassword="asdasdads";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getInstance() throws Exception {

        UtenteBusiness instance = UtenteBusiness.getInstance();
        assertNotNull(instance);

    }

    @Test
    public void login() throws Exception {

        Persona p1 = UtenteBusiness.getInstance().login(username, password.getBytes());
        assertNotNull(p1);

        Persona p2 = UtenteBusiness.getInstance().login(username, fakePassword.getBytes());
        assertNull(p2);

        assertTrue(p1!=p2);

    }

}