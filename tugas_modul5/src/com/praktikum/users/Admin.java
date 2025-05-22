package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(password, username);
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equalsIgnoreCase(getNama()) && inputPassword.equals(getNIM());
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil!");
        System.out.println("Username: " + getNama());
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Lihat & Tandai Laporan");
            System.out.println("2. Kelola Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1 -> manageItems();
                    case 2 -> manageUsers();
                    case 0 -> System.out.println("Logout!");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("--- Semua Laporan Barang ---");
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            System.out.println(i + ". " + LoginSystem.reportedItems.get(i));
        }

        int index = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Masukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");

            try {
                index = scanner.nextInt();
                scanner.nextLine();
                Item item = LoginSystem.reportedItems.get(index);

                if (item.getStatus().equalsIgnoreCase("Reported")) {
                    item.setStatus("Claimed");
                    System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                } else {
                    System.out.println("Barang sudah dalam status 'Claimed'.");
                }

                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Indeks tidak valid." + (LoginSystem.reportedItems.size() - 1));
            }
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n--- Kelola Mahasiswa ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("NIM Mahasiswa: ");
                        String nim = scanner.nextLine();
                        LoginSystem.userList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                    }
                    case 2 -> {
                        System.out.print("NIM Mahasiswa yang ingin dihapus: ");
                        String nim = scanner.nextLine();
                        Iterator<User> iterator = LoginSystem.userList.iterator();
                        boolean found = false;
                        while (iterator.hasNext()) {
                            User u = iterator.next();
                            if (u instanceof Mahasiswa && u.getNIM().equals(nim)) {
                                iterator.remove();
                                found = true;
                                System.out.println("Mahasiswa berhasil dihapus.");
                                break;
                            }
                        }
                        if (!found) System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    case 0 -> System.out.println("Kembali ke menu admin!");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }
}
