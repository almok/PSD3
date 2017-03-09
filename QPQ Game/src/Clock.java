import javafx.animation.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.WritableIntegerValue;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/*public class CountDownTimer extends Initializable {
  //@Override public void start(final Stage stage) throws Exception {
    final CountDown countdown = new CountDown(10);
    final CountDownLabel countdownLabel  = new CountDownLabel(countdown);

    final Button countdownButton = new Button("  Start  ");
    final Button stopButton = new Button("  Stop   ");
    countdownButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
        countdownButton.setText("Restart");
        countdown.start();
      }
    });
    stopButton.setOnAction(new EventHandler<ActionEvent>() {
    	@Override public void handle(ActionEvent t){
    		countdown.stop();
    	}
    });

   
    public void display(Button button) throws IOException{
        VBox layout = new VBox(10);
        layout.getChildren().addAll(countdownLabel, countdownButton, stopButton);
        layout.setAlignment(Pos.BASELINE_RIGHT);
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 20; -fx-font-size: 20;");
        stage.setScene(new Scene(layout));
        stage.show();
    }
  
}

class CountDownLabel extends Label {
  public CountDownLabel(final CountDown countdown) {
		  textProperty().bind(Bindings.format("Mins: %02d , Seconds: %02d", countdown.getMinsLeft(), countdown.getSecondsLeft()));
  }
}

class CountDown {
  private ReadOnlyIntegerWrapper secondsLeft;
  private ReadOnlyDoubleWrapper secondsDouble;
  private final Timeline timelineSec;
  private final Timeline timelineMin;
  private ReadOnlyIntegerWrapper minsLeft;
  private ReadOnlyDoubleWrapper minsDouble;

  public ReadOnlyIntegerProperty getSecondsLeft() {
    return secondsLeft.getReadOnlyProperty();
  }
  public ReadOnlyIntegerProperty getMinsLeft(){
	  return minsLeft.getReadOnlyProperty();
  }

  public CountDown(final int time) {
    secondsLeft = new ReadOnlyIntegerWrapper(60);
    secondsDouble = new ReadOnlyDoubleWrapper(60);
    minsLeft = new ReadOnlyIntegerWrapper(time);
    minsDouble = new ReadOnlyDoubleWrapper(time);
    

    timelineSec = new Timeline(
    		new KeyFrame(Duration.ZERO,
    				new KeyValue(secondsDouble,60)
            ),
    		new KeyFrame(Duration.seconds(60),
    				new KeyValue(secondsDouble,0))
    		);
    timelineSec.setCycleCount(time);
    
    timelineMin = new Timeline(
    		new KeyFrame(Duration.ZERO,
    		  new KeyValue(minsDouble, time)
          ),
    		new KeyFrame(Duration.minutes(time),
    		  new KeyValue(minsDouble, 0))
    );
    		
    secondsDouble.addListener(new InvalidationListener() {
      @Override public void invalidated(Observable o) {
        secondsLeft.set((int) Math.ceil(secondsDouble.get()));
      }
    });
    minsDouble.addListener(new InvalidationListener() {
        @Override public void invalidated(Observable o) {
          minsLeft.set((int) Math.ceil(minsDouble.get()));
        }
      });
  }

  public void start() {
    timelineSec.playFromStart();
    timelineMin.playFromStart();
  }
  public void stop() {
	timelineSec.pause();
	timelineMin.pause();
  }
}*/

public class Clock {
    private long startTime;
    private long skippedTime = 0L;
    private long addedTime = 0L;
    private long pauseTime;
    private boolean paused = false;

    /**
     * Constructs a new clock starting 0ms
     * */
    Clock(){
        startTime = System.currentTimeMillis();
    }

    /**
     * Constructs a new clock starting at the specified time
     * */
    Clock(long time) {
        startTime = System.currentTimeMillis();
        addedTime += time;
    }

    /**
     * Gets the current time in milliseconds
     * @return The time in ms since the timer was started
     * */
    public long getCurrentTime(){
        if (paused){
            return pauseTime - startTime + addedTime - skippedTime;
        }
        long currentSysTime = System.currentTimeMillis();
        return currentSysTime - startTime + addedTime - skippedTime;
    }

    /**
     * Pauses the timer
     * */
    public void pause(){
        if (!paused) {
            pauseTime = System.currentTimeMillis();
            paused = true;
        }
    }

    /**
     * Resumes the timer
     * */
    public void resume(){
        if (paused){
            skippedTime += System.currentTimeMillis() - pauseTime;
            paused = false;
        }
    }

}