# 自然语言处理课程设计
  这是根据自然语言处理相关知识实现宋词自动生成系统和中文分词系统。  
  实现语言为java，编译器eclipse，系统平台windows，算法为基本nlp算法  
  代码和相应语料库Ci.txt 、词性标注%40人民日报199801.txt都在main分支

## 第一部分 宋词词频统计
  语料库：ci.txt 对应实验一代码
  首先为了统计宋词词频，处理语料库中存在许多标点符号，编写StringOperate.java 在StringOperate类中对字符串使用String类的split方法实现删去标点符号功能lineErase函数。同时为了生成宋词要统计单字词，双字词和三字词词频，这就需要对去掉标点字符串按规模进行切割，设计stringCut函数实现。同时语料库中含有扒取时的不是中文的字符，编写判断是否为中文字符函数isChinese，在进行切割时运到非中文字符舍去。  
  
  
  在学习完自然语言处理后进行的课程设计，分为四个部分，实现宋词自动生成系统和中文分词系统。在完成过程中遇到许多困难，感谢学姐的帮助https://zhuanlan.zhihu.com/p/31641900 学姐github https://github.com/CeliaChien/song-poem
