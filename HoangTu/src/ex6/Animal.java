package ex6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Animal {
    protected double x;
    protected double y;
    private int rank = 0;
    private int age;
    protected double month = 0;
    protected int health = 10000;

    public Ecosystem ecosystem = Ecosystem.createEcosystem();;

    private double strength = 0;
    private final boolean gender;
    protected double range = ecosystem.MAP_SIZE / 50.0;

    protected ImageIcon image;

    protected void setBear(){
        range *= 3;
        rank = 1;
    }
    protected Animal(int age) {
        boolean isMale = new Random().nextBoolean();
        if (isMale){
            strength += 500;
        }
        this.gender = isMale;
        this.strength = getStrength();
        this.age = age;
        randomPosition();
    }

    protected Animal(double x, double y){
        this.x = x;
        this.y = y;
        this.gender = true;
        age = 1;
    }


    public int getAge() {
        return age;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHealth(){
        return health;
    }
    public double getStrength(){
        this.strength = Math.floor(( - 80.0 / 9.0 * Math.pow(age - 15, 2) + 2000.0) * 100) / 100;
        return this.strength;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public Image getImage() {
        return image.getImage();
    }

    public boolean canCreate(Animal other){
        return (this.age >= 4 && other.age >= 4 && this.gender ^ other.gender);
    }

    private void randomPosition(){
        Random random = new Random();
        this.x = Math.floor(random.nextDouble(ecosystem.MAP_SIZE) * 100) / 100;
        this.y = Math.floor(random.nextDouble(ecosystem.MAP_SIZE) * 100 ) / 100;
    }

    protected double correct(double value){
        final int TEMP = 10;
        if (value > ecosystem.MAP_SIZE - TEMP){
            return ecosystem.MAP_SIZE - TEMP;
        } else if (value < TEMP){
            return TEMP;
        }
        return Math.floor(value * 100) / 100;
    }

    public void move(){
        Random random = new Random();
        int    radius = random.nextInt(360) - 180;
        int    length = random.nextInt(ecosystem.MAP_SIZE / 20) + 1;
        if (this.rank == 1){
            length *= 3;
        }

        x += length * Math.cos(Math.toRadians(radius));
        y += length * Math.sin(Math.toRadians(radius));

        x = correct(x);
        y = correct(y);
    }

    public double getRange() {
        return range;
    }

    public double distance(Animal other){
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public void create(){

    }

    private void fight(Animal other){
        if (other.health - this.strength < 0){
            ecosystem.remove(other);
        }
        else if (this.health - other.strength < 0){
            ecosystem.remove(this);
        }else{
            while (this.health > 0 && other.health > 0){
                this.health -= other.strength;
                other.health -= this.strength;
            }
            if (this.health <= 0){
                ecosystem.remove(this);
            }
            else {
                ecosystem.remove(other);
            }
        }
    }

    public void collide(Animal other){
        if(this.rank > other.rank){
            ecosystem.remove(other);
            this.health += 10000;
        }else if (this.rank < other.rank){
            ecosystem.remove(this);
            other.health += 10000;
        }else {
            if (canCreate(other)){
                create();
            }else {
                fight(other);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (rank == 0){
            result.append("Fish{");
        }else {
            result.append("Bear{");
        }
        result.append("Age: ").append(age).append(" (").append(month).append("/12)").append(", Position (").append(x)
                .append(", ").append(y).append("), Health:").append(health).append(", Strength: ").append(strength)
                .append(", Gender: ").append(gender?"Male":"Female").append("}");
        return result.toString();
    }
}
