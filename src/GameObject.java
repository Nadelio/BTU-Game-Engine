import javax.swing.JComponent;

public class GameObject extends JComponent {
    private String name = "UnnamedGameObject";
    private Transform transform;
    private String[] tags = new String[] {"Untagged"};
    private GameObject[] children;
    private Script[] scripts;
    private GameComponent[] components;

    public GameObject(GameScene scene, String name, Transform transform, String[] tags, GameObject[] children, Script[] scripts, GameComponent[] components) {
        this.name = name;
        this.transform = transform;
        this.tags = tags;
        this.children = children;
        this.scripts = scripts;
        this.components = components;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String[] tags, GameObject[] children) {
        this.name = name;
        this.transform = transform;
        this.tags = tags;
        this.children = children;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String[] tags, Script[] scripts) {
        this.name = name;
        this.transform = transform;
        this.tags = tags;
        this.scripts = scripts;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String[] tags, GameComponent[] components) {
        this.name = name;
        this.transform = transform;
        this.tags = tags;
        this.components = components;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String tag, GameObject[] children, Script[] scripts, GameComponent[] components) {
        this.name = name;
        this.transform = transform;
        addTag(tag);
        this.children = children;
        this.scripts = scripts;
        this.components = components;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String tag, GameObject[] children) {
        this.name = name;
        this.transform = transform;
        addTag(tag);
        this.children = children;
        scene.register(this);
    }
    
    public GameObject(GameScene scene, String name, Transform transform, String tag, Script[] scripts) {
        this.name = name;
        this.transform = transform;
        addTag(tag);
        this.scripts = scripts;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String tag, GameComponent[] components) {
        this.name = name;
        this.transform = transform;
        addTag(tag);
        this.components = components;
        scene.register(this);
    }
    
    public GameObject(GameScene scene, String name, Transform transform, String[] tags){
        this.name = name;
        this.transform = transform;
        this.tags = tags;
        scene.register(this);
    }

    public GameObject(GameScene scene, String name, Transform transform, String tag) {
        this.name = name;
        this.transform = transform;
        addTag(tag);
        scene.register(this);
    }
    
    public GameObject(GameScene scene, String name, Transform transform) {
        this.name = name;
        this.transform = transform;
        scene.register(this);
    }
    
    public GameObject(GameScene scene, String name) {
        this.name = name;
        this.transform = new Transform();
        scene.register(this);
    }
    
    public void addTag(String tag) {
        if(Utils.contains(this.tags, "Untagged")) {
            tags = new String[] {tag};
            return;
        }

        String[] newTags = new String[tags.length + 1];
        for (int i = 0; i < tags.length; i++) {
            newTags[i] = tags[i];
        }
        newTags[tags.length] = tag;
        tags = newTags;
    }

    public void removeTag(String tag) {
        if(Utils.contains(tags, tag)) {
            String[] newTags = new String[tags.length - 1];
            int j = 0;
            for (int i = 0; i < tags.length; i++) {
                if(tags[i] != tag) {
                    newTags[i] = tags[i];
                    j++;
                }
            }
            tags = newTags;
        }
    }

    public boolean hasTag(String tag) {
        return Utils.contains(tags, tag);
    }

    public void addScript(Script script) {
        if(scripts == null) {
            scripts = new Script[] {script};
            return;
        }

        Script[] newScripts = new Script[scripts.length + 1];
        for (int i = 0; i < scripts.length; i++) {
            newScripts[i] = scripts[i];
        }
        newScripts[scripts.length] = script;
        scripts = newScripts;
    }

    public void removeScript(Script script) {
        if(Utils.contains(scripts, script)) {
            Script[] newScripts = new Script[scripts.length - 1];
            int j = 0;
            for (int i = 0; i < scripts.length; i++) {
                if(scripts[i] != script) {
                    newScripts[i] = scripts[i];
                    j++;
                }
            }
            scripts = newScripts;
        }
    }

    public boolean hasScript(Script script) {
        return Utils.contains(scripts, script);
    }

    public void addComponent(GameComponent component) {
        if(components == null) {
            components = new GameComponent[] {component};
            return;
        }

        GameComponent[] newComponents = new GameComponent[components.length + 1];
        for (int i = 0; i < components.length; i++) {
            newComponents[i] = components[i];
        }
        newComponents[components.length] = component;
        components = newComponents;
    }

    public void removeComponent(GameComponent component) {
        if(Utils.contains(components, component)) {
            GameComponent[] newComponents = new GameComponent[components.length - 1];
            int j = 0;
            for (int i = 0; i < components.length; i++) {
                if(components[i] != component) {
                    newComponents[i] = components[i];
                    j++;
                }
            }
            components = newComponents;
        }
    }

    public boolean hasComponent(GameComponent component) {
        return Utils.contains(components, component);
    }

    public void addChild(GameObject child) {
        if(children == null) {
            children = new GameObject[] {child};
            return;
        }

        GameObject[] newChildren = new GameObject[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            newChildren[i] = children[i];
        }
        newChildren[children.length] = child;
        children = newChildren;
    }

    public void removeChild(GameObject child) {
        if(Utils.contains(children, child)) {
            GameObject[] newChildren = new GameObject[children.length - 1];
            int j = 0;
            for (int i = 0; i < children.length; i++) {
                if(children[i] != child) {
                    newChildren[i] = children[i];
                    j++;
                }
            }
            children = newChildren;
        }
    }

    public boolean hasChild(GameObject child) {
        return Utils.contains(children, child);
    }

    public void changeName(String name) { this.name = name; }

    public String getName() { return this.name; }
    public Transform getTransform() { return this.transform; }
    public String[] getTags() { return this.tags; }
    public GameObject[] getChildren() { return this.children; }
    public Script[] getScripts() { return this.scripts; }
    public GameComponent[] getGameComponents() { return this.components; }

    public void destroy(){
        for(GameObject child : children) {
            child.destroy();
        }

        for(Script script : scripts) {
            ScriptUpdater.unregister(script);
        }

        for(GameComponent component : components) {
            ComponentUpdater.unregister(component);
            FixedUpdater.unregister(component);
        }

        this.name = null;
        this.transform = null;
        this.tags = null;
        this.children = null;
        this.scripts = null;
        this.components = null;
    }
}
