//Student Name: Nicole Liang
//Student Number: 260828103
import java.io.*;
import java.util.ArrayList;

public class FileIO {
	
	//a method that takes a String represents a file name as input
	//and returns a character
	public static Character readCharacter(String filename) {
		//use try and catch blocks to catch two exceptions
		try {
			//use a FileReader and a BufferedReader to open and read the file
			FileReader fr= new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			String name="";
			double attackValue=0.0;
			double maxHealth=0.0;
			int numWins=0;
			//use for loops to reach each line in the file
			for(int i=0;i<4;i++) {
				String currentLine=br.readLine();
				if(i==0) {
					 name=currentLine;
				}
				if(i==1) {
				     attackValue= Double.parseDouble(currentLine);
				}
				if(i==2) {
					 maxHealth=Double.parseDouble(currentLine);
				}
				if(i==3) {
					numWins=Integer.parseInt(currentLine);
				}
			}
			br.close();
			fr.close();
			//use constructor and information above to create a Character
			Character newCharacter=new Character(name, attackValue,maxHealth,numWins);
			return newCharacter;
		}
		//use catch block to catch FileNotFoundException
		//print the error message and return null
		catch(FileNotFoundException e){
			System.out.println("Error: The file "+filename+" is not found.");
			return null;
		}
		//use catch block to catch IOException
		//print the error message and return null
		catch(IOException e) {
			System.out.println("Error: Something went wrong.");
			return null;
		} 
	}
	
	//a method that takes a String represents a file name of spells as input
	//and returns an ArrayList of Spell 
	public static ArrayList<Spell> readSpells(String filename){
		try{
			//use a FileReader and a BufferedReader to open and read the file
			FileReader fr=new FileReader(filename);
		    BufferedReader br= new BufferedReader(fr);
		    ArrayList<Spell>spells= new ArrayList<Spell>();
		    //use for loops to add each Spell into the ArrayList of Spell
		    String spell=br.readLine();
		    while(spell!=null) {
		    	//use split method to splits one line into an Array of String 
		    	//contains four elements of one Spell
		    	String[] arrayStr=spell.split("\t");
		    	//use constructor to create a new Spell 
		    	//and use add method to add that Spell into the ArrayList
		    	Spell newSpell =new Spell(arrayStr[0],Double.parseDouble(arrayStr[1]),
		    			Double.parseDouble(arrayStr[2]),Double.parseDouble(arrayStr[3]));
		    	spells.add(newSpell);
		    	spell=br.readLine();
		    }
		    br.close();
	    	fr.close();
		    return spells;
		}
		//use catch block to catch FileNotFoundException
		//print the error message and return null
		catch(FileNotFoundException e){
			System.out.println("Error: The file "+filename+" is not found.");
			return null;
		}
		//use catch block to catch IOException
		//print the error message and return null
		catch(IOException e) {
			System.out.println("Error: Something went wrong.");
			return null;
		} 
	}
	
	//a method that takes a Character and a String represents the file name of that character
	//and rewrites that file with the updated info of that character
	public static void writeCharacter(Character c,String fileName) {
		//use try and catch blocks to catch the exceptions
		try{
			//use FileWriter and BufferedWriter to open and write the file
			FileWriter fw= new FileWriter(fileName);
			BufferedWriter bw= new BufferedWriter(fw);
			//use for loops and if statements to write the correct info on each line
			for(int i=0;i<4;i++) {
				if(i==0) {
					bw.write(c.getName()+"\n");
				}
				if(i==1) {
					bw.write(""+c.getAttackValue()+"\n");
				}
				if(i==2) {
					bw.write(""+c.getMaxHealth()+"\n");
				}
				if(i==3) {
					bw.write(""+c.getNumWins());
				}
			}
			bw.close();
			fw.close();
			System.out.println("Successfully wrote to file: "+fileName);
			}
		//use try and catch blocks to catch the exceptions
		catch(IOException e){
				System.out.println("Error: Something went wrong.");
				}
		}
	
	
	public static void main(String[]args) {
		 
	}
}
