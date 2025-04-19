public class Mahasiswa {
    private final String nama = "ardhan";
    private final String nim = "202410370110375";

public boolean login(String inputNama, String inputNim) {
        if (inputNama.equals(nama) && inputNim.equals(nim)) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo(nama, nim);
            return true;
        } else {
            System.out.println("Nama atau NIM salah.");
            return false;
        }
    }

    public void displayInfo(String nama, String nim) {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}
