package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public abstract class Carnivore extends Animal {

	public Carnivore(Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightBehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface ) throws TerrariumException {
		super(coordinate, eatBehavior, fightBehavior, loveBehavior, terrariumInterface);
		// TODO Auto-generated constructor stub
	}
	
	
}
