import java.util.ArrayList;
import java.util.List;

public class FixedUpdater implements Runnable {
    
    private static List<GameComponent> components = new ArrayList<GameComponent>();
    
    public static void register(GameComponent component) {
        components.add(component);
    }

    @Override
    public void run() {
        for (GameComponent component : components) {
            component.fixedUpdate();
        }
    }
    
}
