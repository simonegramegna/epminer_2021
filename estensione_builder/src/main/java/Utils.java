import java.util.Arrays;

class Utils {

    static boolean isNumber(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static float getNumber(String str) {

        return Float.parseFloat(str);
    }

    static boolean checkStringArray(String[] arr, String str) {
        if (Arrays.stream(arr).anyMatch(str::equals)) {
            return true;
        } else {
            return false;
        }
    }
}
