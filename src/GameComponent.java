public abstract class GameComponent implements Runnable {
    private final int UID;

    public GameComponent() { this.UID = Utils.componentUID(); }

    public abstract void start();
    public abstract void update();
    public abstract void fixedUpdate();

    @Override
    public void run() { this.fixedUpdate(); }

    public boolean equals(GameComponent other) { return this.UID() == other.UID(); }

    public int UID() { return this.UID; }
}