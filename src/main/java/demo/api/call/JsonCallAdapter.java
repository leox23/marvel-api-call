package demo.api.call;

import com.google.gson.*;

import java.lang.reflect.Type;

public class JsonCallAdapter implements JsonDeserializer<Character> {

    public Character deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject data = jsonObject.get("data").getAsJsonObject();
        JsonObject character = data.get("results").getAsJsonArray().get(0).getAsJsonObject();

        return new Character(
                character.get("id").getAsString(),
                character.get("name").getAsString(),
                character.get("description").getAsString()
                );
    }

}
