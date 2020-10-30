//Student Name: Nicole Liang
//Student Number: 260828103
import java.util.Random;
public class Spell {
	//attributes 
	private String name;
	private double miniDamage;
	private double maxDamage;
	private double chanceSuccess;
	
	//constructor that initializes all the attributes
	public Spell(String name,double miniDamage,double maxDamage,double chanceSuccess) {
		//throw an exception if the input minimum damage is not valid
		if(miniDamage<0.0||miniDamage>maxDamage) {
			throw new IllegalArgumentException("The minimun damage should be larger than 0 "
					+ "and smaller than the maximum damage.");
		}
		//throw an exception if the input chance of success is not valid
		if(chanceSuccess<0.0||chanceSuccess>1.0) {
			throw new IllegalArgumentException("The chance of success should be larger than 0 "
					+ "and smaller than 1.");
		}
		this.name=name;
		this.miniDamage=miniDamage;
		this.maxDamage=maxDamage;
		this.chanceSuccess=chanceSuccess;
	}
	// a method that takes no input and returns the name of the Spell
	public String getName() {
		return this.name;
	}
	
	//a method that takes an int represents the seed used in Random object as input 
	//and return a double represents the value of damage the spell has
	public double getMagicDamage(int seed) {
		//use the input int as seed and create a Random object
		Random randomGen=new Random(seed);
		double randomNum=randomGen.nextDouble();
		//use if statement to check whether the spell fails or not
		//(the random opportunity generates should be smaller than the chance of success)
		if(randomNum>this.chanceSuccess) {
			//returns 0 when it fails
			return 0;
		}else {
			//when it doesn't fail, a random double between miniDamagen and maxDamage is returned
			double damage= randomGen.nextDouble()*(this.maxDamage-this.miniDamage)+this.miniDamage;
			return damage;
		}
	}
	
	//a method that takes no input and returns a String that contains
	//the name, minimum damage,maximum damage and the chance of success in percentage of one spell
	public String toString() {
		String spell= "Name: "+this.name+" Damage: "+this.miniDamage+"-"+this.maxDamage
				+" Chance: "+ (this.chanceSuccess*100) +"%";
		return spell;
	}

	public static void main(String[]args) {
		
	}
}
