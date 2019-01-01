package quiz;

import com.shellucas.data.utils.Continent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
        primaryStage.setTitle("Countries And Capitals");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        try {
//            extractFiles();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        launch(args);
    }

//    private static boolean copy(InputStream source , String destination) {
//        if (new File(destination).exists()) return true;
//
//        try {
//            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ex) {
//            return false;
//        }
//
//        return true;
//
//    }

//    private static void extractFiles() throws IOException {
//        File destination = new File(FileSystems.getDefault().getPath("capitals").toAbsolutePath().toString());
//        if (!destination.mkdir()) {
//            if (!destination.isDirectory()) {
//                System.out.println("There is a file with the same name.");
//            }
//        }
//
//        for (Continent continent : Continent.values()) {
//            URL inputUrl = Main.class.getResource("/capitals/capitals_" + continent.name().toLowerCase());
//            if (!copy(inputUrl.openStream(), destination.getAbsolutePath() + "/capitals_" + continent.name().toLowerCase())) {
//                System.out.println("File could not be extracted");
//                System.exit(-1);
//            }
//        }
//    }
}
