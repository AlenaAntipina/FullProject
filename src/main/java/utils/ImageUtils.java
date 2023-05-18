package utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base64;

@UtilityClass
public class ImageUtils {

    public static boolean isImageEquals(byte[] sentImage, String downloadedImage) {
        byte[] downloadedImageToByte = Base64.decodeBase64(downloadedImage);
        return sentImage.length == downloadedImageToByte.length && getPercentageOfDifference(sentImage, downloadedImageToByte) <= 15;
    }

    private static double getPercentageOfDifference(byte[] first, byte[] second) {
        int allDifferentBytes = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                allDifferentBytes++;
            }
        }
        return allDifferentBytes * 100 / first.length;
    }

}
