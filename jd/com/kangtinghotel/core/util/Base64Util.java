package com.kangtinghotel.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;
import org.apache.commons.codec.binary.Base64;
import com.opensymphony.module.random.Test;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import sun.misc.BASE64Decoder;

public class Base64Util {
	 /** 
     * 对文件进行编码 
     * @param file 需要编码的问家 
     * @return 对文件进行base64编码后的字符串 
     * @throws Exception 
     */  
    public static String file2String(File file) throws Exception{  
        StringBuffer sb = new StringBuffer();  
        FileInputStream in = new FileInputStream(file);
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter("d:/dy/3.txt");
        int b;  
        char ch; 
        byte a;
        byte[] buf = new byte[1024];
        ByteArrayInputStream bis = new ByteArrayInputStream(buf);
        while ((b = reader.read()) != -1) {
        	writer.write(b);
		}
        reader.close();
        writer.close();
        while((b=in.read())!=-1){  
        	ch = (char)b;  
        	sb.append(ch);  
        }  
        in.close();  
        String oldString = sb.toString();
        //使用base64编码  
        String newString = compressData(oldString);  
        return newString;  
    }  
      
    /** 
     * 对文件进行解码 
     * @param oldString 需要解码的字符串 
     * @param filePath  将字符串解码到filepath文件路径 
     * @return  返回解码后得到的文件 
     * @throws Exception 
     */  
    public static File string2File(String oldString,String filePath) throws Exception{  
        File file = new File(filePath);  
        if(file.exists()){  
            System.out.println("文件已经存在，不能将base64编码转换为文件");  
            return null;  
        }else{  
            file.createNewFile();  
        }
        FileOutputStream out = new FileOutputStream(file);  
        //对oldString进行解码  
        String newString = "";
		try {
			out.write(decompressData(oldString));
			out.flush();
	        out.close();  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			out.close();
		}
        return file;  
    }  
    
    /** 
     * 使用base64编码字符串 
     * @param data 
     * @return 编码后的字符串 
     */  
    public static String compressData(String data) {  
        try {  
            return new String(getenBASE64inCodec(data.getBytes()));  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return "ZIP_ERR";  
        }  
    }  
      
    /** 
     * 使用base64解码字符串 
     * @param encdata 
     * @return 解码后的字符串 
     */  
    public static byte[] decompressData(String encdata) {
        try { 
            return getdeBASE64inCodec(encdata);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return null;  
        }  
    }  
      
      
    /** 
     * 调用apache的编码方法 
     */  
    public static String getenBASE64inCodec(byte [] b) {  
        if (b == null)  
            return null;  
        return new String((new Base64()).encode(b));  
    }  
      
    /** 
     * 调用apache的解码方法 
     */  
    public static byte[] getdeBASE64inCodec(String s) {
        return new Base64().decode(s.getBytes());
    }  
    
    public static void main(String[] args) throws IOException{
    	try {
			String t2 = Base64Util.file2String(new File("D:/dy/1.txt"));
			//System.out.println(t2);
			Base64Util.string2File(t2, "D:/dy/2.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
      
}

