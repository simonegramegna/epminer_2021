class InputUtils {

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
}
