package Gioco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fasi {
	final String yellowBgColor = "\u001B[43m";
	final String resetColor = "\u001B[0m";
	final String redColor = "\u001B[31m";
	boolean lican = false;
	HashMap<Integer, Personaggio> players = new HashMap<>();
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	boolean statoLuna = r.nextBoolean();

	public void scegliPlayer(int pNum) {
		if (pNum == 1) {
			System.out.println("Pronti allo scontro?");
		}
		System.out.println("\nChi sarà il giocatore" + pNum + "?\nA: L'Eroe\nB: Il Vampiro\nC: Il Licantropo");

		while (true) {
			String c1 = s.nextLine().toUpperCase();
			switch (c1) {
			case "A": {
				sceglieEroe(pNum);
				return;
			}
			case "B": {
				scegliVampiro(pNum);
				return;

			}
			case "C": {
				scegliLicantropo(pNum);
				return;
			}
			}

		}

	}

	public void sceglieEroe(int pNum) {
		while (true) {
		System.out.println("Quale sarà il nome dell'eroe?");
		String p1name = s.nextLine();
		if (!p1name.trim().equals("")) {
		players.put(pNum, (new Eroe(pNum, p1name)));
		System.out.println(yellowBgColor + redColor + p1name + " l'eroe si prepara al combattimento" + resetColor);
		return;
		}else System.out.println("Devi scegliere un nome!");
	}
		}

	public void scegliVampiro(int pNum) {
		while (true) {
		System.out.println("Quale sarà il nome del vampiro?");
		String p1name = s.nextLine();
		if (!p1name.trim().equals("")) {
		players.put(pNum, (new Vampiro(pNum, p1name)));
		System.out.println(yellowBgColor + redColor + p1name + " il vampiro si prepara al combattimento" + resetColor);
		return;
		}else System.out.println("Devi scegliere un nome!");
		}
	}

	public void scegliLicantropo(int pNum) {
		while (true) {
		System.out.println("Quale sarà il nome del licantropo?");
		String p1name = s.nextLine();
		if (!p1name.trim().equals("")) {
		players.put(pNum, (new Licantropo(pNum, p1name, statoLuna)));
		System.out
				.println(yellowBgColor + redColor + p1name + " il licantropo si prepara al combattimento" + resetColor);
		lican = true;	
		return;
		}else System.out.println("Devi scegliere un nome!");
		}
	}

	public void licanOn() {
		if (lican) {
			if (statoLuna)
				System.out.println("\nC'è la luna piena, i licantropi sono in forma di lupo\n\n");
			else
				System.out.println("\nNon c'è la luna piena, i licantropi sono in forma umana\n\n");
		}
	}

	public void provaAttacco() {
		while (true) {
			players.get(1).azione(players.get(2));
			if (players.get(2).getVita() == 0) return;
			System.out.println("\n ---------------- \n Prossimo turno \n");
			String wait = s.nextLine();
			players.get(2).azione(players.get(1));
			if (players.get(1).getVita() == 0) return;
			System.out.println("\n ---------------- \n Prossimo turno \n");
			String wait2 = s.nextLine();
		}
	}
}
