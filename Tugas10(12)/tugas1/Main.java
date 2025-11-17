/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        Manusia manusia = new Manusia("Arthamna");
        System.out.println(">>>>> Summon Manusia <<<<<");
        manusia.bernapas();
        manusia.makan();
        manusia.tidur();
        manusia.bangun();
        Hewan hewan = new Hewan("Jangkrik");
        System.out.println(">>>>> Summon Hewan <<<<<");
        hewan.bernapas();
        hewan.makan();
        hewan.tidur();
        hewan.bertarung();
        Tumbuhan tumbuhan = new Tumbuhan("Bunga");
        System.out.println(">>>>> Summon Tumbuhan <<<<<");
        tumbuhan.bernapas();
        tumbuhan.makan();
        tumbuhan.tidur();
        tumbuhan.fotosintesis();
    }
}