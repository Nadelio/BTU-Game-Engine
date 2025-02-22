import javax.swing.JComponent;

public class GameObject extends JComponent {
    private Vector3 position;
    private double rotation;
    private Vector3 scale;

    private String[] tags = new String[] {"Untagged"};
    private GameObject[] children;

    private Script[] scripts;

    private Component[] components;

    public GameObject(Vector3 position, double rotation, Vector3 scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public GameObject(Vector3 position, double rotation) {
        this(position, rotation, new Vector3(1, 1, 1));
    }

    public GameObject(Vector3 position) {
        this(position, 0, new Vector3(1, 1, 1));
    }

    public GameObject() {
        this(Vector3.zero(), 0, Vector3.one());
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
}
