package demo.api.call;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ApiCall {
    public static final Logger log = Logger.getLogger(String.valueOf(Character.class));

    final OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String result(String characterId) throws IOException {
        ApiCall characterCall = new ApiCall();
        Properties constant = Constants.property;
        String url = constant.getProperty("MARVEL_BASE_URL")
                + constant.getProperty("END_POINT_CHARACTERS");

        String parameters = "?apikey=" + constant.getProperty("API_KEY")
                + "&ts=" + constant.getProperty("TS")
                + "&hash=" + constant.getProperty("HASH");

        return characterCall.run(url + characterId + parameters);
    }
}
