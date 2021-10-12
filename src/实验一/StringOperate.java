package ʵ��һ;
import java.math.*;
import java.util.*;
public class StringOperate {
	//ɾȥ������
	static String[] lineErase(String line,int scale) {
		String[] lineDicts = null;
		final List<String> ans=new ArrayList<String>();
		if(line!=null) {
			String[]spliter=line.split("\\s+|��+|��+|��+|��+|��+|��+|��+|��+|��+|��");
			for(int i=0;i<spliter.length;i++) {
				stringCut(spliter[i],scale,ans);
			}
			lineDicts = new String[ans.size()];
            ans.toArray(lineDicts);
		}
		return lineDicts;
	}
	
	//����ģ1,2,3�и�
	static void stringCut(String s,int scale,List<String> ans){
		List<String> result=new ArrayList<String>();
		boolean is=true;
		int n=s.length();
		while(n>=scale) {
			String tmp=s.substring(0,scale);
			if(tmp.length()>0)
				for(char c:tmp.toCharArray())
					if(!isChinese(c)) {
						is=false;
						break;
					}
			if(is) ans.add(tmp);
				s=s.substring(1);//����һλ��ʼ
				n=s.length();
		}
	}
	//�Ƿ��������ַ�
	static boolean isChinese(char c) {
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
