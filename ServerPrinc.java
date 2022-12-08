package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import sock.Transfert;

import java.io.InputStream;
import java.io.OutputStream;

public class ServerPrinc {
	public static void main(String[] args) throws IOException {
		// Ouverture d'une communication
		ServerSocket servSocket = new ServerSocket(3456);
		System.out.println("-------------- Serveur ---------------");
		System.out.println("-> En attente de connexion...");
		Socket client = servSocket.accept();
		System.out.println("-> Client connecte");
		ObjectInputStream in = new ObjectInputStream(client.getInputStream());

		// Reception de message
		int n = in.readInt();

		String[] tab = new String[n];
		for (int i=0; i<n; i++) tab[i]=in.readUTF();

		// Reception du fichier
		String path = "D:\\.Transfert\\cloud\\receive.txt";
		File receive = new File(path);
		Transfert.transfert(in,new FileOutputStream(receive),true);

		// Fermeture de la communication avec le client
		client.close();

		int nbrSousServeur = 3;

		// Boucle qui envoye le fichier recu par le seveur vers les diffrerent sous serveur
		for (int i = 0; i < nbrSousServeur; i++) {
			// Ouverture de la communication avec le sous serveur1 
			int port = 3457 + i;
			int indiceServeur = 1+i;
			String nomSousServeur = "Sous-Serveur"+indiceServeur;
			Socket sousServeur = new Socket(InetAddress.getLocalHost(),port);
			System.out.println("-> Connecte au port server: "+port);
			ObjectOutputStream output = new ObjectOutputStream(sousServeur.getOutputStream());

			// Message pour le seveur
			String message = "-> Fichier telecharge"; 
			output.writeInt(1);
			output.writeUTF(message);

			// Envoi du fichier 
			Transfert.transfert(new FileInputStream(path), output, true);

			sousServeur.close();

			System.out.println("-> Fichier envoye vers "+nomSousServeur);
		}


		// Affichage du message du client
		for (String s : tab) System.out.println(s);
    }
}