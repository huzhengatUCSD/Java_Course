package ch14;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class DisplayClock extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a clock and a label
    ClockPane clock = new ClockPane();
    //String timeString = clock.getHour() + ":" + clock.getMinute() 
    //  + ":" + clock.getSecond();
    Label lblCurrentTime = new Label(String.format("%tr%n",new java.util.Date()));
    
    // Place clock and label in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(lblCurrentTime);
    BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

    // Create a handler for changing text
    EventHandler<ActionEvent> eventHandler = e -> {
    	clock.setCurrentTime();
    	lblCurrentTime.setText(String.format("%tr%n",new java.util.Date()));
    };

    // Create an animation for alternating text
    Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
//
//    primaryStage.resizableProperty().addListener(new ChangeListener<Boolean>() {
//      @Override
//      public void changed(ObservableValue<? extends Boolean> arg0,
//          Boolean arg1, Boolean arg2) {
//        System.out.println("Not supported yet.");
//      }
//    });
//    
//    primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
//      @Override
//      public void changed(ObservableValue<? extends Number> arg0,
//          Number arg1, Number arg2) {
//        clock.setW(primaryStage.widthProperty().getValue());
//      }
//    });
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
