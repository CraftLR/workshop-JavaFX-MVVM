package dev.craftlr.exercice2;

import dev.craftlr.exercice2.model.PokemonService;
import dev.craftlr.exercice2.view.PokemonView;
import dev.craftlr.exercice2.viewmodel.PokemonViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PokemonApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            PokemonService service = new PokemonService();
            PokemonViewModel viewModel = new PokemonViewModel(service);
            StackPane root = new PokemonView(viewModel);

            stage.setTitle("Hello Pokémon");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
