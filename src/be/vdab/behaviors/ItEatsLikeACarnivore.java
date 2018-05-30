package be.vdab.behaviors;

import be.vdab.organisms.Herbivore;
import be.vdab.organisms.Organism;

public class ItEatsLikeACarnivore implements EatBehavior {

	@Override
	public void eat(Organism org1, Organism org2) {
		if(!org1.equals(org2)) {
			if(org2 instanceof Herbivore) {
				org1.setLifeForce(org1.getLifeForce() + org2.getLifeForce());
				System.out.println("I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I have eaten a " + org2.getClass().getSimpleName().toLowerCase() +"!");
				org2.getTerrariumInterface().deleteOrganism(org2);
				org1.setDailyActionPerformed(true);
			}else {
				System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + ", I can't eat a " + org2.getClass().getSimpleName().toLowerCase() + ", I only eat herbivores!");
			}
		}else {
			System.out.println("I'm not a canibal, I can't eat myself duhhh!!!");
		}
	}

}
