package model;

public class Tape {
	
	private Tape nextTape;
	private Tape beforeTape;
	private char keyChar;
	
	public Tape (char k){
		keyChar = k ;
		
	}

	public Tape getNextTape() {
		return nextTape;
	}

	public Tape getBeforeTape() {
		return beforeTape;
	}

	public char getKeyChar() {
		return keyChar;
	}

	public void setNextTape(Tape nextTape) {
		this.nextTape = nextTape;
	}
	
	public void setBeforeTape(Tape beforeTape) {
		this.beforeTape = beforeTape;
	}
	
	
	

}
