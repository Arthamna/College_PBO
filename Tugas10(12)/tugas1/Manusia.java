/**
 * Write a description of class Manusia here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Manusia extends MakhlukHidup
{
    public Manusia(String nama){
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
        System.out.println(getNama() + " tidur");
    }
    @Override
    public void makan()
    {
        System.out.println(getNama() + " makan");
    }
    public void bangun()
    {
        System.out.println(getNama() + " bangun");
    }

}