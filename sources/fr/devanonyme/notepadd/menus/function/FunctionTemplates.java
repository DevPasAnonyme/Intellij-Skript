package fr.devanonyme.notepadd.menus.function;

import fr.devanonyme.notepadd.Main;

public class FunctionTemplates {

    Main main;

    public FunctionTemplates(Main main) {
        this.main = main;
    }

    public void templateCommand() {
        insert("" +
                "command /<command>:" +
                "\n aliases:" +
                "\n executable by:" +
                "\n usage:" +
                "\n description:" +
                "\n permission:" +
                "\n permission message:" +
                "\n trigger:"
        );
    }

    private void insert(String arg0) {
        main.textArea.insert(arg0, main.textArea.getCaretPosition());
    }

}
