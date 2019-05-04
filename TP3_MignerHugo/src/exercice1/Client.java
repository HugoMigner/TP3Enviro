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
		String phraseClient;
		String phraseServeur;

		try {
			socketClient = new Socket(InetAddress.getLocalHost(), port);

			System.out.println("Entrez votre nom d'utilisateur et votre mot de passe séparés par un ESPACE.");
			BufferedReader entreeClavier = new BufferedReader(new InputStreamReader(System.in));

			phraseClient = entreeClavier.readLine();

			OutputStream os = socketClient.getOutputStream();
			PrintWriter sortieVersServeur = new PrintWriter(os);
			sortieVersServeur.println(phraseClient);
			sortieVersServeur.flush();
			
			InputStream is = socketClient.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader entreDepuiServeur = new BufferedReader(isr);
			phraseServeur = entreDepuiServeur.readLine();

			System.out.println(phraseServeur);

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
