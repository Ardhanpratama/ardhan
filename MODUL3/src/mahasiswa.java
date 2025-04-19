class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        if (inputNama.equals(getNama()) && inputNim.equals(getNim())) {
            System.out.println("Login Mahasiswa berhasil!");
            return true;
        } else {
            System.out.println("Nama atau NIM salah.");
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Selamat datang, Mahasiswa!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}
