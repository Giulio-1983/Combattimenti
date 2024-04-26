package Gioco;

public interface Personaggio {

	String getName();

	int getForza();

	int getVita();

	void attacca(Personaggio p);

	void riceviDanno(int danno);

	int getId();

	void azione(Personaggio p);
	
	void stancati(int stanchezza);
}
