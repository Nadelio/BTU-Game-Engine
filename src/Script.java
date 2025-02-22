public abstract class Script {

    private final int UID;

    public Script(){this.UID = Utils.scriptUID();}

    abstract public void start();
    abstract public void update();
 
    public boolean equals(Script other){ return this.UID() == other.UID(); }

    public int UID(){ return this.UID; }
}
