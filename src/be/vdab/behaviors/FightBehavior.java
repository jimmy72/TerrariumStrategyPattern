package be.vdab.behaviors;

import be.vdab.organisms.Animal;
import be.vdab.organisms.Organism;
import be.vdab.terrarium.TerrariumInterface;

public interface FightBehavior {
	public void fight(Organism org1, Organism org2);
}
