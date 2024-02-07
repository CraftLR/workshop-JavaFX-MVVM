package dev.craftlr.exercice3.viewmodel;

import dev.craftlr.exercice3.model.MemeImage;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class MemeViewModel {
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();
    private StringProperty topTextProperty = new SimpleStringProperty("");
    private StringProperty bottomTextProperty = new SimpleStringProperty("");

    public MemeViewModel(MemeImage memeImage) {
        // TODO
    }

    // Getters pour les propriétés
    public ObjectProperty<Image> imageProperty() {
        return imageProperty;
    }

    public StringProperty topTextProperty() {
        return topTextProperty;
    }

    public StringProperty bottomTextProperty() {
        return bottomTextProperty;
    }

    // Méthodes pour mettre à jour le modèle
    public void updateMemeImage(Image image, String topText, String bottomText) {
        imageProperty.set(image);
        topTextProperty.set(topText);
        bottomTextProperty.set(bottomText);
    }
}
