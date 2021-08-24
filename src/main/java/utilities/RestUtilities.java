package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtilities extends TestBase{


    public Response Get(String endpointURL, Map<String, String> parametersMap)
            throws Exception {

        RestAssured.baseURI = endpoint.get_property("Base_URI");
        Response response;

        if (parametersMap.isEmpty())
            response = RestAssured.given().get();
        else
            response = RestAssured.given().params(parametersMap).get(endpointURL);

        return response;
    }

}
