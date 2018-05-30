package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.ItDoesNotMakeLove;
import be.vdab.behaviors.ItEatsLikeACarnivore;
import be.vdab.behaviors.ItFights;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public class Leopard extends Carnivore{
	public Leopard (Coordinate coordinate, TerrariumInterface terrariumInterface) throws TerrariumException {
		this(coordinate, new ItEatsLikeACarnivore(), new ItFights(), new ItDoesNotMakeLove(), terrariumInterface);
	}
	
	public Leopard(Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightBehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface) throws TerrariumException {
		super(coordinate, eatBehavior, fightBehavior, loveBehavior, terrariumInterface);
		this.setLifeForce(3);
	}

	@Override
	public char draw() {
		// TODO Auto-generated method stub
		return 'L';
	}
}
