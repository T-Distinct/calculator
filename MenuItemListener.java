package com.chp01.test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuItemListener implements ActionListener {//��Ӧ�˵��¼�
	static Calculator a = new Calculator();
	static ScienceCal b = new ScienceCal();
	public static void main(String[] args){
		 a.setVisible(true);
		 a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("����������".equals(e.getActionCommand())) {
			b.setVisible(false);
			a.setVisible(true);//�л������׼���������
		} else if ("��ѧ������".equals(e.getActionCommand())) {
			
			 a.setVisible(false);
			 b.setVisible(true);
			 
		}
		
	else if (e.getActionCommand().equals("About...")) {
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("�����ͼ�����\n��Ա��������    ����Ȩ    �Ƽҿ�");
			JOptionPane.showMessageDialog(null, aboutArea, "���� ������", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
   