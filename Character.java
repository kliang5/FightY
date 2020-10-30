//Student Name: Nicole Liang
//Student Number: 260828103
import java.util.Random;
import java.util.ArrayList;

public class Character {
	//attributes
	private String name;
	private double attackValue;
	private double maxHealth;
	private double currHealth;
	private int numWins;
	private static ArrayList<Spell> spells;
	
	//constructor that initializes all the attributes
	public Character(String name,double attackValue, double maxHealth, int numWins) {
		this.name=name;
		this.attackValue=attackValue;
		this.maxHealth=maxHealth;
		//the attribute currentHealth is same as the maxHealth at the beginning
		this.currHealth=maxHealth;
		this.numWins=numWins;
	}
	
	//a method that takes no input and returns
	//a String represents the name of the character
	public String getName() {
		return this.name;
	}
	
	//a method that takes no input and returns
	//a double represents the attack value of the character
	public double getAttackValue() {
		return this.attackValue;
	}
	
	//a method that takes no input and returns
    //a double represents the max health value of the character
	public double getMaxHealth() {
		return this.maxHealth;
	}
	
	//a method that takes no input and returns
    //a double represents the current health value of the character
	public double getCurrHealth() {
		return this.currHealth;
	}
	
	//a method that takes no input and returns
    //an int represents the number of wins of the character
	public int getNumWins() {
		return this.numWins;
	}
	
	//a  method that takes no input and returns
	//a String that consists the character's name and current Health
	public String toString() {
		String currentHealthValue=String.format("%1$.2f", this.currHealth);
		String s=this.name+" current health is "+ currentHealthValue+".";
		return s;
	}
	
	//a method that takes an int as input and 
	//returns a double represents the damage value of one character 
	//after attacking
    public double getAttackDamage(int seed) {
    	//create a Random object with the input int as seed 
    	Random randomGen= new Random(seed);
    	//the damage value should be the attack value multiple by a random from 0.7 to 1.0
    	double attackDamage= this.attackValue* (randomGen.nextDouble()*0.3+0.7);
    	return attackDamage;
    }
    
    //a method that takes a double represents the damage one character had as input
    //and returns a double represents the current Health value 
    //after subtracting the damage value from the before current Health
    public double takeDamage(double damage) {
    	this.currHealth=this.currHealth-damage;
    	return this.currHealth;
    }
    
    //a method that takes no input 
    //and increase the number of wins of the winner character
    public void increaseWins() {
    	this.numWins++;
    }
    
    //a method that takes an ArrayList of Spell as input and 
    //returns an ArrayList of Spell represents the Spells stored inside the attribute spells
    public static void setSpells(ArrayList<Spell> inputSpells){
    	Character.spells=new ArrayList<Spell>();
    	//use for loops and get method to copy each Spell inside the input ArrayList of Spells
    	for(int i=0;i<inputSpells.size();i++) {
    		Spell s=inputSpells.get(i);
    		//use add method of ArrayList to add each Spell into the new ArrayList inside attribute
    		Character.spells.add(s);
    	}
    }
    
    //a method that takes no input and display the info of each Spell
    public static void displaySpells() {
    	//use for loops and get method to reach each Spell inside the ArrayList
    	for(int i=0;i<Character.spells.size();i++) {
    		//use toString method to display the info
    		System.out.println(Character.spells.get(i).toString());
    	}
    }
    
    //a method that takes a String represents the name of one spell and a int as inputs
    //and return of the damage value of that specific spell if it can be found
    public static double castSpell(String spellName, int seed) {
    	//use for loops and get method to reach and compare each Spell inside the ArrayList
    	for(int i=0;i<Character.spells.size();i++) {
    		Spell s=Character.spells.get(i);
    		//use if statement and equalsIgnoreCase method to check whether the input spell matches
    		if(s.getName().equalsIgnoreCase(spellName)) {
    			//use getMagicDamage to return the damage value of that specific spell
    			return s.getMagicDamage(seed);
    		}
    	}
    	//if the input spell is not found, return -1
    	return -1;
    	
    }
    
    public static void main(String[]args) {
    	 
    }

}
