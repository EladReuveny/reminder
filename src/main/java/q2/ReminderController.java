/*
 * @package javafx.maman14q2
 *
 * This class allows controlling the Reminder's app.
 *
 * @author Elad Reuveny
 */
package q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class ReminderController {
    @FXML
    private ComboBox<String> dayC;

    @FXML
    private ComboBox<String> monthC;

    @FXML
    private ComboBox<String> yearC;

    @FXML
    private TextArea text;

    @FXML
    private VBox vBox;

    private Reminder reminder = new Reminder();

    /**
     * Initializes the controller.
     * This method is automatically called when the controller is initialized.
     * It initializes the ComboBoxes and loads data from a file.
     */
    public void initialize() {
        initComboBox();
        loadFromFile();
    }

    /**
     * Handles the event when the "Add/Update/Save" button is pressed.
     * Retrieves the selected date from the ComboBoxes and the text from the TextArea.
     * Adds a reminder using the Reminder instance.
     * Calls the addClosingEvent() method.
     *
     * @param event The action event triggered by the "Add" button.
     */
    @FXML
    void addPressed(ActionEvent event) {
        Date date = new Date(Integer.parseInt(dayC.getValue()),
                                                  Integer.parseInt(monthC.getValue()),
                                                  Integer.parseInt(yearC.getValue()));
        reminder.addReminder(date, text.getText());

        addClosingEvent();
    }

    /**
     * Handles the event when the "Show" button is pressed.
     * Retrieves the selected date from the ComboBoxes and gets the reminder text for that date from the Reminder instance.
     * Sets the reminder text in the TextArea.
     *
     * @param event The action event triggered by the "Show" button.
     */
    @FXML
    void showPressed(ActionEvent event) {
        Date date = new Date(Integer.parseInt(dayC.getValue()),
                Integer.parseInt(monthC.getValue()),
                Integer.parseInt(yearC.getValue()));
        text.setText(reminder.getReminder(date));
    }

    /**
     * Initializes the ComboBoxes for day, month, and year.
     * Add necessary values to the ComboBoxes.
     * This method should be called during initialization.
     */
    private void initComboBox() {
        final int DAYS = 31, MONTHS = 12, START_YEAR = 2018, END_YEAR = 2023;

        for (int i = 1; i <= DAYS; i++) {
            dayC.getItems().add(Integer.toString(i));
        }
        dayC.setValue("1");

        for (int i = 1; i <= MONTHS; i++) {
            monthC.getItems().add(Integer.toString(i));
        }
        monthC.setValue("1");

        for (int i = START_YEAR; i <= END_YEAR; i++) {
            yearC.getItems().add(Integer.toString(i));
        }
        yearC.setValue(Integer.toString(END_YEAR));
    }

    /**
     * Loads reminder data from a file.
     * This method should be called during initialization to populate the reminders.
     */
    private void loadFromFile() {

        File file = getFile();

        if (file != null) {
            try {

                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fi);
                reminder = (Reminder)ois.readObject();
                ois.close();
                fi.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves the reminder data to a file.
     * This method is called when the application is closed.
     * It writes the reminder object to the selected file using serialization.
     */
    private void saveToFile() {
        File file = getFile();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(reminder);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a closing event to the application window.
     * This method should be called after adding a reminder to update the UI or perform any other necessary actions.
     * It sets the closing event to save the reminder data to a file.
     */
    private void addClosingEvent() {
        Stage stage = (Stage) vBox.getScene().getWindow();
        stage.setOnCloseRequest(windowEvent -> {
            saveToFile();
        });
    }

    /**
     * Opens a file chooser dialog to select a file.
     *
     * @return The selected file.
     */
    private File getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        fileChooser.setInitialDirectory(new File("."));
        return fileChooser.showOpenDialog(null);
    }
}