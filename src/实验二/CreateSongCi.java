package ʵ���;
import java.util.ArrayList;
import java.util.LinkedList;

public class CreateSongCi {
	public static LinkedList<LinkedList<String>>oneWord=creatNumWord(1);
	public static LinkedList<LinkedList<String>>twoWord=creatNumWord(2);
	public static LinkedList<LinkedList<String>>threeWord=creatNumWord(3);
	/*creatNumWord����Ҫ�����ֵĹ�ģ1��2��3������2������FileOperate���ȡʵ��һͳ�ƽ��2
	 �����ذ���scale�������ֱ�word�Ͷ�Ӧ���ִ���times�Ķ�ά����*/
	public static LinkedList<LinkedList<String>> creatNumWord(int scale){
		LinkedList<LinkedList<String>>ans=new LinkedList();
		LinkedList<String> word=new LinkedList<>();
		LinkedList<String> times=new LinkedList<>();
		FileOperate.readInput(new LineSolution() {
			@Override
			public void solveLine(String line) {
				// TODO Auto-generated method stub
				String[] lineSplit=line.split("\t times: ");
				if(lineSplit!=null) {
					for(int i=0;i<lineSplit.length-1;i++) {
						//System.out.print(lineSplit[i]);
						word.add(lineSplit[i]);
						times.add(lineSplit[i+1]);
					}
				ans.add(word);
				ans.add(times);	
				}
			}
		},"ͳ�ƽ��"+scale+".txt");
		return ans;
	}
	
	/*�������ƴʸ�ʽ
	 * ¶ѿ/����/����ϸ������/��/���ԡ���ѩ/͸/��ƿ������/�ɷ磬����/��΢��
	 * ����/����/�޼�˼����֪/��/���⡣����/��/¬�ɣ�����/������Ӯ��/����˯��
	 * �ϰ����°����䣬����ֻ����һ�룬�Ͼ��ʽһ����223��212��212��22��23��*/
	public static String ����() {
		String poem="";
		//one
		String one_part1=creatFrequencyPlace(2);
		String one_part2=creatFrequencyPlace(2);
		String one_part3=creatFrequencyPlace(3);
		String one=one_part1+one_part2+one_part3+"��";
		//second
		String second_part1=creatFrequencyPlace(2);
		String second_part2=creatFrequencyPlace(1);
		String second_part3=creatFrequencyPlace(2);
		String second=second_part1+second_part2+second_part3+"��";
		//third
		String third_part1=creatFrequencyPlace(2);
		String third_part2=creatFrequencyPlace(1);
		String third_part3=creatFrequencyPlace(2);
		String third=third_part1+third_part2+third_part3+"��";
		//forth
		String forth_part1=creatFrequencyPlace(2);
		String forth_part2=creatFrequencyPlace(2);
		String forth=forth_part1+forth_part2+"��";
		//fifth
		String fifth_part1=creatFrequencyPlace(2);
		String fifth_part2=creatFrequencyPlace(3);
		String fifth=fifth_part1+fifth_part2+"��";
		poem=one+second+third+forth+fifth;
		return poem;
	}
	/*�����Ӵ��Ƹ�ʽ
	 * СԲ/�鴮/����顣ҹ/���ᡣ��/����������/б������/��/ü�⡣����/�뿪/����С����/���£���/��󸡣
	 * 223��12��12��22��212��223��12��12��
	 * �ϰ��°벻�Գƣ�8��һ��������*/
	public static String ������() {
		String poem="";
		//one
		String one_part1=creatFrequencyPlace(2);
		String one_part2=creatFrequencyPlace(2);
		String one_part3=creatFrequencyPlace(3);
		String one=one_part1+one_part2+one_part3+"��";
		//second
		String second_part1=creatFrequencyPlace(1);
		String second_part2=creatFrequencyPlace(2);
		String second=second_part1+second_part2+"��";
		//third
		String third_part1=creatFrequencyPlace(1);
		String third_part2=creatFrequencyPlace(2);
		String third=third_part1+third_part2+"��";
		//forth
		String forth_part1=creatFrequencyPlace(2);
		String forth_part2=creatFrequencyPlace(2);
		String forth=forth_part1+forth_part2+"��";
		//fifth
		String fifth_part1=creatFrequencyPlace(2);
		String fifth_part2=creatFrequencyPlace(1);
		String fifth_part3=creatFrequencyPlace(2);
		String fifth=fifth_part1+fifth_part2+fifth_part3+"��";
		//sixth
		String sixth_part1=creatFrequencyPlace(2);
		String sixth_part2=creatFrequencyPlace(2);
		String sixth_part3=creatFrequencyPlace(3);
		String sixth=sixth_part1+sixth_part2+sixth_part3+"��";
		//seventh
		String seventh_part1=creatFrequencyPlace(1);
		String seventh_part2=creatFrequencyPlace(2);
		String seventh=seventh_part1+seventh_part2+"��";
		//eight
		String eight_part1=creatFrequencyPlace(1);
		String eight_part2=creatFrequencyPlace(2);
		String eight=eight_part1+eight_part2+"��";
		poem=one+second+third+forth+fifth+sixth+seventh+eight;
		return poem;
	}
	/*����/Ǯ��������/���/�����ϡ����/��ӳ/��΢�䡣����/ˮ�������컨/�ļ�/�����š�����/����/�����ϡ�����/����/���������/�����Ρ�
	 * 22 223 23 �ظ����ֹ�8��*/
	public static String ��Ȫ��() {
		String poem="";
		//one
		String part1=creatFrequencyPlace(2);
		String part2=creatFrequencyPlace(2);
		poem+=part1+part2+"��";
		//second
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		String part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"��";
		//third
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"��";
		//4
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(3);
		poem+=part1+part2+"��";
		//5
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"��";
		//6
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"��";
		//7
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"��";
		//8
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(3);
		poem+=part1+part2+"��";
		return poem;
	}
	//��ʽ���������δ�
	public static String creatCi(String cipai) {
		long begin0 = System.currentTimeMillis();
		 ArrayList<String> list= new ArrayList<String>();
		 if(cipai.equals("����")) {
			 list.add(����());
			 list.add(����());
		 }else if(cipai.equals("������")) {
			 list.add(������());		 
		 }else if(cipai.equals("��Ȫ��")) {
			 list.add(��Ȫ��());
		 }
		 long end0 = System.currentTimeMillis();
	    System.out.println("ִ�к�ʱ:" + (end0 - begin0) + " ����"+'\n');
	    String poem="";
	    for(String s:list)
	    	poem+=s;
		return poem;		
	}
	
	//���ɶ�Ӧ�����ĸ�Ƶ��
	public static String creatFrequencyPlace(int num) {
		LinkedList<LinkedList<String>>numWord=null;
		if(num==1)numWord=oneWord;
		else if(num==2)numWord=twoWord;
		else if(num==3)numWord=threeWord;
		else System.out.print("������������ֻ�е��ִʣ�˫�ִʣ����ִ�");
		
		boolean isFrequency=false;
		int place=0;
		String s="";
		int n=numWord.get(0).size();
		while(!isFrequency) {
			place=(int)(n*Math.random());
			if(Integer.parseInt(numWord.get(1).get(place))>=10 )
					isFrequency=true;
		}
		return numWord.get(0).get(place);
	}
	
}
interface LineSolution {
    void solveLine(String line);
}
