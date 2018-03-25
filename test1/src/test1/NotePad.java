package test1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class NotePad extends JPanel implements ActionListener
{
  JTextArea text;          ///����������    
  JButton ������־,ɾ����־;
  Hashtable table;          ///������־��ɢ�б�   
  JLabel ��Ϣ��;            //// �����������ڵ���Ϣ��  
  int year,month,day;       //// ������¼����  
  File file;                ////����ɢ�б���ļ�   
  adult calendar;
  public  NotePad(adult calendar)
   {
     this.calendar=calendar;
     year=calendar.getYear();
     month=calendar.getMonth();
     day=calendar.getDay();;
     table=calendar.getHashtable();
     file=calendar.getFile();
     ��Ϣ��=new JLabel(""+year+"��"+month+"��"+day+"��",JLabel.CENTER);
     ��Ϣ��.setFont(new Font("TimesRoman",Font.BOLD,16));
     ��Ϣ��.setForeground(Color.blue);
     text=new JTextArea(10,10);
     ������־=new JButton("������־") ;
     ɾ����־=new JButton("ɾ����־") ;
     ������־.addActionListener(this);
     ɾ����־.addActionListener(this);
     setLayout(new BorderLayout());
     JPanel pSouth=new JPanel();       
     add(��Ϣ��,BorderLayout.NORTH);
     pSouth.add(������־);
     pSouth.add(ɾ����־);
     add(pSouth,BorderLayout.SOUTH);
     add(new JScrollPane(text),BorderLayout.CENTER);
   }
 public void actionPerformed(ActionEvent e)
   {
     if(e.getSource()==������־)
      {
        ������־(year,month,day);
      }
     else if(e.getSource()==ɾ����־)
      {
       ɾ����־(year,month,day);
      }
   }
  public void setYear(int year)
  {
    this.year=year;
  }
 public int getYear()
  {
    return year;
  }
 public void setMonth(int month)
  {
    this.month=month;
  } 
  public int getMonth()
  {
    return month;
  } 
  public void setDay(int day)
  {
    this.day=day;
  }
  public int getDay()
   {
    return day;
   }
 public void ������Ϣ��(int year,int month,int day)
   {
     ��Ϣ��.setText(""+year+"��"+month+"��"+day+"��");
   }
  public void �����ı���(String s)
   {
     text.setText(s);
   }
  public void ��ȡ��־����(int year,int month,int day)
   {
       String key=""+year+""+month+""+day;
       try
             {
              FileInputStream   inOne=new FileInputStream(file);
              ObjectInputStream inTwo=new ObjectInputStream(inOne);
              table=(Hashtable)inTwo.readObject();         
              inOne.close();
              inTwo.close();
             }
       catch(Exception ee)
             {
             }
       if(table.containsKey(key))	///���ɢ�б��а���ѡ�е�������򵯳�ѯ�ʶԻ���
          {
            String m=""+year+"��"+month+"��"+day+"��һ������־����,�뿴��?";
            int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
                if(ok==JOptionPane.YES_OPTION)
                  {
                    text.setText((String)table.get(key));
                  }
                else
                  {
                   text.setText(""); 
                  }
          } 
       else
          {
            text.setText("�޼�¼");
          } 
   }
  public void ������־(int year,int month,int day)
   {
     String ��־����=text.getText();
        String key=""+year+""+month+""+day;
        
        String m=""+year+"��"+month+"��"+day+"������־��?";
        int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
        if(ok==JOptionPane.YES_OPTION)
          {
           try
             {
              FileInputStream   inOne=new FileInputStream(file);
              ObjectInputStream inTwo=new ObjectInputStream(inOne);
              table=(Hashtable)inTwo.readObject();///���ȵ��ļ���ȥ��ȡHASHTABLE����
              inOne.close();
              inTwo.close();
              table.put(key,��־����);     ////����־������ӵ�ɢ�б����                             
              FileOutputStream out=new FileOutputStream(file);
              ObjectOutputStream objectOut=new ObjectOutputStream(out);
              objectOut.writeObject(table);
              objectOut.close();
              out.close();
             }
           catch(Exception ee)
             {
             }
         }
   }
  public void ɾ����־(int year,int month,int day)
   {
      String key=""+year+""+month+""+day;
         if(table.containsKey(key))
          {  
            String m="ɾ��"+year+"��"+month+"��"+day+"�յ���־��?";
            int ok=JOptionPane.showConfirmDialog(this,m,"ѯ��",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
            if(ok==JOptionPane.YES_OPTION)
              { 
              try
                {
                 FileInputStream   inOne=new FileInputStream(file);
                 ObjectInputStream inTwo=new ObjectInputStream(inOne);
                 table=(Hashtable)inTwo.readObject();
                 inOne.close();
                 inTwo.close();
                 table.remove(key);    /////ɾ����־                                    
                 FileOutputStream out=new FileOutputStream(file);
                 ObjectOutputStream objectOut=new ObjectOutputStream(out);
                 objectOut.writeObject(table);
                 objectOut.close();
                 out.close();
                 text.setText(null);
                }
               catch(Exception ee)
                {
                }
              }
          }
        else
          {
            
            String m=""+year+"��"+month+"��"+day+"����־��¼";
            JOptionPane.showMessageDialog(this,m,"��ʾ",JOptionPane.WARNING_MESSAGE);
          }
   }

}
