public class Transform {
    public Vector3 position;
    public double rotation;
    public Vector3 scale;

    public Transform(Vector3 position, double rotation, Vector3 scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Transform(Vector3 position, double rotation) {
        this(position, rotation, Vector3.one());
    }

    public Transform(Vector3 position) {
        this(position, 0, Vector3.one());
    }

    public Transform() {
        this(Vector3.zero(), 0, Vector3.one());
    }
}
