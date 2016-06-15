package priv.pcap;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;  

public class pcap_ReadFromFile_ByBytes {

	//���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ��� 
	public static void readFileByBytes(String fileName) {  
        File file = new File(fileName);  
        InputStream in = null;  
        try {  
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");  
            // һ�ζ�һ���ֽ� 
            in = new FileInputStream(file);  
            int tempbyte;  
            while ((tempbyte = in.read()) != -1) {  
                System.out.write(tempbyte);  
            }  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            return;  
        }  
        try {  
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");  
            // һ�ζ�����ֽ�  
            byte[] tempbytes = new byte[100];  
            int byteread = 0;  
            in = new FileInputStream(fileName);  
            pcap_ReadFromFile_ByBytes.showAvailableBytes(in);  
            // �������ֽڵ��ֽ������У�byte readΪһ�ζ�����ֽ���  
            while ((byteread = in.read(tempbytes)) != -1) {  
                System.out.write(tempbytes, 0, byteread);  
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {  
            if (in != null) {  
                try {  
                    in.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
	
	//��ʾ�������л�ʣ���ֽ�
	private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "C:/Users/Administrator/Desktop/ping.pcap";  
		pcap_ReadFromFile_ByBytes.readFileByBytes(fileName); 
	}

}
