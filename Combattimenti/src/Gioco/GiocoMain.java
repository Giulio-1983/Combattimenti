package Gioco;

import java.util.Map;


public class GiocoMain {
	public static void main(String[] args) {

		Fasi f = new Fasi();
		f.scegliPlayer(1);
		f.scegliPlayer(2);
		f.licanOn();
		System.out.println("INIZIA LO SCONTRO\n\n");
f.provaAttacco();
	}
}
//	 boolean statoLuna;
//	 int luna = r.nextInt(2);
//	 if (luna == 0) {
//		 statoLuna = true;
//		 System.out.println("C'è la luna piena, il licantropo è un forma di lupo");
//	 }
//	 else {
//		 statoLuna = false;
//		 System.out.println("Non c'è la luna piena, il licantropo è un forma di umano");
//	 }
//	 
// Eroe e = new Eroe(); 
//
//Licantropo l = new Licantropo(statoLuna); 
// Vampiro v = new Vampiro(); 
// 
// while(true) {
// e.attacca(l);
// if (l.getVita() == 0) return;
// System.out.println("Prossimo turno");
// String wait = s.nextLine();
// 
// l.attacca(e);
// if (e.getVita() == 0) return;
// System.out.println("Prossimo turno");
// String wait2 = s.nextLine();
//
// }
//Creare un gioco utilizzando la classe random
//i personaggi devono avere un valore di punti ferita, un valore di forza ed un danno