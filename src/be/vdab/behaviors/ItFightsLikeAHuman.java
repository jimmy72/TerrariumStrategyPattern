package be.vdab.behaviors;

import be.vdab.organisms.Hyena;
import be.vdab.organisms.Organism;

public class ItFightsLikeAHuman implements FightBehavior{

	@Override
	public void fight(Organism org1, Organism org2) {
		if(!org1.equals(org2)) {
			
			if(org2 instanceof Hyena) {
				if(org1.getLifeForce() > org2.getLifeForce()) {
					org1.setLifeForce(org1.getLifeForce() + org2.getLifeForce());
				}else if(org2.getLifeForce() > org1.getLifeForce()){
					org2.setLifeForce(org2.getLifeForce() + org1.getLifeForce());
				}
				System.out.println("I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I just fought a " + org2.getClass().getSimpleName().toLowerCase() +"!!!");
				org1.setDailyActionPerformed(true);
			}else {
				System.out.println("Sorry, I'm a " + org1.getClass().getSimpleName().toLowerCase() + " and I only fight Hyena's!!!");
			}
		}else {
			System.out.println("I can't fight myself duhhh!!!");
		}
		
	}
	
}
