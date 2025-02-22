public class Vector3 {
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(x + other.x, y + other.y, z + other.z);
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(x - other.x, y - other.y, z - other.z);
    }

    public Vector3 multiply(double scalar) {
        return new Vector3(x * scalar, y * scalar, z * scalar);
    }

    public Vector3 divide(double scalar) {
        return new Vector3(x / scalar, y / scalar, z / scalar);
    }

    public double dot(Vector3 other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3 cross(Vector3 other) {
        return new Vector3(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        );
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3 normalize() {
        double mag = magnitude();
        return new Vector3(x / mag, y / mag, z / mag);
    }

    public double distance(Vector3 other) {
        return subtract(other).magnitude();
    }

    public Vector3 lerp(Vector3 other, double t) {
        return add(other.subtract(this).multiply(t));
    }

    public Vector3 slerp(Vector3 other, double t) {
        double dot = normalize().dot(other.normalize());
        double theta = Math.acos(dot) * t;
        Vector3 relative = other.subtract(this.multiply(dot)).normalize();
        return add(relative.multiply(Math.cos(theta)).add(relative.cross(this).multiply(Math.sin(theta))));
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public boolean equals(Vector3 obj) {
        return x == obj.x && y == obj.y && z == obj.z;
    }

    public Vector3 clone() {
        return new Vector3(x, y, z);
    }

    public static Vector3 zero() {
        return new Vector3(0, 0, 0);
    }

    public static Vector3 one() {
        return new Vector3(1, 1, 1);
    }

    public static Vector3 right() {
        return new Vector3(1, 0, 0);
    }

    public static Vector3 left() {
        return new Vector3(-1, 0, 0);
    }

    public static Vector3 up() {
        return new Vector3(0, 1, 0);
    }

    public static Vector3 down() {
        return new Vector3(0, -1, 0);
    }
}
