package tictactoe;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class TicTacToe {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        
        char [][]board = {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}};
        
        
        
        
        while(true){
            Scanner scan  = new Scanner(System.in);
            System.out.print("Enter your placement(1-9): ");
            int Playerposition = scan.nextInt();
            while(playerPosition.contains(Playerposition)||cpuPosition.contains(Playerposition)){
                System.out.println("Position taken! Enter another Position.");
                Playerposition = scan.nextInt();
            }
            places(board,Playerposition,"player");
            String result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
        
            Random r = new Random();
            int cpuposition = r.nextInt(10);
            while(playerPosition.contains(cpuposition)||cpuPosition.contains(cpuposition)){
                
                cpuposition = r.nextInt(10);
            }
            places(board,cpuposition,"cpu");
        
            PrintBoard(board);
            result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
            
        }
        
    }
    public static void PrintBoard(char[][] board){
        
        for (char []row: board) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    
    public static void places(char[][]board,int Position,String user){
        
        char symbol = ' ';
        
        if(user.equals("player")){
            symbol = 'X';
            playerPosition.add(Position);
        }
        else if(user.equals("cpu")){
            symbol = '0';
            cpuPosition.add(Position);
        }
        
        
        switch(Position){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;    
            default:
                break;
        }
    }
    
    public static String checkWinner(){
        
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List bottomCol = Arrays.asList(3,6,9);
        List crossLeft = Arrays.asList(1,5,9);
        List crossRight = Arrays.asList(3,5,7);
        
        List <List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(bottomCol);
        winningConditions.add(crossLeft);
        winningConditions.add(crossRight);
        
        for(List list : winningConditions){
            if(playerPosition.containsAll(list)){
                return "Congratulations you won!";
            }
            else if(cpuPosition.containsAll(list)){
                return "CPU wins!";
            }
            else if(playerPosition.size()+cpuPosition.size()==9){
                return "It's a draw";
            }
        }
        
        return"";
    }
    
}
