package extractdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class GenJReport {

	public static void main(String[] args){
		String file1 = "D:\\github\\qaweb\\resource\\index.html";
		String file3 = "D:\\github\\qaweb\\resource\\index_custom.html";

		String content = readfileAsString(file1).replace("dashboard.js", "dashboard_custom.js");
		 
		writeFile(file3,content);
		
	}
	
	 public static void writeFile(String filePath, String content) {  
        BufferedWriter bw = null;  
          
        try {           
            bw = new BufferedWriter(new FileWriter(filePath));     
            bw.write(content);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bw != null) {  
                try {  
                    bw.close();  
                } catch (IOException e) {  
                    bw = null;  
                }  
            }  
        }  
    }     
	 
	public static String readfileAsString(String sourcefile) {
		StringBuffer buffer = new StringBuffer();
        BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(sourcefile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        String s = null;
        try {
			while((s = bf.readLine())!=null){
			    buffer.append(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

        String xml = buffer.toString();
		 return xml;
	}

}