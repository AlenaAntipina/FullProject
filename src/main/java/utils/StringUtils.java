package utils;

import data.Symbol;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public static String cutStringFromSymbolColon(String string) {
        return string.substring(string.indexOf(Symbol.COLON.getSymbol()) + 2);
    }

    public static String cutImageString(String string) {
        return string.substring(string.indexOf(Symbol.COMMA.getSymbol()) + 1);
    }

    public static String cutStringFromSymbolEquals(String string) {
        return string.substring(string.indexOf(Symbol.EQUALS.getSymbol()) + 1);
    }
}
