/**
 * Write a description of class Tumbuhan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tumbuhan extends MakhlukHidup
{
    public Tumbuhan(String nama){
        super(nama);
    }
    @Override
    public void bernapas()
    {
        System.out.println(getNama() + " menyerap karbon dioksida");
    }
    @Override
    public void tidur() {
        System.out.println(getNama() + " tidak tidur seperti hewan, tetapi beristirahat");
    }
    @Override
    public void makan() {
        System.out.println(getNama() + " tidak makan seperti hewan, tetapi menyerap nutrisi");
    }
    public void fotosintesis()
    {
        System.out.println("Tumbuhan fotosintesis");
    }

}