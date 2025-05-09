package com.praktikum.main;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;

        System.out.println("=== Sistem Login ===");
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        // Simulasi login
        if (username.equals("admin")) {
            user = new Admin("admin", "admin123");
        } else if (username.equals("mahasiswa")) {
            user = new Mahasiswa("mahasiswa", "mhs123");
        }

        if (user != null && user.login(username, password)) {
            System.out.println("Login berhasil sebagai " + username);
            user.displayAppMenu(); // polymorphism
        } else {
            System.out.println("Login gagal. Coba lagi.");
        }
    }
}
