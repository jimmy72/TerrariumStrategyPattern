package be.vdab.behaviors;

import be.vdab.organisms.Organism;

public class ItDoesNotMakeLove implements LoveBehavior {

	@Override
	public void makeLove(Organism org1, Organism org2) {
		System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and do not make love at all!!!");
		
	}

}
