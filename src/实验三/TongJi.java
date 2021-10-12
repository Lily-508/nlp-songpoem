package 实验三;
import java.io.*;
import java.util.*;
public class TongJi {
	public static void gram_1() {
		final HashMap<String, Integer> wordDictFreqency=new HashMap<>();
		final HashMap<String, Integer> propertyDictFreqency=new HashMap<>();
		FileOperate.readInput(new LineSolution() {
			@Override
			public void solveLine(String line) {
				//如   [上海/ns  国脉/nz  通讯/n  股份/n  有限公司/n]nt 
				line=line.replace("[", "/");
				line=line.replace("]", "/");
				String []lineSplit=line.split("  ");
				if(lineSplit!=null) {
					for(int i=0;i<lineSplit.length;i++) {
						String []wordSplit=lineSplit[i].split("/");
						String word="";
						String property="";
						for(String s:wordSplit) {
							if(ChineseAndEnglish.isChinese(s)) {
								word+=s;
							}else if(ChineseAndEnglish.isEnglish(s)) {
								property+=s+"->";
							}
						}
						//字词字典
						if(wordDictFreqency.containsKey(word)){
							int value=wordDictFreqency.get(word);
							wordDictFreqency.put(word, value+1);
						}else wordDictFreqency.put(word, 1);
						//词性字典
						if(propertyDictFreqency.containsKey(property)){
							int value=propertyDictFreqency.get(property);
							propertyDictFreqency.put(property, value+1);
						}else propertyDictFreqency.put(property, 1);
					}
				}
			}
		},"词性标注%40人民日报199801.txt");
		int sum=0;
		int count=0;
		String con=null;
	    String con2=null;
	    ArrayList<String> list= new ArrayList<String>();
	    ArrayList<String> list2= new ArrayList<String>();
	    for(Map.Entry<String, Integer>entry:wordDictFreqency.entrySet()) {
	    	if(entry.getKey()!=null&&!entry.getKey().equals("")) {
	    		con=entry.getKey()+"\ttimes: "+entry.getValue()+"\n";
	    		list.add(con);
	    		sum+=entry.getValue();
	    	}
	    }
	    for(Map.Entry<String, Integer>entry:propertyDictFreqency.entrySet()) {
	    	if(entry.getKey()!=null&&!entry.getKey().equals("")/*去掉空值*/) {
	    		con2=entry.getKey()+"\ttimes: "+entry.getValue()+"\n";
	    		list2.add(con2);
	    		count++;
	    	}
	    }
	    System.out.println("1-gram词性的种类个数："+count);
	    System.out.println("1-gram字词总数："+sum);
	    FileOperate.writeWordOutput(1, list);
	    FileOperate.writePropertyOutput(1, list2);
	}
	public static void gram_2() {
		final HashMap<String, Integer> wordDictFreqency=new HashMap<>();
		final HashMap<String, Integer> propertyDictFreqency=new HashMap<>();
		FileOperate.readInput(new LineSolution() {
			@Override
			public void solveLine(String line) {
				line=line.replace("[", "/");
				line=line.replace("]", "/");
				String []lineSplit=line.split("  ");
				if(lineSplit!=null) {
					for(int i=0;i<lineSplit.length-1;i++) {
						String word1=lineSplit[i]+"/"+lineSplit[i+1];
						String word2="";
						String property="";
						String[] wordSplit = word1.split("/");
						for(String s:wordSplit) {
							if(ChineseAndEnglish.isChinese(s))word2+=s;
							else if(ChineseAndEnglish.isEnglish(s))property+=s;
						}
						if(wordDictFreqency.containsKey(word2)){
							int value=wordDictFreqency.get(word2);
							wordDictFreqency.put(word2, value+1);
						}else wordDictFreqency.put(word2, 1);
						//词性字典
						if(propertyDictFreqency.containsKey(property)){
							int value=propertyDictFreqency.get(property);
							propertyDictFreqency.put(property, value+1);
						}else propertyDictFreqency.put(property, 1);
					}
				}
			}
		},"词性标注%40人民日报199801.txt");
		int sum=0;
		int count=0;
		String con=null;
	    String con2=null;
	    ArrayList<String> list= new ArrayList<String>();
	    ArrayList<String> list2= new ArrayList<String>();
	    for(Map.Entry<String, Integer>entry:wordDictFreqency.entrySet()) {
	    	if(entry.getKey()!=null&&!entry.getKey().equals("")) {
	    		con=entry.getKey()+"\ttimes: "+entry.getValue()+"\n";
	    		list.add(con);
	    		sum+=entry.getValue();
	    	}
	    }
	    for(Map.Entry<String, Integer>entry:propertyDictFreqency.entrySet()) {
	    	if(entry.getKey()!=null&&!entry.getKey().equals("")/*去掉空值*/) {
	    		con2=entry.getKey()+"\ttimes: "+entry.getValue()+"\n";
	    		list2.add(con2);
	    		count++;
	    	}
	    }
	    System.out.println("2-gram词性的种类个数："+count);
	    System.out.println("2-gram字词总数："+sum);
	    FileOperate.writeWordOutput(2, list);
	    FileOperate.writePropertyOutput(2, list2);
	}
		
	public static void main(String[] args) {
		long begin0 = System.currentTimeMillis();   
      	gram_1();
      	gram_2();
		//state_p();
      	//Sentence();
        System.out.println("词语统计完毕");
        long end0 = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end0 - begin0) + " 豪秒"+'\n'); 
      	   
         }
}
//处理一行的标注接口
interface LineSolution{
	void solveLine(String line);
}