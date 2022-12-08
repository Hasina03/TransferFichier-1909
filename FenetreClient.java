package affichage;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;

import listner.BoutonParcourir;
import listner.BoutonEnvoyer;

public class FenetreClient extends JFrame{
    public FenetreClient() throws Exception {
        this.setTitle("Client");
        this.setSize(700,450);

        JPanel panel = new JPanel();
        panel.setBounds(20, 20, 700, 500);
        //panel.setBackground(Color.BLUE);
        panel.setLayout(null);

        JLabel fileName = new JLabel("Emplacement du fichier: ");
        fileName.setBounds(0,50,150,30);
        panel.add(fileName);

        JTextField filePath = new JTextField();
        filePath.setBounds(180,50,400,30);
        panel.add(filePath);

        // Boutton pour selectionner le fichier a envoyer
        JButton parcourir = new JButton("Parcourir");
        parcourir.setBounds(200,120,100, 35);
        parcourir.addActionListener(new BoutonParcourir(filePath));
        panel.add(parcourir);

        // Message de verifivation 
        JLabel message = new JLabel();
        message.setBounds(270,200,200,50);
        message.setFont(new Font("OCR A Extended",1,15));
        panel.add(message); 

        // Boutton pour envoyer le fichier vers le serveur
        JButton envoyer = new JButton("Envoyer");
        envoyer.setBounds(350, 120, 100, 35);
        envoyer.addActionListener(new BoutonEnvoyer(filePath, message));
        panel.add(envoyer);
        
        this.add(panel);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws Exception {
        new FenetreClient();
    }
    
}
