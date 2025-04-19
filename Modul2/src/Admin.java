public class Admin {
    private final String username = "admin";
    private final String password = "admin123";

    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login Admin berhasil!");
            return true;
        } else {
            System.out.println("Username atau password Admin salah.");
            return false;
        }
    }
}
