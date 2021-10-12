package 实验一;
import java.util.*;
public class LineSolution {
	public void solveLine(String line,int scale,HashMap<String,Integer>dictFreq){
		//去标点
		String[] lineDicts = StringOperate.lineErase(line, scale);
		if(lineDicts!=null)
			for(int i=0;i<lineDicts.length;i++) {
				String word = lineDicts[i];
				if(dictFreq.containsKey(word)) {
					int num=dictFreq.get(word);
					dictFreq.put(word, ++num);
				}else dictFreq.put(word, 1);
		}
		
	}
}
