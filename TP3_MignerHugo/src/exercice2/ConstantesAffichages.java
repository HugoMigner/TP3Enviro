package exercice2;

import javax.swing.ImageIcon;

public interface ConstantesAffichages {
	public ImageIcon IMAGE_EAU = new ImageIcon(ConstantesAffichages.class.getResource( "images/eau.jpg" ));
	public ImageIcon IMAGE_SKY = new ImageIcon(ConstantesAffichages.class.getResource( "images/Sky.gif" ));
	
	public final int SKY_LARGEUR = IMAGE_SKY.getIconWidth();
	public final int SKY_HAUTEUR = IMAGE_SKY.getIconHeight();
	public final int EAU_LARGEUR = IMAGE_EAU.getIconWidth();
	public final int EAU_HAUTEUR = IMAGE_EAU.getIconHeight();
	
	public final int FENETRE_LARGEUR = SKY_LARGEUR;
	public final int FENETRE_HAUTEUR = EAU_HAUTEUR + SKY_HAUTEUR + 100;
}
