public class Debug {

    // ANSI Constants
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Logs a message to the console with no color formatting
     * @param message
     * @param newline
     */
    public void log(String message, boolean newline){
        if(newline) System.out.println(message);
        else System.out.print(message);
    }

    /**
     * Logs info to the console with a blue font color
     * @param message
     * @param newline
     */
    public void info(String message, boolean newline){
        if(newline) System.out.println(ANSI_BLUE + message + ANSI_RESET);
        else System.out.print(ANSI_BLUE + message + ANSI_RESET);
    }

    /**
     * Logs an error message to the console with a red font color
     * @param message
     * @param newline
     */
    public void error(String message, boolean newline){
        if(newline) System.out.println(ANSI_RED + message + ANSI_RESET);
        else System.out.print(ANSI_RED + message + ANSI_RESET);
    }

    /**
     * Logs a warning message to the console with a yellow font color
     * @param message
     * @param newline
     */
    public void warning(String message, boolean newline){
        if(newline) System.out.println(ANSI_YELLOW + message + ANSI_RESET);
        else System.out.print(ANSI_YELLOW + message + ANSI_RESET);
    }

    /**
     * Logs a success message to the console with a green font color
     * @param message
     * @param newline
     */
    public void success(String message, boolean newline){
        if(newline) System.out.println(ANSI_GREEN + message + ANSI_RESET);
        else System.out.print(ANSI_GREEN + message + ANSI_RESET);
    }
}
