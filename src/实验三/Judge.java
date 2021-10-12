package 实验三;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Judge {
	public static boolean isOneGram(String word) {
		final Map<String,Integer> dictFreq = new HashMap<String,Integer>();
		FileOperate.readInput(new LineSolution() {
			@Override
			public void solveLine(String line) {
				String[] lineDicts = line.split("\ttimes: ");
				if(lineDicts != null){
					for(int i=0; i<lineDicts.length; i++){
						String word = lineDicts[i];
						if(dictFreq.containsKey(word)){
							int num = dictFreq.get(word);
						    dictFreq.put(word, ++num);
						}else {
						    dictFreq.put(word, 1);
						}
					}
				}
			}
		}, "1-gram分词统计.txt");
		
		for(Map.Entry<String,Integer> entry : dictFreq.entrySet()) {
	    	 if(entry.getKey()!=null) {
	    		 if(word.equals(entry.getKey())) {
	    			 System.out.println("该词是单词！ "+"出现次数"+entry.getValue()); 
	    			 return true;
	    			 }
	    		 }
	        }
		return false;
	}
	public static boolean isTwoGram(String word) {
		final Map<String,Integer> dictFreq = new HashMap<String,Integer>();
		FileOperate.readInput(new LineSolution() {
			@Override
			public void solveLine(String line) {
				String[] lineDicts = line.split("\ttimes: ");
				if(lineDicts != null){
					for(int i=0; i<lineDicts.length; i++){
						String word = lineDicts[i];
						if(dictFreq.containsKey(word)){
							int num = dictFreq.get(word);
						    dictFreq.put(word, ++num);
						}else {
						    dictFreq.put(word, 1);
						}
					}
				}
			}
		}, "2-gram分词统计.txt");
		for(Map.Entry<String,Integer> entry : dictFreq.entrySet()) {
	    	 if(entry.getKey()!=null) {
	    		 if(word.equals(entry.getKey())) {
	    			 System.out.println("该词是双字词！ "+"出现次数"+entry.getValue()); 
	    			 return true;
	    			 }
	    		 }
	        }
		return false;
	}
	public static void main(String[] args) {
		long begin0=System.currentTimeMillis();
		System.out.println("输入字词：");
		Scanner in =new Scanner(System.in);
		String word=in.nextLine();
		if(!isOneGram(word))
			if(!isTwoGram(word)) {
				System.out.println("找不到！请重新输入");
			}
		long end0 = System.currentTimeMillis();
		System.out.println("执行耗时:" + (end0 - begin0) + " 豪秒"+'\n');
	}

}
