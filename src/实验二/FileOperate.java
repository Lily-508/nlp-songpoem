package 实验二;
import java.io.*;
import java.util.ArrayList;
public class FileOperate {
	static String readInput(LineSolution/*此接口方便CreateSongCi类行操作*/ solution,String filename) {
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
