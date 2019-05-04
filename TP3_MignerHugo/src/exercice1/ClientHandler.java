package exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {
	private Socket socketConnexion = null;
	private BufferedReader entreeDuClient;

	private static Utilisateur[] utilisateurs = { new Utilisateur("admin", "admin"), new Utilisateur("aaa", "bbb"),
			new Utilisateur("Pauline", "allo123"), new Utilisateur("Jean", "woofwoof"),
			new Utilisateur("hugo", "wow123") };

	public ClientHandler(Socket socketConnexion) {
		this.socketConnexion = socketConnexion;
		try {
			InputStream inputStream = socketConnexion.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			entreeDuClient = new BufferedReader(inputStreamReader);
		} catch (IOException e) {
			System.out.println("Erreur" + e.getMessage());

		}
	}

	@Override
	public void run() {
		String chaine;
		String cle;
		StringBuilder sb = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nombres = "1234567890";
		try {

			while (!(chaine = entreeDuClient.readLine()).trim().equalsIgnoreCase("fin")) {
				chaine = entreeDuClient.readLine();
				String[] infos = chaine.split(" ");
				Utilisateur userTemp = new Utilisateur(infos[0], infos[1]);
				for (Utilisateur user : utilisateurs) {
					if (user.equals(userTemp)) {
						for (int i = 0; i < 2; i++) {
							sb.append(alphabet.charAt((int) (Math.random() * 26) + 1));
							sb.append(nombres.charAt((int) (Math.random() * 10) + 1));
							cle = sb.toString();
							System.out.println(cle);
						}
					}
				} 
			}

		} catch (IOException e) {
			System.out.println("Erreur" + e.getMessage());
		} finally {
			try {
				if (socketConnexion != null) {
					socketConnexion.close();
				}
			} catch (IOException e) {
				System.out.println("Erreur de  fermeture de socket" + e.getMessage());
			}
		}
	}
}
