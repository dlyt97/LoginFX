package application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class sec_win {

	static String userString = "user";
	static String passString = "user123";
	
	static Stage oneStage=new Stage();
	
	static void alertbox(String one, String two, String three) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText(one);
		alert.setContentText(two);
		alert.showAndWait().ifPresent(rs -> {
			if (rs == ButtonType.OK) {
				System.out.println(three);
			}
		});
	}
	
	private static String title_second = "User: " + userString;

	private static HBox hBox = new HBox(20);
	private static Scene newScene = new Scene(hBox, 500, 500);
	private static Stage stage = new Stage();

	static void login_second_window() {
		dc.alertbox("Login - Successfull !!!", "User: " + userString, "Login - Successfull !!!");
		
		Button logout=new Button("Logout");{
			logout.setStyle("-fx-background-color:black");
			logout.setTextFill(Color.WHITE);
			logout.setOnMouseEntered(e->{
				logout.setScaleX(1.2);
				logout.setScaleY(1.2);
				logout.setStyle("-fx-background-color: linear-gradient(from 5% 5% to 100% 100%, #0069c0, #2196f3);");
			});
			logout.setOnMouseExited(e->{
				logout.setScaleX(1.0);
				logout.setScaleY(1.0);
				logout.setStyle("-fx-background-color:black");
			});
			logout.setOnAction(e->{
				Platform.exit();
			});
		}
		
		hBox.setAlignment(Pos.TOP_LEFT);
		hBox.setSpacing(20);
		hBox.setPadding(new Insets(20));
		hBox.getChildren().addAll(logout);
		hBox.setStyle("-fx-background-color:black");
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle(title_second);
		stage.getIcons().add(new Image("application/login.png"));
		stage.setScene(newScene);
		stage.show();
		
	}
	
}
