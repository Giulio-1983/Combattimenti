package Gioco;

import java.util.Scanner;

public class Eroe implements Umano {
	private int playerId;
	private String nome;
	private int vita;
	private int forza;
	Scanner s = new Scanner(System.in);
	public Eroe(int playerId, String nome) {
		this.playerId = playerId;
		this.nome = nome;
		vita = 40;
		forza = 10;
	}

	@Override
	public void azione(Personaggio p) {
while(true) {
		System.out.println("Cosa farà l'eroe " + nome + "?\nA: attacca\nB: Si riposa");
		String action = s.nextLine().toUpperCase();
		switch (action) {
		case "A": {
			attacca(p);
			return;
		}
		case "B": {
			riposa();
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
	public int getId() {
		return playerId;
	}

	@Override
	public void combatti() {
		if (vita > 0) {
			stancati(1);
			System.out.println("L'eroe attacca!");
			System.out.println("L'eroe si stanca, la sua forza scende a: " + forza);
		} else {
			System.out.println("L'eroe non può attaccare perché è morto!");
		}
	}

	public int getForza() {
		return forza;
	}

	public int getVita() {
		return vita;
	}

	@Override
	public void attacca(Personaggio p) {
		combatti();
		p.riceviDanno(forza + 1);
	}

	@Override
	public void riposa() {
		System.out.println("L'eroe riposa");
		if (forza < 10) {
			stancati(-2);
			if (forza > 10)
				forza = 10;
		}
		if (vita < 70) {
			vita += 20;
			if (vita > 70)
				vita = 70;
		}
		System.out.println("la sua forza sale a: "+getForza()+ " e la sua vita sale a: "+getVita());
	}

	@Override
	public void riceviDanno(int danno) {
		vita -= danno;
		System.out.println("l'Eroe riceve danno, la sua vita scende a: " + vita);
		if (vita <= 0) {
			System.out.println("L'Eroe "+getName()+" muore");
			vita = 0;
		}

	}

	@Override
	public void stancati(int stanchezza) {
		forza -= stanchezza;
		if(forza < 0) forza =0;
	}


}