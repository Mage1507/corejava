package pdfgeneration;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import java.io.*;
import java.awt.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFImplementation extends UnicastRemoteObject implements PDF{
     public PDFImplementation() throws RemoteException {
		
	}
     @Override
    public void pdfgen(String msg,String filename) throws Exception {
    	 Document document = new Document(PageSize.A4, 36, 72, 108, 180);
         PdfWriter.getInstance(document,new FileOutputStream(filename+".pdf"));
         document.open();
         document.add(new Paragraph(msg));
         System.out.println("Here is Your PDF!!!Check the Folder");
         document.close();
        
    }
}
