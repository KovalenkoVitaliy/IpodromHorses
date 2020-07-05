import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses () {
        return horses;
    }

    public Horse getWinner() {
        double max = horses.get(0).getDistance();
        int index = 0;
        for (int j = 0; j<horses.size(); j++) {
            if (horses.get(j).getDistance() > max) {
                max = horses.get(j).getDistance();
                index = j;
            }
        }
        return horses.get(index);
    }

    public void printWinner() {
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }

    public void run() {
        for (int i=1; i <=100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                
            }
        }
    }

    public void print() {
        for(Horse x: horses) {
            x.print();
        }
        for (int i =0; i <3; i++) {
            System.out.println();
        }
    }

    public void move() {
        for(Horse x: horses) {
            x.move();
        }
    }
    
    public static void main(String[] args) {

        List<Horse> list = new ArrayList<>();
        game = new Hippodrome(list);
        Horse one1 = new Horse("horse1", 3, 0);
        Horse one2 = new Horse("horse2", 3, 0);
        Horse one3 = new Horse("horse3", 3, 0);
        game.getHorses().add(one1);
        game.getHorses().add(one2);
        game.getHorses().add(one3);

        game.run();
        game.printWinner();

    }
}