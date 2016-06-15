package priv.pcap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import priv.online.sip_Dict;

public class pcap_ReadFromFile_ByLines {

	/**
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     */
    public static void readFileByLines(String fileName) {
    	sip_Dict sip=new sip_Dict();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
            	//��ȡ���ĵ�ַ����sip��ַ�ֵ��ļ�online.sip_Dict.java
            	sip.sip_flow_ip_Dict(tempString);
                // ��ʾ�к�
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
