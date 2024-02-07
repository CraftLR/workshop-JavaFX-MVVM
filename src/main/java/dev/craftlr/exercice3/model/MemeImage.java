package dev.craftlr.exercice3.model;

import javafx.scene.image.Image;

public class MemeImage {
    private Image image;
    private String topText;
    private String bottomText;

    public MemeImage(Image image, String topText, String bottomText) {
        this.image = image;
        this.topText = topText;
        this.bottomText = bottomText;
    }

    // Getters et setters
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }
}
