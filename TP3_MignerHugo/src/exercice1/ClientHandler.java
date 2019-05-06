package exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
	private Socket socketConnexion = null;
	private BufferedReader entreeDuClient;
	private PrintWriter printWriter;

	private static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public ClientHandler( Socket socketConnexion ) {
		this.socketConnexion = socketConnexion;
		try {
			InputStream inputStream = socketConnexion.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader( inputStream );
			entreeDuClient = new BufferedReader( inputStreamReader );
			OutputStream outputStream = socketConnexion.getOutputStream();
			printWriter = new PrintWriter( outputStream );
			utilisateurs.add( new Utilisateur( "admin", "admin" ) );
			utilisateurs.add( new Utilisateur( "cool", "man" ) );
			utilisateurs.add( new Utilisateur( "hugo", "wow123" ) );
			utilisateurs.add( new Utilisateur( "test", "test" ) );
			utilisateurs.add( new Utilisateur( "jeanpaul", "pauline" ) );
		} catch ( IOException e ) {
			System.out.println( "Erreur" + e.getMessage() );

		}
	}

	@Override
	public void run() {
		String chaine;
		String cle = "";
		int cpt = 0;
		StringBuilder sb = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nombres = "1234567890";
		try {
			while ( cpt != 3 ) {
				chaine = entreeDuClient.readLine();
				String[] infos = chaine.split( "&&&" );
				Utilisateur userTemp = new Utilisateur( infos[0], infos[1] );
				if ( utilisateurs.contains( userTemp ) ) {
					for ( int i = 0; i <= 2; i++ ) {
						sb.append( alphabet.charAt( (int) ( Math.random() * 26 ) ) );
						sb.append( nombres.charAt( (int) ( Math.random() * 10 ) ) );
						cle = sb.toString();
					}
					printWriter.println( "serveur>> La clé secrète est " + cle );
					cpt = 3;
				} else {
					cpt++;
					if ( cpt == 3 ) {
						printWriter.println( "serveur>> Déconnexion en cours" );
					} else {
						printWriter.println( "Mot de passe invalide, essayez à nouveau" );
					}
				}
				printWriter.flush();
			}

		} catch (

		IOException e ) {
			System.out.println( "Erreur" + e.getMessage() );
		} finally {
			try {
				if ( socketConnexion != null ) {

					socketConnexion.close();
				}
			} catch ( IOException e ) {
				System.out.println( "Erreur de  fermeture de socket" + e.getMessage() );
			}
		}
	}
}
