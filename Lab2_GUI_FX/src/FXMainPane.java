


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

    private DataManager dataManager;
    private Button button1, button2, button3, button4, button5;
    private Label label;
    private TextField textField;
    private HBox hbox1, hbox2;

    FXMainPane() {
        button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");

        label = new Label("Feedback: ");
        textField = new TextField();

        hbox1 = new HBox();
        hbox2 = new HBox();

        dataManager = new DataManager();

        button1.setOnAction(new ButtonHandler("Hello"));
        button2.setOnAction(new ButtonHandler("Howdy"));
        button3.setOnAction(new ButtonHandler("Chinese"));
        button4.setOnAction(new ButtonHandler("Clear"));
        button5.setOnAction(new ButtonHandler("Exit"));

        hbox2.getChildren().addAll(label, textField);
        hbox1.getChildren().addAll(button1, button2, button3, button4, button5);

        this.getChildren().addAll(hbox1, hbox2);
        
        Insets inset = new Insets(10); // You can adjust the insets as needed

        HBox.setMargin(button1, inset);
        HBox.setMargin(button2, inset);
        HBox.setMargin(button3, inset);
        HBox.setMargin(button4, inset);
        HBox.setMargin(button5, inset);

        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        private String buttonText;

        public ButtonHandler(String buttonText) {
            this.buttonText = buttonText;
        }

        @Override
        public void handle(ActionEvent event) {
            if ("Hello".equals(buttonText)) {
                String response = dataManager.getHello();
                textField.setText(response);
            } else if ("Howdy".equals(buttonText)) {
                String response = dataManager.getHowdy();
                textField.setText(response); 
            } else if ("Chinese".equals(buttonText)) {
                String response = dataManager.getChinese();
                textField.setText(response);
            } else if ("Clear".equals(buttonText)) {
                textField.setText("");
            } else if ("Exit".equals(buttonText)) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}