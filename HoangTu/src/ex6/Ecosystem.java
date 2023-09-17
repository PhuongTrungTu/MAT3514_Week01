package ex6;

import java.util.*;

public class Ecosystem {
    private static Ecosystem instance = null;
    private final List<Animal> river = new ArrayList<Animal>();
    protected final int MAP_SIZE = 800;
    private List<Animal[]> closestPairs = new ArrayList<>();

    private Ecosystem() {
    }

    public void randomEcosystem(int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                river.add(new Bear(random.nextInt(20) + 10));
            } else {
                river.add(new Fish(random.nextInt(20) + 10));
            }
        }
    }

    protected void clear() {
        river.clear();
    }

    public static Ecosystem createEcosystem() {
        if (instance == null) {
            instance = new Ecosystem();
        }
        return instance;
    }

    private boolean check(Animal animal) {
        return (animal.getAge() > 30 || animal.getHealth() <= 0);
    }

    public void check() {
        river.sort(Comparator.comparingDouble(Animal::getX));

        TreeSet<Animal> ySet = new TreeSet<>(Comparator.comparingDouble(Animal::getY));
        int j = 0;
        for (int i = 0; i < river.size() - 1; i++) {
            Animal animal1 = river.get(i);
            while (j < i && animal1.getX() - get(j).getX() > animal1.range) {
                ySet.remove(get(j));
                j++;
            }

            Animal lowerBound = new Animal(animal1.getX(), animal1.getY() - animal1.getRange());
            Animal upperBound = new Animal(animal1.getX(), animal1.getY() + animal1.getRange() );

            for (Animal animal2 : ySet.subSet(lowerBound, true, upperBound, true)) {
                double distance = animal1.distance(animal2);
                if (distance <= animal1.getRange()) {
                    closestPairs.add(new Animal[] { animal1, animal2 });
                }
            }

        }
    }

    public void action() {
        for (int i = 0; i < river.size(); i++) {
            get(i).move();
        }
        check();
        clean();
    }

    public void add(Animal animal) {
        river.add(animal);
    }

    public Animal get(int index) {
        return river.get(index);
    }

    public void remove(Animal animal) {
        river.remove(animal);
    }

    public int size() {
        return river.size();
    }

    private void clean() {
        for (int i = 0; i < river.size(); i++) {
            if (check(get(i))) {
                river.remove(i);
                i--;
            }
        }

        for (int i = 0; i < closestPairs.size(); i++) {
            closestPairs.get(i)[0].collide(closestPairs.get(i)[1]);
        }
    }

    public boolean alive() {
        return river.size() != 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Animal animal : river) {
            result.append(animal).append("\n");
        }
        return result.toString();
    }
}
