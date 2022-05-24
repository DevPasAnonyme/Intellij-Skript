package fr.devanonyme.notepadd;

import fr.devanonyme.notepadd.menus.function.FunctionFichier;
import fr.devanonyme.notepadd.menus.function.FunctionTemplates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    public JFrame window;
    public JTextArea textArea;
    JScrollPane scrollPane;

    JMenuBar menuBar;
    // FICHIER
    JMenu menuFile;
    JMenuItem newFile, load, save, saveAs;

    FunctionFichier functionFichier = new FunctionFichier(this);
    FunctionTemplates functionTemplates = new FunctionTemplates(this);

    // SKRIPT
    JMenu menuSkript;
    JMenuItem itemCommand;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        createWindow();
        createTextArea();
        createScroll();
        createMenuBar();

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Intellij Skript");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setBackground(new Color(43, 43, 43));
        textArea.setCaretColor(new Color(255, 255, 255));
        textArea.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        textArea.setSelectedTextColor(new Color(255, 255, 255));
        textArea.setSelectionColor(new Color(0, 148, 255));
        textArea.setBorder(null);
        textArea.setTabSize(2);
        window.add(textArea);
    }

    public void createScroll() {
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setBorder(null);
        menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        window.setJMenuBar(menuBar);

        // MENU FICHIER
        menuFile = new JMenu("Fichier");
        menuBar.add(menuFile);

        newFile = new JMenuItem("Nouveau");
        newFile.addActionListener(this);
        newFile.setActionCommand("Nouveau");
        menuFile.add(newFile);

        load = new JMenuItem("Ouvrir");
        load.addActionListener(this);
        load.setActionCommand("Ouvrir");
        menuFile.add(load);

        save = new JMenuItem("Enregistrez");
        save.addActionListener(this);
        save.setActionCommand("Enregistrez");
        menuFile.add(save);

        saveAs = new JMenuItem("Enregistrez - sous");
        saveAs.addActionListener(this);
        saveAs.setActionCommand("Enregistrez - sous");
        menuFile.add(saveAs);



        // MENU SKRIPT
        menuSkript = new JMenu("Skript");
        menuBar.add(menuSkript);

        itemCommand = new JMenuItem("Commande");
        itemCommand.addActionListener(this);
        itemCommand.setActionCommand("itemCommand");
        menuSkript.add(itemCommand);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Nouveau":
                functionFichier.newFile();
                break;
            case "Ouvrir":
                functionFichier.open();
                break;
            case "Enregistrez":
                functionFichier.save();
                break;
            case "Enregistrez - sous":
                functionFichier.saveAs();
                break;

            // Skript Models
            case "itemCommand":
                functionTemplates.templateCommand();
                break;
        }
    }
}
