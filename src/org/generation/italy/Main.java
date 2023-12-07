package org.generation.italy;

import java.util.ArrayList;
import java.util.Iterator;
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
				"Martinez", "Dascalu", "Sgarlata", "Allegrini", "Barone",  "Mingione", "Trovato"};
		String assenti, cognomeAssente;
		ArrayList <String> listaAssenti = new ArrayList<>();
		ArrayList <String> gruppo;
		ArrayList <ArrayList <String>> elencoGruppi=new ArrayList<>();
		
		int numeroGruppi, dimensione, n,  personeAggiunte=0, presenti;
		
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
		
		System.out.println("Gli assenti di oggi sono:");
		for(String assente:listaAssenti)	//per ogni assente in listaAssenti
			System.out.println(assente);
		
		presenti=cognomi.length-listaAssenti.size();
		System.out.println("Il numero di persone presenti è: "+presenti);
		
		System.out.println("Quanti gruppi si devono formare?");
		numeroGruppi = Integer.parseInt(sc.nextLine());
		
		if (numeroGruppi>presenti)
		{
			System.out.println("Numero di gruppi non valido");
			numeroGruppi=presenti;	//gruppi da 1 persona
		}
		
		dimensione = presenti/numeroGruppi;
		
		for (int i=0;i<numeroGruppi;i++)
		{
			gruppo = new ArrayList<>();	
			elencoGruppi.add(gruppo);
			
			while (gruppo.size()<dimensione)
			{
				n = r.nextInt(cognomi.length);
				if(cognomi[n] != "estratto" && !listaAssenti.contains(cognomi[n]))  // aggiungiamo se il cognome non è stato estratto e non è presente nella lista assenti
				{
					gruppo.add(cognomi[n]);
					cognomi[n]="estratto";					
					personeAggiunte++;	//totale persone aggiunte
				}	
			}
		}	
		//se siamo arrivati all'ultimo gruppo e il numero di persone aggiunte
		//è minore del numero di persone presenti, continuiano ad
		//aggiungere 	
		Iterator<ArrayList <String>> gruppiIterator= elencoGruppi.iterator();		//riparto dal primo gruppo
			
		while (personeAggiunte<presenti)
		{
			n = r.nextInt(cognomi.length);
			if (cognomi[n] !="estratto" && !listaAssenti.contains(cognomi[n]))
			{
				if (gruppiIterator.hasNext()) 
				{
					gruppo=gruppiIterator.next();	//prossimo gruppo
					gruppo.add(cognomi[n]);
					cognomi[n]="estratto";					
					personeAggiunte++;					
				}				
			}			
			
		}
			
		System.out.println("Sono stati creati questi gruppi:");
		for(int i=0;i<elencoGruppi.size();i++)
			System.out.println("Gruppo "+ (i+1)+ ": "+ elencoGruppi.get(i));
		sc.close();
		System.out.println("Ciao");
		}	
		
	}


