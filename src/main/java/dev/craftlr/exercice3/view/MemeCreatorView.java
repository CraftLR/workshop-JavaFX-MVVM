package dev.craftlr.exercice3.view;

import java.io.File;
import java.io.IOException;

import dev.craftlr.exercice3.viewmodel.MemeViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

public class MemeCreatorView extends StackPane {

    @FXML
    private Canvas memeCanvas;
    @FXML
    private TextField topTextField;
    @FXML
    private TextField bottomTextField;

    private MemeViewModel viewModel;

    public MemeCreatorView(MemeViewModel viewModel) {
        this.viewModel = viewModel;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/dev/craftlr/exercice3/view/MemeViewModel.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new UnsupportedOperationException(exception);
        }
    }

    public void initialize() {
        createBindings();
    }

    private void createBindings() {
        topTextField.textProperty().bindBidirectional(viewModel.topTextProperty());
        bottomTextField.textProperty().bindBidirectional(viewModel.bottomTextProperty());

        viewModel.imageProperty().addListener((obs, oldImage, newImage) -> drawMeme());
    }

    @FXML
    private void handleChooseImage() {
        FileChooser fileChooser = new FileChooser();
        // Configurer fileChooser...
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            viewModel.updateMemeImage(image, viewModel.topTextProperty().get(), viewModel.bottomTextProperty().get());
        }
    }

    private void drawMeme() {
        GraphicsContext gc = memeCanvas.getGraphicsContext2D();
        Image image = viewModel.imageProperty().get();
        gc.clearRect(0, 0, memeCanvas.getWidth(), memeCanvas.getHeight());
        gc.drawImage(image, 0, 0, memeCanvas.getWidth(), memeCanvas.getHeight());
        // Ajouter le texte en haut et en bas
    }

    @FXML
    private void handleSaveMeme() {
        // Implémenter la sauvegarde de l'image
    }
}
