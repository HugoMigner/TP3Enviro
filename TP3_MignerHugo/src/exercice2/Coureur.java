package exercice2;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Coureur extends Thread implements ConstantesAffichages {
	private int vitesse = 10;
	private int posX;
	private int posY;
	private ImageIcon imageCoureur;
	public boolean fini = false;
	private boolean attente = false;
	private int largeur;
	private int hauteur;
	private char orientation; // D pour droite, G pour gauche
	
	
	public Coureur(char orientation, ImageIcon imageCoureur) {
		this.imageCoureur = imageCoureur;
		this.orientation = orientation;
		largeur = imageCoureur.getIconWidth();
		hauteur = imageCoureur.getIconHeight();
		posY = SKY_HAUTEUR - hauteur;
		if(this.orientation == 'D') {
			posX = 20;
		}else {
			posX = FENETRE_LARGEUR - 200;
		}
	}
	
	@Override
	public void run(){
		while(!fini) {
			if(!attente) {
				avancer();
			}
		}
	}
	
	private void avancer() {
		try {
			sleep(vitesse);
			if(this.orientation == 'D') {
				this.posX += 5;
			}else if(this.orientation == 'G') {
				this.posX -= 5;
			}
		} catch ( InterruptedException e ) {
			System.out.println( e.getMessage() );
		}
	}
	
	public Image getImageCoureur() {
		Image img = this.imageCoureur.getImage();
		return img;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public void setAttente(boolean b) {
		this.attente = b;
	}
}
