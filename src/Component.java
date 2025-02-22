public abstract class Component {
    private final int UID;

    public Component() { this.UID = Utils.componentUID(); }

    public abstract void start();
    public abstract void update();

    public boolean equals(Component other) { return this.UID() == other.UID(); }

    public int UID() { return this.UID; }
}
