/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package sampleejercicio3addressapp;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author juanmaguerra0
 */
public class SampleEjercicio3AddressApp extends Application  {
    
      private Stage stage;
    
      private BorderPane RootLayout;
    
      private ObservableList<Person> personData = FXCollections.observableArrayList();

      
      public void start(Stage stage) throws Exception {
        
          this.stage = stage;
          
          this.stage.setTitle("AddressApp");
          
          initRootLayout();
          
          showPersonOverview();
          
          
          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void initRootLayout() {

        try{
        
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(SampleEjercicio3AddressApp.class.getResource("RootLayout.fxml"));
        
        RootLayout = (BorderPane) loader.load();
                
        Scene scene = new Scene(RootLayout);
        
        this.stage.setScene(scene);
        
        this.stage.show();
        
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showPersonOverview() {

         try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SampleEjercicio3AddressApp.class.getResource("FXMLDocument.fxml"));
            
             AnchorPane personOverview = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            RootLayout.setCenter(personOverview);
            
             // Give the controller access to the main app.
            FXMLDocumentController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
    
    public Stage getStage() {
		return stage;
	}
    
    public SampleEjercicio3AddressApp() {
		// Add some sample data
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}
    
    public ObservableList<Person> getPersonData() {
		return personData;
	}
   
    
}
