package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Arrays;

public class Taquin {

    private int[][] plateau;

    public Taquin() {
        plateau = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plateau[i][j] = 3*i + j;
            }
        }
    }

    public Taquin(int [][]plateau) {
        this.plateau = plateau;
    }


    public int[][] copie(int[][]tab) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tab[i][j] = this.plateau[i][j];
            }
        }
        return tab;
    }

    public String toString() {
        String renvoie = "";
        for (int p = 0; p < 3; p++) {
            for (int q = 0; q < 3; q++) {
                renvoie = renvoie + plateau[p][q] + " ";
            }
            renvoie = renvoie + "\n";
        }
        return renvoie;
    }

    public boolean estGagnant() {
        boolean renvoie = true;
        int i = 1;
        int a = 0;
        int b = 0;
        while (i < 8) {
            if (plateau[a][b] != i) {
                return false;
            }
            i++;
            b++;
            if (b > 2) {
                b = 0;
                a++;
            }
        }
        if (plateau[2][2] != 0) {
            return false;
        }
        return renvoie;
    }

    public ArrayList<Taquin> genererFils() {
        ArrayList<Taquin> listeFils = new ArrayList<>();
        int x = 0; // colonne du trou
        int y = 0; // ligne du trou
        for (int i = 0; i < this.plateau.length; i++) {
            for (int j = 0; j < this.plateau[0].length; j++) {
                if (this.plateau[i][j] == 0) {
                    x = j;
                    y = i;
                }
            }
        }

        if (x < this.plateau[0].length - 1) {
            int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
            newPlateau = copie(newPlateau);
            newPlateau[y][x] = newPlateau[y][x + 1];
            newPlateau[y][x + 1] = 0;
            Taquin T1 = new Taquin(newPlateau);
            listeFils.add(T1);
        } // mouvement vers la droite du trou

        if (x > 0) {
            int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
            newPlateau = copie(newPlateau);
            newPlateau[y][x] = newPlateau[y][x - 1];
            newPlateau[y][x - 1] = 0;
            Taquin T1 = new Taquin(newPlateau);
            listeFils.add(T1);
        } // mouvement vers la gauche du trou

        if (y > 0) {
            int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
            newPlateau = copie(newPlateau);
            newPlateau[y][x] = newPlateau[y - 1][x];
            newPlateau[y - 1][x] = 0;
            Taquin T1 = new Taquin(newPlateau);
            listeFils.add(T1);
        }

        if (y < this.plateau.length - 1) {
            int[][] newPlateau = new int [this.plateau.length][this.plateau[0].length];
            newPlateau = copie(newPlateau);
            newPlateau[y][x] = newPlateau[y + 1][x];
            newPlateau[y + 1][x] = 0;
            Taquin T1 = new Taquin(newPlateau);
            listeFils.add(T1);
        } // mouvement vers le bas du trou


        return listeFils;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taquin T = (Taquin) o;
        //return Arrays.equals(plateau, taquin.plateau);
        boolean renvoie = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.plateau[i][j] != T.plateau[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(plateau);
    }

}