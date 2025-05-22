package com.praktikum.users;

import com.praktikum.actions.MahasiswaAction;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaAction {

    public Mahasiswa(String nama, String nim) {
        super(nim, nama);
    }

    @Override
    public boolean login(String inputNama, String inputNIM) {
        return inputNama.equalsIgnoreCase(getNama()) && inputNIM.equals(getNIM());
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa Berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNIM());
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n--- Menu Mahasiswa ---");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1 -> reportItem();
                    case 2 -> viewReportedItems();
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
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi: ");
        String lokasi = scanner.nextLine();

        LoginSystem.reportedItems.add(new Item(nama, deskripsi, lokasi));
        System.out.println("Status : Reported!");
    }

    @Override
    public void viewReportedItems() {
        boolean ada = false;
        System.out.println("--- Daftar Barang Dilaporkan ---");
        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(item);
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("Belum ada laporan barang.");
        }
    }
}
