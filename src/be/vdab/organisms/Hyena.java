package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.ItDoesNotMakeLove;
import be.vdab.behaviors.ItEatsLikeAHyena;
import be.vdab.behaviors.ItFightsLikeAHyena;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public class Hyena extends Carnivore{
	public Hyena (Coordinate coordinate, TerrariumInterface terrariumInterface) throws TerrariumException {
		this(coordinate, new ItEatsLikeAHyena(), new ItFightsLikeAHyena(), new ItDoesNotMakeLove(), terrariumInterface);
	}
	
	public Hyena(Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightBehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface) throws TerrariumException {
		super(coordinate, eatBehavior, fightBehavior, loveBehavior, terrariumInterface);
		this.setLifeForce(3);
	}

	@Override
	public char draw() {
		// TODO Auto-generated method stub
		return 'H';
	}
}
