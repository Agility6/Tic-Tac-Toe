import java.util.Scanner;

public class Game {

    public static Scanner keyboard;
    
    public static String[] arr = new String [9];

    private static final String O = "O";
    private static final String X = "X";
    private static final String oWinner = "OOO";
    private static final String xWinner = "XXX";

    private static String[][] boardAll;

    public Game(Scanner scanner) {
        keyboard = scanner;
    }

    public void play() {
        
        // 切换玩家
        boolean flag = false;
        int stepMax = 9;

        while (stepMax-- > 0) {
            int i = keyboard.nextInt();
            arr[i] =  flag ? O : X;
            updateBoard();
            flag = !flag; 
            printBoard();
            // 判断是否有赢家
            winner();
        }

        System.out.println("No win ===> ");
    }
    
    public void init() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  ""+i;
        }
        printBoard();
    }

    private static void updateBoard() {
        boardAll = new String[][] {
            {arr[0], "|", arr[1], "|", arr[2]},
            {"-", "-", "-", "-", "-"},
            {arr[3], "|", arr[4], "|", arr[5]},
            {"-", "-", "-", "-", "-"},
            {arr[6], "|", arr[7], "|", arr[8]},
        };
    }
    
    private static void winner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = arr[0] + arr[1] + arr[2];
                break;
            case 1:
                line = arr[3] + arr[4] + arr[5];
                break;
            case 2:
                line = arr[6] + arr[7] + arr[8];
                break;
            case 3:
                line = arr[0] + arr[3] + arr[6];
                break;
            case 4:
                line = arr[1] + arr[4] + arr[7];
                break;
            case 5:
                line = arr[2] + arr[5] + arr[8];
                break;
            case 6:
                line = arr[0] + arr[4] + arr[8];
                break;
            case 7:
                line = arr[2] + arr[4] + arr[6];
                break;
            }

            if (line.equals(xWinner)) {
                System.out.print("X player win ===> ");
                playQuit();
            } else if (line.equals(oWinner)) {
                System.out.print("O player win ===> ");
                playQuit();
            }
            
        }
    }

    private static void printBoard() {
        updateBoard();
        for (int i = 0; i < boardAll.length; i++) {
            for (int j = 0; j < boardAll[0].length; j++) {
                System.out.print(boardAll[i][j]);
            }
            System.out.println();
        }

        System.out.println("- - - - -");
    }

    private static void playQuit() {
        System.out.println("play end!!!");
    }
}
