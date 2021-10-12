package ʵ����;

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
	public static JButton jb1=new JButton("ˢ��");
	public static JButton jb2=new JButton("����");
	public static void createGUI() {
				//���ڿ��
				jf=new JFrame();
				jf.setTitle("���ķִ�ϵͳ");
				jf.setBounds(300, 300, 300, 600);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//�ı���
				textArea.setLineWrap(true);
				JScrollPane jsp1=new JScrollPane(textArea);
				jsp1.setBorder(new TitledBorder("����������"));
				jp1.add(jsp1);
				textResult.setEditable(false);
				textResult.setLineWrap(true);
				JScrollPane jsp2=new JScrollPane(textResult);
				jsp2.setBorder(new TitledBorder("�ִʽ��"));
				jp1.add(jsp2);
				
				//���ɰ�ť
				jb2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(e.getActionCommand().equals("����")) {
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
						if(e.getActionCommand().equals("ˢ��")) {
							System.out.println("ˢ��");
							textResult.setText("ˢ�����");
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
