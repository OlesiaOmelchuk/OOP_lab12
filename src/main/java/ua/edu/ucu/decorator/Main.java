package ua.edu.ucu.decorator;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop_lab12_olesia/oop_lab12.JPG");
        document = new TimedDocument(document);
//        document = CashedDocument(document);
        System.out.println(document.parse());
    }
}
