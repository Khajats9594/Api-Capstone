package clients.exchangeRateApi;

import models.exchangeRate.response.ExchangeRateResponseBody;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ExchangeRateAssertionHelper {

    public static void assertAPICallSuccessful(ExchangeRateResponseBody response) {
        Assert.assertNotNull(response, "Response object should not be null");
        Assert.assertEquals(response.getResult(), "success", "API call should be successful");
    }

    public static void assertStatusCode(ExchangeRateResponseBody response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code should match");
    }

    public static void assertUSDtoAEDInRange(ExchangeRateResponseBody response,double minAEDRate,double maxAEDRate) {
        double usdToAedRate = response.getRatesResponseBody().getAED();
        Assert.assertTrue(usdToAedRate >= minAEDRate && usdToAedRate <= maxAEDRate, "USD to AED rate should be in range 3.6 - 3.7");
    }

    public static void assertResponseTime(ExchangeRateResponseBody response,long expectedTime) {
        long responseTime = response.getTimeLastUpdateUnix();
        long currentTime = System.currentTimeMillis() / 1000;
        Assert.assertTrue((currentTime - responseTime) >= expectedTime, "API response time should not be less than 3 seconds");
    }

    public static void assertCurrencyPairsCount(ExchangeRateResponseBody response, int expectedCount) {
        Assert.assertEquals(response.getRatesResponseBody().size(), expectedCount, "Currency pairs count should match");
    }

    public static void assertResponseSchema(ExchangeRateResponseBody response, String schemaFilePath) {
        given().body(response)
                .then().body(matchesJsonSchema(new File(schemaFilePath)));
    }
}
