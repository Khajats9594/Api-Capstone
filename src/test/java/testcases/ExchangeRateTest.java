package testcases;

import clients.exchangeRateApi.ExchangeRateAssertionHelper;
import clients.exchangeRateApi.ExchangeRateClient;
import constants.FrameworkConstants;
import models.ExchangeRate.responseEntity.ExchangeRateResponseBody;
import org.testng.annotations.Test;

public class ExchangeRateTest extends BaseTest{

    @Test
    public void testExchangeRateAPI() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();
        String exchangeRateSchemaFilePath = FrameworkConstants.getExchangeRateSchemaFilePath();

        // Act
        ExchangeRateResponseBody response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertAPICallSuccessful(response);
        ExchangeRateAssertionHelper.assertStatusCode(response,200);
        ExchangeRateAssertionHelper.assertUSDtoAEDInRange(response);
        ExchangeRateAssertionHelper.assertResponseTime(response);
        ExchangeRateAssertionHelper.assertCurrencyPairsCount(response, 162);
        ExchangeRateAssertionHelper.assertResponseSchema(response,exchangeRateSchemaFilePath);
    }
}
