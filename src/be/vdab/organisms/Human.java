package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.ItDoesNotEat;
import be.vdab.behaviors.ItDoesNotMakeLove;
import be.vdab.behaviors.ItFightsLikeAHuman;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public class Human extends Omnivore {
	
	public Human (Coordinate coordinate, TerrariumInterface terrariumInterface) throws TerrariumException {
		this(coordinate, new ItDoesNotEat(), new ItFightsLikeAHuman(), new ItDoesNotMakeLove(), terrariumInterface);
	}
	
	public Human (Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightbehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface) throws TerrariumException {
		super(coordinate, eatBehavior, fightbehavior, loveBehavior, terrariumInterface);
		this.setLifeForce(4);
	}

	@Override
	public char draw() {
		// TODO Auto-generated method stub
		return 'M';
	}
}
