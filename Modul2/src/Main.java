import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();  
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi login (1/2): ");
        String pilihan = scanner.nextLine();

        switch (pilihan) {
            case "1":
                System.out.print("Masukkan username Admin: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password Admin: ");
                String password = scanner.nextLine();
                admin.login(username, password);
                break;

            case "2":
                System.out.print("Masukkan nama Mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nim = scanner.nextLine();
                mahasiswa.login(nama, nim);
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }

        scanner.close();
    }
}

