import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private int angkaRahasia;
    private int jumlahTebakan;

    private TextField inputTebakan;
    private Label labelFeedback;
    private Label labelJumlahTebakan;
    private Button tombolTebak;

    @Override
    public void start(Stage primaryStage) {
        mulaiGameBaru();

        Label labelJudul = new Label("🔄 Tebak Angka 1–100");
        labelJudul.setFont(new Font("Arial", 22));
        labelJudul.setTextFill(Color.DARKBLUE);

        Label labelInstruksi = new Label("Masukkan tebakanmu!");
        labelInstruksi.setFont(new Font("Arial", 16));
        labelInstruksi.setTextFill(Color.GRAY);

        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka di sini");
        inputTebakan.setMaxWidth(180);

        tombolTebak = new Button("🟩 Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        tombolTebak.setOnAction(e -> prosesTebakan());

        labelFeedback = new Label("");
        labelFeedback.setFont(new Font("Arial", 14));
        labelFeedback.setTextFill(Color.ORANGE);

        labelJumlahTebakan = new Label("Jumlah percobaan: 0");
        labelJumlahTebakan.setFont(new Font("Arial", 12));
        labelJumlahTebakan.setTextFill(Color.GRAY);

        HBox hboxInput = new HBox(10, inputTebakan, tombolTebak);
        hboxInput.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, labelJudul, labelInstruksi, hboxInput, labelFeedback, labelJumlahTebakan);
        root.setStyle("-fx-padding: 30; -fx-background-color: #eef7fb;");
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mulaiGameBaru() {
        angkaRahasia = new Random().nextInt(100) + 1;
        jumlahTebakan = 0;

        if (labelFeedback != null) labelFeedback.setText("");
        if (labelJumlahTebakan != null) labelJumlahTebakan.setText("Jumlah percobaan: 0");
        if (inputTebakan != null) {
            inputTebakan.clear();
            inputTebakan.setDisable(false);
        }
        if (tombolTebak != null) {
            tombolTebak.setText("🟩 Coba Tebak!");
            tombolTebak.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        }
    }

    private void prosesTebakan() {
        if (tombolTebak.getText().equals("🔁 Main Lagi")) {
            mulaiGameBaru();
            return;
        }

        String input = inputTebakan.getText();
        try {
            int tebakan = Integer.parseInt(input);
            jumlahTebakan++;
            labelJumlahTebakan.setText("Jumlah percobaan: " + jumlahTebakan);

            if (tebakan > angkaRahasia) {
                labelFeedback.setText("⚠ Terlalu besar!");
                labelFeedback.setTextFill(Color.ORANGE);
            } else if (tebakan < angkaRahasia) {
                labelFeedback.setText("▼ Terlalu kecil!");
                labelFeedback.setTextFill(Color.ORANGE);
            } else {
                labelFeedback.setText("✔ Tebakan benar!");
                labelFeedback.setTextFill(Color.GREEN);
                tombolTebak.setText("🔁 Main Lagi");
                tombolTebak.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
                inputTebakan.setDisable(true);
            }
        } catch (NumberFormatException e) {
            labelFeedback.setText("❌ Masukkan angka yang valid!");
            labelFeedback.setTextFill(Color.RED);
        }

        inputTebakan.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
