package excelgeneration;

import java.rmi.Remote;
import java.util.Collection;
import java.util.Map;

public interface Excel extends Remote {
		public void excelGen(String Filename,String Worksheetname,Map data) throws Exception;
}
