package Common;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class UserOperations {

    public static String getToken(UserRegisterDto user) {
        Map<String, String> formBody = new HashMap<String, String>() {{
            put("grant_type", "password");
            put("username", user.getEmail());
            put("password", user.getPassword());
        }};
        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .baseUri(Parameters.getUrl())
                .formParams(formBody)
                .post("/signin")
                .then()
                .log().ifError()
                .extract()
                .response();
        return "Bearer " + response.jsonPath()
                .getString("jwt");
    }


}
