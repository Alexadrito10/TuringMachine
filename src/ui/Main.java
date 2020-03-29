package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import model.Machine;


public class Main {
		public static final  String INPUT = "data/in_turing.txt";
		public static final String OUTPUT = "data/myOutput.txt";
	
	public static void main (String[]args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(INPUT));
		BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));
		
		Machine mac = new Machine();
		
		long ftime= System.currentTimeMillis();
		String line = br.readLine();
		while(line != null) {
			for(int i=0; i<line.length();i++) {
				char head = line.charAt(i);
				i++;
				char option=line.charAt(i);
				//System.out.println("cabeza: "+head +" y accion: "+ option  );
				
				switch(option) {
				
				case '0':
					//System.out.println("Entrando a leer");
					bw.write(mac.readElement(head)+"\n");
					//System.out.println("Salí");
					
					break;
				case '1':
					i++;
					char key = line.charAt(i);
					//System.out.println("la letrica :"+ key);
				
					mac.addElement(head, key);
					//System.out.println("Pasé");
					
					break;
				case '2':
					mac.deleteElement(head);
					break;
				
				}
			}
			
			line = br.readLine();
			mac.resetList();
		}
		long time = System.currentTimeMillis()-ftime;
		System.out.println(time);
		br.close();
		bw.close();
		
		
		
	} 
	
	
	
	

}
