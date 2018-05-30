package be.vdab.terrarium;


import java.util.Random;

import be.vdab.organisms.Animal;
import be.vdab.organisms.Buffalo;
import be.vdab.organisms.Coordinate;
import be.vdab.organisms.EmptyOrganism;
import be.vdab.organisms.Human;
import be.vdab.organisms.Leopard;
import be.vdab.organisms.Organism;
import be.vdab.organisms.PalmTree;

public class Terrarium implements TerrariumInterface{
	
	private int rows = 6;
	private int cols = 6;
	private Organism[][] organisms = new Organism[rows][cols];
	private int organismCount = 0;
	private int dayCount = 1;
		
	public Terrarium() {
		init();
	}
	
	private void init() {
		//Fill array with empty organisms
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				Coordinate coordinate = new Coordinate(i,j);
				try {
					this.addOrganism(new EmptyOrganism(coordinate,this));
				} catch (TerrariumException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		//add palmtrees
		try {
			for(int i=1; i<=3;i++) {
				addOrganism(new PalmTree(getCoordinate(), this));
			}
		} catch (TerrariumException e) {
			System.out.println(e.getMessage());
		}
		
		//add humans
		try {
			for(int i=1; i<=2;i++) {
				addOrganism(new Human(getCoordinate(), this));
			}
		} catch (TerrariumException e) {
			System.out.println(e.getMessage());
		}
		
		//add leopards
		try {
			for(int i=1; i<=3;i++) {
				addOrganism(new Leopard(getCoordinate(), this));
			}
		} catch (TerrariumException e) {
			System.out.println(e.getMessage());
		}
		
		//add buffalos
		try {
			for(int i=1; i<=4;i++) {
				addOrganism(new Buffalo(getCoordinate(), this));
			}
		} catch (TerrariumException e) {
			System.out.println(e.getMessage());
		}
	}
			
	public void nextDay() throws TerrariumException{
		//increase day counter
		this.setDayCount(this.getDayCount() + 1);
		
		Organism organism1;
		Organism organism2;
		
		//set daily action of all organisms to false at the beginning of a new day
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols-1; j++) {
				organism1 = organisms[i][j];
				organism1.setDailyActionPerformed(false);
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols-1; j++) {
				
				organism1 = organisms[i][j];
				organism2 = organisms[i][j+1];
				
				count++;
				System.out.println("ORGANISM " + count + " WANTS TO HAVE SOME ACTION:");
				
				if (organism1.isDailyActionPerformed() ) {
					System.out.println("Sorry, I'm a " + organism1.getClass().getSimpleName().toLowerCase() + " and I already moved today!");
				}else {
					if (! organism1.isDailyActionPerformed() ) {
						organism1.tryToEat(organism2);
					}
					if (! organism1.isDailyActionPerformed() ) {
						organism1.tryToFight(organism2);
					}
					if (! organism1.isDailyActionPerformed() ) {
						organism1.tryToMakeLove(organism2);
					}
					if (! organism1.isDailyActionPerformed() ) {
						organism1.tryToMove();
					}
				}
				System.out.println();
			}
		}
		
		//Add palm trees
		try {
			for(int i=1; i<=1;i++) {
				addOrganism(new PalmTree(getCoordinate(), this));
			}
		} catch (TerrariumException e) {
			System.out.println(e.getMessage());
		}
		//Check if terrarium is full, then throw exception
		if(this.getOrganismCount() >= this.getRows() * this.getCols()) {
			throw new TerrariumException("\nTerrarium is full, program is being terminated!");
		}
	}
	
	public Coordinate getCoordinate() {
		//Return a coordinate of free location within terrarium. If full coordinate = -1,-1 
		Coordinate coordinate;
		if(!isLocationFree()) { 
			coordinate = new Coordinate(-1,-1);
		}else {
			Random rand = new Random();
			coordinate = new Coordinate(rand.nextInt(rows),rand.nextInt(cols));
			boolean isFound = false;
			while(!isFound) {
				if(organisms[coordinate.getRow()][coordinate.getCol()] instanceof EmptyOrganism ) {
					isFound = true;
				}else {
					coordinate = new Coordinate(rand.nextInt(rows),rand.nextInt(cols));
				}
			}
		}
		return coordinate;
	}

	@Override
	public void addOrganism(Organism org){
		if(org != null) {
			organisms[org.getCoordinate().getRow()][org.getCoordinate().getCol()] = org;
			//increase organism count
			if(! (org instanceof EmptyOrganism)) {
				this.setOrganismCount(this.getOrganismCount() + 1);
				System.out.println(org.getClass().getSimpleName() + " was added to the terrarium!");
			}
		}
	}

	@Override
	public void deleteOrganism(Organism org) {
		Coordinate c = org.getCoordinate();
		try {
			organisms[c.getRow()][c.getCol()] = new EmptyOrganism(c, this);
			//decrease organism count
			this.setOrganismCount(this.getOrganismCount() - 1);
			System.out.println(org.getClass().getSimpleName() + " was removed from terrarium!!!");
		} catch (TerrariumException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void moveOrganism(Organism organism) {
		Coordinate huidigePos = organism.getCoordinate();
		//controle of organisme zich niet in de uiterst rechtse kolom bevindt
		if(huidigePos.getCol() < this.getCols() - 1) {  
			Organism organismEast = organisms[huidigePos.getRow()][huidigePos.getCol() + 1];
			if(organism instanceof Animal && organismEast instanceof EmptyOrganism) {
				Coordinate nieuwePos;
				boolean moved = false;
				while (!moved) {
					// random getal "richting" van 1-4
					Random rand = new Random();
					int richting = rand.nextInt(4)+1;
					// switch volgens "richting"
					switch (richting) {
						case 1:
							if (organism.getCoordinate().getRow() == 0) { break; }
							Organism north = organisms[organism.getCoordinate().getRow()-1][organism.getCoordinate().getCol()];
							if (north instanceof EmptyOrganism) {
								nieuwePos = north.getCoordinate();
								swapOrganisms(huidigePos, nieuwePos);
								moved = true;
								System.out.println("I'm a " + organism.getClass().getSimpleName().toLowerCase() + " and I moved one step to the north!");
							} else {
								moved = false;
							}
							break;
						case 2:
							if (organism.getCoordinate().getCol() == this.getCols() - 1) { break; }
							Organism east = organisms[organism.getCoordinate().getRow()][organism.getCoordinate().getCol()+1];
							nieuwePos = east.getCoordinate();
							swapOrganisms(huidigePos, nieuwePos);
							moved = true;
							System.out.println("I'm a " + organism.getClass().getSimpleName().toLowerCase() + " and I moved one step to the east!");
							break;
						case 3:
							if (organism.getCoordinate().getRow() == this.getRows() - 1) { break; }
							Organism south = organisms[organism.getCoordinate().getRow()+1][organism.getCoordinate().getCol()];
							if (south instanceof EmptyOrganism) {
								nieuwePos = south.getCoordinate();
								swapOrganisms(huidigePos, nieuwePos);
								moved = true;
								System.out.println("I'm a " + organism.getClass().getSimpleName().toLowerCase() + " and I moved one step to the south!");
							} else {
								moved = false;
							}
							break;
						case 4:
							if (organism.getCoordinate().getCol() == 0) { break; }
							Organism west = organisms[organism.getCoordinate().getRow()][organism.getCoordinate().getCol()-1];
							if (west instanceof EmptyOrganism) {
								nieuwePos = west.getCoordinate();
								swapOrganisms(huidigePos, nieuwePos);
								moved = true;
								System.out.println("I'm a " + organism.getClass().getSimpleName().toLowerCase() + " and I moved one step to the west!");
							} else {
								moved = false;
							}
							break;
					}
				}
				//organism has moved
				organism.setDailyActionPerformed(true);
			}else if(organism instanceof Animal){
				System.out.println("Sorry, I'm a " + organism.getClass().getSimpleName().toLowerCase() + " and I can't move because the position to the right is not empty!");
			}else {
				System.out.println("Sorry, I'm a " + organism.getClass().getSimpleName().toLowerCase() + " and I can't move at all!");
			}
		}else {
			System.out.println("Sorry, I can't move because I'm in the far right of the terrarium!");
		}
	}
	
	public void print() {
		System.out.println("\nDay " + dayCount + ":");
		System.out.println("*********\n");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
			//System.out.print(organisms[i][j].draw()+ "   ");
				System.out.print(organisms[i][j].draw()+ "(" + organisms[i][j].getLifeForce()+ ")" + "   ");
				
			}
			System.out.println();
		}
	}
	
	public Organism[][] getOrganisms() {
		return organisms;
	}

	public void setOrganisms(Organism[][] organisms) {
		this.organisms = organisms;
	}

	public int getOrganismCount() {
		return organismCount;
	}

	public void setOrganismCount(int organismCount) {
		this.organismCount = organismCount;
	}

	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public int getRows() {
			return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
	
	private void swapOrganisms(Coordinate c1, Coordinate c2) {
		//Swap objects
		Organism temp = organisms[c1.getRow()][c1.getCol()];
		organisms[c1.getRow()][c1.getCol()] = organisms[c2.getRow()][c2.getCol()];
		organisms[c2.getRow()][c2.getCol()] = temp;
		//change coordinates
		try {
			organisms[c1.getRow()][c1.getCol()].setCoordinate(c1);
		} catch (TerrariumException e) {
			e.printStackTrace();
		}
		try {
			organisms[c2.getRow()][c2.getCol()].setCoordinate(c2);
		} catch (TerrariumException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isLocationFree() {
		//Check if there is a free location within the organisms array
		int teller = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(organisms[i][j] instanceof EmptyOrganism) {
					teller++;
				}
			}
		}
		return (teller == 0) ? false : true;
	}

}
