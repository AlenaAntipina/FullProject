package data;

import lombok.experimental.UtilityClass;
import utils.ChangeClassUtils;

import java.util.Map;

@UtilityClass
public class StatusMap {
    public static Map<Long, String> status = ChangeClassUtils.changeStatusListToMap();

    public static Map<Long, String> getStatusMap() {
        return status;
    }
}
