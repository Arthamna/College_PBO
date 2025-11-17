/**
 * Write a description of class Hewan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hewan extends MakhlukHidup
{
    public Hewan(String nama){
        super(nama);
    }
    @Override
    public void bernapas()
    {
        System.out.println(getNama() + " bernapas");
    }
    @Override
    public void tidur()
    {
        System.out.println("Hewan tidur");
    }
    @Override
    public void makan()
    {
        System.out.println("Hewan makan");
    }
    public void bertarung()
    {
        System.out.println("Hewan bertarung");
    }
}