package aoizora;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import java.io.File;
import java.net.ConnectException;

public class Main {

    public static void main(String[] args) {
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(6080);

        try {
            connection.connect();
            System.out.println("Connected to OpenOffice");
        } catch (ConnectException e) {
            System.out.println(e.getMessage());
        }

        File docFile = new File("sample.doc");
        File pdfFile = new File("sample.pdf");

        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        converter.convert(docFile, pdfFile);

        connection.disconnect();
    }
}
