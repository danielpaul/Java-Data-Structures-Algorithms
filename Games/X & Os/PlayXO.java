import java.util.Scanner;

public class PlayXO
{

  static char[][] board;

  public static void main(String args[])
  {
      createBoard();

      Scanner scan = new Scanner(System.in);

      System.out.print("Player1 name: ");
      String player1Name = scan.nextLine();

      System.out.print("Player2 name: ");
      String player2Name = scan.nextLine();

      Player p1 = new Player(player1Name, 'X');
      Player p2 = new Player(player2Name, 'O');

      printBoard();

      Player turn = p1;

      while(true)
      {

        System.out.print(turn.name + "'s (" + turn.marker + ") turn: ");
        int q1 = scan.nextInt();
        int q2 = scan.nextInt();

        if(q1 > 2 || q2 > 2) {
          System.out.println("Learn to count!");
          continue;
        }

        if(board[q1][q2] != ' ') {
          System.out.println("No cheating!");
          continue;
        }

        board[q1][q2] = turn.marker;

        printBoard();

        if(checkWinning(turn.marker)) {
          System.out.println();
          System.out.println(turn.name + " is the winner! WooHoo!");
          break;
        }

        if(isFull()) {
          System.out.println("It's a tie!");
          break;
        }

        turn = (turn.marker == 'X') ? p2 : p1;
      }


  }

  public static void createBoard() {
    board = new char[3][3];

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        board[i][j] = ' ';
      }
    }
  }

  public static boolean checkWinning(char c) {
    for(int i = 0; i < 3; i++) {
        if(board[i][0] == c && board[i][1] == c && board[i][2] == c) {
          return true;
        } else if(board[0][i] == c && board[1][i] == c && board[2][i] == c) {
          return true;
        }
    }

    if((board[0][2] == c && board[1][1] == c && board[2][0] == c)
      || (board[0][0] == c && board[1][1] == c && board[2][2] == c)) {
      return true;
    }

    return false;
  }

  public static boolean isFull() {
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        if(board[i][j] == ' ') return false;
      }
    }

    return true;
  }

  public static void printBoard() {

    System.out.println();
    System.out.println("      |       |      ");
    System.out.println("  " + board[0][0] + "   |   " + board[0][1] + "   |   " + board[0][2] + "  ");
    System.out.println("      |       |      ");
    System.out.println("------+------+------");
    System.out.println("      |       |      ");
    System.out.println("  " + board[1][0] + "   |   " + board[1][1] + "   |   " + board[1][2] + "  ");
    System.out.println("      |       |      ");
    System.out.println("------+------+------");
    System.out.println("      |       |      ");
    System.out.println("  " + board[2][0] + "   |   " + board[2][1] + "   |   " + board[2][2] + "  ");
    System.out.println("      |       |      ");

  }

}