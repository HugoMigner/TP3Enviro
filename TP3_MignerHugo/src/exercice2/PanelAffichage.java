package exercice2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelAffichage extends JPanel implements ConstantesAffichages {
	private Coureur coureurD;
	private Coureur coureurG;
	Image tamponImage = null;
	
	public PanelAffichage(Coureur coureur1, Coureur coureur2) {
		this.coureurD = coureur1;
		this.coureurG = coureur2;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent( g );
		tamponImage = createImage(getWidth(), getHeight());
		Graphics bg = tamponImage.getGraphics();
		bg.drawImage( IMAGE_SKY.getImage(), 0, 0, this );
		bg.setFont( new Font("Verdana", Font.BOLD, 18) );
		bg.drawString( "Cliquez sur démarrer", FENETRE_LARGEUR / 2 - 100, 50 );
		bg.drawImage( IMAGE_EAU.getImage(), 0, SKY_HAUTEUR, this );
		bg.drawImage( coureurD.getImageCoureur(), coureurD.getPosX(), coureurD.getPosY(), this );
		bg.drawImage( coureurG.getImageCoureur(), coureurG.getPosX(), coureurG.getPosY(), this );
		g.drawImage( tamponImage, 0, 0, this);
		g.dispose();
	}
	
	public Coureur getCoureurD() {
		return this.coureurD;
	}
	
	public Coureur getCoureurG() {
		return this.coureurG;
	}
}
