package testcases;

import clients.exchangeRateApi.ExchangeRateAssertionHelper;
import clients.exchangeRateApi.ExchangeRateClient;
import constants.FrameworkConstants;
import models.exchangeRate.response.ExchangeRateResponseBody;
import org.testng.annotations.Test;

public class ExchangeRateTest extends BaseTest{

    @Test
    public void toVerifyExchangeRateCallSuccessful() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();

        // Act
        ExchangeRateResponseBody response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertStatusCode(response, 200);
        ExchangeRateAssertionHelper.assertAPICallSuccessful(response);
    }

    @Test
    public void toVerifyExchangeRateOfUSDtoAEDInRange() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();

        // Act
        ExchangeRateResponseBody response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertUSDtoAEDInRange(response, 3.6, 3.7);
    }

    @Test
    public void toVerifyExchangeRateResponseTime() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();

        // Act
        ExchangeRateResponseBody response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertResponseTime(response, 3);
    }

    @Test
    public void toVerifyExchangeRateCurrencyPairs() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();

        // Act
        ExchangeRateResponseBody response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertCurrencyPairsCount(response, 162);
    }

    @Test
    public void toVerifyExchangeRateResponseSchema() {
        // Arrange
        ExchangeRateClient client = new ExchangeRateClient();
        String exchangeRateSchemaFilePath = FrameworkConstants.getExchangeRateSchemaFilePath();

        // Act
        ExchangeRateResponseBody response = client.getExchangeRate();

        // Assert
        ExchangeRateAssertionHelper.assertResponseSchema(response, exchangeRateSchemaFilePath);
    }

}
