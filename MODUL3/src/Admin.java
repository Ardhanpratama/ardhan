public class Admin extends User {
    private final String username = "admin";
    private final String password = "admin123";

    public Admin(String nama, String nim) { //Constructor
        super(nama, nim);
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login Admin berhasil!");
            return true;
        } else {
            System.out.println("Username atau password Admin salah.");
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Selamat datang, Admin!");
    }
}
