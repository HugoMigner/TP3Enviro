package exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		int port = 1026;
		Socket socketClient = null;
		String phraseNom;
		String phraseMdp;
		String phraseComplete;
		String phraseServeur;
		int cpt = 0;

		try {
			socketClient = new Socket(InetAddress.getLocalHost(), port);

			while ( cpt != 3 ) {
				System.out.print( "client>> Usager: " );
				BufferedReader entreeClavier = new BufferedReader( new InputStreamReader( System.in ) );
				phraseNom = entreeClavier.readLine();
				System.out.print( "client>> Mot de passe: " );
				phraseMdp = entreeClavier.readLine();
				phraseComplete = phraseNom + "&&&" + phraseMdp;
				OutputStream os = socketClient.getOutputStream();
				PrintWriter sortieVersServeur = new PrintWriter( os );
				sortieVersServeur.println( phraseComplete );
				sortieVersServeur.flush();
				InputStream is = socketClient.getInputStream();
				InputStreamReader isr = new InputStreamReader( is );
				BufferedReader entreeDepuiServeur = new BufferedReader( isr );
				phraseServeur = entreeDepuiServeur.readLine();
				System.out.println( phraseServeur );
				cpt++;
				if(phraseServeur.contains( "clé secrète" )) {
					break;
				}
			}

		} catch (IOException e) {
			System.out.print("Erreur Client" + e.getMessage());
		} finally {
			if (socketClient != null) {
				try {
					socketClient.close();
				} catch (IOException e) {
					System.out.print("Erreur lors de fermeture du socket" + e.getMessage());
				}
			}
		}
	}

}
