package utils;

import internet.ConfigUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

import static io.restassured.RestAssured.given;

@UtilityClass
public class APIUtils {
    public static Response getResponse(String request, String param, String variant) {
        return given()
                .spec(getRequestSpecification())
                .param(param, variant)
                .when()
                .post(request)
                .then()
                .extract()
                .response();
    }

    private static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigUtils.getBaseUri())
                .build();
    }
}
