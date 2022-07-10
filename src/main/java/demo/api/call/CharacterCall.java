package demo.api.call;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class CharacterCall {
    private static final Logger log = Logger.getLogger(String.valueOf(CharacterCall.class));
    final OkHttpClient client = new OkHttpClient();

    static final String MARVEL_BASE_URL = "https://gateway.marvel.com:443";
    static final String END_POINT_CHARACTERS = "/v1/public/characters/";
    static final String API_KEY = "?apikey=9181b7eb55851794829d0fa009dc3407";
    static final String TS = "&ts=9";
    static final String HASH = "&hash=dbc282948bdf0b2edf10249b43190026";

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void call() throws IOException {
        CharacterCall example = new CharacterCall();
        String response = example.run(
                MARVEL_BASE_URL
                        + END_POINT_CHARACTERS
                        +"1011054"
                        + API_KEY
                        + TS
                        + HASH);
        log.info(response);

        Gson gson = new Gson();
        Character r = gson.fromJson(response,Character.class);

        log.info(r.toString());


    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Character {
    int id;
    String name;
    String description;
    Date modified;
    String resourceURI;
    Arrays urls;
    Image thumbnail;
    java.util.List<String> comics;
    java.util.List<String> stories;
    java.util.List<String> events;
    List<String> series;
}
