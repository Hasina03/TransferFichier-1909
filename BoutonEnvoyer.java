package listner;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Client;

public class BoutonEnvoyer implements ActionListener {
    JTextField textField;
    JLabel jLabel;

    public BoutonEnvoyer(JTextField textField, JLabel jLabel){
        this.textField = textField; 
        this.jLabel = jLabel;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String path = this.textField.getText();
            Client client = new Client(3456,path);
            client.envoye();

            jLabel.setText("Fichier envoye !");

        } catch (Exception f) {
            // TODO: handle exception
            f.printStackTrace();
        }
    }

}
