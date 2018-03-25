
package test1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class youth extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3439634693767815667L;
	private JLabel startTime, pastTime, label1, label2, lyear, lmonth, lday, lhour, lmin, lsec;
	private JTextField year, month, day, hour, min, sec;
	private JButton ok;
	private String str;
	private int y, m, d, h, mi, s;
	private boolean runflag = true;

	public youth() { 
		super(); 
		
		ImageIcon img = new ImageIcon("image\\focus2.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false); 
		
		// ��ʼ��������*/
		setBounds(100, 100, 600,440);  
		label1 = new JLabel("����רעʱ���������:");
		label2 = new JLabel();
		startTime = new JLabel("��ʼʱ�䣺");
		pastTime = new JLabel("�ѹ�ʱ�䣺");

		JPanel north = new JPanel();
		north.setOpaque(false);
		north.setLayout(new BorderLayout());
		north.add(label1, BorderLayout.CENTER);
		north.add(startTime, BorderLayout.NORTH);

		this.add(north, BorderLayout.NORTH);
		this.add(label2, BorderLayout.CENTER);

		JPanel south = new JPanel();
		south.setOpaque(false);
		south.setLayout(new BorderLayout());
		JPanel south_center = new JPanel();
		south_center.setOpaque(false);
		Calendar c = Calendar.getInstance();
		year = new JTextField(c.get(Calendar.YEAR) + "", 6);
		month = new JTextField(c.get(Calendar.MONTH) + 1 + "", 4);
		day = new JTextField(c.get(Calendar.DAY_OF_MONTH) + "", 4);
		hour = new JTextField(c.get(Calendar.HOUR_OF_DAY) + "", 4);
		min = new JTextField(c.get(Calendar.MINUTE) + "", 4);
		sec = new JTextField(c.get(Calendar.SECOND) + "", 4);
		lyear = new JLabel("��");
		lmonth = new JLabel("��");
		lday = new JLabel("��");
		lhour = new JLabel("ʱ");
		lmin = new JLabel("��");
		lsec = new JLabel("��");
		ok = new JButton("��ʼ��ʱ");
		south_center.add(year);
		south_center.add(lyear);
		south_center.add(month);
		south_center.add(lmonth);
		south_center.add(day);
		south_center.add(lday);
		south_center.add(hour);
		south_center.add(lhour);
		south_center.add(min);
		south_center.add(lmin);
		south_center.add(sec);
		south_center.add(lsec);
		south_center.add(ok);
		south.add(south_center, BorderLayout.CENTER);
		south.add(pastTime, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);

		ok.addActionListener(this);
		label1.setFont(new Font("����", Font.BOLD, 20));
		label2.setFont(new Font("����", Font.BOLD, 26));
		label1.setForeground(new Color(154, 0, 255));
		label2.setForeground(new Color(154, 0, 255));
		
		JMenuBar mb = new JMenuBar();// �����˵���
		JMenu b1 = new JMenu("ѡ��");
		JMenu b2 = new JMenu("����");
		JMenuItem c1 = new JMenuItem("��ҳ");
		JMenuItem c2 = new JMenuItem("����һ�̡����й�����");
		JMenuItem c4= new JMenuItem("����һ�̡���ɨ��");
		JMenuItem c3 = new JMenuItem("About...");
		setJMenuBar(mb);// ��Ӳ˵���
		mb.add(b1);
		mb.add(b2);// ��Ӳ˵�
		b1.add(c1);
		b1.add(c2);
		b1.add(c4);
		b2.add(c3);
		
		b1.setFont(new Font("����", Font.PLAIN, 17));
		b2.setFont(new Font("����", Font.PLAIN, 17));
		c1.addActionListener(new MenuItemListener());// �������׼�����
		c2.addActionListener(new MenuItemListener());// ������ѧ������
		c3.addActionListener(new MenuItemListener());// ��������
		c4.addActionListener(new MenuItemListener());// ����
		// ���ü������ı�����ɫ
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("���װ�רע����");

	}
	public synchronized void stopthread() {
		runflag = false;
	}

	public synchronized void startthread() {
		runflag = true;
	}

	public synchronized boolean getrunflag() {
		return runflag;
	}

	class MyThread extends Thread {
		Calendar target = null;
		Calendar startTime = null;
		long targetInMill = 0;
		long startInMill = 0;

		private MyThread(int y, int m, int d, int h, int mi, int s) {
			target = new GregorianCalendar(y, m - 1, d, h, mi, s);
			startTime = Calendar.getInstance();
			startInMill = startTime.getTimeInMillis();
			targetInMill = target.getTimeInMillis();
		}

		public void run() {
			while (runflag) {
				runflag = true;
				Calendar today = new GregorianCalendar();
				long todayInMill = today.getTimeInMillis();
				long dd = targetInMill - todayInMill;
				long dis = dd / 1000;
				long ms = (dd / 100) % 10;
				long mms = (dd / 10) % 10;
				String d;

				int day = (int) (dis / (3600 * 24));
				int hour = (int) (dis % (3600 * 24) / 3600);
				int min = (int) (dis % 3600 / 60);
				int sec = (int) (dis % 60);
				if (day < 10)
					d = "  " + day;
				else if (day >= 10 && day < 100)
					d = " " + day;
				else
					d = day + "";
				String s = d + " �� " + intToString(hour) + " Сʱ " + intToString(min) + " �� " + intToString(sec) + " ��"
						+ ms + " " + mms;
				label2.setText(s);
				pastTime();
				if (dd <= 0) {
					ok.setText("���¿�ʼ");
					JOptionPane.showMessageDialog(youth.this, "ʱ�䵽");
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void pastTime() {
			Calendar today = new GregorianCalendar();
			long nowInMill = today.getTimeInMillis();
			long dd = nowInMill - startInMill;
			long dis = dd / 1000;
			long ms = (dd / 100) % 10;
			long mms = (dd / 10) % 10;
			String d;

			int day = (int) (dis / (3600 * 24));
			int hour = (int) (dis % (3600 * 24) / 3600);
			int min = (int) (dis % 3600 / 60);
			int sec = (int) (dis % 60);
			if (day < 10)
				d = "  " + day;
			else if (day >= 10 && day < 100)
				d = " " + day;
			else
				d = day + "";
			String s = d + " �� " + intToString(hour) + " Сʱ " + intToString(min) + " �� " + intToString(sec) + " ��" + ms
					+ " " + mms;
			pastTime.setText("�ѹ�ʱ�䣺" + s);
		}
	}

	public String intToString(int i) {
		if (i < 10) {
			str = "0" + i;
			return str;
		} else
			return i + "";
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		MyThread t = null;
		if (str.equals("��ʼ��ʱ")) {
			try {
				this.startthread();
				startTime.setText("��ʼʱ�䣺" + new Timestamp(System.currentTimeMillis()));
				y = Integer.parseInt(year.getText());
				m = Integer.parseInt(month.getText());
				d = Integer.parseInt(day.getText());
				h = Integer.parseInt(hour.getText());
				mi = Integer.parseInt(min.getText());
				s = Integer.parseInt(sec.getText());
				year.setEditable(false);
				month.setEditable(false);
				day.setEditable(false);
				hour.setEditable(false);
				min.setEditable(false);
				sec.setEditable(false);
				// ok.setEnabled(false);
				ok.setText("ֹͣ");
				t = new MyThread(y, m, d, h, mi, s);
				t.start();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "�Բ������������֣�", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (str.equals("ֹͣ") || str.equals("���¿�ʼ")) {
			this.stopthread();
			year.setEditable(true);
			month.setEditable(true);
			day.setEditable(true);
			hour.setEditable(true);
			min.setEditable(true);
			sec.setEditable(true);
			ok.setText("��ʼ��ʱ");
		}

	}

	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); new
	 * Countdown(); } catch (ClassNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (InstantiationException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (UnsupportedLookAndFeelException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
