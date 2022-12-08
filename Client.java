package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import sock.Transfert;

public class Client {
    int portServer;
    String filePath;
    
    public Client(int portServeur, String filePath) {
        this.portServer = portServeur;
        this.filePath = filePath;
    }

    public void envoye() throws IOException {

        // Ouverture de la communication
        Socket socket = new Socket(InetAddress.getLocalHost(), this.portServer);
        //Socket socket = new Socket("192.168.67.244", this.portServer);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        // Message pour le seveur
		String message = "-> Fichier telecharge"; 
		out.writeInt(1);
		out.writeUTF(message);

        // Envoi du fichier 
        File fichier = new File(this.filePath);
        Transfert.transfert(new FileInputStream(fichier), out, true);

        socket.close();


    } 
}
