import java.util.ArrayList;
import java.util.List;

public class ScriptUpdater implements Runnable {
    
    private static List<Script> scripts = new ArrayList<Script>();

    public static void register(Script script) {
        scripts.add(script);
    }

    @Override
    public void run() {
        for (Script script : scripts) {
            script.update();
        }
    }
}
