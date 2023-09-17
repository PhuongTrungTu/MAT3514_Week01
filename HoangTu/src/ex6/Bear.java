package ex6;

import javax.swing.ImageIcon;

public class Bear extends Animal {
    public Bear(int age) {
        super(age);
        super.image = new ImageIcon("Bear.png");
        super.setBear();
    }

    @Override
    public void move(){
        super.move();
        super.month += 0.025;
        setHealth(getHealth() - 50);
        if (month >= 12.0){
            setAge(getAge() + 1);
            super.month = 0;
        }
        setStrength(getStrength());
    }

    @Override
    public void create() {
        Animal child = new Bear(1);
        child.x = correct(x + getRange() * 2);
        child.y = correct(y + getRange() * 2);
        ecosystem.add(child);
    }
}
