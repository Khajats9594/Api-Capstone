package testcases;

import Utiles.PropertyUtils;
import enums.ConfigProperties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest(){}

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = PropertyUtils.get(ConfigProperties.BASEURI);
    }
}
