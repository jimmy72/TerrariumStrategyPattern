package be.vdab.organisms;

import be.vdab.behaviors.EatBehavior;
import be.vdab.behaviors.FightBehavior;
import be.vdab.behaviors.LoveBehavior;
import be.vdab.terrarium.TerrariumException;
import be.vdab.terrarium.TerrariumInterface;

public abstract class Organism {
	
	private int lifeForce = 0;
	private Coordinate coordinate;
	private boolean dailyActionPerformed = false;
	private EatBehavior eatBehavior;
	private FightBehavior fightBehavior;
	private LoveBehavior loveBehavior;
	private TerrariumInterface terrariumInterface;
	
		
	public Organism(Coordinate coordinate, EatBehavior eatBehavior, FightBehavior fightBehavior, LoveBehavior loveBehavior, TerrariumInterface terrariumInterface) throws TerrariumException {
		this.setCoordinate(coordinate);
		this.setEatBehavior(eatBehavior);
		this.setFightBehavior(fightBehavior);
		this.setLoveBehavior(loveBehavior);
		this.setTerrariumInterface(terrariumInterface);
	}
	
	public boolean isDailyActionPerformed() {
		return dailyActionPerformed;
	}

	public void setDailyActionPerformed(boolean dailyActionPerformed) {
		this.dailyActionPerformed = dailyActionPerformed;
	}
	
	public TerrariumInterface getTerrariumInterface() {
		return terrariumInterface;
	}

	public void setTerrariumInterface(TerrariumInterface terrariumInterface) {
		this.terrariumInterface = terrariumInterface;
	}

	public FightBehavior getFightBehavior() {
		return fightBehavior;
	}

	public void setFightBehavior(FightBehavior fightBehavior) {
		this.fightBehavior = fightBehavior;
	}

	public EatBehavior getEatBehavior() {
		return eatBehavior;
	}

	public void setEatBehavior(EatBehavior eatBehavior) {
		this.eatBehavior = eatBehavior;
	}
	
	public LoveBehavior getLoveBehavior() {
		return loveBehavior;
	}

	public void setLoveBehavior(LoveBehavior loveBehavior) {
		this.loveBehavior = loveBehavior;
	}
	
	public int getLifeForce() {
		return lifeForce;
	}
	
	public void setLifeForce(int lifeForce) {
		this.lifeForce = lifeForce;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) throws TerrariumException {
		if(coordinate != null && coordinate.getRow() != -1) {
			this.coordinate = coordinate;
		}else {
			throw new TerrariumException("Terrarium is volgelopen, niet mogelijk om nieuw organisme toe te voegen!!!");
		}
		
	}

	public void tryToEat(Organism myLunch) {
		this.eatBehavior.eat(this, myLunch);
	}
	
	public void tryToFight(Organism opponent) {
		this.fightBehavior.fight(this, opponent);
	}
	
	public void tryToMakeLove(Organism lover) {
		this.loveBehavior.makeLove(this, lover);
	}
	
	public abstract char draw();
}
