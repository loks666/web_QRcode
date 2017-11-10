package com.tz.util;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @ClassName : QRcode
 * @Description : ��ά�����ɺ�����
 * @author : ����/lok666
 * @date : 2017/11/10 AM11:40
 */
public class QrcodeUtil {
	
	/**
	 * @Description : ��ά�����ɺ��ķ���
	 * @param content
	 * @param imgPath
	 */
	/**
	 * @param content
	 * @param imgPath
	 */
	public static void  QRcodeImg(String content,String imgPath) {
		try {
			//ʵ����һ��QRcode����
			Qrcode qrcode = new Qrcode();
			
			/*
			 *  ���ö�ά���Ŵ��ʣ���ѡL(7%)��M(15%)��Q(25%)��H(30%)
			 *  �Ŵ���Խ�߿ɴ洢����ϢԽ�٣����Զ�ά�������ȵ�Ҫ��ԽС
			 */   
			qrcode.setQrcodeErrorCorrect('M');

			//�����ʽ
			qrcode.setQrcodeEncodeMode('B');
			//�������ö�ά��ߴ�汾��ȡֵ��Χ1-40��ֵԽ��ߴ�Խ�󣬿ɴ洢����ϢԽ��  
			qrcode.setQrcodeVersion(7);
			
			int width = 140;
			int height = 140;
			//��ʼ���� ---> ����
			BufferedImage bf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//�������ƹ���
			Graphics2D gs = bf.createGraphics();
			//���ñ���ɫ
			gs.setBackground(Color.white);
			//���û�������
			gs.clearRect(0, 0, width, height);
			//���û�����ɫ
			gs.setColor(Color.pink);
			// ����ƫ�����������ÿ��ܵ��½�������  
            int pixoff = 2; 
			
			//��ʽ����  �������ݻ���
			byte[] contentByte = content.getBytes("utf-8");
			//��ά����
			boolean[][] codesOut = qrcode.calQrcode(contentByte);
			//�õ���ά����������ݽ����ж�
			for (int i = 0; i < codesOut.length; i++) {
				for (int j = 0; j < codesOut.length; j++) {
					if(codesOut[j][i]){
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3); 
					}
				}
			}
			gs.dispose();
			
			//�ļ�д��
			File imageFile = new File(imgPath);
			ImageIO.write(bf, "png", imageFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		QRcodeImg("����һ���汾Ϊ7*7�Ķ�ά��",
				"C:/Users/Administrator/Desktop/shop/QRcode.png");
		//ǰ��һ����Ҫ�洢����Ϣ��������������ļ���·��
		System.out.println("�ļ������ɣ���鿴");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
