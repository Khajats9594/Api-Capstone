package clients.exchangeRateApi;

import utiles.EndpointConfigReader;
import models.exchangeRate.response.ExchangeRateResponseBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class ExchangeRateClient {

    public ExchangeRateResponseBody getExchangeRate(){
        String exchangeRateEndPointOfUSD = EndpointConfigReader.getEndpoint("exchangeRate.usd");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(exchangeRateEndPointOfUSD);

        ExchangeRateResponseBody exchangeRateResponseBody = response.as(ExchangeRateResponseBody.class);
        exchangeRateResponseBody.setStatusCode(response.getStatusCode());
        return exchangeRateResponseBody;
    }
}
