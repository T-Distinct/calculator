package test1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Calculator extends JFrame implements ActionListener {
	// �������ϵļ�����ʾ���� */
	private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
			"*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
	// �������ϵĹ��ܼ�����ʾ���� */
	private final String[] COMMAND = { "��", "CE", "C" };
	// ��������ߵ�M����ʾ���� */
	private final String[] M = { " ", "MC", "MR", "MS", "M+" };
	// �������ϼ��İ�ť */
	private JButton keys[] = new JButton[KEYS.length];
	// �������ϵĹ��ܼ��İ�ť */
	private JButton commands[] = new JButton[COMMAND.length];
	// ��������ߵ�M�İ�ť */
	private JButton m[] = new JButton[M.length];
    
	// �������ı��� */
	private JTextField resultText = new JTextField("0");

	// ��־�û������Ƿ����������ʽ�ĵ�һ������,�������������ĵ�һ������
	private boolean firstDigit = true;
	// ������м�����
	private double resultNum = 0.0;
	// ��ǰ����������
	private String operator = "=";
	// �����Ƿ�Ϸ�
	private boolean operateValidFlag = true;

	/**
	 * ���캯��
	 */
	public Calculator() {
		super();
		// ��ʼ��������
		init();
	
		ImageIcon img = new ImageIcon("image\\timg.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false); 
		
		JMenuBar mb = new JMenuBar();//�����˵���
		JMenu b1 = new JMenu("������ѡ��");
		JMenu b2 = new JMenu("���յ���");
		JMenu b3 = new JMenu("��������");
		JMenu b4 = new JMenu("����");
		
		JMenuItem c1 = new JMenuItem("����������");
		JMenuItem c2 = new JMenuItem("��ѧ������");
		JMenuItem c3 = new JMenuItem("About...");
		JMenuItem c4 = new JMenuItem("��ͯʱ��");
		JMenuItem c5 = new JMenuItem("����ʱ��");
		JMenuItem c6 = new JMenuItem("��������");
		JMenuItem c7 = new JMenuItem("����ʱ��");
		setJMenuBar(mb);//��Ӳ˵���
		mb.add(b1);
		mb.add(b2);//��Ӳ˵�
		mb.add(b3);
		mb.add(b4);
		b1.add(c2);
		b1.add(c1);
		b4.add(c3);
		b3.add(c4);
		b3.add(c5);
		b3.add(c6);
		b2.add(c7);
		b1.setFont(new Font("����", Font.PLAIN, 17));
		b2.setFont(new Font("�� ��", Font.PLAIN, 17));
		b3.setFont(new Font("�� ��", Font.PLAIN, 17));
		b4.setFont(new Font("�� ��", Font.PLAIN, 17));
		
		c1.addActionListener(new MenuItemListener());//�������׼���
		c2.addActionListener(new MenuItemListener());//������ѧ����
		c3.addActionListener(new MenuItemListener());//��������
		c4.addActionListener(new MenuItemListener());//������ͯʱ��
		c5.addActionListener(new MenuItemListener());//��������ʱ��
		c6.addActionListener(new MenuItemListener());//��������ʱ��
	    c7.addActionListener(new MenuItemListener());//����ʱ��
		  
		// ���ü������ı�����ɫ
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("ʱ�������������һ·���㣬����~");
		// ����Ļ(300, 200)���괦��ʾ������
		this.setLocation(300, 200);
		// �����޸ļ������Ĵ�С
		this.setResizable(false);
		// ʹ�������и������С����
		setVisible(true);
		 
        this.pack();
	}

	/**
	 * ��ʼ��������
	 */
	private void init() {
		// �ı����е����ݲ����Ҷ��뷽ʽ
		resultText.setHorizontalAlignment(JTextField.RIGHT);
		// �������޸Ľ���ı���
		resultText.setEditable(false);
		// �����ı��򱳾���ɫΪ��ɫ
		resultText.setBackground(Color.white);

		// ��ʼ���������ϼ��İ�ť����������һ��������
		JPanel calckeysPanel = new JPanel();
		
		calckeysPanel.setOpaque(false); 
		
		// �����񲼾�����4�У�5�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
		calckeysPanel.setLayout(new GridLayout(4, 5, 3, 3));
		for (int i = 0; i < KEYS.length; i++) {
			keys[i] = new JButton(KEYS[i]);
			calckeysPanel.add(keys[i]);
			keys[i].setForeground(Color.blue);
			keys[i].setFont(new Font("΢���ź�", Font.BOLD, 13));
		}
		// ��������ú�ɫ��ʾ������������ɫ��ʾ
		keys[3].setForeground(Color.black);
		keys[8].setForeground(Color.black);
		keys[13].setForeground(Color.black);
		keys[18].setForeground(Color.black);
		keys[19].setForeground(Color.black);
		keys[4].setForeground(Color.black);
		keys[9].setForeground(Color.black);
		keys[14].setForeground(Color.black);

		// ��ʼ�����ܼ������ú�ɫ��ʾ�������ܼ�����һ��������
		JPanel commandsPanel = new JPanel();
		
		commandsPanel.setOpaque(false);
		
		// �����񲼾�����1�У�3�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
		commandsPanel.setLayout(new GridLayout(1, 3, 3, 3));
		for (int i = 0; i < COMMAND.length; i++) {
			commands[i] = new JButton(COMMAND[i]);
			commandsPanel.add(commands[i]);
			commands[i].setForeground(Color.black);
			commands[i].setFont(new Font("����", Font.PLAIN, 13));
		}

		// ��ʼ��M�����ú�ɫ��ʾ����M������һ��������
		JPanel calmsPanel = new JPanel();
		
		calmsPanel.setOpaque(false);
		
		
		// �����񲼾ֹ�������5�У�1�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
		calmsPanel.setLayout(new GridLayout(5, 1, 3, 3));
		for (int i = 0; i < M.length; i++) {
			m[i] = new JButton(M[i]);
			
			calmsPanel.add(m[i]);
			m[i].setForeground(Color.black);//m[i].setOpaque(false);
			
		}

		// ������м����������岼�֣���calckeys��command������ڼ��������в���
		// ���ı�����ڱ�������calms������ڼ�������������

		// �½�һ����Ļ��壬�����潨����command��calckeys������ڸû�����
		JPanel panel1 = new JPanel();
		
		panel1.setOpaque(false);
		
		
		// ������ñ߽粼�ֹ����������������֮���ˮƽ�ʹ�ֱ�����ϼ����Ϊ3����
		panel1.setLayout(new BorderLayout(3, 3));
		panel1.add("North", commandsPanel);
		panel1.add("West", calckeysPanel);

		// ����һ��������ı���
		JPanel top = new JPanel();
		
		top.setOpaque(false);
		
		
		top.setLayout(new BorderLayout());
		top.add("Center", resultText);

		// ���岼��
		getContentPane().setLayout(new BorderLayout(3, 5));
		getContentPane().add("North", top);
		getContentPane().add("Center", panel1);
		getContentPane().add("West", calmsPanel);
		// Ϊ����ť����¼�������
		// ��ʹ��ͬһ���¼����������������󡣱������������implements ActionListener
		for (int i = 0; i < KEYS.length; i++) {
			keys[i].addActionListener(this);
		}
		for (int i = 0; i < COMMAND.length; i++) {
			commands[i].addActionListener(this);
		}
		for (int i = 0; i < M.length; i++) {
			m[i].addActionListener(this);
		}
	}

	/**
	 * �����¼�
	 */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ�ı�ǩ
		String label = e.getActionCommand();
		if (label.equals(COMMAND[0])) {
			// �û�����"Backspace"��
			handleBackspace();
		} else if (label.equals(COMMAND[1])) {
			// �û�����"CE"��
			resultText.setText("0");
		} else if (label.equals(COMMAND[2])) {
			// �û�����"C"��
			handleC();
		} else if ("0123456789.".indexOf(label) >= 0) {
			// �û��������ּ�����С�����
			handleNumber(label);
		} else {
			// �û������������
			handleOperator(label);
		}
	}

	/**
	 * ����Backspace�������µ��¼�
	 */
	private void handleBackspace() {
		String text = resultText.getText();
		int i = text.length();
		if (i > 0) {
			// �˸񣬽��ı����һ���ַ�ȥ��
			text = text.substring(0, i - 1);
			if (text.length() == 0) {
				// ����ı�û�������ݣ����ʼ���������ĸ���ֵ
				resultText.setText("0");
				firstDigit = true;
				operator = "=";
			} else {
				// ��ʾ�µ��ı�
				resultText.setText(text);
			}
		}
	}

	/**
	 * �������ּ������µ��¼�
	 * 
	 * @param key
	 */
	private void handleNumber(String key) {
		if (firstDigit) {
			// ����ĵ�һ������
			resultText.setText(key);
		} else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
			// �������С���㣬����֮ǰû��С���㣬��С���㸽�ڽ���ı���ĺ���
			resultText.setText(resultText.getText() + ".");
		} else if (!key.equals(".")) {
			// �������Ĳ���С���㣬�����ָ��ڽ���ı���ĺ���
			resultText.setText(resultText.getText() + key);
		}
		// �Ժ�����Ŀ϶����ǵ�һ��������
		firstDigit = false;
	}

	/**
	 * ����C�������µ��¼�
	 */
	private void handleC() {
		// ��ʼ���������ĸ���ֵ
		resultText.setText("0");
		firstDigit = true;
		operator = "=";
	}

	/**
	 * ����������������µ��¼�
	 * 
	 * @param key
	 */
	private void handleOperator(String key) {
		if (operator.equals("/")) {
			// ��������
			// �����ǰ����ı����е�ֵ����0
			if (getNumberFromText() == 0.0) {
				// �������Ϸ�
				operateValidFlag = false;
				resultText.setText("��������Ϊ��");
			} else {
				resultNum /= getNumberFromText();
			}
		} else if (operator.equals("1/x")) {
			// ��������
			if (resultNum == 0.0) {
				// �������Ϸ�
				operateValidFlag = false;
				resultText.setText("��û�е���");
			} else {
				resultNum = 1 / resultNum;
			}
		} else if (operator.equals("+")) {
			// �ӷ�����
			resultNum += getNumberFromText();
		} else if (operator.equals("-")) {
			// ��������
			resultNum -= getNumberFromText();
		} else if (operator.equals("*")) {
			// �˷�����
			resultNum *= getNumberFromText();
		} else if (operator.equals("sqrt")) {
			
			// ƽ��������
			resultNum = Math.sqrt(getNumberFromText());
		} else if (operator.equals("%")) {
			// �ٷֺ����㣬����100
			resultNum = resultNum / 100;
		} else if (operator.equals("+/-")) {
			// ������������
			resultNum = resultNum * (-1);
		} else if (operator.equals("=")) {
			// ��ֵ����
			resultNum = getNumberFromText();
		}
		if (operateValidFlag) {
			// ˫���ȸ�����������
			long t1;
			double t2;
			t1 = (long) resultNum;
			t2 = resultNum - t1;
			if (t2 == 0) {
				resultText.setText(String.valueOf(t1));
			} else {
				resultText.setText(String.valueOf(resultNum));
			}
		}
		// ����������û����İ�ť
		operator = key;
		firstDigit = true;
		operateValidFlag = true;
	}

	/**
	 * �ӽ���ı����л�ȡ����
	 * 
	 * @return
	 */
	private double getNumberFromText() {
		double result = 0;
		try {
			result = Double.valueOf(resultText.getText()).doubleValue();
		} catch (NumberFormatException e) {
		}
		return result;
	}	
}
