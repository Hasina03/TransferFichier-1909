package listner;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonParcourir implements ActionListener{
    JTextField textField;

    public BoutonParcourir(JTextField textField){
        this.textField = textField;
    }

    public void actionPerformed(ActionEvent e){
        JFileChooser choser = new JFileChooser(new File(textField.getText()));
        File choix = new File(textField.getText());

        if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            choix = choser.getSelectedFile();
        }
        textField.setText(choix.getAbsolutePath());

    }

}
