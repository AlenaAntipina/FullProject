package utils;

import aquality.selenium.core.logging.Logger;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

@UtilityClass
public class JsonUtils {
    public static String getStringData(String field, String path) {
        return (String) getJsonObject(path).get(field);
    }

    private static JSONObject getJsonObject(String path) {
        try {
            FileReader reader = new FileReader(path);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            Logger.getInstance().error("IOException :" + e);
            throw new RuntimeException(e);
        }
    }
}



