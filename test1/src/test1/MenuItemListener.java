package test1;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuItemListener implements ActionListener {//��Ӧ�˵��¼�
	static Calculator a = new Calculator();
	static ScienceCal b = new ScienceCal();
	static child ch = new child();
	
	 static int y=Calendar.getInstance().get(Calendar.YEAR);           ///��ȡ���
     static int m=Calendar.getInstance().get(Calendar.MONTH)+1;        ///��ȡ�·�
    static  int d=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);  
	static adult ad = new adult(y,m,d);
	
	static GeneticHeight gene = new GeneticHeight();
	static youth yo = new youth();
	static Chess che = new Chess();
	static TabbedPane lo = new TabbedPane();
	static JMine mine = new JMine();
	
	static clock3 cl=new clock3();

	//static ExchangeRate ex=new ExchangeRate();


	public static void main(String[] args){ 
		 a.setVisible(true);
		 a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("��ҳ".equals(e.getActionCommand())) {
			b.setVisible(false);
			a.setVisible(true);//�л������׼���������
			yo.setVisible(false);
			 ch.setVisible(false);
			 ad.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);	
			 cl.setVisible(false);
		} else if ("����ʱ��".equals(e.getActionCommand())){
			 a.setVisible(false);
			 b.setVisible(false);	
			 yo.setVisible(false);
			 ch.setVisible(false);
			 ad.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);	
			 cl.setVisible(true);
		}
		
		else if ("��ѧ������".equals(e.getActionCommand())){
			 a.setVisible(false);
			 b.setVisible(true);	
			 yo.setVisible(false);
			 ch.setVisible(false);
			 ad.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
			
		}
		
	    else if (e.getActionCommand().equals("About...")) {
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("ʱ���������\n��Ա����¤��    ��ɺɺ");
			JOptionPane.showMessageDialog(null, aboutArea, "���� ������", JOptionPane.PLAIN_MESSAGE);
		}
		
	    else if ("��ͯʱ��".equals(e.getActionCommand())) {
	    	ad.setVisible(false);
	    	yo.setVisible(false);
			 ch.setVisible(true);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			// ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("����ʱ��".equals(e.getActionCommand())){
	    	ch.setVisible(false);
	    	ad.setVisible(false);
			 yo.setVisible(true);	
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("��������".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(true);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			cl.setVisible(false);
	    }else if ("�Ŵ���߼�����".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(true);
			 che.setVisible(false); 
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("BMIָ��������".equals(e.getActionCommand())) {
	    	ch.setVisible(true);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("���װ�רע����".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(true);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 mine.setVisible(false);
			// ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("�������ļ���".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(true); 
			 mine.setVisible(false);
			//ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("����һ�̡����й�����".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(true);
			 lo.setVisible(false); 
			 mine.setVisible(false);	
			 cl.setVisible(false);
	    }  else if ("����һ�̡���ɨ��".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 mine.setVisible(true);	
			 cl.setVisible(false);
	    }   else if ("�������±�".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(true);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 mine.setVisible(false);
			 cl.setVisible(false);
	    }  
	    else if ("���ʻ���".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 cl.setVisible(false);
			 mine.setVisible(false);
			 ExchangeRate.main(null);
	    }  
		
		
	}
}
   