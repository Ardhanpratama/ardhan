package com.praktikum.users;

public abstract class User {
    private String nama;
    private String nim;

    public User(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNama() { return nama; }
    public String getNIM() { return nim; }
    public void setNama(String nama) { this.nama = nama; }
    public void setNIM(String nim) { this.nim = nim; }

    public abstract boolean login(String input1, String input2);
    public abstract void displayInfo();
    public abstract void displayAppMenu();
}
