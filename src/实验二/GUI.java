package ʵ���;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;

public class GUI {
	public static JFrame jf;
	public static JTextArea textArea=new JTextArea(12,42);
	static String[] cipai = {"ѡ�����", "����", "������" ,"��Ȫ��"};
	static JPanel jp1=new JPanel();
	static JPanel jp2=new JPanel();
	public static JButton jb1=new JButton("ˢ��");
	public static JButton jb2=new JButton("����");
	
	public static void craetGUI() {
		//���ڿ��
		jf=new JFrame();
		jf.setTitle("�δ�������");
		jf.setBounds(300, 300, 300, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�����б��
		JComboBox comboBox=new JComboBox(cipai);
		jp1.add(comboBox);
		
		//�����δ��ı���
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		JScrollPane jsp1=new JScrollPane(textArea);
		jsp1.setBorder(new TitledBorder("�����δ�"));
		jp1.add(jsp1);
		
		//���ɰ�ť
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("����")) {
					String Cipai=String.valueOf(comboBox.getSelectedItem());
					System.out.println("ѡ����"+Cipai);
					textArea.setText(Cipai+"\n"+CreateSongCi.creatCi(Cipai));
				} 
			}
		});
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("ˢ��")) {
					System.out.println("ˢ��");
					textArea.setText("ˢ�����");
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
