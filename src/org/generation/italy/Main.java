package org.generation.italy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		/* Inserire in un array i nomi, chiedere all'utente quanti gruppi formare
		   e generare in modo casuale i gruppi di dimensione ideale
		 */
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		String [] cognomi = {"Tiberia", "Persico", "Lozzi", "Cuccuru", "Cuomo", "Patitucci", "Tanase",
				"Di Biase", "Lo Re", "Pagliarini", "Fanasca", "Germani", "Foco", "Pignataro", "Troiani",
				"Cingolani", "Fanelli", "Farroni", "Turino", "Hubencu", "Franco", "Luzzi", "Ganesio", 
				"Martinez", "Dascalu", "Sgarlata", "Allegrini", "Barone", "Bellucci", "Mingione", "Trovato"};
		String assenti, cognomeAssente;
		ArrayList <String> listaAssenti = new ArrayList<>();
		
		int gruppi, dimensione, n, conta, personeAggiunte=0;
		
		System.out.println("Ci sono persone assenti? (si/no)");
		assenti = sc.nextLine();
		if (assenti.equals("si"))
			do
			{
				System.out.println("Scrivere il cognome della persona assente");
				cognomeAssente=sc.nextLine();
				listaAssenti.add(cognomeAssente);
				System.out.println("Ci altre persone assenti? (si/no)");
				assenti = sc.nextLine();
			}	while (assenti.equals("si"));
		
		
		n = r.nextInt(cognomi.length);
		
		System.out.println("Quanti gruppi si devono formare?");
		gruppi = Integer.parseInt(sc.nextLine());
		
		if (gruppi>cognomi.length)
		{
			System.out.println("Numero di gruppi non valido");
			gruppi=31;
		}
		
		dimensione = cognomi.length/gruppi;
		
		for (int i=0;i<gruppi;i++)
		{
			ArrayList <String> gruppo = new ArrayList<>();
			conta=0;
			
			while (conta<dimensione)
			{
				n = r.nextInt(cognomi.length);
				if(cognomi[n] != "estratto" && !listaAssenti.contains(cognomi[n]))  // aggiungiamo se il cognome non è stato estratto e non è presente nella lista assenti
				{
					gruppo.add(cognomi[n]);
					cognomi[n]="estratto";
					conta+=1;
					personeAggiunte++;
				}	
			}
			
			//se siamo arrivati all'ultimo gruppo e il numero di persone aggiunte
			//è minore del numero di persone preseni nell'array, continuiano ad
			//aggiungere all'ultimo gruppo
			
			if (i==gruppi-1)
			{
				while (personeAggiunte<cognomi.length)
				{
					n = r.nextInt(cognomi.length);
					if (cognomi[n] !="estratto" && !listaAssenti.contains(cognomi[n]))
					{
						gruppo.add(cognomi[n]);
						cognomi[n]="estratto";
						conta+=1;
						personeAggiunte++;
					}
				}
			}
			System.out.println("Sono stati creati questi gruppi:");
			System.out.println("Gruppo "+ (i+1)+ ": "+ gruppo);
		}
		
		sc.close();
		
	}

}
