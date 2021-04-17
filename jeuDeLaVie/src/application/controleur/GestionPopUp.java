package application.controleur;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class GestionPopUp implements EventHandler<MouseEvent>{
	
	private Text id;
	private Text posi;
	
	public GestionPopUp(Text t, Text p) {
		id = t;
		posi = p;
	}

	
	
	/*@FXML
    private Text idSprite;
	@FXML
    private Text posiSprite;
	*/

	@Override
	public void handle(MouseEvent event){
		System.out.println(event.getSource());
		Node a = ((Node)event.getSource());
		System.out.println(a.getId());
		String content = a.getId();
		id.setText(content);
		String posiContent = "("+a.getTranslateX()+";"+a.getTranslateY()+")";
		posi.setText(posiContent);
		
	}
//tooltip
}
