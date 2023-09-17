package ex6;

import javax.swing.ImageIcon;

public class Fish extends Animal{
    public Fish(int age) {
        super(age);
        super.image = new ImageIcon("Fish.png");
    }

    @Override
    public void move(){
       super.move();

        super.month += 0.5;
        setHealth(getHealth() - 10);

        if (month >= 12.0){
            setAge(getAge() + 1);
            super.month = 0;
        }
        setStrength(getStrength());
    }

    @Override
    public void create() {
        Animal child = new Fish(1);
        child.x = correct(x + getRange() * 5);
        child.y = correct(y + getRange() * 5);
        ecosystem.add(child);
    }
}
