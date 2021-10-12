package 实验四;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Algorithm {
		public static String fmm(String str) {
			ArrayList<String>list=new ArrayList<String>();
			for(int i=0;i<str.length();i++) {
				for(int j=str.length()-1;i<=j;j--) {
					String s=str.substring(i, j+1);
					if(Judge.judge(s)) {
						list.add(s+"/");
						i=j;
						break;
					}
				}
			}
			String a="";
			for(String i:list)
				a+=i;
			return a;
		}
		public static String hmm(String str) {
			LinkedList<String>list=new LinkedList<String>();
			for(int i=str.length()-1;i>=0;i--) {
				for(int j=0;i>=j;j++) {
					String s=str.substring(j, i+1);
					if(Judge.judge(s)) {
						list.addFirst(s+"/");
						i=j;
						break;
					}
				}
			}
			String a="";
			for(String i:list)
				a+=i;
			return a;
		}
		public static void main(String[]args) {
			long begin0=System.currentTimeMillis();
			System.out.println("输入要分词的句子");
			Scanner sc=new Scanner(System.in);
			String s=sc.nextLine();
			System.out.println(fmm(s));
			System.out.println(hmm(s));
			long end0=System.currentTimeMillis();
			System.out.println("执行耗时:" + (end0 - begin0) + " 豪秒");
		}
	
	
}
