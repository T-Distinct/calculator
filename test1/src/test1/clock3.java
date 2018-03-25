package test1;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//import test1.MenuItemListener;





public class clock3 extends JFrame{
	
ImagePane imagePane[];
String mypic;
static Calendar now;
static Float s;
static Float m;
static Float h;	
Thread ts;
Thread tm;
Thread th;



class s extends Thread
   {
	  public void run()
	  {
		  while(true) {
		  gettime();
		  s = (float)(now.get(Calendar.SECOND) * 6);// �����ת���ɶ�����ÿ��ת1��(1/360Բ��)
		  imagePane[0].ratoteImage(s*Math.PI/180);//������ת
		  try {Thread.sleep(1000);}
		  catch (Exception ex) {}
	  }}
   }

class m extends Thread
{
	  public void run()
	  {
		  while(true) {
		  gettime();
		  m = (float)(now.get(Calendar.MINUTE) * 6+Math.rint(now.get(Calendar.SECOND)/15)*1.5);// ��÷���,ÿ15��ת1��(1/360Բ��)
		  imagePane[1].ratoteImage(m*Math.PI/180);//������ת
		  try {Thread.sleep(15000);}
		  catch (Exception ex) {}
	  }}
}


class h extends Thread
{
	  public void run()
	  {
		while(true) {
		  gettime();
		  h = (float)((now.get(Calendar.HOUR_OF_DAY) - 12) * 30+ Math.rint(now.get(Calendar.MINUTE)/2));// ���Сʱ��ÿ12��ת1��(1/360Բ��)
		  imagePane[2].ratoteImage(h*Math.PI/180);//ʱ����ת
		  try {Thread.sleep(120000);}
		  catch (Exception ex) {}
	  }}
}

public static void gettime()
{
	now = new GregorianCalendar();

}

public clock3()
{
	super("javaʱ��"); //���ø��๹�캯��
	
	
	
	
	JMenuBar mb = new JMenuBar();//�����˵���
		JMenu b1 = new JMenu("ѡ��");
		JMenu b2 = new JMenu("����");
		JMenuItem c1 = new JMenuItem("��ҳ");
		JMenuItem c3 = new JMenuItem("About...");
		setJMenuBar(mb);//��Ӳ˵���
		mb.add(b1);
		mb.add(b2);//��Ӳ˵�
		b1.add(c1);
		b2.add(c3);
		b1.setFont(new Font("����", Font.ROMAN_BASELINE, 17));
		b2.setFont(new Font("����", Font.PLAIN, 17));
		c1.addActionListener(new MenuItemListener());//�������׼�����
		c3.addActionListener(new MenuItemListener());//��������
	
	imagePane=new ImagePane[4]; 
	Container container=getContentPane(); //�õ���������

for(int i=0;i<4;i++)
{
	imagePane[i]=new ImagePane();
	imagePane[i].setOpaque(false);//����͸��
	imagePane[i].loadImage("image/"+(3-i)+".png"); //װ��ͼƬ
	imagePane[i].setBounds(0, 0, 500, 600);//����λ��
	container.add(imagePane[i]); //���������������
}


 ts=this.new s();
tm=this.new m();
 th=this.new h();
 gettime();
 ts.start();tm.start();th.start();

this.setSize(520,620); //���ô��ڳߴ�
//this.setVisible(true); //���ô��ڿ���
this.setResizable(false);//���ɸı��С
this.setLocationRelativeTo(null);//����
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�رմ���ʱ�˳����� 

}


}
