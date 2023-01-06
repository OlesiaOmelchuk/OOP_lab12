import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.decorator.CashedDocument;
import ua.edu.ucu.decorator.DBConnection;
import ua.edu.ucu.decorator.Document;
import ua.edu.ucu.decorator.SmartDocument;

public class TestTask2 {
    @Test
    public void testCashedDocument() {
        String path = "gs://oop_lab12_olesia/oop_lab12.JPG";
        DBConnection db = DBConnection.getInstance();
        Document document = new CashedDocument(
                new SmartDocument(path));
        String result = document.parse();
        Assertions.assertEquals(result, db.searchQuery("select * from document where path = '" + path + "'"));
    }
}
