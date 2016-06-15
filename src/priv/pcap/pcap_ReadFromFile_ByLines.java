package priv.pcap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import priv.online.sip_Dict;

public class pcap_ReadFromFile_ByLines {

	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
    	sip_Dict sip=new sip_Dict();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	//读取到的地址调入sip地址字典文件online.sip_Dict.java
            	sip.sip_flow_ip_Dict(tempString);
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                //line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String fileName = "C:/Users/Administrator/Desktop/ping.pcap";
		String fileName = "C:/Users/Administrator/Desktop/yuan/1.txt";  
		pcap_ReadFromFile_ByLines.readFileByLines(fileName); 
		
	}
	

}
