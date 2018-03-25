package test1;

import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;
public class adult extends JFrame implements MouseListener
{
   int year,month,day;
   Hashtable hashtable;  ////����������־��ɢ�б�           
   File file;            ////����ɢ�б���ļ�           
   JTextField showDay[]; ////��ʾ���ڵ��ı�������            
   JLabel title[];       ////�����Ƶ����ڱ���            
   Calendar ����;
   int ���ڼ�; 
   NotePad notepad=null;             
   Month ����ı���;
   Year  ����ı���;
   String ����[]={"������","����һ","���ڶ�","������","������","������","������"};
   JPanel leftPanel,rightPanel;    ////��������������±�
  public  adult(int year,int month,int day)
   { 
     leftPanel=new JPanel();
     JPanel leftCenter=new JPanel();
     JPanel leftNorth=new JPanel();
     leftCenter.setLayout(new GridLayout(7,7));////////////��һ����ʾ���ڱ���ı�ǩ����������ʾ���ڱ�ǩ
         
     JMenuBar mb = new JMenuBar();// �����˵���
		JMenu b1 = new JMenu("ѡ��");
		JMenu b2 = new JMenu("����");
		JMenuItem c1 = new JMenuItem("��ҳ");
		JMenuItem c2 = new JMenuItem("�������ļ���");
		JMenuItem c4 = new JMenuItem("���ʻ���");
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
		c1.addActionListener(new MenuItemListener());// 
		c2.addActionListener(new MenuItemListener());// 
		c4.addActionListener(new MenuItemListener());// 
		c3.addActionListener(new MenuItemListener());// 
		// ���ü������ı�����ɫ
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("�������±�");
		
		/*this.pack();*������ʺ���Ļ�Ŀ�ȣ��ﲻ���Լ����õ�Ŀ��/
		// this.setVisible(true);*/
                                                  
     rightPanel=new JPanel();
     this.year=year;
     this.month=month;
     this.day=day;
     ����ı���=new Year(this);
     ����ı���.setYear(year);
     ����ı���=new Month(this);
     ����ı���.setMonth(month);
  
     title=new JLabel[7];            /////��ʾ���ڱ���ı�ǩ             
     showDay=new JTextField[42];     ////  ��ʾ���ڱ���ı�ǩ            
     for(int j=0;j<7;j++)                         
       {
         title[j]=new JLabel();
         title[j].setText(����[j]);
         title[j].setBorder(BorderFactory.createRaisedBevelBorder());
         leftCenter.add(title[j]);
       } 
     title[0].setForeground(Color.red);
     title[6].setForeground(Color.blue);

     for(int i=0;i<42;i++)                        
       {
         showDay[i]=new JTextField();
         showDay[i].addMouseListener(this);
         showDay[i].setEditable(false);
         leftCenter.add(showDay[i]);
       }
         
     ����=Calendar.getInstance();
     Box box=Box.createHorizontalBox(); ////���������Ϸ�����һ��ˮƽBOX����������������ʾ����         
     box.add(����ı���);
     box.add(����ı���);
     leftNorth.add(box);
     leftPanel.setLayout(new BorderLayout());
     leftPanel.add(leftNorth,BorderLayout.NORTH);
     leftPanel.add(leftCenter,BorderLayout.CENTER);
     leftPanel.add(new Label("�������(������ʾ��Ԫǰ)"),
                  BorderLayout.SOUTH) ;
     leftPanel.validate();
     Container con=getContentPane();
     JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     leftPanel,rightPanel);////����ָ�
     
     con.add(split,BorderLayout.CENTER);
     con.validate();
    
     hashtable=new Hashtable();
     file=new File("�������±�.txt");
      if(!file.exists())
      {
       try{
           FileOutputStream out=new FileOutputStream(file);
           ObjectOutputStream objectOut=new ObjectOutputStream(out);
           objectOut.writeObject(hashtable);
           objectOut.close();
           out.close();
          }
       catch(IOException e)
          {
          }
      } 
     notepad=new NotePad(this);    /////////////////////���±�����                                  
     rightPanel.add(notepad);
     
     ����������(year,month);
     addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                         System.exit(0);
                       }
                    });
    
    setBounds(100,50,524,350);
    validate();
   }
  public void ����������(int year,int month)
   {
     ����.set(year,month-1,1);              
     ///��������YEAR��MONTH��һ�գ�0��ʾһ�£�
     ���ڼ�=����.get(Calendar.DAY_OF_WEEK)-1;///���㵱��һ�������ڼ����շ���1��������7
     if(month==1||month==3||month==5||month==7
                        ||month==8||month==10||month==12)
        {
            ���к���(���ڼ�,31);         
        }
     else if(month==4||month==6||month==9||month==11)
        {
            ���к���(���ڼ�,30);
        }
     else if(month==2)
        {
         if((year%4==0&&year%100!=0)||(year%400==0))  
           {
             ���к���(���ڼ�,29);
           }
         else
           {
             ���к���(���ڼ�,28);
           }
       }
   } 
  public void ���к���(int ���ڼ�,int ������)
   {
      for(int i=���ڼ�,n=1;i<���ڼ�+������;i++)
             {
               showDay[i].setText(""+n);
               if(n==day)
                 {
                   showDay[i].setForeground(Color.green); 
                   showDay[i].setFont(new Font("TimesRoman",Font.BOLD,20));
                 }
               else
                 { 
                  showDay[i].setFont(new Font("TimesRoman",Font.BOLD,12));
                  showDay[i].setForeground(Color.black);
                 }
               if(i%7==6)
                 {
                  showDay[i].setForeground(Color.blue);  
                 }
               if(i%7==0)
                 {
                  showDay[i].setForeground(Color.red);  
                 }
               n++; 
             }
       for(int i=0;i<���ڼ�;i++)
             {
                showDay[i].setText("");
             }
       for(int i=���ڼ�+������;i<42;i++)
             {
                showDay[i].setText("");
             }
   }
 public int getYear()
   {
    return year;
   } 
 public void setYear(int y)
   {
     year=y;
     notepad.setYear(year);
   }
 public int getMonth()
   {
    return month;
   }
 public void setMonth(int m)
   {
     month=m;
     notepad.setMonth(month); 
   }
 public int getDay()
   {
    return day;
   }
 public void setDay(int d)
   {
    day=d;
    notepad.setDay(day);
   }
 public Hashtable getHashtable()
   {
     return hashtable;
   }
 public File getFile()
   {
     return file;
   }
 public void mousePressed(MouseEvent e)             /////��Ӧ����¼�
   {
     JTextField source=(JTextField)e.getSource();
     try{
         day=Integer.parseInt(source.getText());
         notepad.setDay(day);
         notepad.������Ϣ��(year,month,day);
         notepad.�����ı���(null);
         notepad.��ȡ��־����(year,month,day);
        } 
      catch(Exception ee)
        {
        }
   }
 public void mouseClicked(MouseEvent e)
   {
   }
 public void mouseReleased(MouseEvent e)
   {
   }
 public void mouseEntered(MouseEvent e)
   {
   }
 public void mouseExited(MouseEvent e)
   {
   }
 
 
}  
