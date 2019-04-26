package client;

public interface IEditor {
    void insertLetter(char letter, int pos);
    void removeLetter(char letter, int pos);
    void update();
}
