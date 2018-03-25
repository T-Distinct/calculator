package test1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

class ImagePane extends JPanel {

	Image image;
	BufferedImage bufImage; //������ʾ�Ļ�����ͼ��
	BufferedImage originalBufImage; //ԭʼ������ͼ��
	Graphics2D bufImageG; //������ͼ���ͼ�λ��� 

	public void loadImage(String fileName) {
		image = this.getToolkit().getImage(fileName); //ȡ��ͼ��
		MediaTracker mt = new MediaTracker(this); //ʵ����ý�������
		mt.addImage(image, 0); //����ͼ�񵽼�������
		try {
			mt.waitForAll(); //�ȴ�ͼƬ����
		} catch (Exception ex) {
			ex.printStackTrace(); //���������Ϣ
		}
		originalBufImage = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB); //����ԭʼ������ͼ��
		bufImage = originalBufImage;
		bufImageG = bufImage.createGraphics(); //����bufImage��ͼ�λ���
		bufImageG.drawImage(image, 0, 0, this); //����Դͼ�����ݵ�������ͼ����
		repaint(); //�ػ����
	}
	//����ͼ��
	public void ratoteImage(double angle) {
		if (bufImage == null)
			return; //���bufImageΪ����ֱ�ӷ���
		BufferedImage filteredBufImage =new BufferedImage(image.getWidth(this) ,image.getHeight(this),BufferedImage.TYPE_INT_ARGB); //���˺��ͼ��
		AffineTransform transform = new AffineTransform(); //����任����
		transform.rotate(angle,image.getWidth(this)/2 ,image.getHeight(this)/2); //��תͼ��
		AffineTransformOp imageOp = new AffineTransformOp(transform, null);//��������任�������� 
		imageOp.filter(originalBufImage, filteredBufImage);//����ͼ��Ŀ��ͼ����filteredBufImage
		bufImage = filteredBufImage; //��������ʾ�Ļ�����ͼ��ָ����˺��ͼ��
		repaint(); //�ػ����
	}

	//����������paintComponent()����
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (bufImage != null) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(bufImage,0,0,this); //����ͼƬ
		}
	}
}