package ʵ����;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FMM {
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
		return list.toString();
	}
	public static String bmm(String str) {
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
		return list.toString();
	}
	public static void main(String[]args) {
		long begin0=System.currentTimeMillis();
		System.out.println("����Ҫ�ִʵľ���");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(fmm(s));
		System.out.println(bmm(s));
		long end0=System.currentTimeMillis();
		System.out.println("ִ�к�ʱ:" + (end0 - begin0) + " ����");
	}
}
