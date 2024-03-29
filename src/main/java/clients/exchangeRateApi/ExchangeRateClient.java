package clients.exchangeRateApi;

import Utiles.EndpointConfigReader;
import entity.responseEntity.ResponseExchangeRate;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public final class ExchangeRateClient {

    public ResponseExchangeRate getExchangeRate(){
        String exchangeRateEndPointOfUSD = EndpointConfigReader.getEndpoint("exchangeRate.usd");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(exchangeRateEndPointOfUSD);

        Assert.assertEquals(response.getStatusCode(),200);
        return response.as(ResponseExchangeRate.class);
    }
}
