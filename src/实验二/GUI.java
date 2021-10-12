package 实验二;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;

public class GUI {
	public static JFrame jf;
	public static JTextArea textArea=new JTextArea(12,42);
	static String[] cipai = {"选择词牌", "醉花阴", "江城子" ,"酒泉子"};
	static JPanel jp1=new JPanel();
	static JPanel jp2=new JPanel();
	public static JButton jb1=new JButton("刷新");
	public static JButton jb2=new JButton("生成");
	
	public static void craetGUI() {
		//窗口框架
		jf=new JFrame();
		jf.setTitle("宋词生成器");
		jf.setBounds(300, 300, 300, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//下拉列表框
		JComboBox comboBox=new JComboBox(cipai);
		jp1.add(comboBox);
		
		//生成宋词文本框
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		JScrollPane jsp1=new JScrollPane(textArea);
		jsp1.setBorder(new TitledBorder("生成宋词"));
		jp1.add(jsp1);
		
		//生成按钮
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("生成")) {
					String Cipai=String.valueOf(comboBox.getSelectedItem());
					System.out.println("选择了"+Cipai);
					textArea.setText(Cipai+"\n"+CreateSongCi.creatCi(Cipai));
				} 
			}
		});
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("刷新")) {
					System.out.println("刷新");
					textArea.setText("刷新完成");
				}
			}
		});
		jp1.add(jb1,BorderLayout.NORTH);
		jp1.add(jb2,BorderLayout.SOUTH);
		jf.add(jp1);
		jf.pack();
		jf.setVisible(true);
		
	}
	public static void main(String args[]) {
		craetGUI();
	}
}
