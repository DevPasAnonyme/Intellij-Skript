package fr.devanonyme.notepadd.menus.function;

import fr.devanonyme.notepadd.Main;

public class FunctionTemplates {

    Main main;

    public FunctionTemplates(Main main) {
        this.main = main;
    }

    // SKRIPT
    public void templateCommand() {
        insert("command /<command>:" +
                "\n\taliases: " +
                "\n\texecutable by: " +
                "\n\tusage: " +
                "\n\tdescription: " +
                "\n\tpermission: " +
                "\n\tpermission message: " +
                "\n\ttrigger: "
        );
    }

    // ÉVENEMENTS
    public void templateEventOnJoin() {
        insert("on join:" +
                "\n\t"
        );
    }

    public void templateEventOnQuit() {
        insert("on quit:" +
                "\n\t"
        );
    }

    public void templateEventOnFirstJoin() {
        insert("on first join:" +
                "\n\t"
        );
    }

    public void templateEventOnBreak() {
        insert("on break:" +
                "\n\t"
        );
    }

    public void templateEventOnBreakOf() {
        insert("on break of <block>:" +
                "\n\t"
        );
    }

    public void templateEventOnPlace() {
        insert("on place:" +
                "\n\t"
        );
    }

    public void templateEventOnPlaceOf() {
        insert("on place of <block>:" +
                "\n\t"
        );
    }

    public void templateEventOnDrop() {
        insert("on drop:" +
                "\n\t"
        );
    }

    public void templateEventOnPickup() {
        insert("on pickup:" +
                "\n\t"
        );
    }

    public void templateEventOnChat() {
        insert("on chat:" +
                "\n\t"
        );
    }

    private void insert(String arg0) {
        main.textArea.insert(arg0, main.textArea.getCaretPosition());
    }

}
