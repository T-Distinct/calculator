package test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Year extends Box implements ActionListener
{
  int year;                           
  JTextField showYear=null;     ///��ʾ��ݵ��ı���      
  JButton ����,ȥ��;
  adult ����;
  public Year(adult ����)
  {  
     super(BoxLayout.X_AXIS);    ////һ��ˮƽ�ֲ������BOX����    
     showYear=new JTextField(4);
     showYear.setForeground(Color.blue);
     showYear.setFont(new Font("TimesRomn",Font.BOLD,14)); 
     this.����=����;
     year=����.getYear();
     ����=new JButton("����");
     ȥ��=new JButton("����");
     add(ȥ��);
     add(showYear);
     add(����);
     showYear.addActionListener(this);
     ȥ��.addActionListener(this);
     ����.addActionListener(this);
  }
 public void setYear(int year)
  {
    this.year=year;
    showYear.setText(""+year);
  }
 public int getYear()
  {
    return year;
  } 
 public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==ȥ��)
      {
        year=year-1;
        showYear.setText(""+year);
        ����.setYear(year);
        ����.����������(year,����.getMonth());
      }
    else if(e.getSource()==����)
      {
        year=year+1;
        showYear.setText(""+year);
        ����.setYear(year);
        ����.����������(year,����.getMonth());
      }
    else if(e.getSource()==showYear)
      {
         try
            {
              year=Integer.parseInt(showYear.getText());
              showYear.setText(""+year);
              ����.setYear(year);
              ����.����������(year,����.getMonth());
            }
         catch(NumberFormatException ee)////�������ݲ���������ָ�Ϊ��ǰ��ʾ�ĵ����
            {
              showYear.setText(""+year);
              ����.setYear(year);
              ����.����������(year,����.getMonth());
            }
      }
  }   
}
