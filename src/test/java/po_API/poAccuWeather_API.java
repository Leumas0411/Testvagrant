package po_API;

import io.restassured.response.Response;
import utilities.RestUtilities;
import utilities.TestBase;

import java.util.*;

public class poAccuWeather_API extends TestBase {



    public float get_current_Weather_API() throws Exception {

        Map<String, String> params = new HashMap<String, String>();
        params.put("appid",configProps.get_property("api_key"));
        params.put("q",data.get_property("UI_Location"));
        Response resp=rest.Get(endpoint.get_property("Weather"),params);

        String API_TEMP=resp.jsonPath().getString("main.temp");
        System.out.println("The temp in API is "+API_TEMP);

        return Float.parseFloat(API_TEMP);
    }

}
