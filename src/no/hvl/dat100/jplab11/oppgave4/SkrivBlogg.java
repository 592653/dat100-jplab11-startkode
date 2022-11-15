package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv (Blogg samling, String mappe, String filnavn) {

		try {
			
			File blogg = new File (filnavn + ".txt");
			PrintWriter skriver = new PrintWriter (blogg);
	
			for (int i = 0; i < 15; i++) {
				
				skriver.println (samling.toString());
			}
			
			skriver.close();
			
			return true;
		
		} catch (FileNotFoundException e) {
			
			System.out.println ("Filen ble ikke funnet.");
			return false;
			
		} 
		// alternativ catch som tar for seg alle mulige Exceptions:
		
		catch (Exception e) {
			
			System.out.println ("Det har skjedd en feil.");
			return false;
		} 
	}
}
