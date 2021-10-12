package 实验三;

import java.io.*;
import java.util.ArrayList;
public class FileOperate {
	public static void readInput(LineSolution solution,String filename) {
		try {
			InputStreamReader fr=new InputStreamReader(new FileInputStream(filename) ,"UTF-8");
			BufferedReader br=new BufferedReader(fr);
			String line="";
			while(line!=null) {
				line=br.readLine();
				if(line == null){
        			break;
        		}else {
        			solution.solveLine(line);
        			}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void writeWordOutput(int scale,ArrayList<String> list) {
		try {
			FileOutputStream f=new FileOutputStream("D:\\eclipse-workspace\\nlp\\"+scale+"-gram分词统计.txt");
			OutputStreamWriter fw=new OutputStreamWriter(f,"UTF-8");
			BufferedWriter bw=new BufferedWriter(fw);
			for(String s:list) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writePropertyOutput(int scale,ArrayList<String> list) {
		try {
			FileOutputStream f=new FileOutputStream("D:\\eclipse-workspace\\nlp\\"+scale+"-gram分词词性统计.txt");
			OutputStreamWriter fw=new OutputStreamWriter(f,"UTF-8");
			BufferedWriter bw=new BufferedWriter(fw);
			for(String s:list) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
