package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {

		super (id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {

		super (id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		
		return url;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	@Override
	public String toString() {

		setTekst ("et bilde");
		
		String tekst = "BILDE\n" + id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n" + this.tekst + "\n" + url + "\n";
				
		return tekst;
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
