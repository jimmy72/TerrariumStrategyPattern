package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.ItDoesNotFight;
import be.vdab.behaviors.ItEatsLikeAHerbivore;
import be.vdab.behaviors.ItMakesLoveLikeABuffalo;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public class Buffalo extends Herbivore {
	
	public Buffalo (Coordinate coordinate, TerrariumInterface terrariumInterface) throws TerrariumException {
		this(coordinate, new ItEatsLikeAHerbivore(), new ItDoesNotFight(), new ItMakesLoveLikeABuffalo(), terrariumInterface);
	}
	
	public Buffalo(Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightBehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface) throws TerrariumException {
		super(coordinate, eatBehavior, fightBehavior, loveBehavior, terrariumInterface);
		this.setLifeForce(0);
	}

	@Override
	public char draw() {
		// TODO Auto-generated method stub
		return 'B';
	}
}
