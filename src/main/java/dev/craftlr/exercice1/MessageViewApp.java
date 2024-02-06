package dev.craftlr.exercice1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MessageViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            MessageModel model = new MessageModel();
            MessageViewModel viewModel = new MessageViewModel(model);
            StackPane root = new MessageView(viewModel);

            stage.setTitle("Hello MVVM");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
