package ʵ����;
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
		}, "1-gram�ִ�ͳ��.txt");
		
		for(Map.Entry<String,Integer> entry : dictFreq.entrySet()) {
	    	 if(entry.getKey()!=null) {
	    		 if(word.equals(entry.getKey())) {
	    			 System.out.println("�ô��ǵ��ʣ� "+"���ִ���"+entry.getValue()); 
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
		}, "2-gram�ִ�ͳ��.txt");
		for(Map.Entry<String,Integer> entry : dictFreq.entrySet()) {
	    	 if(entry.getKey()!=null) {
	    		 if(word.equals(entry.getKey())) {
	    			 System.out.println("�ô���˫�ִʣ� "+"���ִ���"+entry.getValue()); 
	    			 return true;
	    			 }
	    		 }
	        }
		return false;
	}
	public static void main(String[] args) {
		long begin0=System.currentTimeMillis();
		System.out.println("�����ִʣ�");
		Scanner in =new Scanner(System.in);
		String word=in.nextLine();
		if(!isOneGram(word))
			if(!isTwoGram(word)) {
				System.out.println("�Ҳ���������������");
			}
		long end0 = System.currentTimeMillis();
		System.out.println("ִ�к�ʱ:" + (end0 - begin0) + " ����"+'\n');
	}

}
