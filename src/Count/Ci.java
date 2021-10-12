package Count;


import java.awt.Container;
import java.io.*;
import java.util.*;

public class Ci {
	public static void main(String arg[]) {
		try {
			FileReader fr =new FileReader("Ci.txt");
			FileWriter fw = new FileWriter("new.txt");
			BufferedReader br =new BufferedReader(fr);
			BufferedWriter bw =new BufferedWriter(fw);
			String line="";
			//去除词牌名和标点符号，。、
			while(line!=null) {
				line=br.readLine();
				if(line==null)break;
				else if(line.length()>8) {
					line=lineParser(line);
					bw.write(line);
					}
			}
			bw.close();
			//统计单字词
			HashMap<Character, Integer>count1=new HashMap<Character, Integer>();
			BufferedReader new_br=new BufferedReader(new FileReader("new.txt"));
			BufferedWriter new_bw=new BufferedWriter(new FileWriter("singal.txt"));
			line=new_br.readLine();
			int n=line.length();
			for(int i=0;i<n;i++) {
				char temp=line.charAt(i);
				if(isChinese(temp)) {
					if(!count1.containsKey(temp))
					count1.put(temp, 1);
					else
					count1.replace(temp, count1.get(temp)+1);
				}
			}
			for(char temp:count1.keySet()) {
				double fre=(double)count1.get(temp)/(double)n;
				new_bw.write(temp+"\t times: "+String.valueOf(count1.get(temp)) +"\t frequence: "+String.valueOf(fre));
				new_bw.newLine();
			}
			new_bw.close();
			//统计双字词
			HashMap<String, Integer>count2=new HashMap<String, Integer>();
			BufferedWriter bw2=new BufferedWriter(new FileWriter("double.txt"));
			for(int i=0;i<n-1;i++) {
				int j=i+1;
				String temp="";
				temp=temp+line.charAt(i)+line.charAt(j);
				if(isChinese(line.charAt(i))&&isChinese(line.charAt(j))) {
					if(!count2.containsKey(temp))
						count2.put(temp, 1);
					else 
						count2.replace(temp, count2.get(temp)+1);
				}
			}
			for(String temp:count2.keySet()) {
				double fre=(double)count2.get(temp)/(double)n;
				bw2.write(temp+"\t times: "+String.valueOf(count2.get(temp))+"\t frequence: "+String.valueOf(fre));
				bw2.newLine();
			}
			bw.close();
			
			
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public static String lineParser(String line) {
		String[] strArray=line.split("\\s+|，+|。+|、+|‘+|’+|“+|”");
		StringBuffer strB = new StringBuffer();
		for(int i=0;i<strArray.length;i++)
			strB.append(strArray[i]);
		return strB.toString();
		
	}
	 public static boolean isChinese(char c) {
	        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
	        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
	         || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
	         || ub==Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
	         || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
	         || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
	         ||ub==Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS){
	            return true;
	        }
	        return false;
	    }
	
	
}
