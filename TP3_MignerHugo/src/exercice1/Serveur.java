package exercice1;

import java.io.*;
import java.net.*;

public class Serveur {
	
	private static Utilisateur[] utilisateurs = {new Utilisateur("admin", "admin"),
								  		  new Utilisateur("aaa", "bbb"),
								  		  new Utilisateur("Pauline", "allo123"),
								  		  new Utilisateur("Jean", "woofwoof"),
								  		  new Utilisateur("hugo", "wow123")};

	public static void main( String[] args ) {
		ServerSocket serverSocketEcoute = null;
		Socket socketConnexion = null;
		String chaine;
		
		try {
			serverSocketEcoute = new ServerSocket( 1026 );
			while (true) {
				socketConnexion = serverSocketEcoute.accept();
				
				InputStream inputStream = socketConnexion.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader entreeDuClient = new BufferedReader(inputStreamReader);
				
				chaine = entreeDuClient.readLine();
				String[] infos = chaine.split(" ");
 				Utilisateur userTemp = new Utilisateur(infos[0], infos[1]);
 				
 				for(Utilisateur user : utilisateurs) {
 					if(user.equals( userTemp )) {
 						
 					}
 				}
			}
		}catch( IOException e ) {
			
		}

	}

}
