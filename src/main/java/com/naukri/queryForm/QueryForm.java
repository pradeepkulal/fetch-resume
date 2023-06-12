package com.naukri.queryForm;

import com.naukri.lib.utils.Log;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class QueryForm extends Application{


    public static String email;
    public static String password;
    public static String query;
    public static String minExperience;
    public static String maxExperience;
    public static String locations;
    public static String compareSkills;
    private Label errorLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(30);
        gridPane.setVgap(30);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPrefWidth(800);
        emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailField, 1, 0);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        Label queryLabel = new Label("Query:");
        TextField queryField = new TextField();
        queryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(queryLabel, 0, 2);
        gridPane.add(queryField, 1, 2);

        Label minExperienceLabel = new Label("Minimum Experience:");
        TextField minExperienceField = new TextField();
        minExperienceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(minExperienceLabel, 0, 3);
        gridPane.add(minExperienceField, 1, 3);

        Label maxExperienceLabel = new Label("Maximum Experience:");
        TextField maxExperienceField = new TextField();
        maxExperienceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(maxExperienceLabel, 0, 4);
        gridPane.add(maxExperienceField, 1, 4);

        Label locationLabel = new Label("Locations:");
        TextField locationsField = new TextField();
        locationLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(locationLabel, 0, 5);
        gridPane.add(locationsField, 1, 5);

        Label compareSkillsLabel = new Label("CompareSkills:");
        TextField compareSkillsField = new TextField();
        compareSkillsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(compareSkillsLabel, 0, 6);
        gridPane.add(compareSkillsField, 1, 6);

        Label noticePriodLabel = new Label("NoticePeriod:");

        // Create multiple checkboxes
        CheckBox checkBox1 = new CheckBox("Checkbox 1");
        CheckBox checkBox2 = new CheckBox("Checkbox 2");
        CheckBox checkBox3 = new CheckBox("Checkbox 3");

        // Add checkboxes to the layout container
        noticePriodLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(noticePriodLabel, 0, 7);
        gridPane.add(checkBox1, 0, 0);
        gridPane.add(checkBox2, 1, 0);
        gridPane.add(checkBox3, 2, 0);


        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(errorLabel , 1, 15);

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size:30");
        submitButton.setOnAction(event -> {

            if (emailField.getText().isEmpty()) {
                showError("Please enter a email");
                return;
            }

            if (passwordField.getText().isEmpty()) {
                showError("Please enter a password");
                return;
            }

            if (queryField.getText().isEmpty()) {
                showError("Please enter a query");
                return;
            }

            if (compareSkillsField.getText().isEmpty()) {
                showError("Please enter a compare skills");
                return;
            }

            clearError();

            email = emailField.getText();
            password = passwordField.getText();
            query = queryField.getText();
            minExperience = minExperienceField.getText();
            maxExperience = maxExperienceField.getText();
            locations = locationsField.getText();
            compareSkills = compareSkillsField.getText();


            Log.info("Email : " + email);
            Log.info("Password : " + password);
            Log.info("Query : " + query);
            Log.info("MinimumExperience : " + minExperience);
            Log.info("MaximumExperience : " + maxExperience);
            Log.info("Locations : " + locations);
            Log.info("CompareSkills : " + compareSkills);

            primaryStage.close();
        });


        gridPane.add(submitButton, 1, 15);

        Scene scene = new Scene(gridPane, 1200, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showError(String message) {
        errorLabel.setText(message);
    }

    private void clearError() {
        errorLabel.setText("");
    }

    public static void launchForm(){
        launch();
    }
}
