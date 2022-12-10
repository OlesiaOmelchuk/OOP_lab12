package ua.edu.ucu.decorator;

public class CashedDocument implements Document{
    private Document document;

    public CashedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        return null;
    }
}
