
# 自然语言处理课程设计
  这是根据自然语言处理相关知识实现宋词自动生成系统和中文分词系统。  
  实现语言为java，编译器eclipse，系统平台windows，算法为基本nlp算法  
  代码和相应语料库Ci.txt 、词性标注%40人民日报199801.txt都在main分支

## 第一部分 宋词词频统计
  语料库：ci.txt 对应实验一代码  
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
  
  在学习完自然语言处理后进行的课程设计，分为四个部分，实现宋词自动生成系统和中文分词系统。在完成过程中遇到许多困难，感谢学姐的帮助https://zhuanlan.zhihu.com/p/31641900 学姐github https://github.com/CeliaChien/song-poem


