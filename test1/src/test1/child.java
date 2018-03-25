    package test1; 
      
    import javax.swing.*;  
    import javax.swing.border.EmptyBorder;  
      
    import java.awt.*;  
    import java.awt.event.*;  
    import java.text.DecimalFormat;  
    import java.util.regex.*;  
      
      
    public class child extends JFrame {       
        private static final long serialVersionUID = 1L;  
        private JPanel contentPane;  
        private JLabel titleLabel;  
        private JPanel contentPanel;  
        private JButton submitButton;  
        private ButtonGroup bg;  
        private JPanel sexPanel;  
        private JRadioButton ChinaRadio;  
        private JRadioButton AsiaRadio;  
        private JRadioButton WHORadio;  
        private JPanel whPanel;  
        private JLabel heightLabel;  
        private JLabel weightLabel;  
        private JTextField heightText;  
        private JTextField weightText;  
        private JPanel consolePanel;  
        private JLabel consoleLabel;  
        private JTextField consoleText;  
          
        private double weight;  
        private double height;  
        private double BMI;  
     
      
        /** 
         * Create the frame. 
         */  
        public child() {  
        super();
        	this.setTitle("BMIָ��������");
        	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
             setBounds(100, 100, 500,500); 
             
           
        	JMenuBar mb = new JMenuBar();//�����˵���
    		JMenu b1 = new JMenu("ѡ��");
    		JMenu b2 = new JMenu("����");
    		JMenuItem c1 = new JMenuItem("��ҳ");
    		JMenuItem c2 = new JMenuItem("�Ŵ���߼�����");
    		
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
            //1-���ײ�������ӱ���ͼƬ
            ImageIcon img = new ImageIcon("image\\bmi6.jpg");
            JLabel imgLabel = new JLabel(img);
            getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
            imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
            ((JPanel)getContentPane()).setOpaque(false);         
            //���⣬��������  
            titleLabel = new JLabel("BMIָ��������");  
            
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);  
            contentPane.add(titleLabel, BorderLayout.NORTH);  
            
         
            
            //���ѡ���panel����������  
            contentPanel = new JPanel();  
            contentPanel.setLayout(new BorderLayout()); 
            
           
            contentPanel.setOpaque(false); 
            
            contentPane.add(contentPanel,BorderLayout.CENTER);  
                        
            //�ύ��ť����������  
            submitButton = new JButton("����");  
            contentPane.add(submitButton, BorderLayout.SOUTH);  
              
            
          
            //������ѡ���panel��ѡ�  
            bg = new ButtonGroup();  
            sexPanel = new JPanel();  
            sexPanel.setLayout(new FlowLayout());  
            
            sexPanel.setOpaque(false); 
            
            contentPanel.add(sexPanel,BorderLayout.NORTH);  
            ChinaRadio = new JRadioButton("�й���׼");  
            ChinaRadio.setSelected(true);  
            AsiaRadio = new JRadioButton("���ޱ�׼");  
            WHORadio = new JRadioButton("WHO������������֯����׼");  
            bg.add(ChinaRadio);  
            bg.add(AsiaRadio);  
            bg.add(WHORadio);  
            sexPanel.add(ChinaRadio);  
            sexPanel.add(AsiaRadio);  
            sexPanel.add(WHORadio);  
            
          
            //���������ص�panel��ѡ����  
            whPanel = new JPanel();  
            
            whPanel.setOpaque(false); 
            
            whPanel.setLayout(new FlowLayout());  
            contentPanel.add(whPanel,BorderLayout.CENTER);  
            heightLabel = new JLabel("��ߣ���/m����");  
            weightLabel = new JLabel("���أ�ǧ��/kg����");  
            heightText = new JTextField(10);  
            heightText.setToolTipText("���������");  
            weightText = new JTextField(10);  
            weightText.setToolTipText("����������");  
            whPanel.add(heightLabel);  
            whPanel.add(heightText);  
            whPanel.add(weightLabel);  
            whPanel.add(weightText);  
            
            
          
            //��� ��Panel 
            consolePanel = new JPanel();  
            
            consolePanel.setOpaque(false); 
            
            consolePanel.setLayout(new FlowLayout());  
            consoleLabel = new JLabel("�����������ָ��Ϊ��");  
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
                        height = Double.parseDouble(hstr);  
                        weight = Double.parseDouble(wstr);  
                        BMI = weight / (height*height);  
                        DecimalFormat df = new DecimalFormat("#.0");  
                        String out = "";  
                        if(ChinaRadio.isSelected())  
                        {  
                            if(BMI<18.5)  
                                out = "ƫ�ݣ��ݹ���᾵ģ���Ե�ɣ�";  
                            else if(BMI<23.9)  
                                out = "�����������գ�";  
                            else if(BMI<28)  
                                out = "ƫ�֣���������˶����ʣ�";  
                            else if(BMI>=28)  
                                out = "���֣����ڼ������ļ���";  
                            else  
                                out ="��������������Ŷ�����������룡";  
                        }  
                        else if(AsiaRadio.isSelected())  
                        {  
                            if(BMI<18.5)  
                                out = "ƫ�ݣ��ݹ���᾵ģ���Ե�ɣ�";  
                            else if(BMI<22.9)  
                                out = "�����������գ�";  
                            else if(BMI<24.9)  
                                out = "ƫ�֣���������˶����ʣ�";  
                            else if(BMI<30)  
                                out = "���֣����ڼ������ļ���";  
                            else if(BMI>=30)  
                                out = "�ضȷ��֣�����һ���ˣ��Ͻ����ʰɣ�";  
                            else  
                                out ="��������������Ŷ�����������룡";  
                        }  
                        else  
                        {  
                            if(BMI<18.5)  
                                out = "ƫ�ݣ��ݹ���᾵ģ���Ե�ɣ�";  
                            else if(BMI<24.9)  
                                out = "�����������գ�";  
                            else if(BMI<29.9)  
                                out = "ƫ�֣���������˶����ʣ�";  
                            else if(BMI<34.9)  
                                out = "���֣����ڼ������ļ���";  
                            else if(BMI<39.9)  
                                out = "�ضȷ��֣�����һ���ˣ��Ͻ����ʰɣ�";  
                            else if(BMI>=40)  
                                out = "���ضȷ���,�ǿ��ܵ�ȥҽԺ��������";  
                            else  
                                out ="��������������Ŷ�����������룡";  
                        }  
                          
                        consoleText.setText("���ָ��Ϊ��"+df.format(BMI)+"����Ľ���״��Ϊ��"+out);  
                    }  
                      
                }  
            });  
        }  
      
    }  
    