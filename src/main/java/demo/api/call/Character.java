package demo.api.call;

import com.google.gson.GsonBuilder;
import java.io.IOException;

public class Character {

    public String id;
    public String name;
    public String description;

    public Character(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Character showData(String characterId) throws IOException {
        String response = ApiCall.result(characterId);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Character.class, new JsonCallAdapter());

        return gsonBuilder.create().fromJson(response, Character.class);
    }
}