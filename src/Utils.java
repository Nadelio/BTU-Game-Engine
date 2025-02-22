public class Utils {
    private static int scriptUID = 0;
    private static int componentUID = 0;

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

    public static boolean contains(Component[] arr, Component target) {
        for (Component c : arr) {
            if (c.equals(target)) { return true; }
        }
        return false;
    }

    public static int scriptUID() { return scriptUID++; }
    public static int componentUID() { return componentUID++; }
}