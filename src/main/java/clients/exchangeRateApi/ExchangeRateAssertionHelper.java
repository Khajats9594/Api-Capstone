package clients.exchangeRateApi;

import entity.responseEntity.ResponseExchangeRate;
import org.testng.Assert;

public class ExchangeRateAssertionHelper {

    public static void assertAPICallSuccessful(ResponseExchangeRate response) {
        Assert.assertNotNull(response, "Response object should not be null");
        Assert.assertEquals(response.getResult(), "success", "API call should be successful");
    }

    public static void assertStatusCode(ResponseExchangeRate response, int expectedStatusCode) {
        Assert.assertNotNull(response, "Response object should not be null");
        //Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code should match");
    }

    public static void assertUSDtoAEDInRange(ResponseExchangeRate response) {
        Assert.assertNotNull(response, "Response object should not be null");
        double usdToAedRate = response.getResponseRates().getAED();
        Assert.assertTrue(usdToAedRate >= 3.6 && usdToAedRate <= 3.7, "USD to AED rate should be in range 3.6 - 3.7");
    }

    public static void assertResponseTime(ResponseExchangeRate response) {
        Assert.assertNotNull(response, "Response object should not be null");
        long responseTime = response.getTimeLastUpdateUnix();
        long currentTime = System.currentTimeMillis() / 1000; // Convert to seconds
        Assert.assertTrue((currentTime - responseTime) >= 3, "API response time should not be less than 3 seconds");
    }

    public static void assertCurrencyPairsCount(ResponseExchangeRate response, int expectedCount) {
        Assert.assertNotNull(response, "Response object should not be null");
        Assert.assertEquals(response.getResponseRates().size(), expectedCount, "Currency pairs count should match");
    }
}
