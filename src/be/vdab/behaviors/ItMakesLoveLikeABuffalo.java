package be.vdab.behaviors;

import be.vdab.organisms.Buffalo;
import be.vdab.organisms.Coordinate;
import be.vdab.organisms.Organism;
import be.vdab.terrarium.TerrariumException;

public class ItMakesLoveLikeABuffalo implements LoveBehavior{

	@Override
	public void makeLove(Organism org1, Organism org2) {
		
		if(!org1.equals(org2)) {
			if(org2 instanceof Buffalo) {
				//zoek een vrije positie voor een pasgeboren buffalo
				Coordinate c = org1.getTerrariumInterface().getCoordinate();
				try {
					System.out.println("I'm a buffalo and I just made love with a " + org2.getClass().getSimpleName().toLowerCase() + "!!!");
					org1.getTerrariumInterface().addOrganism(new Buffalo(c, org1.getTerrariumInterface()));
					org1.setDailyActionPerformed(true);
				} catch (TerrariumException e) {
					System.out.println("Unfortunately, there was no place in the terrarium anymore for the newly born buffalo!!!");
				}
			}else {
				System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I can't make love with a " + org2.getClass().getSimpleName().toLowerCase() +"!!!");
			}
		}else {
			System.out.println("I can't make love with myself!");
		}
		
	}

}
