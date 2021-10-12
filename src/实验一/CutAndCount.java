package 实验一;
import java.util.*;
public class CutAndCount {
	public static void Word(int scale) {
		final HashMap <String,Integer> dictFreq = new HashMap<String,Integer>();
		FileOperate.readInput(new LineSolution(), scale, dictFreq);
		System.out.println("执行完读文件");
		int sum=0; 
        String con=null;
        int count=0;
        ArrayList<String> list= new ArrayList<String>();
        for(Map.Entry<String,Integer> entry : dictFreq.entrySet()) {
        	if(entry.getValue()>10)count++;
        	sum=sum+entry.getValue();
        	}
        System.out.println("出现次数大于10的总数："+count);
        //按格式输出
        for(Map.Entry<String,Integer> entry : dictFreq.entrySet()) {
        	con=entry.getKey() + "\t times: " + entry.getValue()+"\n";//+ "\t frequency:"+Operat.divide(entry.getValue(),sum)*100+"%"+'\n';
            list.add(con);
        }
        FileOperate.writeoutput(scale,list);
        System.out.println("输出统计的词总数："+sum);
		
	}
}
