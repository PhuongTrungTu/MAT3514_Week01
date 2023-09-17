package ex4;

public class Sphere {
    private double radius;
    private double x;
    private double y;
    private double z;

    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getRadius(){
        return radius;
    }

    public double area(){
        return 4 * Math.PI * radius * radius;
    }

    public double volume(){
        return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
    }

    public double distance(Sphere other){
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2) + Math.pow(other.z - this.z, 2));
    }

    public boolean isIntersect(Sphere other){
        return distance(other) < this.radius + other.radius;
    }

    public boolean isInside(Sphere other){
        return  distance(other) < this.radius || distance(other) < other.radius;
    }

    @Override
    public String toString() {
        return "ex4.Sphere{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        Sphere sphere = new Sphere(5,1,2,3);
        Sphere sphere1 = new Sphere(3,1,2,3);
        System.out.printf("Surface area: %.2f\n", sphere.area());
        System.out.printf("Volume: %.2f\n", sphere.volume());

        System.out.println("Is inside: " + sphere.isInside(sphere1));
        System.out.println("Is intersect: " + sphere.isIntersect(sphere1));
    }
}
