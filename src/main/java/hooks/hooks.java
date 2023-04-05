package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

import static utils.DriverManager.closeDriver;

public class hooks {

    @After
    public void afterTest() {
        closeDriver();
    }
}
