package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TimeUtils {
    public static long cutMilliseconds(long time) {
        return (time / 1000) * 1000;
    }
}
