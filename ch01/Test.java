package ch01;

public class Test {
    public static void main(String[] args) {
        int player1Score = 0;
        int player2Score = 0;
        boolean gameOn = true;
        
        while(gameOn) {
            double random = Math.random();
            if(random < 0.5) {
                player1Score++;
            } else {
                player2Score++;
            }
            
            System.out.println("Player 1: " + player1Score + " Player 2: " + player2Score);
            
            if(player1Score >= 21 || player2Score >= 21) {
                gameOn = false;
            }
        }
        
        if(player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}