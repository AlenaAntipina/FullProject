package tests;

import org.testng.annotations.*;
import utils.DriverUtils;

public abstract class BaseTest {
    @BeforeClass
    public void setUp() {
        DriverUtils.maximize();
    }

    @AfterClass
    public void tearDown() {
        DriverUtils.quit();
    }
}
