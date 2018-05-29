package be.vdab.behaviors;

import be.vdab.organisms.Buffalo;
import be.vdab.organisms.Organism;
import be.vdab.terrarium.TerrariumInterface;

public class ItEatsLikeAHyena implements EatBehavior {

	@Override
	public void eat(Organism org1, Organism org2) {
		if(!org1.equals(org2)) {
			if(org2 instanceof Buffalo) {
				org1.setLifeForce(org1.getLifeForce() + org2.getLifeForce());
				System.out.println("I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I have eaten a " + org2.getClass().getSimpleName().toLowerCase() +"!!!");
				org2.getTerrariumInterface().deleteOrganism(org2);
				org1.setDailyActionPerformed(true);
			}else {
				System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I only eat buffalo's!!!");
			}
		}else {
			System.out.println("I can't eat myself duhhh!!!");
		}
	}

}
