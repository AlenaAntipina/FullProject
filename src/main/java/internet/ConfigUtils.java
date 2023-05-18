package internet;

import lombok.experimental.UtilityClass;
import utils.JsonUtils;
import utils.PathUtils;

@UtilityClass
public class ConfigUtils {
    private static final String PATH = PathUtils.getAbsolutePath("config.json");

    public static String getMainUrlWithCredentials() {
        return JsonUtils.getStringData(FieldInJsonConfig.MAIN_URL_WITH_CREDENTIALS.getUrl(), PATH);
    }

    public static String getBaseUri() {
        return JsonUtils.getStringData(FieldInJsonConfig.BASE_URI.getUrl(), PATH);
    }
}
