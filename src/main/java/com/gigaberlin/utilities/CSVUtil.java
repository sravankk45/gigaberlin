package com.gigaberlin.utilities;


import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class CSVUtil {
	
		
	public void createLocationData(String baseDir,String address,String pluscode) {
		
		try {
			
			String csvFile=baseDir+"/data/locationdata.csv";
			
			 // create a writer
		    Writer writer = Files.newBufferedWriter(Paths.get(csvFile));

		    // write CSV file
		    CSVPrinter printer = CSVFormat.DEFAULT.withHeader("Address", "PlusCode").print(writer);
				      
		     printer.printRecord(address,pluscode);	
		 
		    // flush the stream
		    printer.flush();

		    // close the writer
		    writer.close();
            
		}
		catch(Exception ioe) {
			ioe.printStackTrace();
		}
		
		
	}
	
}
