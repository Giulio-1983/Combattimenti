package Gioco;

import java.util.Random;
import java.util.Scanner;

public class Vampiro implements Mostro {
	private int playerId;
	protected String nome;
	protected int vita;
	protected int forza;

	public Vampiro(int playerId, String nome) {
		this.nome = nome;
		this.playerId = playerId;
		forza = 8;
		vita = 100;
	}
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	@Override
	public int getId() {
		return playerId;
	}
	@Override
	public void azione(Personaggio p) {
while(true) {
		System.out.println("Cosa farà il vampiro " + nome + "?\nA: attacca\nB: Ipnotizza");
		String action = s.nextLine().toUpperCase();
		switch (action) {
		case "A": {
			attacca(p);
			return;
		}
		case "B": {
			ipnotizza(p);
			return;
		}
		default: {
			System.out.println("Scegli un'azione da fare\n\n");
			break;
		}
		}
	}
}


	@Override
	public String getName() {
		return nome;
	}

	@Override
	public void azzanna(Personaggio p) {
		if (vita > 0) {
			int risucchio = r.nextInt(3);
			if (risucchio < 1) {
				forza -= 1;
				System.out.println("Il Vampiro attacca ma non riesce a mordere!");
				System.out.println("Il Vampiro perde energie, la sua forza scende a: " + forza);
			} else {
				forza += 1;
				System.out.println("Il Vampiro attacca e riesce a mordere!");
				System.out.println("Il Vampiro viene rinvigorito dal risucchio, la sua forza sale a: " + forza);
			}
		} else {
			System.out.println("Il Vampiro non può attaccare perché è morto!");
		}
	}

	public int getForza() {
		return forza;

	}

	@Override
	public int getVita() {
		return vita;
	}

	@Override
	public void attacca(Personaggio p) {
		azzanna(p);
		p.riceviDanno(forza - 1);
	}

	@Override
	public void riceviDanno(int danno) {
		vita -= danno;
		System.out.println("il Vampiro riceve danno, la sua vita scende a: " + vita);
		if (vita <= 0) {
			System.out.println("Il Vampiro "+getName()+" muore");
			vita = 0;
		}

	}
	public void ipnotizza(Personaggio p) {
		p.stancati(3);
		System.out.println("Il vampiro ipnotizza "+ p.getName() + " la sua forza scende di 3 ed arriva a: " + p.getForza());
	}
	@Override
	public void stancati(int stanchezza) {
		forza -= stanchezza;
		if(forza < 0) forza =0;
	}
}