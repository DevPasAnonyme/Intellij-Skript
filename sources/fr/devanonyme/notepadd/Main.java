package fr.devanonyme.notepadd;

import fr.devanonyme.notepadd.menus.function.FunctionFichier;
import fr.devanonyme.notepadd.menus.function.FunctionTemplates;
import fr.devanonyme.notepadd.menus.keys.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main implements ActionListener {

    public JFrame window;
    public JTextArea textArea;
    JScrollPane scrollPane;

    JMenuBar menuBar;
    // FICHIER
    JMenu menuFile;
    JMenuItem newFile, load, save, saveAs;

    public FunctionFichier functionFichier = new FunctionFichier(this);
    FunctionTemplates functionTemplates = new FunctionTemplates(this);
    KeyHandler keyHandler = new KeyHandler(this);

    // SKRIPT
    JMenu menuSkript, itemMenuEvents;
    JMenuItem itemCommand;

    JMenu menuEventBreak, menuEventPlace;
    JMenuItem eventOnJoin, eventOnQuit, eventOnBreak, eventOnBreakOf, eventOnPlace, eventOnPlaceOf, eventOnFirstJoin, eventOnDrop, eventOnPickup, eventOnChat;

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
        window = new JFrame("Intellij Skript : Nouveau");
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
        textArea.addKeyListener(keyHandler);
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
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        newFile.addActionListener(this);
        newFile.setActionCommand("Nouveau");        menuFile.add(newFile);

        load = new JMenuItem("Ouvrir");
        load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        load.addActionListener(this);
        load.setActionCommand("Ouvrir");
        menuFile.add(load);

        save = new JMenuItem("Enregistrez");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        save.addActionListener(this);
        save.setActionCommand("Enregistrez");
        menuFile.add(save);

        saveAs = new JMenuItem("Enregistrez - sous");
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
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

        // EVENTS
        itemMenuEvents = new JMenu("Évènements");
        menuBar.add(itemMenuEvents);

        eventOnJoin = new JMenuItem("on join");
        eventOnJoin.addActionListener(this);
        eventOnJoin.setActionCommand("eventOnJoin");
        itemMenuEvents.add(eventOnJoin);

        eventOnQuit = new JMenuItem("on quit");
        eventOnQuit.addActionListener(this);
        eventOnQuit.setActionCommand("eventOnQuit");
        itemMenuEvents.add(eventOnQuit);

        eventOnFirstJoin = new JMenuItem("on first join");
        eventOnFirstJoin.addActionListener(this);
        eventOnFirstJoin.setActionCommand("eventOnFirstJoin");
        itemMenuEvents.add(eventOnFirstJoin);

        menuEventBreak = new JMenu("on break");
        itemMenuEvents.add(menuEventBreak);

        eventOnBreak = new JMenuItem("on break");
        eventOnBreak.addActionListener(this);
        eventOnBreak.setActionCommand("eventOnBreak");
        menuEventBreak.add(eventOnBreak);

        eventOnBreakOf = new JMenuItem("on break of <block>");
        eventOnBreakOf.addActionListener(this);
        eventOnBreakOf.setActionCommand("eventOnBreakOf");
        menuEventBreak.add(eventOnBreakOf);

        menuEventPlace = new JMenu("on place");
        itemMenuEvents.add(menuEventPlace);

        eventOnPlace = new JMenuItem("on place");
        eventOnPlace.addActionListener(this);
        eventOnPlace.setActionCommand("eventOnPlace");
        menuEventPlace.add(eventOnPlace);

        eventOnPlaceOf = new JMenuItem("on place of <block>");
        eventOnPlaceOf.addActionListener(this);
        eventOnPlaceOf.setActionCommand("eventOnPlaceOf");
        menuEventPlace.add(eventOnPlaceOf);

        eventOnDrop = new JMenuItem("on drop");
        eventOnDrop.addActionListener(this);
        eventOnDrop.setActionCommand("eventOnDrop");
        itemMenuEvents.add(eventOnDrop);

        eventOnPickup = new JMenuItem("on pickup");
        eventOnPickup.addActionListener(this);
        eventOnPickup.setActionCommand("eventOnPickup");
        itemMenuEvents.add(eventOnPickup);

        eventOnChat = new JMenuItem("on chat");
        eventOnChat.addActionListener(this);
        eventOnChat.setActionCommand("eventOnChat");
        itemMenuEvents.add(eventOnChat);
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
            case "eventOnJoin":
                functionTemplates.templateEventOnJoin();
                break;
            case "eventOnQuit":
                functionTemplates.templateEventOnQuit();
                break;
            case "eventOnFirstJoin":
                functionTemplates.templateEventOnFirstJoin();
                break;
            case "eventOnBreak":
                functionTemplates.templateEventOnBreak();
                break;
            case "eventOnBreakOf":
                functionTemplates.templateEventOnBreakOf();
                break;
            case "eventOnPlace":
                functionTemplates.templateEventOnPlace();
                break;
            case "eventOnPlaceOf":
                functionTemplates.templateEventOnPlaceOf();
                break;
            case "eventOnDrop":
                functionTemplates.templateEventOnDrop();
                break;
            case "eventOnPickup":
                functionTemplates.templateEventOnPickup();
                break;
            case "eventOnChat":
                functionTemplates.templateEventOnChat();
                break;
        }
    }
}
