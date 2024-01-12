
/*Wie startet das Spiel?
 * Das Spiel startet auf Startzustand 1 und zeigt das gesamte spielfeld
 * 
 * Welche Aufforderungen?
 * Es müssen begegnungen mit "Drache" (d.h auch Wasser oder Schwert) "Schlüssel" und zwei mal mit "Schatz" stattfinden
 * 
 * Wann soll das Spiel beendet werden?
 * -> Entweder bei ungültigem Spielzug oder beim erreichen des Endzustands und gleichzeitig erfüllen aller Aufforderungen
 */

import java.util.*; 

//Dieses Programm steht nicht zur freien Verfügung und gehört ausschließlich sim-ctrl

public class Aufgabe1 {
		static int[][][]gameAFS_praII = {
				//x1 x2  x3 x4 x5 x6
				{	{},{0},{},{},{},{}},	    //y 1 
				{	{},{},{2},{5},{},{}   	},		//y2
				{	{1},{},{},{},{},{}	    },		//y3
				{	{},{},{},{},{4},{}	    },		//y4
				{	{},{},{},{},{},{6}	    },		//y5
				{	{},{},{},{4},{},{}	    }, 		//y6
				{	{1},{0},{0},{0},{0},{2}	}				};

		//Das kopierte Feld aus  https://gitlab.hsrw.eu/lv-programmierung/praktika-adventure-game/praktikum-ii/slot-10_00.git
		
		static int[][][] gameAFS_slot1_7 = {
				{{},{0,1,5},{},{},{},{},{1}},
				{{},{},{3},{6},{},{},{}},
				{{2},{},{},{},{},{},{}},
				{{},{},{},{},{5},{},{}},
				{{},{},{},{},{},{6},{}},
				{{},{},{},{5},{},{},{}},
				{{2},{},{},{},{},{},{}},
				{{1},{0},{0},{2},{0},{0},{0}}			
		};
		
		//gameAFS_origin
	static int[][][] gameAFS_origin = {	
				{{},{1},{},{},{},{},{},{},{},{},{},{},{1},{},{},{}},
				{{},{},{1},{0},{},{},{},{},{},{},{},{},{},{},{},{}},
				{{1},{0},{},{},{},{},{},{},{},{},{},{},{},{},{},{}},			
				{{},{},{},{},{4},{},{4},{},{},{5},{3},{},{},{},{},{}},		
				{{},{},{},{},{},{6},{},{},{},{},{},{},{},{},{},{}},			
				{{},{},{},{4},{},{},{},{},{},{},{},{},{},{},{},{}},		
				{{},{},{},{},{},{},{},{6},{},{},{},{},{},{},{},{}},			
				{{},{},{},{},{},{},{},{},{1},{},{},{},{},{},{},{}},		
				{{},{},{},{5},{},{},{},{},{},{},{},{},{},{},{},{}},			
				{{},{},{},{0},{},{},{},{},{},{},{},{},{},{},{},{}},		
				{{},{},{},{},{},{},{},{},{},{},{},{2},{},{},{},{}},		
				{{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}},			
				{{},{},{},{},{},{},{},{},{},{},{},{},{6},{},{},{}},			
				{{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}},		
				{{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{4}},			
				{{},{},{},{},{},{},{},{},{},{},{},{6},{},{},{},{}},
				{{1},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{2},{0},{0},{0},{0}}	};

	public static String[] leer() {
			
			String[] leer = new String[6]; 
			leer[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
			leer[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
			leer[2]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
			leer[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
			leer[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
			leer[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
			return (leer);	
		}

	public static String[] Dragon() {
			
			String[] drache = new String[6]; 
			drache[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
			drache[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
			drache[2]=" "+"D"+"r"+"a"+"c"+"h"+"e"+" "+"|";
			drache[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
			drache[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
			drache[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
			return (drache);	
		}
	public static String[] Sword() {
		
		String[] schwert = new String[6]; 
		schwert[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		schwert[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		schwert[2]=" "+"S"+"w"+"o"+"r"+"d"+" "+" "+"|";
		schwert[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		schwert[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
		schwert[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
		return (schwert);	
	}
	public static String[] River() {
		
		String[] fluss = new String[6]; 
		fluss[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		fluss[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		fluss[2]=" "+"F"+"l"+"u"+"s"+"s"+" "+" "+"|";
		fluss[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		fluss[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
		fluss[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
		return (fluss);	
	}
	public static String[] Arch() {
		
		String[] bogen = new String[6]; 
		bogen[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		bogen[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		bogen[2]=" "+"B"+"o"+"g"+"e"+"n"+" "+" "+"|";
		bogen[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		bogen[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
		bogen[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
		return (bogen);	
	}
	public static String[] Door() {
		
		String[] tuer = new String[6]; 
		tuer[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		tuer[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		tuer[2]=" "+" "+"T"+"ü"+"r"+" "+" "+" "+"|";
		tuer[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		tuer[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
		tuer[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
		return (tuer);	
	}
	public static String[] Key() {
		
		String[] schluessel = new String[6]; 
		schluessel[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		schluessel[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		schluessel[2]="S"+"c"+"h"+"l"+"ü"+"s"+"s"+"l"+"|";
		schluessel[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		schluessel[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
		schluessel[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
		return (schluessel);	
	}
	public static String[] Treasure() {
		
		String[] schatz = new String[6]; 
		schatz[0]=" "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		schatz[1]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		schatz[2]=" "+"S"+"c"+"h"+"a"+"t"+"z"+" "+"|";
		schatz[3]=" "+" "+" "+" "+" "+" "+" "+" "+"|";
		schatz[4]=" "+" "+" "+" "+" "+" "+" "+" "+"|";	
		schatz[5]="*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";										 
		return (schatz);	}


	public static void main(String[] args) {
		//gameAFS_slot1_7
		
		baum(gameAFS_slot1_7);
		
		}
		
	
	public static void baum (int[][][] spielfeldArray) {
		
		try{
			
		int positionY=1;
		int standort=0;
		int schatzzahler=0;
		boolean falscherzug=false;
		boolean schwert=false;
		boolean schlüssel=false;
		boolean drache = false;
		boolean dracheerfüllt = false;
		
		
		Scanner s = new Scanner (System.in);
		//gameAFS_praII
		//System.out.print(createTable(gameAFS_praII, gameAFS_praII.length-1, 0));
		
		
		while (falscherzug==false) {
			
			
			
			
		//try {	
		
		System.out.println(createTable(spielfeldArray, 6, positionY));
		System.out.println("Aktuelle Position: "+positionY);
		System.out.println("Wo möchten Sie hin?");
		standort=s.nextInt();
		
		
		
		
		//Jetzt Prüfen was/ob da was bei mehreren Zuständen an einer stelle

		if (spielfeldArray[positionY-1][standort-1].length==0) {System.out.println("Schade bro, ich dachte du hast es drauf");falscherzug=true;}
		else {
		int wasIstAnDemStandort =0;	
if (spielfeldArray[positionY-1][standort-1].length==1) {
		 wasIstAnDemStandort = spielfeldArray[positionY-1][standort-1][0];}
if (spielfeldArray[positionY-1][standort-1].length>1) {
	
	int wievielewiederholungen = spielfeldArray[positionY-1][standort-1].length;
	System.out.println("Hier sind mehrere Züge möglich! Wähle bedacht!");
	System.out.println("Wähle zwischen ");
	for (int i=0;i<wievielewiederholungen;i++) {
		if (spielfeldArray[positionY-1][standort-1][i]==0) {//Drache
			System.out.print("dem Drachen (gib dann"+i+"ein) ");}
	
		if (spielfeldArray[positionY-1][standort-1][i]==1) {//Schwert
			System.out.print("dem Schwert (gib dann"+i+"ein) ");
		}
		if (spielfeldArray[positionY-1][standort-1][i]==2) {//Fluss
		System.out.print("dem Fluss (gib dann" +i+ "ein) ");}
		
		if (spielfeldArray[positionY-1][standort-1][i]==3) {//Arsch
			System.out.print("dem Torbogen (gib dann "+i+ "ein) ");}
		
		if (spielfeldArray[positionY-1][standort-1][i]==4) {//Tür
			System.out.println("oder der Tür (gib dann" + i +"ein) ");}
		if (spielfeldArray[positionY-1][standort-1][i]==5) {//Schlüssl
			System.out.println("oder dem Schlüssel (gib dann"+i+"ein) ");
		}		
		if (spielfeldArray[positionY-1][standort-1][0]==6) {//Schatz
			
			System.out.println("oder dem Schatz (gib dann"+i+"ein) ");
		}	
	}
	int beimehreren = s.nextInt();
	 wasIstAnDemStandort = spielfeldArray[positionY-1][standort-1][beimehreren];
	
}
								//ob Schwert              oder Fluss		
			if(drache==true) { if(schwert==false||spielfeldArray[positionY-1][standort-1][0]!=2) { System.out.println("Es scheiterte am Drachen....echt schade Bro");falscherzug=true;}}else {
				
					//Wegen else: Wenn Drache also == false
					
					if (wasIstAnDemStandort==0) {//Drache
						dracheerfüllt = true;
						if(schwert==true) {schwert=false;System.out.println("Wunderbar, Drache wurde besiegt");}else {drache=true;System.out.println("Oh nein, ein Drache! Beeil dich");}
					}
				
					if (wasIstAnDemStandort==1) {//Schwert
						schwert=true;
						System.out.println("Easy das Schwert gesnackt");
					}
					if (wasIstAnDemStandort==2) {//Fluss
						drache=false;
					System.out.println("Eine willkommene Abkühlung");
					}
					if (wasIstAnDemStandort==3) {//Arch
						System.out.println("Torbogen dies das, nix passiert");
					}
					if (wasIstAnDemStandort==4) {//Tür
						if(schlüssel==true) {System.out.println("Die Tür öffnest du sneaky");}else {System.out.println("Schade bro, du hast keinen Schlüssel! Das wars");falscherzug=true;}
					}
					if (wasIstAnDemStandort==5) {//Schlüssl
						schlüssel=true;
						System.out.println("Uhh den Schlüssl nimmst du mit");
					}		
					if (wasIstAnDemStandort==6) {//Schatz
						schatzzahler++;
						System.out.println("WoW nice du hast einen Schatz aufgesammelt");
					}
			}//Für Drachen-Abfrage-if abfrage
//}//Fuer Laenge=1



	
	
		}
	//Für das erreichen des ZIEL===
		//Zielbedingungen: Mehr als 1 Schatz & Begebung mit Drache & Begegbung mit 
	if (schatzzahler>1 &&schlüssel&&dracheerfüllt ) {
		//System.out.println(" rechts ist es "+ (standort-1));
		//System.out.println(spielfeldArray.length);
		int wasstehtda = spielfeldArray[spielfeldArray.length-1][standort-1][0];
		if ( wasstehtda == 2) {
			
			System.out.println("WoW du hast es geschafft und zwei Schätze gefunden!");
			System.out.println(" You ve dropped your ♛, King!");
			break;}	}
		
		
		
		
		
// dann einmal PositionY anpassen
		positionY = standort;




		
	}
	
		}
		catch(java.util.InputMismatchException e) {
			
			
			System.out.println("Schade bro, ich dachte du hast es drauf");
			
			
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
//	public static boolean checkpossible(int [][][] gameboard, int n) {
//		boolean checkpossible = false;
//		return checkpossible;									checkpossible(gameAFS_slot1_7, 6);
//	}
	
	public static String createTable(int [][][] gameboard, int n, int currentState) {
		boolean unprofessionell = false;
		//Für die erste Zeile:
		
		String createTable = ""; //1mal 
		//int currentState = 1;
		
		createTable= " "+" "+" "+" "+" "+" "+" "+" "+"|"; 
		for (int i = 1; i < gameboard.length ; i++) {
			if (i<10) {createTable = createTable + " "+" "+" "+" "+" "+" "+" "+i+"|";}else { 	createTable = createTable + " "+" "+" "+" "+" "+" "+i+"|";}
			//Ab 10 ein " " weniger da Platz für zweistellig
		}	
		createTable = createTable + "\n" ;	//ZEILENUMBRUCH
		
		for (int j = 0; j < gameboard.length; j++) {
			
			createTable = createTable + "*********"; 
			 
			
			
		}createTable = createTable + "\n" ;	//ZEILENUMBRUCH
		
		 int unten = 0;
				
		while (unten < gameboard.length-1) {
		
		for ( int fuerASCIIgroesse = 0; fuerASCIIgroesse < n;fuerASCIIgroesse++) { // nur wegen ASCII-Bildgröße
														//6 mal weil das Zeichen 6 Y-Koord groß ist 
			
					if (fuerASCIIgroesse ==0||fuerASCIIgroesse ==1||fuerASCIIgroesse==3||fuerASCIIgroesse==4) {createTable = createTable + " "+" "+" "+" "+" "+" "+" "+" "+"|";}
					int seitenzahl = unten +1;
				
					if (seitenzahl==currentState&&fuerASCIIgroesse ==2&&seitenzahl<10) { createTable = createTable + " "+" "+"-"+"-"+"-"+">"+" "+ seitenzahl +"|";}
					if (seitenzahl==currentState&&fuerASCIIgroesse ==2&&seitenzahl>=10) { createTable = createTable + " "+"-"+"-"+"-"+">"+" "+ seitenzahl +"|";}
					
					
					if (fuerASCIIgroesse ==2&&seitenzahl!=currentState) {
						   if (seitenzahl<10) {
						   createTable = createTable + " "+" "+" "+" "+" "+" "+" "+ seitenzahl +"|";}else {
							   createTable = createTable + " "+" "+" "+" "+" "+" "+ seitenzahl +"|";
						   }
						   
				}
					if (fuerASCIIgroesse==5) {createTable = createTable + "*"+"*"+"*"+"*"+"*"+"*"+"*"+"*"+"*";}
					
					
				for ( int rechts = 0; rechts < gameboard.length-1 ;rechts++) { // n = länge der Zeile mal damit EINE ganze zeile der ASCII Bildchen rausgegeben wird 
					
					
		if (gameboard[unten][rechts].length == 1 && gameboard[unten][rechts][0] == 0 ) {createTable = createTable +  (Dragon()[fuerASCIIgroesse]);unprofessionell = true;}
		if (gameboard[unten][rechts].length  == 1 && gameboard[unten][rechts][0] == 1 ) {createTable = createTable +  (Sword()[fuerASCIIgroesse]);unprofessionell = true;}   //Hier macht er die "fuerASCIIgroesse"-te Zeile 
		if (gameboard[unten][rechts].length == 1 && gameboard[unten][rechts][0] == 2 ) {createTable = createTable +  (River()[fuerASCIIgroesse]);unprofessionell = true;}
		if (gameboard[unten][rechts].length == 1 && gameboard[unten][rechts][0] == 3 ) {createTable = createTable +  (Arch()[fuerASCIIgroesse]);unprofessionell = true;}
		if (gameboard[unten][rechts].length == 1 && gameboard[unten][rechts][0] == 4 ) {createTable = createTable +  (Door()[fuerASCIIgroesse]);unprofessionell = true;}
		if (gameboard[unten][rechts].length == 1 && gameboard[unten][rechts][0] == 5 ) {createTable = createTable +  (Key()[fuerASCIIgroesse]);unprofessionell = true;}
		if (gameboard[unten][rechts].length == 1 && gameboard[unten][rechts][0] == 6 ) {createTable = createTable +  (Treasure()[fuerASCIIgroesse]);unprofessionell = true;}
		
		// Für den Fall dass mehrere Zustaende auftreten
		if (gameboard[unten][rechts].length > 1 && gameboard[unten][rechts][0] == 0 ) {
			//Einfach stumpf geklaut für die letzte Zeile
			if (fuerASCIIgroesse == 5) {createTable = createTable +  (Key()[fuerASCIIgroesse]);unprofessionell = true;}else {
				String wasstehtda = "";
				for (int i=0;i<gameboard[unten][rechts].length;i++) {
				wasstehtda = wasstehtda + gameboard[unten][rechts][i]+"";
				//System.out.println(wasstehtda.contains("5"));
				}
				if (fuerASCIIgroesse == 0) {
				if ( wasstehtda.contains("0")) {
					    createTable = createTable +  " "+"D"+"r"+"a"+"c"+"h"+"e"+"&"+"|";}else {
						createTable = createTable +  " "+" "+" "+" "+" "+" "+" "+" "+"|";}
				unprofessionell = true;}
				
				if (fuerASCIIgroesse == 1) {
					if ( wasstehtda.contains("1")) {
				createTable = createTable +  " "+"S"+"w"+"o"+"r"+"d"+" "+"&"+"|";}else {
				createTable = createTable +  " "+" "+" "+" "+" "+" "+" "+" "+"|";}
				unprofessionell = true;}
				
					if (fuerASCIIgroesse == 2) {
						if ( wasstehtda.contains("2")) {
					createTable = createTable +  " "+"R"+"i"+"v"+"e"+"r"+" "+"&"+"|";}else {
					createTable = createTable +  " "+" "+" "+" "+" "+" "+" "+" "+"|";}
					unprofessionell = true;}
						
				if (fuerASCIIgroesse == 4) {
					if ( wasstehtda.contains("5")&&!wasstehtda.contains("4")) {
						createTable = createTable +  " "+"K"+"e"+"y"+" "+" "+" "+" "+"|";}
					if ( wasstehtda.contains("5")&&( wasstehtda.contains("4"))){
						createTable = createTable +  "K"+"e"+"y"+"&"+" D"+"o"+"r"+"|";}
					if ( wasstehtda.contains("4")&& !wasstehtda.contains("5")) {
						createTable = createTable +  " "+"D"+"o"+"r"+" "+" "+" "+" "+"|";}
					if ( !wasstehtda.contains("4")&& !wasstehtda.contains("5")) {
			            createTable = createTable +  " "+" "+" "+" "+" "+" "+" "+" "+"|";}
					unprofessionell = true;}
				if (fuerASCIIgroesse == 3) {
					if ( wasstehtda.contains("3")&&!wasstehtda.contains("6")) {
						createTable = createTable +  " "+"A"+"r"+"c"+"h"+" "+" "+" "+"|";}
					if ( wasstehtda.contains("3")&&( wasstehtda.contains("6"))){
						createTable = createTable +  "A"+"r"+"c"+"h"+"&"+"T"+"r"+"e"+"|";}
					if ( wasstehtda.contains("6")&& !wasstehtda.contains("3")) {
						createTable = createTable +  " "+"T"+"r"+"e"+"a"+"s"+"u"+" "+"|";}
					if ( !wasstehtda.contains("6")&& !wasstehtda.contains("3")) {
			            createTable = createTable +  " "+" "+" "+" "+" "+" "+" "+" "+"|";}
				unprofessionell = true;}
			
		
				}
		}
		if (!unprofessionell) {
			createTable = createTable +(leer()[fuerASCIIgroesse]);}
		unprofessionell = false;
	} 
				createTable = createTable + "\n" ;	//ZEILENUMBRUCH
		}
				
		unten++;
		
		//System.out.println(unten);
		//Print out leere Zeile nur mit Sternchen		
		//Wiederhole das ganze bei einer Spalte drunter (y+1)
		
		
		}
		createTable = createTable + " "+" "+" "+" "+" "+" "+" "+" "+"|";
		for (int letztezeile=0; letztezeile<gameboard.length-1;letztezeile++ ) {createTable = createTable + "       " +      (gameboard[gameboard.length-1][letztezeile][0])+"|";}
		
	return(createTable);
	}
	}
