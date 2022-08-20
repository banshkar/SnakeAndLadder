import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
/*All UC- Used There And All UC -Merge
FULl Game completly*/
class SnakeAndLadder1 {
    final static int WinPoint = 100;
    static Map<Integer, Integer> snake = new HashMap<>();
    static Map<Integer, Integer> Ladder = new HashMap<>();
    {
        // Store key and position
        // Used 5 snake
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);

        Ladder.put(6,25);
        Ladder.put(11,40);
        Ladder.put(60,85);
        Ladder.put(46,90);
        Ladder.put(17,69);
    }
    // UC-2 There Used
    public int dice() {
        int start = 0;
        Random r = new Random();
        start = r.nextInt(7);
        int ran = (start == 0 ? 1 : start);
        return ran;
    }
    public int TotalValue(int Playposition, int DiceValue) {
        int PlayNewPostion = Playposition + DiceValue;
        if (PlayNewPostion >= WinPoint) {
            return Playposition;
        }
        if (null != snake.get(PlayNewPostion)) {
          //  swallowed by the snake
            PlayNewPostion = snake.get(PlayNewPostion);
        }
        if (null != snake.get(PlayNewPostion)) {
            // climbing the ladder
             PlayNewPostion = Ladder.get(PlayNewPostion);
        }
        return PlayNewPostion;
    }
    public boolean isWin(int Playposition) {
        return WinPoint == Playposition;
    }
    public void start() {
        int Play_1_position = 0, Play_2_position = 0;
        int currentposition = -1;
        Scanner sc = new Scanner(System.in);
        String pressed;
        int Dice = 0;
        int used_numberofdice_player_1=0;
        int used_numberofdice_player_2=0;
        do {
            // UC-1 There Used
            System.out.println((currentposition == -1 ?
                    "\n\n First players turn" : "\n\nsecond players turn"));
                System.out.println(" Press  's' ");
            pressed = sc.next();
            Dice = dice();
            // UC-3 There Used
            if (currentposition == -1) {
                Play_1_position = TotalValue(Play_1_position, Dice);
                System.out.println("Player_1_ is postion :" + Play_1_position);
                System.out.println("Player_2_ is postion :" + Play_2_position);
                used_numberofdice_player_1++;
                if (isWin(Play_1_position)) {
                    System.out.println("total number used dice" + used_numberofdice_player_1);
                    System.out.println("Congratulations! First player won");
                    return;
                }
            } else {
                Play_2_position = TotalValue(Play_2_position, Dice);
                System.out.println("Player_1_ is postion :" + Play_1_position);
                System.out.println("Player_2_ is postion :" + Play_2_position);
                used_numberofdice_player_2++;
                if (isWin(Play_1_position)) {
                    System.out.println("total number used dice" + used_numberofdice_player_2);
                    System.out.println("Congratulations! Second player won");
                    return;
                }
            }
            currentposition = -currentposition;
        } while ("s".equals(pressed));
    }
}
         public class SnakeAndLadder{
        public static void main(String[] args) {
            SnakeAndLadder1 sate = new SnakeAndLadder1();
            System.out.println("...........................");
            System.out.println();
            System.out.println(" Let's Start Bro ");
            System.out.println("...........................");
            sate.start();
        }
    }