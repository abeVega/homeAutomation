import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TESTGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	boolean door;
	int fail =0;
	
	@Override
	public void start(Stage primaryStage) {

		ArrayList<BlackList> ArrBlackList = new ArrayList<BlackList>();
		List<String> list = new ArrayList<String>();
		List<String> idCard = new ArrayList<String>();

		primaryStage.setTitle(" Home Automation ");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));

		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label(" Tap the Card");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		


		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);

		Text t1 = new Text();			
				grid.add(t1, 1, 8);	

		grid.add(hbBtn, 1, 2);
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				fail++;	
				
				String getText = userTextField.getText();
				System.out.println(getText);

				list.add(getText);
				

				for (String line : list) {
					String[] res = line.split(",");
					idCard.add(res[1]);

				}

				List<Integer> listID = new ArrayList<Integer>();
				for (String s : idCard) {
					listID.add(Integer.valueOf(s));
				}
				// accept ids
				int[] numb = { 34844, 44127, 34543 };
				List<Integer> intCheckList = new ArrayList<Integer>();
				for (int i = 0; i < numb.length; i++) {
					intCheckList.add(numb[i]);
				}

				for (Integer igr : listID) {
					if (intCheckList.contains(igr)) {
						t1.setText("You Have Logged In Successfully");	
						String musicFile = "success.mp3";     

						Media sound = new Media(new File(musicFile).toURI().toString());
						MediaPlayer mediaPlayer = new MediaPlayer(sound);
						mediaPlayer.play();
						door = true;
					} else {					
						t1.setText("login failure, try again" );
						String musicFile = "fail.mp3";     

						Media sound = new Media(new File(musicFile).toURI().toString());
						MediaPlayer mediaPlayer = new MediaPlayer(sound);
						mediaPlayer.play();
						door = false;
						if( fail == 3){
							t1.setText("System paused");
							  userTextField.setDisable(true);
							 
						}
					}
				}
				
				if (door == false) {
					for (Integer igr2 : listID) {
						if (!intCheckList.contains(igr2)) {
							BlackList test = new BlackList(igr2);
							ArrBlackList.add(test);
						}
					}
				}
				
				if(fail == 3){
					  fail = 0;
					 Task<Void> sleeper = new Task<Void>() {
				            @Override
				            protected Void call() throws Exception {
				                try {
				                    Thread.sleep(5000);
				                  
				                } catch (InterruptedException e) {
				                }
				                return null;
				            }
				        };
				        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
				            @Override
				            public void handle(WorkerStateEvent event) {
				            	
				            	
				            	System.out.println(fail);
				            	
				            	t1.setText("Please tap the card again");	
				            }
				            
				        });
				        new Thread(sleeper).start();	
				       
				        if(fail == 0){
				        	userTextField.setDisable(false);
				        }
				}
				
				
				
	
				if (door == true) {
					Button Veri = new Button(" Control Panel ");
					HBox VeriB = new HBox(10);
					VeriB.setAlignment(Pos.BOTTOM_LEFT);
					VeriB.getChildren().add(Veri);
					grid.add(VeriB, 2, 8);
					
					
					Veri.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {

							TESTGUIVERI guiVeri = new TESTGUIVERI();

							guiVeri.start(primaryStage);
						}
					});
				}

			}
		});

		
		
		
		
		Scene scene = new Scene(grid, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
}