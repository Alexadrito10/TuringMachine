package model;

public class Machine {
	
	private Tape c0;
	private Tape c1;
	private Tape c2;
	private int counter = 0;
	

	
	public Machine() {
		
	}
	public char readElement (char cabeza) {
		
		if (c0 == null) {
			return '#';
		}
		else {
			if (cabeza == '0' ) {
				return c0.getKeyChar();
			}else if (cabeza == '1') {
				return c1.getKeyChar();
			}else {
				return c2.getKeyChar();
			}
		}
		
		
	}
	
	public void addElement (char cabeza,char letra) {
		
		if (c0 == null) {
			c0 = new Tape(letra);
			c1=c0;
			c2=c1;
			counter++;
		}
		else {
			Tape temp = new Tape(letra);
			if (cabeza == '0' ) {
				temp.setNextTape(c0);
				c0.setBeforeTape(temp);
				c0 = temp;
				counter++;
				
				if(counter % 2 == 0) {
					
					c1 = c1.getBeforeTape();
					
					
				}
				
			
			}else if (cabeza == '1') {
				counter++;
				
				if(counter % 2 == 0) {
					temp.setNextTape(c1);
					temp.setBeforeTape(c1.getBeforeTape());
					c1.getBeforeTape().setNextTape(temp);
					c1.setBeforeTape(temp);
					c1 = temp;
					
				} else {
					temp.setBeforeTape(c1);
					temp.setNextTape(c1.getNextTape());
					c1.getBeforeTape().setNextTape(temp);
					c1.setBeforeTape(temp);
					c1 = temp;
				}
				
				
			}else {
				counter++;
				temp.setBeforeTape(c2);
				c2.setNextTape(temp);
				
				if(counter % 2 == 0) {
					c1 = c1.getBeforeTape();
				}
				
				
				
					
			}
		}
		
		
	}
	
	
}
