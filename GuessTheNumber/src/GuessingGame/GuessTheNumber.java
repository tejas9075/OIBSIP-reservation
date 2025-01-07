package GuessingGame;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int lowerBound = 1;
		int upperBound = 100;
		int maxAttempts = 7;
		int rounds = 3;
		int score = 0;
		
		System.out.println("Welcome to Guess the Number!");
		System.out.println("I've chosen a number between " + lowerBound +" and "+ upperBound + ".");
		
		for(int round=1; round <= rounds; round++) {
			System.out.println("\nRound " + round);
			int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
			int attempts = 0;
			
			System.out.println("You Have " + maxAttempts + " atempts to guess.");
			
			while(attempts < maxAttempts) {
				System.out.println("Enter your guessing Number : ");
				int userGuess = sc.nextInt();
				attempts++;
				
				if(userGuess == targetNumber) {
					System.out.println("Congratulations! You guessed it in "+ attempts +"attempts.");
					score+=(maxAttempts -attempts +1)*10;
					
					System.out.println("You earned "+ (maxAttempts - attempts +1)*10 + "points!");
					break;
				}
				else if(userGuess<targetNumber){
					System.out.println("Too Low! Try again.");
					if(attempts < maxAttempts -1) {
						System.out.println("Hint: The number is higher.");
						
					}else {
						System.out.println("Too High! Try again.");
						if(attempts<maxAttempts - 1) {
							System.out.println("Hint: The number is lower.");
						}
					}
				}
				if(attempts==maxAttempts) {
					System.out.println("Sorry, you have run out of attempts. The Number was: "+ targetNumber);
				}
			}
			System.out.println("\nGame Over!");
			System.out.println("Your final score: " + score);
			
			if(score>= rounds *50) {
				System.out.println("Excellent performance! You ae a true number wizard!");
			}else if(score >= rounds * 25) {
				System.out.println("Good job! You have a knack for guessing");
			}else {
				System.out.println("Keep practicing. you will get better!");
				
				
				
			}
			
		}
		sc.close();
	}
	

}
