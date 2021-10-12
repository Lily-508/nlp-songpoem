package สตั้หฤ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


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
}

