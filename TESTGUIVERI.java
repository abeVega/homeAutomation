import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TESTGUIVERI extends Application {
	
	Boolean adminValid = false;
	ArrayList<Person> ArrPerson = new ArrayList<Person>();
	Person admin = new Person(1, 44127, "Admin", "Admin");

	DataBase data1 = new DataBase(ArrPerson);

	ArrayList<BlackList> ArrBlackList = new ArrayList<BlackList>();
	BlackList bl1 = new BlackList(28745);
	
	ArrayList<WhiteList> ArrWhiteList = new ArrayList<WhiteList>();
	WhiteList wl1 = new WhiteList(44127);
	WhiteList wl2 = new WhiteList(34844);

	DataBaseID dataBL = new DataBaseID(ArrBlackList);
	DataBaseWhiteList dataWL = new DataBaseWhiteList(ArrWhiteList);

	
	String IntPC;
	String GetFN;
	String GetLN;
	int foo;
	int idAdd = 1;

	String IntPC1;
	String GetFN1;
	String GetLN1;
	int foo1;
	String getID3;
	int ID3;
	
	String getID5;
	int ID5;

	public void start(Stage primaryStage) {
		ArrPerson.add(admin);
		ArrBlackList.add(bl1);
		ArrWhiteList.add(wl1);
		ArrWhiteList.add(wl2);
		primaryStage.setTitle(" Home Control Panel ");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));

		BorderPane border = new BorderPane();

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699;");

		Button button1 = new Button(" Admin Panel ");
		button1.setPrefSize(100, 20);

		Button button2 = new Button(" Guest Panel ");
		button2.setPrefSize(100, 20);
		hbox.getChildren().addAll(button1, button2);

		border.setTop(hbox);
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(8);

		Text title = new Text(" Admin Log In Control ");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		Text title2 = new Text(" Enter Password to log in Admin Page ");
		TextField pass = new TextField();

		String adminP = "a";
		Button buttonPass = new Button(" Log In ");
		buttonPass.setPrefSize(100, 20);

		vbox.getChildren().addAll(title2, pass, buttonPass);

		Text login = new Text();

		
		vbox.getChildren().addAll(login);
		border.setLeft(vbox);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				border.setLeft(vbox);
			}
		});

		HBox hboxAdmin = new HBox();
		hboxAdmin.setPadding(new Insets(20, 17, 20, 17));
		hboxAdmin.setSpacing(10);

		Button buttonC1 = new Button(" Create new account ");
		button1.setPrefSize(100, 20);

		Button buttonC2 = new Button(" User summary ");
		button1.setPrefSize(100, 20);

		Button buttonC3 = new Button(" Edit info ");
		button1.setPrefSize(100, 20);

		Button buttonC4 = new Button(" Blacklist passcode ");
		button1.setPrefSize(100, 20);

		Button buttonC5 = new Button(" Delete account ");
		button1.setPrefSize(100, 20);

		Button buttonC6 = new Button(" Whitelist passcode ");
		button1.setPrefSize(100, 20);
		
		Button buttonC7 = new Button(" Panel controller ");
		button1.setPrefSize(100, 20);

		hboxAdmin.getChildren().addAll(buttonC1, buttonC2, buttonC3, buttonC4, buttonC5, buttonC6,buttonC7);
        hboxAdmin.setAlignment(Pos.TOP_CENTER);
		buttonPass.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String getText = pass.getText();
				if (getText.equals(adminP)) {
					adminValid = true;
					login.setText("Login Successful ");
					
					
					
					border.setCenter(hboxAdmin);
				} else {
					adminValid = false;
					login.setText("Invalid Input");					
					
				
				}		
			}
		});

		buttonC1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage newStage = new Stage();
				newStage.setTitle("Add user");
				GridPane rootNode = new GridPane();
				rootNode.setPadding(new Insets(15));
				rootNode.setHgap(10);
				rootNode.setVgap(10);
				rootNode.setAlignment(Pos.TOP_CENTER);
				idAdd++;
				rootNode.add(new Label("PassCode: "), 0, 0);
				TextField PC1 = new TextField();
				rootNode.add(PC1, 1, 0);

				rootNode.add(new Label("First Name:"), 0, 1);
				TextField Fname = new TextField();
				rootNode.add(Fname, 1, 1);

				rootNode.add(new Label("Last Name:"), 0, 2);
				Button addB = new Button("Click to add");
				rootNode.add(addB, 1, 3);

				GridPane.setHalignment(addB, HPos.LEFT);
				TextField Lname = new TextField();
				rootNode.add(Lname, 1, 2);

				Scene stageScene = new Scene(rootNode, 350, 350);
				newStage.setScene(stageScene);
				newStage.show();
				
				addB.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						IntPC = PC1.getText();
						foo = Integer.parseInt(IntPC);
						GetFN = Fname.getText();
						GetLN = Lname.getText();
						final Text actiontarget = new Text();
						rootNode.add(actiontarget, 1, 6);
						actiontarget.setText("Added");
						Person test = new Person(idAdd, foo, GetFN, GetLN);
						ArrPerson.add(test);
						WhiteList wl3 = new WhiteList(foo);
						ArrWhiteList.add(wl3);
						
					}
					
				});
				
			}
		});

		buttonC2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage newStage = new Stage();
				newStage.setTitle("User Info");
				Text text = new Text();
				text.setText(data1.printDatabase());
				int red = 255;
				int green = 0;
				int blue = 0;
				text.setFill(Color.rgb(red, green, blue, 0.9));
				VBox vbox = new VBox(text);
				Scene stageScene = new Scene(vbox, 350, 350);
				newStage.setScene(stageScene);
				newStage.show();
			}
		});

		buttonC3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage newStage = new Stage();
				newStage.setTitle("User Edit Info");
				GridPane rootNode = new GridPane();
				rootNode.setPadding(new Insets(15));
				rootNode.setHgap(10);
				rootNode.setVgap(10);
				rootNode.setAlignment(Pos.TOP_CENTER);

				Text text = new Text();
				text.setText("Enter an ID number   ");
				text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

				rootNode.add(text, 0, 0);
				TextField PC3 = new TextField();
				rootNode.add(PC3, 1, 0);

				Button addB = new Button("Click Here");
				rootNode.add(addB, 2, 0);

				addB.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						rootNode.add(new Label("PassCode: "), 0, 5);
						TextField PC1 = new TextField();
						rootNode.add(PC1, 1, 5);

						rootNode.add(new Label("First Name:"), 0, 6);
						TextField Fname1 = new TextField();
						rootNode.add(Fname1, 1, 6);

						rootNode.add(new Label("Last Name:"), 0, 7);
						TextField Lname1 = new TextField();
						rootNode.add(Lname1, 1, 7);

						Button addB1 = new Button("Click to Edit");
						rootNode.add(addB1, 1, 9);
						GridPane.setHalignment(addB, HPos.LEFT);

						addB1.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								getID3 = PC3.getText();
								ID3 = Integer.parseInt(getID3);
								IntPC1 = PC1.getText();
								foo1 = Integer.parseInt(IntPC1);
								GetFN1 = Fname1.getText();
								GetLN1 = Lname1.getText();
								final Text actiontarget1 = new Text();
								rootNode.add(actiontarget1, 1, 10);
								actiontarget1.setText("Edited");
								data1.changePC(foo1, ID3);
								data1.changeFN(GetFN1, ID3);
								data1.changeLN(GetLN1, ID3);
							}
						});
					}
				});

				Scene stageScene = new Scene(rootNode, 500, 500);
				newStage.setScene(stageScene);
				newStage.show();

			}
		});
		
		buttonC4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage newStage = new Stage();
				newStage.setTitle("BlackList Info");
				GridPane rootNode = new GridPane();
				rootNode.setPadding(new Insets(15));
				rootNode.setHgap(10);
				rootNode.setVgap(10);
				rootNode.setAlignment(Pos.TOP_CENTER);
				
				
				Text text = new Text();
				Button delete = new Button ("Delete");
				Button add = new Button ("Add");
				
				text.setText(dataBL.printDatabaseBL());
				int red = 255;
				int green = 0;
				int blue = 0;
				text.setFill(Color.rgb(red, green, blue, 0.9));
				
				rootNode.add(text, 0, 0);
				rootNode.add(add, 5, 1);
				rootNode.add(delete, 6, 1);
				
				add.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {		
						Stage newStage = new Stage();
						newStage.setTitle("BlackList Info Add");
						GridPane rootNode = new GridPane();
						rootNode.setPadding(new Insets(15));
						rootNode.setHgap(10);
						rootNode.setVgap(10);
						rootNode.setAlignment(Pos.TOP_CENTER);
						Text text = new Text();
						text.setText("Enter passcode to add   ");
						text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

						rootNode.add(text, 0, 0);
						TextField PC3 = new TextField();
						rootNode.add(PC3, 1, 0);

						Button d1 = new Button("Add");
						rootNode.add(d1, 2, 0);
						
						d1.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {								
						getID5 = PC3.getText();
						int ID5 = Integer.parseInt(getID5);
						
						
						BlackList bl3 = new BlackList(ID5);
						ArrBlackList.add(bl3);
						
						final Text actiontarget1 = new Text();
						rootNode.add(actiontarget1, 1, 10);
						actiontarget1.setText("Added");				
							}
						});
						
						Scene stageScene = new Scene(rootNode, 500, 500);
						newStage.setScene(stageScene);
						newStage.show();
					}
				});
				
				
				
				
				
				
				delete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {		
						Stage newStage = new Stage();
						newStage.setTitle("BlackList Info Delete");
						GridPane rootNode = new GridPane();
						rootNode.setPadding(new Insets(15));
						rootNode.setHgap(10);
						rootNode.setVgap(10);
						rootNode.setAlignment(Pos.TOP_CENTER);
						Text text = new Text();
						text.setText("Enter passcode to detele   ");
						text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

						rootNode.add(text, 0, 0);
						TextField PC3 = new TextField();
						rootNode.add(PC3, 1, 0);

						Button d1 = new Button("Delete");
						rootNode.add(d1, 2, 0);
						
						d1.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {								
						getID5 = PC3.getText();
						int ID5 = Integer.parseInt(getID5);
						dataBL.deleteBL(ID5);
						final Text actiontarget1 = new Text();
						rootNode.add(actiontarget1, 1, 10);
						actiontarget1.setText("Deleted");				
							}
						});
						Scene stageScene = new Scene(rootNode, 500, 500);
						newStage.setScene(stageScene);
						newStage.show();
					}
				});
				
				
				
				Scene stageScene = new Scene(rootNode, 500, 500);
				newStage.setScene(stageScene);
				newStage.show();				
			}
		});
		
		buttonC5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage newStage = new Stage();
				newStage.setTitle("Delete User");
				GridPane rootNode = new GridPane();
				rootNode.setPadding(new Insets(15));
				rootNode.setHgap(10);
				rootNode.setVgap(10);
				rootNode.setAlignment(Pos.TOP_CENTER);

				Text text = new Text();
				text.setText("Enter ID number   ");
				text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

				rootNode.add(text, 0, 0);
				TextField PC3 = new TextField();
				rootNode.add(PC3, 1, 0);

				Button d1 = new Button("Delete");
				rootNode.add(d1, 2, 0);
				
				d1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {								
				getID5 = PC3.getText();
				int ID5 = Integer.parseInt(getID5);
				data1.delete(ID5);
				final Text actiontarget1 = new Text();
				rootNode.add(actiontarget1, 1, 10);
				actiontarget1.setText("Deleted");				
					}
				});
				
				Scene stageScene = new Scene(rootNode, 500, 500);
				newStage.setScene(stageScene);
				newStage.show();
				
			}
		});
		
		
		buttonC6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage newStage = new Stage();
				newStage.setTitle("WhiteList Info");
				GridPane rootNode = new GridPane();
				rootNode.setPadding(new Insets(15));
				rootNode.setHgap(10);
				rootNode.setVgap(10);
				rootNode.setAlignment(Pos.TOP_CENTER);
				
				
				Text text = new Text();
				Button delete = new Button ("Delete");
				Button add = new Button ("Add");
				
				text.setText(dataWL.printDatabaseWL());
				int red = 255;
				int green = 0;
				int blue = 0;
				text.setFill(Color.rgb(red, green, blue, 0.9));
				
				rootNode.add(text, 0, 0);
				rootNode.add(add, 0, 1);
				rootNode.add(delete, 1, 1);
				
				add.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {			
						Stage newStage = new Stage();
						newStage.setTitle("WhiteList Info Add");
						GridPane rootNode = new GridPane();
						rootNode.setPadding(new Insets(15));
						rootNode.setHgap(10);
						rootNode.setVgap(10);
						rootNode.setAlignment(Pos.TOP_CENTER);
						Text text = new Text();
						text.setText("Enter passcode to add   ");
						text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

						rootNode.add(text, 0, 0);
						TextField PC3 = new TextField();
						rootNode.add(PC3, 1, 0);

						Button d1 = new Button("Add");
						rootNode.add(d1, 2, 0);
						
						d1.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {								
						getID5 = PC3.getText();
						int ID5 = Integer.parseInt(getID5);
						
						
						WhiteList wl4 = new WhiteList(ID5);
						ArrWhiteList.add(wl4);
						
						final Text actiontarget1 = new Text();
						rootNode.add(actiontarget1, 1, 10);
						actiontarget1.setText("Added");				
							}
						});
						Scene stageScene = new Scene(rootNode, 500, 500);
						newStage.setScene(stageScene);
						newStage.show();
					}
				});
				
				
				
				
				
				
				delete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {		
						Stage newStage = new Stage();
						newStage.setTitle("WhiteList Info Delete");
						GridPane rootNode = new GridPane();
						rootNode.setPadding(new Insets(15));
						rootNode.setHgap(10);
						rootNode.setVgap(10);
						rootNode.setAlignment(Pos.TOP_CENTER);
						Text text = new Text();
						text.setText("Enter passcode to detele   ");
						text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

						rootNode.add(text, 0, 0);
						TextField PC3 = new TextField();
						rootNode.add(PC3, 1, 0);

						Button d1 = new Button("Delete");
						rootNode.add(d1, 2, 0);
						
						d1.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {								
						getID5 = PC3.getText();
						int ID5 = Integer.parseInt(getID5);
						dataWL.deleteWL(ID5);
						final Text actiontarget1 = new Text();
						rootNode.add(actiontarget1, 1, 10);
						actiontarget1.setText("Deleted");				
							}
						});
						Scene stageScene = new Scene(rootNode, 500, 500);
						newStage.setScene(stageScene);
						newStage.show();
					}
				});
				
				
				
				Scene stageScene = new Scene(rootNode, 500, 500);
				newStage.setScene(stageScene);
				newStage.show();							
			}
		});

		Scene scene = new Scene(border, 1500, 800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
