package ʵ���;
import java.io.*;
import java.util.ArrayList;
public class FileOperate {
	static String readInput(LineSolution/*�˽ӿڷ���CreateSongCi���в���*/ solution,String filename) {
		String line="";
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			while(line!=null) {
				line=br.readLine();
				if(line==null)break;
				else solution.solveLine(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
}
