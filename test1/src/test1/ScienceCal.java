package test1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class ScienceCal extends JFrame implements ActionListener {
	private final String[] KEYS = {"��","CE","C","sin","cos","tan","lg","ln","e^x",
			"arcsin","arccos","arctan",
			"7", "8", "9", "+","x��y", "n!","4", "5", "6","-","x^2","3��x",
			 "1", "2", "3","*","x^y","��", "0","+/-",".","/","��","=", };
	//�������ϵĹ��ܼ�����ʾ���� */ 
	private final String[] M = { " ", "MC", "MR", "MS", "M+" };
	//�������ϼ��İ�ť */
	 private JButton keys[] = new JButton[KEYS.length];
	
	// �������ϵĹ��ܼ��İ�ť */
	private JTextField resultText = new JTextField("0");
	// ��־�û������Ƿ����������ʽ�ĵ�һ������,�������������ĵ�һ������
	private boolean firstDigit = true;
	// ������м�����
	private double resultNum = 0.0;
	// ��ǰ����������
	private String operator = "=";
	// �����Ƿ�Ϸ�
	private boolean operateValidFlag = true;
	//���þ��ȣ�����һЩ����BUG����cos60 = 0.5000000...1���ĳ��֡�
	DecimalFormat df = new DecimalFormat( "0.000000");  

	/**
	 * ���캯��
	 */
	public ScienceCal() {
		super();
		// ��ʼ��������
		init();
		
		ImageIcon img = new ImageIcon("image\\blue2.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false); 
		
		JMenuBar mb = new JMenuBar();//�����˵���
		JMenu b1 = new JMenu("����");
		JMenu b2 = new JMenu("����");
		JMenuItem c1 = new JMenuItem("��ҳ");
		JMenuItem c2 = new JMenuItem("��ѧ������");
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
		this.setTitle("��ѧ������");
		// ����Ļ(300, 200)���괦��ʾ������
		this.setLocation(300, 200);
		
		// �����޸ļ������Ĵ�С
		this.setResizable(false);
		// ʹ�������и������С����
		this.pack();
		//this.setVisible(true);
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
		
		// �����񲼾�����6�У�6�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
		calckeysPanel.setLayout(new GridLayout(6, 6, 3, 3));
		for (int i = 0; i < KEYS.length; i++) {
			keys[i] = new JButton(KEYS[i]);
			calckeysPanel.add(keys[i]);
			keys[i].setForeground(Color.blue);
			keys[i].setBackground(Color.white);
			keys[i].setFont(new Font("����", Font.PLAIN, 17));
		}
		// ��������ú�ɫ��ʾ������������ɫ��ʾ
		keys[20].setForeground(Color.black);
		keys[18].setForeground(Color.black);
		keys[19].setForeground(Color.black);
		keys[12].setForeground(Color.black);
		keys[13].setForeground(Color.black);
		keys[14].setForeground(Color.black);
		keys[24].setForeground(Color.black);
		keys[25].setForeground(Color.black);
		keys[26].setForeground(Color.black);
		
		keys[20].setBackground(Color.white);
		keys[18].setBackground(Color.white);
		keys[19].setBackground(Color.white);
		keys[12].setBackground(Color.white);
		keys[13].setBackground(Color.white);
		keys[14].setBackground(Color.white);
		keys[24].setBackground(Color.white);
		keys[25].setBackground(Color.white);
		keys[26].setBackground(Color.white);


	

		// ������м����������岼�֣���calckeys��command������ڼ��������в���
		// ���ı�����ڱ�������calms������ڼ�������������

		// �½�һ����Ļ��壬�����潨����command��calckeys������ڸû�����
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		// ������ñ߽粼�ֹ����������������֮���ˮƽ�ʹ�ֱ�����ϼ����Ϊ3����
		panel1.add( calckeysPanel);

		// ����һ��������ı���
		JPanel top = new JPanel();
		top.setOpaque(false);
		top.setLayout(new BorderLayout());
		top.add("Center", resultText);

		// ���岼��
		getContentPane().add("North", top);
		getContentPane().add("Center", panel1);
		for (int i = 0; i < KEYS.length; i++) {
			keys[i].addActionListener(this);
		}
	}

	/**
	 * �����¼�
	 */
	public void actionPerformed(ActionEvent e) {
		// ��ȡ�¼�Դ�ı�ǩ
		String label = e.getActionCommand();
		if (label.equals("��")) {
			// �û�����"��"��
			handleBackspace();
		} else if (label.equals("CE")) {
			// �û�����"CE"��
			resultText.setText("0");
		} else if (label.equals("C")) {
			// �û�����"C"��
			handleC();
		} else if ("0123456789.".indexOf(label) >= 0) {
			// �û��������ּ�����С�����
			handleNumber(label);
			// handlezero(zero);
		} else {
			// �û������������
			handleOperator(label);
		}
	}

	/**
	 * ������������µ��¼�
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
		} else if (operator.equals("��")) {
			
			// ƽ��������
			resultNum = Math.sqrt(resultNum);
		} else if (operator.equals("%")) {
			// �ٷֺ����㣬����100
			resultNum = resultNum / 100;
		} else if (operator.equals("+/-")) {
			// ������������
			resultNum = resultNum * (-1);
		}
		else if (operator.equals("sin")) {
			// sin����
			resultNum = Double.parseDouble(df.format(Math.sin(Math.toRadians(getNumberFromText()))));
		}
		else if (operator.equals("cos")) {
			// cos����
			resultNum = Double.parseDouble(df.format(Math.cos(Math.toRadians(getNumberFromText()))));
		}
		else if (operator.equals("tan")) {
			// tan����
			resultNum = Double.parseDouble(df.format(Math.tan(Math.toRadians(getNumberFromText()))));
		}
		else if (operator.equals("x^2")) {
			// ƽ������
			resultNum = Double.parseDouble(df.format(Math.pow(resultNum,2)));
		}
		else if (operator.equals("3��x")) {
			// ��������
			resultNum = Math.cbrt(resultNum);
			
		}
		
		else if (operator.equals("x^y")) {
			// �η�����
			resultNum = Math.pow(resultNum,getNumberFromText());
		}
		else if (operator.equals("e^x")) {
			// �η�����
			resultNum = Math.pow(Math.E,getNumberFromText());
		}
		else if (operator.equals("ln")) {
			// ln����
			resultNum = Math.log(resultNum);
		}
		else if (operator.equals("lg")) {
			// lg����
			resultNum = Math.log10(resultNum);
		}
		else if (operator.equals("arcsin")) {
			// ���������� Math.asin���ص��ǻ��� ��Ҫת��Ϊ�Ƕ�
			//.format���ص���String,��Ҫ����Double.parseDouble()����ת��Ϊdouble����

			resultNum = Double.parseDouble(df.format(Math.asin(resultNum)/Math.PI*180));
			
		}
		else if (operator.equals("arccos")) {
			// ����������
			resultNum = Double.parseDouble(df.format(Math.acos(resultNum)/Math.PI*180));
		}
		else if (operator.equals("arctan")) {
			// ����������
			resultNum = Double.parseDouble(df.format(Math.atan(resultNum)/Math.PI*180));
		}
		else if (operator.equals("x��y")) {
			// 
			resultNum = Math.pow(resultNum,1/getNumberFromText());
		}
		else if(operator.equals("n!")){
			resultNum = func(resultNum);
		}
		else if(operator.equals("��")){
			resultNum = Math.PI;
		}
		
		else if (operator.equals("=")) {
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
	private int func(double d){
		int result=1;
		for(int i=2;i<=d;++i)
			result*=i;
		return result;
	}

	
}
