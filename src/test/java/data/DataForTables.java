package data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataForTables {
    public static String getNameTestForTest() {
        return new Faker().twinPeaks().quote();
    }

    public static String getMethodNameForTest() {
        return new Faker().twinPeaks().location();
    }
}
