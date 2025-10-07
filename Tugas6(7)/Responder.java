import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Responder
{
    private Random randomGenerator;
    private HashMap<String, String> responseMap;
    private ArrayList<String> defaultResponses;
    public Responder()
    {
        randomGenerator = new Random();
        responseMap = new HashMap<String, String>();
        defaultResponses = new ArrayList<String>();
        fillResponsesMap();
        fillDefaultResponses();
    }
    public String generateResponse(HashSet<String> words)
    {
        for(String word : words) {
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        
        return pickDefaultResponse();
    }

    private String pickDefaultResponse()
    {
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }

    private void fillDefaultResponses()
    {
        defaultResponses.add("Maaf, saya kurang memahami masalah Anda. Bisakah Anda jelaskan lebih detail?");
        defaultResponses.add("Hmm, menarik. Bisa Anda ceritakan lebih lanjut tentang kendala yang Anda hadapi?");
        defaultResponses.add("Saya perlu informasi lebih lanjut untuk membantu Anda. Bisa dijelaskan dengan lebih spesifik?");
        defaultResponses.add("Apakah Anda sudah mencoba mengecek panduan akademik di portal mahasiswa?");
        defaultResponses.add("Saya ingin membantu, tapi saya butuh detail lebih jelas tentang masalahnya.");
        defaultResponses.add("Coba jelaskan situasinya dari awal, agar saya bisa memberikan solusi yang tepat.");
        defaultResponses.add("Apakah masalah ini baru pertama kali terjadi atau sudah berulang kali?");
        defaultResponses.add("Untuk masalah tersebut, sebaiknya Anda hubungi bagian administrasi akademik.");
        defaultResponses.add("Bisakah Anda sebutkan kata kunci yang lebih spesifik terkait masalah Anda?");
    }

    private void fillResponsesMap()
    {
        responseMap.put("krs",
            "Untuk masalah KRS, pastikan Anda sudah memenuhi syarat pembayaran UKT dan tidak ada tunggakan. Periode pengisian KRS biasanya dibuka setiap awal semester. Silakan cek portal akademik atau hubungi dosen wali Anda.");
        
        responseMap.put("nilai",
            "Jika ada masalah dengan nilai, Anda bisa mengajukan sanggahan nilai maksimal 2 minggu setelah nilai diumumkan. Silakan hubungi dosen pengampu mata kuliah terkait atau koordinator program studi Anda.");
        
        responseMap.put("wali",
            "Untuk konsultasi dengan dosen wali, Anda bisa membuat janji melalui email atau datang langsung ke ruangan dosen pada jam konsultasi. Dosen wali akan membantu Anda terkait akademik dan perwalian KRS.");
        
        responseMap.put("jadwal",
            "Jadwal kuliah dapat dilihat di portal akademik atau sistem informasi akademik kampus. Jika ada bentrok jadwal saat pengisian KRS, segera koordinasikan dengan dosen wali atau bagian akademik.");
        
        responseMap.put("cuti",
            "Untuk mengajukan cuti akademik, Anda harus mengisi formulir cuti dan mendapat persetujuan dosen wali serta orang tua/wali. Cuti akademik maksimal 2 semester dan tidak menghapus masa studi. Silakan ke bagian akademik untuk prosedur lengkapnya.");
        
        responseMap.put("sks",
            "Beban SKS yang dapat diambil bergantung pada IPS semester sebelumnya. IPS >= 3.00 dapat mengambil 24 SKS, IPS 2.50-2.99 dapat mengambil 21 SKS, dan IPS < 2.50 maksimal 18 SKS. Untuk semester 1 biasanya maksimal 20-21 SKS.");
        
        responseMap.put("ukt",
            "Untuk masalah pembayaran UKT, silakan hubungi bagian keuangan atau BAAK. Pastikan pembayaran dilakukan sesuai jadwal agar tidak terkena denda keterlambatan. Jika ada kendala finansial, Anda bisa mengajukan keringanan UKT.");
        
        responseMap.put("skripsi",
            "Untuk mengambil skripsi/tugas akhir, pastikan Anda sudah memenuhi syarat minimal SKS (144 SKS) dan IPK yang ditentukan. Silakan konsultasi dengan koordinator tugas akhir dan dosen pembimbing untuk proses bimbingan.");
        
        responseMap.put("wisuda",
            "Syarat wisuda antara lain: sudah lulus sidang akhir, menyelesaikan administrasi, tidak ada tunggakan, dan mendaftar wisuda sesuai jadwal. Untuk informasi lengkap periode wisuda, silakan cek pengumuman di website kampus atau bagian akademik.");
        
        responseMap.put("absensi",
            "Mahasiswa wajib menghadiri minimal 75% perkuliahan untuk dapat mengikuti ujian akhir. Jika ada kendala presensi karena sakit atau alasan penting, segera hubungi dosen pengampu dan lampirkan bukti seperti surat keterangan sakit.");
        
        responseMap.put("pembayaran", responseMap.get("ukt"));
        responseMap.put("ta", responseMap.get("skripsi"));
        responseMap.put("tugas", responseMap.get("skripsi"));
        responseMap.put("presensi", responseMap.get("absensi"));
        responseMap.put("kehadiran", responseMap.get("absensi"));
    }

}
