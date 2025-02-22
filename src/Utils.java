public class Utils {
    private static int scriptUID = 0;

    public static boolean contains(String[] arr, String target) {
        for (String s : arr) {
            if (s.equals(target)) { return true; }
        }
        return false;
    }

    public static boolean contains(Script[] arr, Script target) {
        for (Script s : arr) {
            if (s.equals(target)) { return true; }
        }
        return false;
    }

    public static int scriptUID() { return scriptUID++; }
}