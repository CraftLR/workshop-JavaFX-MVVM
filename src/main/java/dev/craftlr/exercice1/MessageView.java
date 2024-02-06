package dev.craftlr.exercice1;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MessageView extends StackPane {
    @FXML
    private Label messageLabel;

    private MessageViewModel viewModel;

    public MessageView(MessageViewModel viewModel) {
        this.viewModel = viewModel;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/dev/craftlr/exercice1/MessageView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new UnsupportedOperationException(exception);
        }
    }

    @FXML
    public void initialize() {
        createBindings();
    }

    private void createBindings() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
