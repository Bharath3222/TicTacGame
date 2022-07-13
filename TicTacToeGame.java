package TicTacToe;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class TicTacToeGame {
	static String[] game;
	static String move;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		game = new String[9];
		move = "X";
		String win = null;
		for (int i = 0; i < 8; i++) {
			game[i]=String.valueOf(i+1);
			}
		System.out.println("Welcome to tic tac game");
		designBoard();
		 System.out.println( "X will play first- please input slot number to place X in:");
		  
		        while (win == null) {
		            int input;
		            
		            try {
		                input = scanner.nextInt();
		                if (!(input > 0 && input <= 9)) {
		                    System.out.println( "wrong input please input correct number");
		                    continue;
		                }
		            }
		            catch (InputMismatchException e) {
		            	System.out.println( "wrong input please input correct number");
		                continue;
		            }
		              
		            if (game[input - 1].equals(
		                    String.valueOf(input))) {
		                game[input - 1] = move;
		  
		                if (move.equals("X")) {
		                    move = "O";
		                }
		                else {
		                    move = "X";
		                }
		  
		                designBoard();
		                win = getWinner();
		            }
		            else {
		                System.out.println("Slot already taken- please enter another slot number:");
		            }
		        }
		      
		        if (win.equalsIgnoreCase("draw")) {
		            System.out.println("Match Drawn");
		        }
		     
		        else {
		            System.out.println("Congrats " + win+ " has won game.");
		        }
			
		}

	 static void designBoard() {
		// TODO Auto-generated method stub
		 System.out.println("|______|_____|_____|");
		 System.out.println("|"+game[0]+"|"+game[1]+"|"+game[2]+"|");
		 System.out.println("|"+game[3]+"|"+game[4]+"|"+game[5]+"|");
		 System.out.println("|"+game[6]+"|"+game[7]+"|"+game[8]+"|");
		
	}
	 static String getWinner() {
		 for (int i = 0; i < 8; i++) {
			 String line=null;
			 switch (i) {
			case 0:
				line = game[0]+game[1]+game[2];
				break;
			case 1:
				line = game[3]+game[4]+game[5];
				break;
			case 2:
				line = game[6]+game[7]+game[8];
				break;
			case 3:
				line = game[0]+game[3]+game[6];
				break;
			case 4:
				line = game[1]+game[4]+game[7];
				break;
			case 5:
				line = game[2]+game[5]+game[8];
				break;
			case 6:
				line = game[0]+game[4]+game[8];
				break;
			default:
				line = game[2]+game[4]+game[6];
				break;
			}
			if(line.equals("XXXX"))
				return "X";
			else if(line.equals("OOOO"))
				return "O";
		}
		 for (int i = 0; i < 9; i++) {
			 if (Arrays.asList(game).contains(
	                    String.valueOf(i + 1))) {
	                break;
	            }
	            else if (i == 8) {
	                return "draw";
	            }
			
		}
		 System.out.println(
		            move + " turn- provide a slot number to place "
		            + move + " in:");
		        return null;
	 }
	 
	 

	}
	


