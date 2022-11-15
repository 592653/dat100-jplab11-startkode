package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg [] innleggTabell;
	private int nesteLedig;

	public Blogg () {
		
		innleggTabell = new Innlegg [20];
		nesteLedig = 0;
	}

	public Blogg (int lengde) {
		
		innleggTabell = new Innlegg [lengde];
		nesteLedig = 0;
	}

	public int getAntall () {

		int antall = 0;
		
		for (int i = 0; i < innleggTabell.length; i++) {
			
			if (innleggTabell[i] != null) {
				
				antall++;
			}
		}
		
		return antall;
	}
	
	public Innlegg[] getSamling () {
		
		return innleggTabell;
	}
	
	public int finnInnlegg (Innlegg innlegg) {
		
		for (int i = 0; i < innleggTabell.length; i++) {
			
			Innlegg search = innleggTabell[i];
			
			if (innlegg.erLik (search)) {
				
				return i;
			}
		}
		
		return - 1;
	}

	public boolean finnes (Innlegg innlegg) {

		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass () {
		
		return nesteLedig < innleggTabell.length;
		
		// or: return getAntall() != innleggTabell.length;
	}
	
	public boolean leggTil (Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {
				
			innleggTabell [nesteLedig] = innlegg;
			
			do {
				nesteLedig++;
				
			} while (ledigPlass() && innleggTabell [nesteLedig] != null);
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	@Override
	public String toString () {

		String str = getAntall() + "\n";

		for (int i = 0; i < innleggTabell.length; i++) {
		
			if (innleggTabell[i] != null) {
				
				str += innleggTabell[i].toString();
			}
		}
		
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid () {

		Innlegg [] ny = new Innlegg [innleggTabell.length * 2];
		
		for (int i = 0; i < innleggTabell.length; i++) {
			
			ny [i] = innleggTabell[i];
		}
		
		innleggTabell = ny;
	}
	
	public boolean leggTilUtvid (Innlegg innlegg) {

		if (!finnes(innlegg)) {
			
			if (!ledigPlass()) {
				
				utvid();
			}
			
			return leggTil(innlegg);
		}
		
		return false;
	}
	
	public boolean slett (Innlegg innlegg) {
		
		int i = finnInnlegg(innlegg);
		
		if (i == -1) {
			
			return false;
		} 
		
		innleggTabell[i] = null;
		
		if (nesteLedig > i) {
			
			nesteLedig = i;
		}
		
		return true;
	}
	
	public int[] search (String keyword) {
	
		Innlegg [] result = new Innlegg [innleggTabell.length];
		int count = 0;
		
		for (int i = 0; i < innleggTabell.length; i++) {
			
			Innlegg hasKeyword = innleggTabell[i];
			
			if (hasKeyword.toString().contains(keyword)) {
				
				result [count] = hasKeyword;
				count++;
			}
		}
		
		int [] ids = new int [count];
		
		for (int i = 0; i < count; i++) {
			
			ids [i] = result [i].getId();
		}
		
		return ids;
	}
}