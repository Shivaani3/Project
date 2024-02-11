package paper.scissors.stone;



/**
 *
 * @author User
 */
import java.util.Random;
import java.util.Scanner;
public class PaperScissorsStone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Random b = new Random();
        int count = 0;
        int total = 0;
        int option;
        System.out.println("Welcome to a game of Rock-Paper-Scissors");
        System.out.println("Input\n1-Rock. 2-Paper, 3-Scissors");
        do{
            
        System.out.print("Input your option or negative number to exit: ");
        option = a.nextInt();
        if(option<1){
            System.out.println("Exit Game!");
        }
        
        else if(option>3){
            System.out.println("Invalid input. Try again.");
        }
        else{
        int compGenerate = 4;
        int compGenerate1 = 1;
        int compInput = b.nextInt(1,4);
        System.out.println("Computer plays "+ compInput);
        
        switch(option){
            case 1:
                if(compInput == 2){
                System.out.println("Computer Wins!!");}
                else if(compInput == 1){
                    System.out.println("Its a tie");
                }
                else{
                        System.out.println("You Win! ");
                        count++;
                        }
                
                break;
            
            case 2:
                if(compInput == 1){
                    System.out.println("You win!");
                    count++;
                }
                else if(compInput == 2){
                    System.out.println("Its a tie");
                }
                else{
                    System.out.println("Computer Wins!!");
                }
                
                break;
                
            case 3:
                if(compInput == 1){
                    System.out.println("Computer Wins!");
                }
                else if(compInput == 3){
                    System.out.println("Its a tie");
                }
                else{
                    System.out.println("You Win!");
                    count++;
                }
                
                break;
               
        }
        total++;
        
       
        }
        }while(!(option<1));
        System.out.println("Final Score is "+ count+"/"+total);
        
    }
}
