import java.util.Scanner;

public class Main {
    public static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Game g = new Game(keyboard);
        g.init();
        g.play();
        keyboard.close();
    }
}
