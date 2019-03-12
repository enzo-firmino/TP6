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
        Couple newCouple = this;
        ArrayList solution = new ArrayList<Taquin>();
        while(newCouple!= null){
            solution.add(newCouple.taquin);
            newCouple = newCouple.predecesseur;
        }
    return solution;
    }

    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> tab, ArrayList<Taquin> dejaVus) {
        for(int i = 0; i<tab.size(); i++){
            if(!dejaVus.contains(tab.get(i))){
                dejaVus.add(tab.get(i));
                Couple newCouple = new Couple(tab.get(i), this);
            }
        }

    }


}
