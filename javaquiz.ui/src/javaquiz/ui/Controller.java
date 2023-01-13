package javaquiz.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javaquiz.common.Answer;
import javaquiz.common.Question;
import javaquiz.db.Datasource;

import java.time.LocalDate;

public class Controller {
    ObservableList<Question> questionList;
    ObservableList<Answer> answerList;
    int numberOfQuestions;
    int count = 0;
    int goal = 0;
    @FXML
    Label questionLabel;
    @FXML
    Label resultLabel;
    @FXML
    ListView<Answer> answerListView;
    @FXML
    Button checkButton;
    @FXML
    Button nextButton;

    public void initialize() {
        questionList = FXCollections.observableArrayList(Datasource.getInstance().queryQuestions(Datasource.ORDER_BY_NONE));
        numberOfQuestions = questionList.size();
        resultLabel.setVisible(true);
        answerListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        updateQuestion();
    }

    @FXML
    public void checkAnswer() {
        final Answer answer = answerListView.getSelectionModel().getSelectedItem();
//        setColorToText();
        if (answer == null) {
            System.out.println("Ответ не выбран");
            return;
        }
        if (answer.getText().equals(questionList.get(count).getCorrectAnswer())) {
            resultLabel.setText("Это правильный ответ: " + "\n" +
                    questionList.get(count).getDescription());

            goal++;
        } else {
            resultLabel.setText("Это не правильный ответ: " + "\n" +
                    questionList.get(count).getDescription());
        }
        count++;
        checkButton.setDisable(true);
        nextButton.setDisable(false);

    }

    @FXML
    public void updateQuestion() {
        checkButton.setDisable(false);
        nextButton.setDisable(true);
        resultLabel.setText("");
        if (count < numberOfQuestions) {
            answerList = FXCollections.observableArrayList(Datasource.getInstance().queryAnswersForQuestionId(count + 1));
            questionLabel.setText(questionList.get(count).getText());
            answerListView.setItems(answerList);
        } else {
            answerListView.setVisible(false);
            questionLabel.setVisible(false);
            checkButton.setDisable(true);
            nextButton.setDisable(true);
            resultLabel.setText("Result = " + goal + " of " + numberOfQuestions + "\n\t"
                    + goal * 100 / numberOfQuestions + "%");
        }
    }

    public void setColorToText() {
        answerListView.setCellFactory(new Callback<ListView<Answer>, ListCell<Answer>>() {
            @Override
            public ListCell<Answer> call(ListView<Answer> answerListView) {
                ListCell<Answer> listCell  = new ListCell<>() {

                    @Override
                    protected void updateItem(Answer item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) {
                            setText(null);
                        } else {
                            setText(item.getText());
                            if(item.toString().equals(questionList.get(count).getCorrectAnswer())) {
                                setTextFill(Color.GREEN);
                            } else {
                                setTextFill(Color.RED);
                            }

                        }
                    }
                };
                return listCell;
            }
        });
    }

}
