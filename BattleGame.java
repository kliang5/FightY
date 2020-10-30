//Student Name: Nicole Liang
//Student Number: 260828103
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class BattleGame {
	// create a private static attribute 
	//with a reference to a Random object
	private static Random numRandom= new Random();
	
	//a method that takes two Strings represent the name of two files
	//of two characters respectively 
	public static void playGame(String playerFile,String monsterFile, String spellFile) {
		//use if statement to check whether the methods return two valid references
		if(FileIO.readCharacter(playerFile)==null||FileIO.readCharacter(monsterFile)==null) {
			System.out.println("The game cannot be played");
			return;
		}
		
		//create two characters using readCharacter method from FileIO class
		Character player=FileIO.readCharacter(playerFile);
		Character monster=FileIO.readCharacter(monsterFile);
		
        //display the info
		//for player:
		System.out.println("Name:  "+ player.getName());
		System.out.println("Health:  "+player.getCurrHealth());
		System.out.println("Attack:  "+player.getAttackValue());
		System.out.println("Number of Wins  "+player.getNumWins());
        System.out.println();
        System.out.println();
		//for monster:
		System.out.println("Name:  "+ monster.getName());
		System.out.println("Health:  "+monster.getCurrHealth());
		System.out.println("Attack:  "+monster.getAttackValue());
		System.out.println("Number of Wins:  "+monster.getNumWins());
		//for spells:
		System.out.println();
		System.out.println();
		System.out.println("Here are the avaliable spells:");
		//use if statement to check whether the method readSpells returns a valid reference
		 if(FileIO.readSpells(spellFile)==null) {
			 System.out.println("The game will be played without spells.");
			 //if no spells are fond, initialize the spells with an empty list
			 ArrayList<Spell> noSpell=new ArrayList<Spell>();
			 Character.setSpells(noSpell);
			 }else {
				 //use setSpells to initialize the attribute spells
				Character.setSpells(FileIO.readSpells(spellFile));
				}
				//display the info for spells
				Character.displaySpells();
				
		
		//create a Scanner to take input from user
		Scanner read=new Scanner(System.in);
		
		//use while loop to repeat the process under the condition that
		//two characters both have a positive health value
		while(player.getCurrHealth()>0.0 && monster.getCurrHealth()>0.0) {
			System.out.println();
			System.out.println("Enter a command:");
			//read user's command (input) using Scanner
			String command=read.nextLine();
			//use if statement to check whether the user inputs the attack command
			if(command.equalsIgnoreCase("attack")) {
				//use getAttackDamage method and nextIn() to get a
				//double value represents the attack damage of the player
				double attackPlayer= player.getAttackDamage(numRandom.nextInt());
				//display the info
				String attackStr1=String.format("%1$.2f", attackPlayer);
				System.out.println();
				System.out.println(player.getName()+" attacks for "+attackStr1+" damage!");
				//use if statement to check monster's current health value
				//if the current health value is positive, display the info about its current health value
				if(monster.takeDamage(attackPlayer)>0.0) {
					System.out.println(monster.toString());
				}else {
					//if monster's current health value is below or equal to 0,
					//display the info that the monster has been knocked and exist
					System.out.println(monster.getName()+" was knocked out.");
					break;
				}
				
				//repeat the above steps by swapping the character from player to monster
				//use getAttackDamage method and nextIn() to get a
				//double value represents the attack damage of the monster
				double attackMonster= monster.getAttackDamage(numRandom.nextInt());
				//display the info
				String attackStr2=String.format("%1$.2f", attackMonster);
				System.out.println();
				System.out.println(monster.getName()+" attacks for "+attackStr2+" damage!");
				//use if statement to check palyer's current health value
				//if the current health value is positive, display the info about its current health value
				if(player.takeDamage(attackMonster)>0.0) {
					System.out.println(player.toString());
				}else {
					//if player's current health value is below or equal to 0,
					//display the info that the player has been knocked and exist
					System.out.println(player.getName()+" was knocked out.");
					break;
				}
			//use else if statement to check whether the user inputs the quit command
			}else if (command.equalsIgnoreCase("quit")) {
				//display the info and use return to terminate the method
				System.out.println();
				System.out.println("Goodbye!");
				return;
			//use else if statement to check whether the user inputs spells (commands other than "attack""quit")
			}else if((!command.equalsIgnoreCase("quit"))&& (!command.equalsIgnoreCase("attack"))) {
				int seed= numRandom.nextInt();
				String spellName= command;
				//use castSpell method to get a double represents the damage value
				double spellDamage=Character.castSpell(spellName, seed);
				//use if statement to check whether the spell works
				//and display the info for each situation
				if(spellDamage==0) {
					System.out.println();
					System.out.println(player.getName()+" tried to cast "+ spellName
							+", but they failed." );
				}else if(spellDamage<0) {
					System.out.println();
					System.out.println(player.getName()+" tried to cast "+ spellName
							+", but they don't know that spell." );
				}else {
					String spellStr=String.format("%1$.2f", spellDamage);
					System.out.println();
					System.out.println(player.getName()+" casts "+spellName+" dealing "+ spellStr+" damage!");
					//use if statement to check monster's current health value
					//if the current health value is positive, display the info about its current health value
					if(monster.takeDamage(spellDamage)>0.0) {
						System.out.println(monster.toString());
					}else {
						//if monster's current health value is below or equal to 0,
						//display the info that the monster has been knocked and exist
						System.out.println(monster.getName()+" was knocked out.");
						break;
					}
				}
				//switch to monster's turn (cannot cast a spell, only attack)
				//use getAttackDamage method and nextIn() to get a
				//double value represents the attack damage of the monster
				double attackMonster= monster.getAttackDamage(numRandom.nextInt());
				//display the info
				String attackStr=String.format("%1$.2f", attackMonster);
				System.out.println();
				System.out.println(monster.getName()+" attacks for "+attackStr+" damage!");
				//use if statement to check palyer's current health value
				//if the current health value is positive, display the info about its current health value
				if(player.takeDamage(attackMonster)>0.0) {
					System.out.println(player.toString());
				}else {
					//if player's current health value is below or equal to 0,
					//display the info that the player has been knocked and exist
					System.out.println(player.getName()+" was knocked out.");
					break;
				}
				/*for question 1:
				//display the info
				*System.out.println();
				*System.out.println("The input was not recognized, please enter"
						*+ " \"attack\" or \"quit\" as command");
						*/
			}
		}
		
		read.close();
		 
		//use two if statements to check which character wins
		//(if one character has a current health value <= 0, the other character wins)
		if(player.getCurrHealth()<=0.0) {
			//display the info
			System.out.println();
			System.out.println("Oh, no!! You lost. "+player.getName()+" is knocked down by "+monster.getName()+".");
			//use increaseWins() method to update the number of wins of the winner then display the info
			monster.increaseWins(); 
			//use writeCharacter method to rewrite the file and update the numOfWins
			FileIO.writeCharacter(monster, monsterFile);
			System.out.println(player.getName()+" has won: "+player.getNumWins()+" times");
			System.out.println(monster.getName()+" has won: "+monster.getNumWins()+" times");
		}
		if(monster.getCurrHealth()<=0.0) {
			//display the info
			System.out.println();
			System.out.println("Fantasitic!, "+player.getName()+" has knocked down "+monster.getName()+".");
			//use increaseWins() method to update the number of wins of the winner then display the info
			player.increaseWins(); 
			//use writeCharacter method to rewrite the file and update the numOfWins
			FileIO.writeCharacter(player, playerFile);
			System.out.println(player.getName()+" has won: "+player.getNumWins()+" times");
			System.out.println(monster.getName()+" has won: "+monster.getNumWins()+" times");
		}
	}
	
	public static void main(String[]args) {
		playGame("player.txt","monster.txt","spells.txt");
	}

}
