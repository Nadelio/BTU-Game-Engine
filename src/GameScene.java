import java.util.ArrayList;
import java.util.List;

public class GameScene {
    private List<GameObject> objects = new ArrayList<GameObject>();
    private List<Script> sceneScripts = new ArrayList<Script>();

    public void register(GameObject object) { objects.add(object); }

    public void unregister(GameObject object) { objects.remove(object); }

    public void register(Script script) { sceneScripts.add(script); }

    public void unregister(Script script) { sceneScripts.remove(script); }

    
}
