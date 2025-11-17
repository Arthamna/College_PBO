/**
 * Write a description of class MakhlukHidup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class MakhlukHidup
{
    private String nama;
    public MakhlukHidup(String nama)
    {
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public abstract void bernapas();
    public abstract void tidur();
    public abstract void makan();

}