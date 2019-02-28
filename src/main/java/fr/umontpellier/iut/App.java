package fr.umontpellier.iut;

public class App {
    public static void main(String[] args) {

        int[][] p1 = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
        int[][] p2 = {{1, 0, 3}, {4, 2, 5}, {6, 7, 8}};
        int[][] p3 = {{7, 5, 3}, {4, 2, 8}, {6, 1, 0}};


        Taquin t1 = new Taquin(p1);
        Taquin t2 = new Taquin(p1);
        Taquin t3 = new Taquin(p2);


        System.out.println(t1.equals(t3));



        System.out.println(t3.genererFils());
    }
}
