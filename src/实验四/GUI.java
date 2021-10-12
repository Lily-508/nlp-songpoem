package 实验四;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class GUI {
	public static JFrame jf;
	public static JTextArea textArea=new JTextArea(6,24);
	public static JTextArea textResult=new JTextArea(6,24);
	static JPanel jp1=new JPanel();
	static JPanel jp2=new JPanel();
	public static JButton jb1=new JButton("刷新");
	public static JButton jb2=new JButton("生成");
	public static void createGUI() {
				//窗口框架
				jf=new JFrame();
				jf.setTitle("中文分词系统");
				jf.setBounds(300, 300, 300, 600);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//文本框
				textArea.setLineWrap(true);
				JScrollPane jsp1=new JScrollPane(textArea);
				jsp1.setBorder(new TitledBorder("输入测试语句"));
				jp1.add(jsp1);
				textResult.setEditable(false);
				textResult.setLineWrap(true);
				JScrollPane jsp2=new JScrollPane(textResult);
				jsp2.setBorder(new TitledBorder("分词结果"));
				jp1.add(jsp2);
				
				//生成按钮
				jb2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(e.getActionCommand().equals("生成")) {
							String s=textArea.getText();
							textResult.append("FMM: \n"+Algorithm.fmm(s)+"\n");
							textResult.append("BMM: \n"+Algorithm.hmm(s)+"\n");
							
						} 
					}
				});
				jb1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(e.getActionCommand().equals("刷新")) {
							System.out.println("刷新");
							textResult.setText("刷新完成");
						}
					}
				});
				jp1.add(jb1,BorderLayout.NORTH);
				jp1.add(jb2,BorderLayout.SOUTH);
				jf.add(jp1);
				jf.pack();
				jf.setVisible(true);
				
			}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createGUI();
	}

}
