
package fr.umontpellier.iut;

import java.util.ArrayList;

public class Contexte {
    private Taquin taquin;
    private ArrayList<Taquin> solution = new ArrayList<>();

    public Contexte(Taquin taquin) {
        this.taquin = taquin;
    }

    public void resoudre() {
        boolean test = true;
        ArrayList<Couple> frontiere = new ArrayList<>();
        ArrayList<Taquin> dejaVus = new ArrayList<>();
        ArrayList<Taquin> tab = new ArrayList<>();
        Couple couplePrec = new Couple(taquin,null);
        frontiere.add(couplePrec);
        dejaVus.add(taquin);
        while((!frontiere.isEmpty())&&(test==true)){
            System.out.println(frontiere);
            couplePrec = frontiere.remove(0);
            if (couplePrec.getTaquin().estGagnant()) {
                test = false;
                solution = couplePrec.getListeDeMouvements();
            }
            else {
                tab = couplePrec.getTaquin().genererFils();
                couplePrec.mettreAJour(frontiere,tab,dejaVus);
            }
        }
        if (frontiere.isEmpty()) {
            System.out.println("Pas de solution");
        }
    }

    @Override
    public String toString() {
        return "Contexte{" +
                "solution=" + solution +
                '}';
    }
}