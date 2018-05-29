package be.vdab.behaviors;

import be.vdab.organisms.Organism;
import be.vdab.terrarium.TerrariumInterface;

public class ItDoesNotEat implements EatBehavior {
	@Override
	public void eat(Organism org1, Organism org2) {
		System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I don't eat at all!!!");
	}
}
