package Gioco;

import java.util.Scanner;

public class Licantropo implements Mostro, Umano {
	private int playerId;
	private boolean isUomo;
	protected String nome;
	protected int vita;
	protected int forza;

	public Licantropo(int playerId, String nome, boolean luna)

	{
		this.playerId = playerId;
		this.nome = nome;
		vita = 70;
		forza = 10;
		isUomo = !luna;
		if (luna) {
			forza += 5;
			vita += 30;
		}

	}

	Scanner s = new Scanner(System.in);

	@Override
	public int getId() {
		return playerId;
	}

	@Override
	public void azione(Personaggio p) {
		if (isUomo) {
			while (true) {
				System.out.println("Cosa farà il licantropo " + nome + "?\nA: attacca\nB: Si riposa");
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
				}
				}
			}

		} else {
			while (true) {
				System.out.println("Cosa farà il licantropo " + nome + "?\nA: attacca\nB: Ulula alla luna\n");
				String action = s.nextLine().toUpperCase();
				switch (action) {
				case "A": {
					attacca(p);
					return;
				}
				case "B": {
					ululi();
					return;
				}
				default: {
					System.out.println("\nScegli un'azione da fare\n\n");
				}
				}
			}
		}
	}

	@Override
	public String getName() {
		return nome;
	}

	public int getForza() {
		return forza;

	}

	public void azzanna(Personaggio p) {
		if (vita > 0) {
			stancati(1);
			System.out.println("Il Licantropo morde in forma di lupo!");
			System.out.println("Il Licantropo si stanca, la sua forza scende a: " + forza);
		} else {
			System.out.println("Il Licantropo non può attaccare perché è morto!");
		}
	}

	@Override
	public void combatti() {

		if (vita > 0) {
			stancati(1);
			System.out.println("Il Licantropo attacca in forma umana!");
			System.out.println("Il Licantropo si stanca, la sua forza scende a: " + forza);
		} else {
			System.out.println("Il Licantropo non può attaccare perché è morto!");
		}
	}

	@Override
	public void riposa() {
		System.out.println("Il Licantropo riposa in forma umana!");
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
		System.out.println("la sua forza sale a: " + getForza() + "e la sua vita sale a: " + getVita());
	}

	@Override
	public void attacca(Personaggio p) {
		{
			if (!isUomo) {
				azzanna(p);
				p.riceviDanno(forza + 1);
			} else if (isUomo) {
				combatti();
				p.riceviDanno(forza + 1);
			}

		}
	}

	@Override
	public int getVita() {
		// TODO Auto-generated method stub
		return vita;
	}

	@Override
	public void riceviDanno(int danno) {
		vita -= danno;
		System.out.println("Il Licantropo riceve danno, la sua vita scende a: " + vita);
		if (vita <= 0) {
			System.out.println("Il licantropo " + getName() + " muore");
			vita = 0;
		}
	}

	@Override
	public void stancati(int stanchezza) {
		forza -= stanchezza;
		if (forza < 0)
			forza = 0;
	}

	public void ululi() {
		stancati(-3);
		System.out.println("Auuuuuuu, il licantropo " + getName()
				+ " ulula alla luna e diventa più forte, la sua forza sale a: " + getForza() +"\n");
	}
}
