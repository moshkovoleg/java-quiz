package javaquiz.common;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Answer {

    private SimpleIntegerProperty id;
    private SimpleIntegerProperty questionId;
    private SimpleStringProperty text;

    @Override
    public String toString() {
        return  getText();
    }

    public Answer() {
        this.id = new SimpleIntegerProperty();
        this.questionId = new SimpleIntegerProperty();
        this.text = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    public int getQuestionId() {
        return questionId.get();
    }

    public void setQuestionId(int questionId) {
        this.questionId.set(questionId);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }


}
