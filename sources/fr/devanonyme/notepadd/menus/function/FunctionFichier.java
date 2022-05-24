package fr.devanonyme.notepadd.menus.function;

import fr.devanonyme.notepadd.Main;

//import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFichier {

    Main main;

    String name;
    String url;

    public FunctionFichier(Main main) {
        this.main = main;
    }

    public void newFile() {
        main.textArea.setText("");
        main.window.setTitle("Intellij Skript : Nouveau");
        name = null;
        url = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(main.window, "Ouvrir", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            name = fd.getFile();
            url = fd.getDirectory();
            main.window.setTitle("Intellij Skript : " + name);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(url + name));
            main.textArea.setText("");
            String line = null;
            while((line = br.readLine()) != null) {
                main.textArea.append(line + "\n");
            }
        } catch (Exception exception) {
            System.out.println(name + " pas ouvert !");
        }
    }

    public void save() {
        if(name == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(url + name);
                fw.write(main.textArea.getText());
                main.window.setTitle("Intellij Skript : " + name);
                fw.close();
            } catch (Exception exception) {
                System.out.println("Non enregistrez !");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(main.window, "Enregistrez", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            name = fd.getFile();
            url = fd.getDirectory();
            main.window.setTitle("Intellij Skript : " + name);
        }

        try {
            FileWriter fw = new FileWriter(url + name);
            fw.write(main.textArea.getText());
            fw.close();
        } catch (Exception exception) {
            System.out.println(name + " non enregistrez !");
        }
    }

}
