package be.vdab.terrarium;

import be.vdab.organisms.Coordinate;
import be.vdab.organisms.Organism;

public interface TerrariumInterface {
	public abstract Coordinate getCoordinate();
	public abstract void addOrganism(Organism org);
	public abstract void deleteOrganism(Organism org);
	public abstract void moveOrganism(Organism org);	
}
