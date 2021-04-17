package application.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import applicationV1.modele.Acteur;
import applicationV1.modele.Environnement;
import applicationV1.modele.Loup;
import applicationV1.modele.Mouton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class controleur implements Initializable {
	private Environnement place;
	//intparseint
	//public static  int compteur = 0;//pour match les sprites & acteurs
	
	 @FXML
	 private TextField tourNbr;//à faire
	 
	 @FXML
	    private Label nbrTours;
	 
	 @FXML
	    private RadioButton loup;
	 @FXML
	    private RadioButton mouton;

	 @FXML
	   private TextField nbAnimaux;
	 @FXML
	    private ToggleGroup groupe1;
	 @FXML
	    private Pane panneauDeJeu;
	 @FXML
	    private Text idSprite;

	 @FXML
	    private Text posiSprite;
	 
	 
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		place = new Environnement(200,200);
		
		//BINDER METHODE
		//nbrTours.textProperty().bind(place.getNbrToursProperty().asString());
		//LISTENER METHODE 
		
		place.getNbrToursProperty().addListener( (a,b,c) ->{
			System.out.println(String.valueOf(c));
			nbrTours.setText(String.valueOf(c));
			
		});
		
		ArrayList<Acteur> a = place.getActeurs();
		
		
	}
	

    @FXML //injecter depuis la vue
    void unTour(ActionEvent event) { //onA even.getsource()
    	place.unTour();
    	//Rafraichir();
    	System.out.println(panneauDeJeu.getScaleX()+"ET"+panneauDeJeu.getScaleY());
    	
    }
    
    /*void Rafraichir() {
    	for (Acteur a : this.place.getActeurs()) {
    		Node sprite =  panneauDeJeu.lookup("#"+a.getId());
    		
    		if(sprite==null)
    			creerSprite(a);
    		else {
    			sprite.setTranslateX(a.getX());
    			sprite.setTranslateY(a.getY());
    		}
		}
    	
    	boolean alive;
    	int i;
    	
    	for (Node child : panneauDeJeu.getChildren()) {
    		System.out.println(child.getId());
    		alive = false;
    		i=0;
    		while(alive == false && i < place.getActeurs().size()) {
    			if(child.getId().equalsIgnoreCase(place.getActeurs().get(i).getId())) alive = true;
    			i++;
    		}
    		if(alive == false) {
    			panneauDeJeu.getChildren().remove(panneauDeJeu.lookup("#"+child.getId())); //getChildren liste de node d'un pane
    			break; //un ramassage par tour ok!
    		}
		}
    	
    	//PART DU BAS
    	
    	//place.getNbrToursProperty().addListener( (a,b,c) -> System.out.println(String.valueOf(c))); 
    	
    }*/
    
    void creerSprite(Acteur a){
    	Circle r = new Circle(3);
    	r.setId(a.getId());
    	if(a instanceof Loup)
        	r.setFill(javafx.scene.paint.Color.BLACK);
    	else
    		r.setFill(javafx.scene.paint.Color.WHITE);
    	
    	r.translateXProperty().bind(a.getxProporty());
    	r.translateYProperty().bind(a.getyProporty());
    	panneauDeJeu.getChildren().add(r);    	    	
    	
    	//VERSION HANDLE
    	
    	/*GestionPopUp g = new GestionPopUp(idSprite,posiSprite);  
	    r.setOnMouseClicked(g);*/ 
    	
    	//VERSION LAMBDA 
    	
	    r.setOnMouseClicked(event ->{
	    	System.out.println(event.getSource());
			Node b = ((Node)event.getSource());
			System.out.println(a.getId());
			String content = a.getId();
			idSprite.setText(content);
			String posiContent = "("+b.getTranslateX()+";"+b.getTranslateY()+")";
			posiSprite.setText(posiContent);
			
	    });
	    
	    
    	
    }
    @FXML
    void ajouter(ActionEvent event) {
    	int  ajoutnbr;
    	
    	if(this.loup.isSelected()){
    		ajoutnbr = Integer.parseInt(nbAnimaux.getText());
    		for (int i = 0; i < ajoutnbr; i++){
    			Loup a = new Loup(place);
    			place.ajouter(a);
    			creerSprite(a);
    			
			}
    		
    	}
    	else if(mouton.isSelected()) {
    		ajoutnbr = Integer.parseInt(nbAnimaux.getText());
    		for (int i = 0; i < ajoutnbr; i++){
    			Mouton m = new Mouton(place);
    			place.ajouter(m);
    			creerSprite(m);
    		
			}
    	}
    	System.out.println("il ya : "+place.nbrActeur()+" acteurs");
    }
    @FXML
    void fairedesTours(ActionEvent event) {
    	String t = this.tourNbr.getText();
    		int tourNbr = Integer.parseInt(t);
        	System.out.println(t);
    		for (int i = 0; i <= tourNbr; i++) {
        		this.place.unTour();
        		unTour(event);
    		}
    	}
	}  

