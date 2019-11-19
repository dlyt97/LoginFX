package application;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class dc extends sec_win {}

public class Main extends Application {

	private int w = 400, h = 400;

	private String button_style = "-fx-background-color:silver;" + "-fx-font-family:Calibri;";
	
	static TextField user = new TextField();
	{
		user.setShape(new Circle(2.0));
		user.setStyle("-fx-background-color: linear-gradient(from 5% 5% to 100% 100%, #0069c0, #2196f3);");
		user.setPromptText("Input username...");
		user.setMaxWidth(200);
		user.isDisabled();
	}
	static PasswordField pass = new PasswordField();
	{
		pass.setShape(new Circle(2.0));
		pass.setStyle("-fx-background-color: linear-gradient(from 5% 5% to 100% 100%, #0069c0, #2196f3);");
		pass.setPromptText("Input password...");
		pass.setMaxWidth(200);
		pass.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case ENTER:
				if (user.getText().equals(dc.userString) && pass.getText().equals(dc.passString)) {
					dc.oneStage.close();
					dc.login_second_window();
				} else if (!user.getText().equals(dc.userString) && !pass.getText().equals(dc.passString)) {
					dc.alertbox("Login - Failed !!!", "User: " + user.getText(), "Login - Failed !!!");
				}
				break;
			default:
				break;
			}
		});
	}

	private Button login = new Button("Login");
	{
		login.setShape(new Circle(2.0));
		login.setTextFill(Color.WHITE);
		login.setStyle("-fx-background-color: black;");
		login.setMaxWidth(150 / 2);
		login.setOnMouseEntered(e -> {
			login.setScaleX(1.1);
			login.setScaleY(1.1);
			login.setStyle("-fx-background-color: linear-gradient(from 5% 5% to 100% 100%, #0069c0, #2196f3);"
					+ "-fx-font-weight:Bold;");
		});
		login.setOnMouseExited(e -> {
			login.setScaleX(1.0);
			login.setScaleY(1.0);
			login.setStyle("-fx-background-color: black;-fx-font-weight:Normal;");
		});
		login.setOnAction(e -> {
			if (user.getText().equals(dc.userString) && pass.getText().equals(dc.passString)) {
				dc.oneStage.close();
				dc.login_second_window();
			}
		});
	}
	private Button exit = new Button("Exit");
	{
		exit.setShape(new Circle(2.0));
		exit.setTextFill(Color.WHITE);
		exit.setStyle("-fx-background-color: black;");
		exit.setMaxWidth(150 / 2);
		exit.setOnMouseEntered(e -> {
			exit.setScaleX(1.1);
			exit.setScaleY(1.1);
			exit.setStyle("-fx-background-color: linear-gradient(from 5% 5% to 100% 100%, #0069c0, #2196f3);"
					+ "-fx-font-weight:Bold;");
		});
		exit.setOnMouseExited(e -> {
			exit.setScaleX(1.0);
			exit.setScaleY(1.0);
			exit.setStyle("-fx-background-color: black;-fx-font-weight:Normal;");
		});
		exit.setOnAction(e -> {
			Platform.exit();
		});
	}
	
	void fade(Node node, Double start, Double end, Integer duration) {
		FadeTransition fadeTransition = new FadeTransition();
		{
			fadeTransition.setDuration(javafx.util.Duration.millis(duration));
			fadeTransition.setNode(node);
			fadeTransition.setFromValue(start);
			fadeTransition.setToValue(end);
			fadeTransition.setAutoReverse(true);
			fadeTransition.play();
		}
	}

	private VBox root = new VBox(20, user, pass, login, exit);
	{
		root.setAlignment(Pos.CENTER);
		root.setStyle(button_style);
		root.setScaleX(1.2);
		root.setScaleY(1.2);
		root.setStyle("-fx-background-color: black;");
	}

	private Scene scene = new Scene(root, w, h);
	{
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	}

	@Override
	public void start(Stage stg) {
		
		dc.oneStage = stg;

		fade(user, 0.1, 1.0, 1000);
		fade(pass, 0.1, 1.0, 1000);
		fade(login, 0.0, 1.0, 3500);
		fade(exit, 0.0, 1.0, 3500);

		try {
			dc.oneStage.initStyle(StageStyle.UNDECORATED);

			dc.oneStage.setScene(scene);
			dc.oneStage.setTitle("Login");
			dc.oneStage.show();
			dc.oneStage.getIcons().add(new Image("application/login.png"));
			dc.oneStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Scena nece da se prikaze !!!");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
