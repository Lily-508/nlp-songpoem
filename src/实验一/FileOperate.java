package 实验一;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileOperate {
	static void readInput(LineSolution solution,int scale,HashMap<String,Integer>dictFreq) {
		try {
			FileReader fr=new FileReader("Ci.txt");
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(fr);
			String line="";
			int i=0;
			while(line!=null) {
				line=br.readLine();
				//System.out.println(line);
				if(line == null){
        			break;
        			}
        	    else if(line.length()>5) {//去除词牌名
        	    	solution.solveLine(line, scale,dictFreq);
        	    }
        	    	
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	static void writeoutput(int scale,ArrayList<String> list){
        try{
            BufferedWriter Buff=null;  
            File f=new File("统计结果"+scale+".txt");
            Buff=new BufferedWriter(new FileWriter(f));
            for(int i=0;i<list.size();i++){
            	Buff.write(list.get(i)); 
            	Buff.newLine();
            } 
            Buff.close();       
            }catch(IOException e){
            e.printStackTrace();
        }
    }
}
