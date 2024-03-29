package dev.craftlr.exercice1.viewmodel;

import dev.craftlr.exercice1.model.MessageModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MessageViewModel {
    private StringProperty messageProperty;

    public MessageViewModel(MessageModel model) {
        messageProperty = new SimpleStringProperty(model.getMessage());
    }

    public StringProperty messageProperty() {
        return messageProperty;
    }
}
