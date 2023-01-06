package ua.edu.ucu.decorator;

public class CashedDocument extends Document{
    private Document document;
    private DBConnection db;

    public CashedDocument(Document document) {
        this.document = document;
        this.gcsPath = document.gcsPath;
        this.db = DBConnection.getInstance();
    }

    @Override
    public String parse() {
        String result = db.searchQuery("select * from document where path = '" + gcsPath + "'");
        if (result == null){
            String text = document.parse();
            String query = String.format("insert into document (path, documentText) values ('%s', '%s');",
                    gcsPath, text);
            db.executeQuery(query);
            return text;
        } else {
            return result;
        }

    }
}
