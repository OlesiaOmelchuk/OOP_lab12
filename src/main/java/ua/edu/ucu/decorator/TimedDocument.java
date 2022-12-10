package ua.edu.ucu.decorator;


public class TimedDocument implements Document {
    private Document document;

    public TimedDocument(Document document) {
        this.document = document;
    }
    @Override
    public String parse() {
        long startTime = System.currentTimeMillis();
        String text = document.parse();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return text;
    }
}
