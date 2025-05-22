package com.praktikum.main;

import com.praktikum.models.Item;
import com.praktikum.users.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        userList.add(new Admin("Admin", "123"));
        userList.add(new Mahasiswa("Excl", "070"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Login Sistem Pelaporan Barang ---");
            System.out.print("Masukkan Username: ");
            String inputNama = scanner.nextLine();
            System.out.print("Masukkan Password: ");
            String inputPass = scanner.nextLine();

            User currentUser = null;
            for (User user : userList) {
                if (user instanceof Admin) {
                    Admin admin = (Admin) user;
                    if (admin.login(inputNama, inputPass)) {
                        currentUser = admin;
                        break;
                    }
                } else if (user instanceof Mahasiswa) {
                    Mahasiswa mhs = (Mahasiswa) user;
                    if (mhs.login(inputNama, inputPass)) {
                        currentUser = mhs;
                        break;
                    }
                }
            }

            if (currentUser != null) {
                currentUser.displayInfo();
                currentUser.displayAppMenu();
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }

            System.out.print("\nApakah ingin login lagi? (y/n): ");
            String ulang = scanner.nextLine();
            if (!ulang.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Terima kasih telah menggunakan sistem.");
    }
}
