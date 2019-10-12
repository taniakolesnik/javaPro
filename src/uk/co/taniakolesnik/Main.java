package uk.co.taniakolesnik;

public class Main {

    public static void main(String[] args) {
        Saver saveAction = new Saver(TextContainer.class);
        saveAction.run();
    }
}