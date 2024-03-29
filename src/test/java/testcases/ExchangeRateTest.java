package testcases;

import clients.exchangeRateApi.ExchangeRateAssertionHelper;
import clients.exchangeRateApi.ExchangeRateClient;
import entity.responseEntity.ResponseExchangeRate;
import org.testng.annotations.Test;

public class ExchangeRateTest extends BaseTest{

    @Test
    public void testExchangeRateAPI() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();

        // Act
        ResponseExchangeRate response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertAPICallSuccessful(response);
        ExchangeRateAssertionHelper.assertStatusCode(response, 200);
        ExchangeRateAssertionHelper.assertUSDtoAEDInRange(response);
        ExchangeRateAssertionHelper.assertResponseTime(response);
        ExchangeRateAssertionHelper.assertCurrencyPairsCount(response, 162);
    }
}
