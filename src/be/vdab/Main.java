package be.vdab;

import java.util.Scanner;

import be.vdab.terrarium.Terrarium;
import be.vdab.terrarium.TerrariumException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("TERRARIUM");
		System.out.println("*********\n");
		Terrarium terrarium = new Terrarium();
		String keuze;
		
		terrarium.print();
				
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("\nPress <ENTER> for a new day or S + <ENTER> to end the program!");
			keuze = sc.nextLine();
			while(!keuze.equalsIgnoreCase("S")) {
				if(keuze.isEmpty()) {
					try {
						terrarium.nextDay();
					}catch(TerrariumException e) {
						terrarium.print();
						System.out.println(e.getMessage());
						break;
					}
					
					terrarium.print();
					System.out.println("\nPress <ENTER> for a new day or S + <ENTER> to end the program!");
				}else {
					System.out.println("Wrong choice! Press <ENTER> for a new day or S + <ENTER> to end the program!");
				}
				keuze = sc.nextLine();
			}
		}
		
		System.out.println("\nProgram was terminated!");
	
	}

}
