package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * This class contains the testNG annotation methods which are needed to be run with respect to the test script
 */

public class BaseTest {

    protected static Map<String, String> data;

    /**
     * This block will set the execution environment to the system properties
     */

    static {
        SetDataFile dataFile = new SetDataFile();
        data = dataFile.setData();
    }

    public static final String BASE_URL = data.get("host");


    public static RequestSpecification correctContentType() {
        return new RequestSpecBuilder().setContentType("application/json").build();
    }

    @BeforeSuite
    public void setup() {
        // RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.config =
                RestAssured.config()
                        .httpClient(
                                HttpClientConfig.httpClientConfig().setParam("CONNECTION_MANAGER_TIMEOUT", 15000));
    }
}
