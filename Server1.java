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

public class Server1 {
    public static void main(String[] args) throws IOException {
		// Ouverture d'une communication
		ServerSocket servSocket = new ServerSocket(3457);
		System.out.println("-------------- Sous-serveur 1 ---------------");
		System.out.println("-> En attente de connexion...");
		Socket servprinc = servSocket.accept();
		ObjectInputStream in = new ObjectInputStream(servprinc.getInputStream());

		// Reception de message
		int n = in.readInt();

		String[] tab = new String[n];
		for (int i=0; i<n; i++) tab[i]=in.readUTF();

		// Reception du fichier
		String path = "D:\\.Transfert\\dataServer1\\receive.txt";
		File receive = new File(path);
		Transfert.transfert(in,new FileOutputStream(receive),true);

		// Fermeture de la communication
		servprinc.close();

		// Affichage du message du client
		for (String s : tab) System.out.println(s);
    }
}
