package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.ItDoesNotEat;
import be.vdab.behaviors.ItDoesNotFight;
import be.vdab.behaviors.ItDoesNotMakeLove;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public class EmptyOrganism extends Organism {
	public EmptyOrganism(Coordinate coordinate, TerrariumInterface terrariumInterface) throws TerrariumException {
		this(coordinate, new ItDoesNotEat(), new ItDoesNotFight(), new ItDoesNotMakeLove(), terrariumInterface);
		
	}
	
	public EmptyOrganism(Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightBehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface) throws TerrariumException {
		super(coordinate, eatBehavior, fightBehavior, loveBehavior, terrariumInterface);
	}
	
	@Override
	public char draw() {
		return '.';
	}
}
