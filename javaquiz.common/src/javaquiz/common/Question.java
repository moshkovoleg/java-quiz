package javaquiz.common;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question {

    private SimpleIntegerProperty id;
    private SimpleStringProperty text;
    private SimpleStringProperty correctAnswer;
    private SimpleStringProperty description;

    public Question() {
        this.id = new SimpleIntegerProperty();
        this.text = new SimpleStringProperty();
        this.correctAnswer = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
    }

    public String getCorrectAnswer() {
        return correctAnswer.get();
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer.set(correctAnswer);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }
}
