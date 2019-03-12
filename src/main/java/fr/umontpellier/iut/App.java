package fr.umontpellier.iut;

public class App {
    public static void main(String[] args) {

        int[][] p1 = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
        int[][] p2 = {{1, 0, 3}, {4, 2, 5}, {6, 7, 8}};
        int[][] p3 = {{7, 5, 3}, {4, 2, 8}, {6, 1, 0}};


        Taquin t1 = new Taquin(p1);
        Taquin t2 = new Taquin(p1);
        Taquin t3 = new Taquin(p2);


       // System.out.println(t1.equals(t2));

       // System.out.println(t3.toString());

        //System.out.println(t3.genererFils());

        Taquin t4 = t3.genererFils().get(1);
        Taquin t5 = t4.genererFils().get(1);
         Couple c1 = new Couple(t3, null);
         Couple c2 = new Couple(t4, c1);
         Couple c3 = new Couple(t5, c2);

        System.out.println("t3 :" + t3.toString());
        System.out.println("t5 :" + t5.toString());

        System.out.println(c3.getListeDeMouvements());
    }
}
