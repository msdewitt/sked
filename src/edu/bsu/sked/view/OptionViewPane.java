package edu.bsu.sked.view;

import edu.bsu.sked.model.UserName;
import edu.bsu.sked.model.UserName.Builder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class OptionViewPane implements NavigationTarget {
	private final Image icon;
	private static final String OPTIONS = "Options";
	private final GridPane pane = new GridPane();
	TextField firstName = new TextField();
	TextField lastName = new TextField();
	Label firstNameLabel = new Label();
	Label lastNameLabel = new Label();
	
	public OptionViewPane(){
		super();
		icon = configureIcon();
		setUpPane();
	}

	private Image configureIcon() {
		try {
			return Assets.getImageFromAssetName("options.png");
		} catch (Exception e) {
			return null; 
		}
	}
	
	private void setUpPane() {
		Button loginButton = new Button();
		loginButton.setText("Save");
		firstNameLabel.setText("First Name:");
		lastNameLabel.setText("Last Name:");
		pane.add(firstNameLabel, 1, 0);
		pane.add(firstName, 2,0);
		pane.add(lastNameLabel, 1,1);
		pane.add(lastName, 2,1);
		pane.add(loginButton, 3, 0);
		loginButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				new Builder()
;
				
				Label name = new Label();
				UserName userName = new UserName(new Builder());
				userName.setFirstName(firstName.getText());
				userName.setLastName(lastName.getText());
				Button logoutButton = new Button();
				pane.add(name, 0, 0);
				name.setText(getFullUserName(userName));
				pane.getChildren().remove(firstName);
				pane.getChildren().remove(lastName);
				pane.getChildren().remove(lastNameLabel);
				pane.getChildren().remove(firstNameLabel);
				pane.getChildren().remove(loginButton);
				logoutButton.setText("Edit");
				pane.add(logoutButton, 1, 2);
				logoutButton.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						pane.getChildren().remove(logoutButton);
						pane.getChildren().remove(name);
						setUpPane();
						
					}
					
				});
			
				
			}
			
		});
		
		
		
	}
	
	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getLabel() {
		return OPTIONS;
	}
	
	@Override
	public GridPane getNode() {
		return pane;
	}

	private String getFullUserName(UserName userName){
		if(firstName.getText().isEmpty() && lastName.getText().isEmpty()){
			return userName.getFullName();
		}else{
			return "Unidentified user";
		}
	}
}
