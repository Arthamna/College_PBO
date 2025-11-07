/**
 * Write a description of class Sepeda here.
 *
 * @author Arthamna
 * @version 
 */
public class Sepeda extends Kendaraan
{
    private String jenisSepeda;
    public Sepeda(String merk, String model, int tahunProduksi, String jenisSepeda)
    {
        super(merk, model, tahunProduksi);
        this.jenisSepeda = jenisSepeda;
    }

    public String getInfo()
    {
        return "Sepeda: " + super.getInfo() + " (" + jenisSepeda + ")";
    }
}