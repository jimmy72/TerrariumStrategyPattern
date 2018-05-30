package be.vdab.behaviors;

import be.vdab.organisms.Organism;

public class ItDoesNotFight implements FightBehavior{
	@Override
	public void fight(Organism org1, Organism org2) {
		System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I can't fight at all!");
	}
}
