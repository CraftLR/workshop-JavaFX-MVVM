package dev.craftlr.exercice3;

import dev.craftlr.exercice3.model.MemeImage;
import dev.craftlr.exercice3.view.MemeCreatorView;
import dev.craftlr.exercice3.viewmodel.MemeViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MemeGeneratorApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Image kermitDrinkingTea = new Image(getClass().getResourceAsStream("/assets/kermit.png"));
            String topText = "I WOULD ASK WHY PEOPLE ARE EVEN GINVING TEA TO FROGS";
            String bottomText = "BUT THAT'S NONE OF MY BUSINESS";

            MemeImage memeImage = new MemeImage(kermitDrinkingTea,
                    topText,
                    bottomText);

            MemeViewModel viewModel = new MemeViewModel(memeImage);

            StackPane root = new MemeCreatorView(viewModel);

            stage.setTitle("Hello Mème");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}