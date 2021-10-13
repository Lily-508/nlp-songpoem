
# 自然语言处理课程设计
  这是根据自然语言处理相关知识实现宋词自动生成系统和中文分词系统。  
  实现语言为java，编译器eclipse，系统平台windows，算法为基本nlp算法  
  代码和相应语料库Ci.txt 、词性标注%40人民日报199801.txt都在main分支

## 第一部分 宋词词频统计
  语料库：ci.txt 对应实验一代码   
  自动分析统计ci.txt，统计宋词的单字词，双字词和三字词。统计后，输出是单字词，双字词和三字词的词典文件。文件中包括相应的词和频度（次数）。
  * 首先为了统计宋词词频，处理语料库中存在许多标点符号，编写StringOperate.java 在StringOperate类中对字符串使用String类的split方法实现删去标点符号功能lineErase函数。<br>同时为了生成宋词要统计单字词，双字词和三字词词频，这就需要对去掉标点字符串按规模进行切割，设计stringCut函数实现。同时语料库中含有扒取时的不是中文的字符，编写判断是否为中文字符函数isChinese，在进行切割时运到非中文字符舍去。  
  * 之后编写进行文件读写操作FileOperate.java。在FileOperate类中实现readInput读取文件操作。其中solution是LineSolution类的对象，在LineSolution中调用StringOperate.lineErase，通过参数HashMap<String,Integer>dictFreq来统计词和对应词频。如下    
```
try {
			FileReader fr=new FileReader("Ci.txt");
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(fr);
			String line="";
			int i=0;
			while(line!=null) {
				line=br.readLine();
				if(line == null){
        			break;
        			}
        	    else if(line.length()>5) {//去除词牌名
        	    	solution.solveLine(line, scale,dictFreq);
        	    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}    
 ```
 同时在FileOperate类中实现writeoutput输出对应规模文件操作，文件命名"统计结果"+scale+".txt"  
 * 然后在CutAndCount.java的CutAndCount类中通过Word(int scale)函数调用StringOperate.java和FileOperate.java ，按照输入的规模统计词和词频到HashMap，接着通过Map.Entry<String,Integer>生成对应格式字符串`entry.getKey() + "\t times: " + entry.getValue()+"\n"`
 * 最后在TongJi.java编写主函数，获取用户输入的规模，是单字词，双字词和三字词。调用CutAndCount的Word函数生成对应统计结果文件夹。
  
## 第二部分 宋词自动生成
语料库：ci.txt 对应实验二代码  
输入词牌，基于宋词的词典和宋词的词牌，按照语言模型，自动随机生成宋词。
* 首先编写FileOperate.java在实现文件读取readInput函数，读取实验一已经处理好的单字词，双字词和三字词词频统计。代码与实验一相同，但在实验一基础上改进更加便捷，实验二LineSolution声明为**interface接口**，这样与实验一相比，之后调用readInput函数只需要在调用地方重写solveLine即可，同时这样HashMap也好存储词和词频。
* 然后编写CreateSongCi类实现宋词自动生成。每个词牌有对应的格式，比如 醉花阴词牌词格式
```
露芽/初破/云腴细。玉纤/纤/亲试。香雪/透/金瓶，无限/仙风，月下/人微醉。
相如/消渴/无佳思。了知/君/此意。不信/老/卢郎，花底/春寒，赢得/空无睡。
上半与下半各五句，断句格式一样，223。212。212，22，23。
```
* 
	* 因此我们要生成单字词，双字词和三字词对应的	HashMap 。创建creatNumWord函数实现，在该函数调用FileOperate.readInput重写接口LineSolution中的方法处理文件每一行。
* ```
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
* 
	* 获得HashMap之后还需要随机获取此词表中的高频词，用creatFrequencyPlace函数输入词的规模，获得随机生成高频词。
	* 然后编写对应词牌的词结构。本人只编写的醉花阴, 江城子 和酒泉子三个词牌
	* 最后编写creatCi(String cipai)函数，使用以上函数返回生成的String类型宋词。<br>
* 最后通过GUI函数实现图形化界面，使用java.awt类实现界面。

## 第三部分 中文词频统计
语料库 词性标注%40人民日报199801.txt 对应实验三代码  
功能：1. 分析统计txt文件统计1元模型和2元模型，输出单词和词频文件，双词和词频文件。
2.用户根据输入中文，能够快速载入文件，并检索判断是单词还是双词。
* 词性标注%40人民日报199801.txt中例如```[香港/ns  特别/a  行政区/n]ns  同胞/n  、/w  澳门/ns  和/c  台湾/ns  同胞/n  、/w  海外/s```是由中文/英文字母组成，因此创建ChineseAndEnglish函数使用regex.Matcher和regex.Pattern实现isChinese和isEnglish两个布尔函数功能判断是中文还是英文。
* 






  在学习完自然语言处理后进行的课程设计，分为四个部分，实现宋词自动生成系统和中文分词系统。在完成过程中遇到许多困难，感谢学姐的帮助https://zhuanlan.zhihu.com/p/31641900 学姐github https://github.com/CeliaChien/song-poem



