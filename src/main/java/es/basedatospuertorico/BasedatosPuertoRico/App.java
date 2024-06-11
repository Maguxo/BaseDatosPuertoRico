package es.basedatospuertorico.BasedatosPuertoRico;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import es.basedatospuertorico.controller.*;
/**
 * Hello world!
 *
 */
public class App extends Application
{
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root=FXMLLoader.load(getClass().getResource("/es/basedatospuertorico/view/Main.fxml"));
			Scene scene = new Scene(root);
			
			Image ima= new Image("es/basedatospuertorico/imagenes/DB.png");
			primaryStage.getIcons().add(ima);

			scene.getStylesheets().add(getClass().getResource("/es/basedatospuertorico/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
}}
	
	public static void main(String[] args) {
		launch(args);
 }
}
