package serverClientExample;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
	// IO streams
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Panel p to hold the label and text field
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");
		paneForTextField.setLeft(new Label("Enter a number: "));

		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);

		BorderPane mainPane = new BorderPane();
		// Text area to display contents
		TextArea ta = new TextArea();
		mainPane.setCenter(new ScrollPane(ta));
		mainPane.setTop(paneForTextField);

		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 450, 200);
		primaryStage.setTitle("Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		tf.setOnAction(e -> {
			try {
				// Get the number from the text field
				Integer number;
				try {
					number = Integer.parseInt(tf.getText().trim());
					
					// Throws exception if the number is invalid
					if (number <= 0) {
						throw new IllegalArgumentException(number + " is not a valid number.\n");
					}
					// Send the number to the server
					toServer.writeInt(number);
					toServer.flush();

					// Get result from the server
					int prime = fromServer.readInt();

					// Display to the text area

					if (prime == 1) {
						ta.appendText(number + " is prime.\n");
					} else {
						ta.appendText(number + " is not prime.\n");
					}

				} // catches exception for non-integer inputs and displays message
				catch (NumberFormatException exception) {
					ta.appendText("That is not a valid input. Please input a number \n");
				} // catches exception for zero and negative numbers
				catch (IllegalArgumentException invalidNumber) {
					ta.appendText(invalidNumber.getMessage());
				}

			} catch (IOException ex) {
				System.err.println(ex);
			}
		});

		try {
			// Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);

			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());
			// Create an output stream to send data to the server
			toServer = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ta.appendText(ex.toString() + '\n');
		}
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
