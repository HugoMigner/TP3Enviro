package exercice1;

import java.io.*;
import java.net.*;

public class Serveur {
	
	

	public static void main( String[] args ) {
		ServerSocket serverSocketEcoute = null;
		Socket socketConnexion = null;
		
		try {
			serverSocketEcoute = new ServerSocket( 1026 );
			while (true) {
				socketConnexion = serverSocketEcoute.accept();
				
				ClientHandler processusEchange = new ClientHandler(socketConnexion);
				processusEchange.start();
			}
		}catch( IOException e ) {
			System.out.println(e.getMessage());
		}finally {
			try {
				serverSocketEcoute.close();
			}catch(IOException e) {
				System.out.println( e.getMessage() );
			}
		}

	}

}
