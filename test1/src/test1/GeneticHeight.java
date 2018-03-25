    package test1; 
      
    import javax.swing.*;  
    import javax.swing.border.EmptyBorder;  
      
    import java.awt.*;  
    import java.awt.event.*;  
    import java.text.DecimalFormat;  
    import java.util.regex.*;  
      
      
    public class GeneticHeight extends JFrame {       
        private static final long serialVersionUID = 1L;  
        private JPanel contentPane;  
        private JLabel titleLabel;  
        private JPanel contentPanel;  
        private JButton submitButton;  
        private ButtonGroup bg;  
        private JPanel sexPanel;  
        
        private JRadioButton BoyRadio;  
        private JRadioButton GirlRadio;  
        
        private JPanel whPanel;  
        private JLabel heightLabel;  
        private JLabel weightLabel;  
        private JTextField heightText;  
        private JTextField weightText;  
        private JPanel consolePanel;  
        private JLabel consoleLabel;  
        private JTextField consoleText;  
          
        private double fatherh;   
        private double motherh;  
        private double height;  
          
        /** 
         * Launch the application. 
         */  
     
      
        /** 
         * Create the frame. 
         */  
        public GeneticHeight() {  
        	super();
            setTitle("�Ŵ����");  
            
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setBounds(100, 100, 600,450);  

           
            
            JMenuBar mb = new JMenuBar();//�����˵���
    		JMenu b1 = new JMenu("ѡ��");
    		JMenu b2 = new JMenu("����");
    		JMenuItem c1 = new JMenuItem("��ҳ");
    		JMenuItem c2 = new JMenuItem("BMIָ��������");
    		JMenuItem c3 = new JMenuItem("About...");
    		setJMenuBar(mb);//��Ӳ˵���
    		mb.add(b1);
    		mb.add(b2);//��Ӳ˵�
    		b1.add(c2);
    		b1.add(c1);
    		b2.add(c3);
    		b1.setFont(new Font("����", Font.PLAIN, 17));
    		b2.setFont(new Font("����", Font.PLAIN, 17));
    		c1.addActionListener(new MenuItemListener());//�������׼�����
    		c2.addActionListener(new MenuItemListener());//������ѧ������
    		c3.addActionListener(new MenuItemListener());//��������
    		// ���ü������ı�����ɫ
    		this.setBackground(Color.LIGHT_GRAY);
    		
            
            
            //������  
            contentPane = new JPanel();  
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
            contentPane.setLayout(new BorderLayout(0, 0));  
            setContentPane(contentPane);  

        ImageIcon img = new ImageIcon("image\\height4.jpg");
   		JLabel imgLabel = new JLabel(img);
   		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
   		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
   		((JPanel)getContentPane()).setOpaque(false); 
   		
            //���⣬��������  
            titleLabel = new JLabel("�Ŵ���߼�����");  
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);  
            contentPane.add(titleLabel, BorderLayout.NORTH);  
            //���ѡ���panel����������  
            contentPanel = new JPanel();  
            
            contentPanel.setOpaque(false); 
            
            contentPanel.setLayout(new BorderLayout());  
            contentPane.add(contentPanel,BorderLayout.CENTER);  
            //�ύ��ť����������  
            submitButton = new JButton("����");  
            contentPane.add(submitButton, BorderLayout.SOUTH);  
              
            //����Ա�ѡ���panel��ѡ�  
            bg = new ButtonGroup();  
            sexPanel = new JPanel();  
            
            sexPanel.setOpaque(false); 
            
            sexPanel.setLayout(new FlowLayout());  
            contentPanel.add(sexPanel,BorderLayout.NORTH);  
            
            BoyRadio = new JRadioButton("����");  
            BoyRadio.setSelected(true);  
            
            GirlRadio = new JRadioButton("Ů��");  
          
            
            bg.add(BoyRadio);  
            bg.add(GirlRadio);  
            
            sexPanel.add(BoyRadio);  
            sexPanel.add(GirlRadio);  
           
            //���������ص�panel��ѡ����  
            whPanel = new JPanel();  
            
            whPanel.setOpaque(false); 
            
            whPanel.setLayout(new FlowLayout());  
            contentPanel.add(whPanel,BorderLayout.CENTER);  
            
            heightLabel = new JLabel("������ߣ���/m����");  
            weightLabel = new JLabel("ĸ����ߣ���/m����");  
            heightText = new JTextField(10);  
            heightText.setToolTipText("���������");  
            weightText = new JTextField(10);  
            weightText.setToolTipText("���������");  
            whPanel.add(heightLabel);  
            whPanel.add(heightText);  
            whPanel.add(weightLabel);  
            whPanel.add(weightText);  
            //���  
            consolePanel = new JPanel();  
            
            consolePanel.setOpaque(false); 
            
            consolePanel.setLayout(new FlowLayout());  
            consoleLabel = new JLabel("����Ŵ����Ϊ��");  
            consoleText = new JTextField(28);  
            consoleText.setEditable(false);  
            consolePanel.add(consoleLabel);  
            consolePanel.add(consoleText);  
            contentPanel.add(consolePanel,BorderLayout.SOUTH);  
              
            submitButton.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e) {  
                    String hstr = heightText.getText();  
                    String wstr = weightText.getText();  
                    Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");   
                    Matcher hisNum = pattern.matcher(hstr);  
                    Matcher wisNum = pattern.matcher(wstr);  
                    boolean acc = true;  
                    if( !hisNum.matches()|| !wisNum.matches()){  
                           acc = false;   
                    }   
                    if(acc)  
                    {  
                        fatherh = Double.parseDouble(hstr);  
                        motherh = Double.parseDouble(wstr); 
                        if(BoyRadio.isSelected())  
                        {  
                          height = (fatherh+motherh)*1.08/2;
                        }
                        else if (GirlRadio.isSelected()) 
                        {
                        	height=(fatherh*0.923+motherh)/2;
                        }
                        DecimalFormat df = new DecimalFormat("#.00");  
                                      
                        consoleText.setText("����Ŵ����Ϊ��"+df.format(height)+"(��/m)");  
                    }  
                      
                }  
            });  
        }  
      
    }  