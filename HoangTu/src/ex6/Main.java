package ex6;


public class Main {
    public static void main(String[] args) {
        Ecosystem ecosystem = Ecosystem.createEcosystem();
        ecosystem.randomEcosystem(100);
        for (int month = 1; ecosystem.alive() && month < 10000; month++){
            String data = ecosystem + "__________\n" + "Month: " + month +"\nSize: " + ecosystem.size() + "\n";
            ecosystem.action();
            System.out.println(data);
        }
        System.out.println("Done!");
    }
}
