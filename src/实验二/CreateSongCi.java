package 实验二;
import java.util.ArrayList;
import java.util.LinkedList;

public class CreateSongCi {
	public static LinkedList<LinkedList<String>>oneWord=creatNumWord(1);
	public static LinkedList<LinkedList<String>>twoWord=creatNumWord(2);
	public static LinkedList<LinkedList<String>>threeWord=creatNumWord(3);
	/*creatNumWord输入要生成字的规模1、2、3如输入2，调用FileOperate类读取实验一统计结果2
	 ，返回包含scale字数的字表word和对应出现次数times的二维数组*/
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
		},"统计结果"+scale+".txt");
		return ans;
	}
	
	/*醉花阴词牌词格式
	 * 露芽/初破/云腴细。玉纤/纤/亲试。香雪/透/金瓶，无限/仙风，月下/人微醉。
	 * 相如/消渴/无佳思。了知/君/此意。不信/老/卢郎，花底/春寒，赢得/空无睡。
	 * 上半与下半各五句，此类只生成一半，断句格式一样，223。212。212，22，23。*/
	public static String 醉花阴() {
		String poem="";
		//one
		String one_part1=creatFrequencyPlace(2);
		String one_part2=creatFrequencyPlace(2);
		String one_part3=creatFrequencyPlace(3);
		String one=one_part1+one_part2+one_part3+"。";
		//second
		String second_part1=creatFrequencyPlace(2);
		String second_part2=creatFrequencyPlace(1);
		String second_part3=creatFrequencyPlace(2);
		String second=second_part1+second_part2+second_part3+"。";
		//third
		String third_part1=creatFrequencyPlace(2);
		String third_part2=creatFrequencyPlace(1);
		String third_part3=creatFrequencyPlace(2);
		String third=third_part1+third_part2+third_part3+"，";
		//forth
		String forth_part1=creatFrequencyPlace(2);
		String forth_part2=creatFrequencyPlace(2);
		String forth=forth_part1+forth_part2+"，";
		//fifth
		String fifth_part1=creatFrequencyPlace(2);
		String fifth_part2=creatFrequencyPlace(3);
		String fifth=fifth_part1+fifth_part2+"。";
		poem=one+second+third+forth+fifth;
		return poem;
	}
	/*江城子词牌格式
	 * 小圆/珠串/静慵拈。夜/厌厌。下/重帘。曲屏/斜烛，心事/入/眉尖。金字/半开/香穗小，愁/不寐，恨/西蟾。
	 * 223。12。12。22，212。223，12，12。
	 * 上半下半不对称，8句一次生成完*/
	public static String 江城子() {
		String poem="";
		//one
		String one_part1=creatFrequencyPlace(2);
		String one_part2=creatFrequencyPlace(2);
		String one_part3=creatFrequencyPlace(3);
		String one=one_part1+one_part2+one_part3+"。";
		//second
		String second_part1=creatFrequencyPlace(1);
		String second_part2=creatFrequencyPlace(2);
		String second=second_part1+second_part2+"。";
		//third
		String third_part1=creatFrequencyPlace(1);
		String third_part2=creatFrequencyPlace(2);
		String third=third_part1+third_part2+"。";
		//forth
		String forth_part1=creatFrequencyPlace(2);
		String forth_part2=creatFrequencyPlace(2);
		String forth=forth_part1+forth_part2+"，";
		//fifth
		String fifth_part1=creatFrequencyPlace(2);
		String fifth_part2=creatFrequencyPlace(1);
		String fifth_part3=creatFrequencyPlace(2);
		String fifth=fifth_part1+fifth_part2+fifth_part3+"。";
		//sixth
		String sixth_part1=creatFrequencyPlace(2);
		String sixth_part2=creatFrequencyPlace(2);
		String sixth_part3=creatFrequencyPlace(3);
		String sixth=sixth_part1+sixth_part2+sixth_part3+"。";
		//seventh
		String seventh_part1=creatFrequencyPlace(1);
		String seventh_part2=creatFrequencyPlace(2);
		String seventh=seventh_part1+seventh_part2+"。";
		//eight
		String eight_part1=creatFrequencyPlace(1);
		String eight_part2=creatFrequencyPlace(2);
		String eight=eight_part1+eight_part2+"。";
		poem=one+second+third+forth+fifth+sixth+seventh+eight;
		return poem;
	}
	/*长忆/钱塘，不是/人寰/是天上。万家/掩映/翠微间。处处/水潺潺。异花/四季/当窗放。出入/分明/在屏障。别来/隋柳/几经秋。何日/得重游。
	 * 22 223 23 重复出现共8句*/
	public static String 酒泉子() {
		String poem="";
		//one
		String part1=creatFrequencyPlace(2);
		String part2=creatFrequencyPlace(2);
		poem+=part1+part2+"，";
		//second
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		String part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"。";
		//third
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"。";
		//4
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(3);
		poem+=part1+part2+"。";
		//5
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"。";
		//6
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"。";
		//7
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(2);
		part3=creatFrequencyPlace(3);
		poem+=part1+part2+part3+"。";
		//8
		part1=creatFrequencyPlace(2);
		part2=creatFrequencyPlace(3);
		poem+=part1+part2+"。";
		return poem;
	}
	//正式生成完整宋词
	public static String creatCi(String cipai) {
		long begin0 = System.currentTimeMillis();
		 ArrayList<String> list= new ArrayList<String>();
		 if(cipai.equals("醉花阴")) {
			 list.add(醉花阴());
			 list.add(醉花阴());
		 }else if(cipai.equals("江城子")) {
			 list.add(江城子());		 
		 }else if(cipai.equals("酒泉子")) {
			 list.add(酒泉子());
		 }
		 long end0 = System.currentTimeMillis();
	    System.out.println("执行耗时:" + (end0 - begin0) + " 豪秒"+'\n');
	    String poem="";
	    for(String s:list)
	    	poem+=s;
		return poem;		
	}
	
	//生成对应个数的高频字
	public static String creatFrequencyPlace(int num) {
		LinkedList<LinkedList<String>>numWord=null;
		if(num==1)numWord=oneWord;
		else if(num==2)numWord=twoWord;
		else if(num==3)numWord=threeWord;
		else System.out.print("输入数量错误，只有单字词，双字词，三字词");
		
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
