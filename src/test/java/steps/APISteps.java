package steps;

import aquality.selenium.core.logging.Logger;
import lombok.experimental.UtilityClass;
import org.testng.Assert;
import utils.APIUtils;

@UtilityClass
public class APISteps {
    public static String getToken(String request, String param, String variant) {
        Logger.getInstance().info("Step: get token");
        return APIUtils.getResponse(request, param, variant).asString();
    }

    public static void checkTokenReceived(String token) {
        Assert.assertFalse(token.isEmpty(), "Token is not generated");
    }
}
