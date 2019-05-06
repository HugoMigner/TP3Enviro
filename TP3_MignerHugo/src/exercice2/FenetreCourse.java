package exercice2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FenetreCourse extends JFrame implements ConstantesAffichages, ActionListener {
	private JButton btnDemarrer;
	private JButton btnArreter;
	private JButton btnContinuer;
	
	ImageIcon imageCoureurD = new ImageIcon(FenetreCourse.class.getResource( "images/coureur.gif" ));
	ImageIcon imageCoureurG = new ImageIcon(FenetreCourse.class.getResource( "images/cycliste.gif" ));
	
	private Coureur coureur1 = new Coureur('D', imageCoureurD);
	private Coureur coureur2 = new Coureur('G', imageCoureurG);
	
	private PanelAffichage affiche;
	
	public FenetreCourse() {
		setSize(FENETRE_LARGEUR, FENETRE_HAUTEUR);
		setTitle("Course");
		getContentPane().setLayout(null);
		
		affiche = new PanelAffichage(coureur1, coureur2);
		affiche.setBounds(0, 0, 584, 302);
		getContentPane().add(affiche);
		affiche.setLayout(null);
		
		btnDemarrer = new JButton("D\u00E9marrer");
		btnDemarrer.setBounds(150, 327, 89, 23);
		getContentPane().add(btnDemarrer);
		
		btnArreter = new JButton("Arr\u00EAter");
		btnArreter.setBounds(249, 327, 89, 23);
		getContentPane().add(btnArreter);
		
		btnContinuer = new JButton("Continuer");
		btnContinuer.setBounds(346, 327, 89, 23);
		getContentPane().add(btnContinuer);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnArreter.addActionListener( this );
		btnDemarrer.addActionListener( this );
		btnContinuer.addActionListener( this );
	}
	
	public void run() {
		while(true) {
			affiche.repaint();
			if(affiche.getCoureurD().getPosX() == FENETRE_LARGEUR && affiche.getCoureurG().getPosX() == 0) {
				btnContinuer.setEnabled( false );
				btnArreter.setEnabled( false );
			}
			try {
				Thread.sleep( 10 );
			} catch ( InterruptedException e ) {
				System.out.println( e.getMessage() );
			}
		}
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		if(e.getSource() == btnDemarrer) {
			coureur1.start();
			coureur2.start();
			btnDemarrer.setEnabled( false );
		}else if(e.getSource() == btnArreter) {
			coureur1.setAttente( true );
			coureur2.setAttente( true );
		}else if(e.getSource() == btnContinuer) {
			coureur1.setAttente( false );
			coureur2.setAttente( false );
		}
	}
}
