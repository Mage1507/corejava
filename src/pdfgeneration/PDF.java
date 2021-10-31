package pdfgeneration;


import java.rmi.Remote;
import com.itextpdf.text.Document;

public interface PDF extends Remote {
    public void pdfgen(String msg,String filename) throws Exception ;
}
