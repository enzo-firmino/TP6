package fr.umontpellier.iut;

public class App {
    public static void main(String[] args) {
        Taquin T1,T2;
        T1 = new Taquin();
        T2 = new Taquin();
        System.out.println(T1.estGagnant());
        System.out.println(T1.equals(T2));
    }
}