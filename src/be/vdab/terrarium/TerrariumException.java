package be.vdab.terrarium;

public class TerrariumException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TerrariumException(){
        super();
    }
    public TerrariumException(String omschrijving){
        super(omschrijving);
    }
}
