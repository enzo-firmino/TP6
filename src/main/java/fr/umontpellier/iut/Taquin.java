package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Taquin {

    private int [][] plateau;


    public Taquin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("le nombre de colonnes du taquin :");
        int nbColonne = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("le nombre de lignes du taquin :");
        int nbLigne = sc.nextInt();
        this.plateau = new int [nbLigne][nbColonne];
     }

    public Taquin(int[][] plateau) {
        this.plateau = plateau;
    }

    public boolean estGagnant() {
        int x = 1;
        for( int i = 0; i<this.plateau.length; i++){
            for( int j = 0; j<this.plateau[0].length; i++){
                if(this.plateau[i][j] != x) {
                    return false;
                }
                x++;
            }
        }
        return true;
    }

    public ArrayList<Taquin> genererFils() {
        ArrayList<Taquin> listeFils = new ArrayList<Taquin>();
        int colonneTrou = 0;
        int ligneTrou = 0;
        for (int i = 0; i < this.plateau.length; i++) {
            for (int j = 0; j < this.plateau[0].length; j++) {
                if (this.plateau[i][j] == 0) {
                    colonneTrou = j;
                    ligneTrou = i;
                }
            }
        }


        if (colonneTrou < this.plateau[0].length - 1) { //on bouge vers la droite
            int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
            newPlateau = copiePlateau(newPlateau);
            newPlateau[ligneTrou][colonneTrou] = newPlateau[ligneTrou][colonneTrou + 1];
            newPlateau[ligneTrou][colonneTrou + 1] = 0;
            Taquin newTaquin = new Taquin(newPlateau);
            listeFils.add(newTaquin);

        }

            if (colonneTrou > 0) { //on bouge vers la gauche
                int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
                newPlateau = copiePlateau(newPlateau);
                newPlateau[ligneTrou][colonneTrou] = newPlateau[ligneTrou][colonneTrou - 1];
                newPlateau[ligneTrou][colonneTrou - 1] = 0;
                Taquin newTaquin = new Taquin(newPlateau);
                listeFils.add(newTaquin);
            }

            if (ligneTrou > 0) { //on bouge vers le haut
                int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
                newPlateau = copiePlateau(newPlateau);
                newPlateau[ligneTrou][colonneTrou] = newPlateau[ligneTrou - 1][colonneTrou];
                newPlateau[ligneTrou - 1][colonneTrou] = 0;
                Taquin newTaquin = new Taquin(newPlateau);
                listeFils.add(newTaquin);
            }


            if (ligneTrou < this.plateau.length - 1) { //on bouge vers le bas
                int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
                newPlateau = copiePlateau(newPlateau);
                newPlateau[ligneTrou][colonneTrou] = newPlateau[ligneTrou + 1][colonneTrou];
                newPlateau[ligneTrou + 1][colonneTrou] = 0;
                Taquin newTaquin = new Taquin(newPlateau);
                listeFils.add(newTaquin);
            }
            return listeFils;
        }


        public int [][] copiePlateau(int [][] newPlateau) {
            for (int i = 0; i < this.plateau.length; i++) {
                for (int j = 0; j < this.plateau[0].length; j++) {
                    newPlateau[i][j] = this.plateau[i][j];
                }
            }
            return newPlateau;
        }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taquin taquin = (Taquin) o;
        return this.plateau == taquin.plateau ;

        }

    @Override
    public int hashCode() {
        return Arrays.hashCode(plateau);
    }

    @Override
    public String toString() {
        String plateau= "";
        for( int i = 0; i<this.plateau.length; i++){
            for( int j = 0; j<this.plateau[0].length; j++){
                plateau = plateau + this.plateau[i][j];
            }
            plateau = plateau + "\n";
        }
        return plateau;
    }


}
