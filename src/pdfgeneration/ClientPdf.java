package pdfgeneration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.rmi.Naming;

import com.itextpdf.text.Document;

public class ClientPdf {
    public static void main(String[] args) throws Exception {
		PDF pdf = (PDF)Naming.lookup("rmi://localhost:2000/pdfserver");
		System.out.println("Enter the text to convert into pdf:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String msg = in.readLine();
		System.out.println("Enter the FileName to Save:");
		String filename = in.readLine();
		pdf.pdfgen(msg,filename);
		File file = new File(filename);
		System.out.println("Your PDF File is in Folder:");
		System.out.println(file.getAbsolutePath());
	}
}
