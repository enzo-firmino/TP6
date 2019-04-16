package fr.umontpellier.iut;

import java.util.ArrayList;

public class Couple {
    private Taquin taquin;
    private Couple predecesseur;

    public Couple(Taquin taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }

    public ArrayList<Taquin> getListeDeMouvements() {
        int i = 0, j;
        ArrayList<Taquin> renvoie = new ArrayList<>();
        Couple test;
        Taquin sauv;
        test = this;
        while (test != null) {
            renvoie.add(test.taquin);
            test = test.predecesseur;
        }
        j = renvoie.size()-1;
        while (i < j) {
            sauv = renvoie.get(i);
            renvoie.set(i,renvoie.get(j));
            renvoie.set(j,sauv);
            i++;
            j--;
        }
        return renvoie;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "taquin=" + taquin +
                '}';
    }

    public Taquin getTaquin() {
        return taquin;
    }

    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> tab, ArrayList<Taquin> dejaVus) {
        for (int i = 0; i < tab.size(); i++) {
            if (!dejaVus.contains(tab.get(i))) {
                dejaVus.add(tab.get(i));
                Couple test = new Couple(tab.get(i), this);
                frontiere.add(test);
            }
        }
    }




}