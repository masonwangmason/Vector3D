package project01;

public class Vector3D {
    // fields and constructors
    public double x, y, z;
    public double magnitude;
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Methods to get the values of individual components
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }

    // A toString method that returns a string that describes this vector.
    public String toString(){
        String temp_x = String.format("%.2f", x);
        String temp_y = String.format("%.2f", y);
        String temp_z = String.format("%.2f", z);
        return "(" + temp_x + ", " + temp_y + ", " + temp_z + ")";
    }

    // A method getMagnitude that returns its magnitude.
    public double getMagnitude(){
        magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return magnitude;
    }

    // A method normalize that returns a normalized version of this vector.
    public Vector3D normalize(){
        double mag = getMagnitude();
        if (mag == 0) {
            throw new IllegalStateException("Can't normalize a vector with magnitude 0");
        }
        return new Vector3D(x/mag, y/mag, z/mag);
    }

    // A method add that returns the result of adding this vector to another vector.
    public Vector3D add(Vector3D v){
        double new_x = v.getX() + x;
        double new_y = v.getY() + y;
        double new_z = v.getZ() + z;
        return new Vector3D(Math.round(new_x), Math.round(new_y), Math.round(new_z));
    }

    // A method multiply that returns the result of multiplying this vector by a constant.
    // It should not change the vector that is being multiplied.
    public Vector3D multiply(double constant){
        return new Vector3D(x * constant, y * constant, z * constant);
    }

    // A method dotProduct that returns the dot product of this vector and another vector.
    public double dotProduct(Vector3D v){
        return (x * v.x) + (y * v.y) + (z * v.z);
    }

    // A method angleBetween that returns the angle between two vectors in degrees.
    public double angleBetween(Vector3D v) {
        double dotProduct = dotProduct(v);
        double angle = Math.acos(dotProduct / (this.getMagnitude() * v.getMagnitude()));
        return Math.toDegrees(angle);
    }

    // Cross Product
    public Vector3D crossProduct(Vector3D v){
        double crossX = (y * v.z) - (z * v.y);
        double crossY = (z * v.x) - (x * v.z);
        double crossZ = (x * v.y) - (y * v.x);
        return new Vector3D(crossX, crossY, crossZ);
    }
}
