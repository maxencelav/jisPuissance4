import java.util.Scanner;

public class principale {

	public static void main(String[] args) {
		
		
		// Import de Scanner pour lire les entrees clavier
		Scanner sc = new Scanner(System.in);
		
		
		int x = 0;
		boolean jeuLance = true;
		int nbTours = 1;
		
		int[][] tableau=new int[8][];
		for (int i=0 ; i<tableau.length; i++)
			tableau[i]=new int[9];
		/* 8 et 9 au lieu de 6 et 7 pour avoir
		 * une bordure au tableau de jeu et
		 * faciliter les calculs */
		
		
		System.out.print("    ____        _                                    __ __\r\n" + 
				"   / __ \\__  __(_)_____________ _____  ________     / // /\r\n" + 
				"  / /_/ / / / / / ___/ ___/ __ `/ __ \\/ ___/ _ \\   / // /_\r\n" + 
				" / ____/ /_/ / (__  |__  ) /_/ / / / / /__/  __/  /__  __/\r\n" + 
				"/_/    \\__,_/_/____/____/\\__,_/_/ /_/\\___/\\___/     /_/   \r\n" + 
				"                                                          \r\n" + 
				"\r\n" + 
				"");

		System.out.print("------------------- pour JisComputing ------------------- \n\n");
		
		while (jeuLance == true) {
			// JOUEUR 1
			for(int nbJoueur = 1; nbJoueur < 3; nbJoueur++) {
				if (jeuLance == true) {
					System.out.println("TOUR "+nbTours+" - JOUEUR "+nbJoueur);
					System.out.println("Entrez le numero de la colonne (1 a 6) ou placer le jeton :");
					
					int colonne = 9;
					while (colonne > 7 || colonne < 1) {
						colonne = sc.nextInt();
						if (colonne > 7 || colonne < 1) { System.out.print ("Valeur incorrecte.\nEntrez le numero de la colonne (1 a 6) ou placer le jeton :"); }
					}
					
					System.out.println("Vous avez saisi : " + colonne);
					System.out.println();
					
					// Pose le jeton le plus bas possible dans la colonne
					for(int i = 6; i >= 0; i--) {
						if (tableau[i][colonne] < 1) {
							tableau[i][colonne] = nbJoueur;
							x = i;
							break;
						}				
					}
					
					// Affiche le plateau de jeu 
					for(int i = 1; i < 7; i++) {    
					  for(int j = 1; j < 8; j++) {
						if(tableau[i][j] == 0)
			                System.out.print("O ");
						else
							System.out.print(tableau[i][j]+" ");       
					  }
					  System.out.println();
					}
					
					if (verifPuissance4(x,colonne,tableau,nbJoueur) == true) {
						System.out.println();
						System.out.println("JOUEUR "+nbJoueur+" A GAGNE");
						jeuLance = false;
						}
						
						else {
							System.out.println();
							System.out.println("___________________________________________________");
							System.out.println();
						}
				}	
				}
		nbTours++;
		}
}



	private static boolean verifPuissance4(int x, int y, int[][]tableau,int nbJoueur) {
		// Initialisation des variables supplémentaires
        int nbJetons;
        int i;
        int j;

        
        // Diagonale du haut droit vers bas gauche
        nbJetons=0;
        i=x;
        j=y;
        while(i<9 && j<8 && tableau[i][j] == nbJoueur){
        	nbJetons++;
            i++;
            j++;
        }
        i=x-1;
        j=y-1;
        while(i>=0 && j>=0 && tableau[i][j] == nbJoueur){
        	nbJetons++;
            i--;
            j--;
        }
        if(nbJetons == 4)
            return true;
        
        // Diagonale du haut gauche vers bas droit
        nbJetons=0;
        i=x;
        j=y;
        while(i<9 && j>=0 && tableau[i][j] == nbJoueur){
        	nbJetons++;
            i++;
            j--;
        }
        i=x-1;
        j=y+1;
        while(i>=0 && j<8 && tableau[i][j] == nbJoueur){
        	nbJetons++;
            i--;
            j++;
        }
        if(nbJetons == 4)
            return true;
        
        // Horizontal
        nbJetons=0;
        i=y;
        while(i<9 && tableau[x][i] == nbJoueur){
        	nbJetons++;
            i++;
        }
        i=y-1;
        while(i>=0 && tableau[x][i] == nbJoueur){
        	nbJetons++;
            i--;
        }
        if(nbJetons == 4)
            return true;
        
        // Vertical
        nbJetons=0;
        j=x;
        while(j<8 && tableau[j][y] == nbJoueur){
        	nbJetons++;
            j++;
        }
        if(nbJetons == 4)
            return true;
        
        return false;
	}
}


