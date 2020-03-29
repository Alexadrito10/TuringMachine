package model;

public class Machine {
	
	private Tape c0;
	private Tape c1;
	private Tape c2;
	private int counter = 0;
	

	
	public Machine() {
		
	}
	public char readElement (char cabeza) {
		
		if (counter == 0) {
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
					
					if(c1.getBeforeTape()==null) {
						
							c1.setBeforeTape(temp);//BA
							temp.setNextTape(c1);
							c1=temp;
							c0= c1;
							
						
					}else {
					temp.setNextTape(c1);
					temp.setBeforeTape(c1.getBeforeTape());
					c1.getBeforeTape().setNextTape(temp);
					c1.setBeforeTape(temp);
					c1 = temp;
					}

				} else {
					if(c1.getBeforeTape()==null) {
						Tape sig = c1.getNextTape();
						c1.setNextTape(temp);//BCA
						temp.setNextTape(sig);
						temp.setBeforeTape(c1);
						sig.setBeforeTape(temp);
						c1 = temp;
						
						}
					else {
					Tape sig = c1.getNextTape();
					temp.setBeforeTape(c1);
					temp.setNextTape(c1.getNextTape());
					c1.setNextTape(temp);
					sig.setBeforeTape(temp);
					c1 = temp;
					}
				}


			}else {
				counter++;
				temp.setBeforeTape(c2);
				c2.setNextTape(temp);
				c2= temp;

				if(counter % 2 != 0) {
					c1 = c1.getNextTape();
				}

			}
		}


	}
	public void deleteElement (char cabeza) {

		if (c0 == null) {

		}
		else if(counter==1) {
			resetList();
			

		}
		else {
			if (cabeza == '0' ) {
				c0 = c0.getNextTape();
				c0.setBeforeTape(null);
				counter--;
				if(counter % 2 != 0) {
					c1= c1.getNextTape();
				}

			}else if (cabeza == '1') {
				counter--;
				if (counter % 2 == 0) {
					c1.getBeforeTape().setNextTape(c1.getNextTape());
					c1.getNextTape().setBeforeTape(c1.getBeforeTape());
					c1= c1.getBeforeTape();
				}else {
					
					if (c1.getBeforeTape()== null) {
						c1 = c1.getNextTape();
						c1.setBeforeTape(null);
						c0=c1;
					}else {
						c1.getBeforeTape().setNextTape(c1.getNextTape());
						c1.getNextTape().setBeforeTape(c1.getBeforeTape());
						c1=c1.getNextTape();
					}

				}

			}else {
				counter--;
				c2= c2.getBeforeTape();
				c2.setNextTape(null);
				
				if (counter % 2 == 0 ) {
					c1 = c1.getBeforeTape();
				}
			
				

			}
		}

	}
	
	public void resetList () {
		c0 = null;
		c1 = null;
		c2= null;
		counter = 0;
		
	}
	
	
}
