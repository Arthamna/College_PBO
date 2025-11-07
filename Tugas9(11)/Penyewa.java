
/**
 * Write a description of class Penyewa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Penyewa
{
    private String namaPenyewa;
    private Kendaraan kendaraan;
    public Penyewa(String namaPenyewa, Kendaraan kendaraan){
        this.namaPenyewa = namaPenyewa;
        this.kendaraan = kendaraan;
    }
    public String getDetail(){
        return "Penyewa: " + namaPenyewa + " -> " + kendaraan.getInfo();
    }
}