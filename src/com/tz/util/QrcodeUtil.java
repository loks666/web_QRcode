package com.tz.util;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @ClassName : QRcode
 * @Description : 二维码生成核心类
 * @author : 李翔/lok666
 * @date : 2017/11/10 AM11:40
 */
public class QrcodeUtil {
	
	/**
	 * @Description : 二维码生成核心方法
	 * @param content
	 * @param imgPath
	 */
	/**
	 * @param content
	 * @param imgPath
	 */
	public static void  QRcodeImg(String content,String imgPath) {
		try {
			//实例化一个QRcode对象
			Qrcode qrcode = new Qrcode();
			
			/*
			 *  设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)
			 *  排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			 */   
			qrcode.setQrcodeErrorCorrect('M');

			//编码格式
			qrcode.setQrcodeEncodeMode('B');
			//设置设置二维码尺寸版本，取值范围1-40，值越大尺寸越大，可存储的信息越大  
			qrcode.setQrcodeVersion(7);
			
			int width = 140;
			int height = 140;
			//开始绘制 ---> 画板
			BufferedImage bf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//创建绘制工具
			Graphics2D gs = bf.createGraphics();
			//设置背景色
			gs.setBackground(Color.white);
			//设置绘制区域
			gs.clearRect(0, 0, width, height);
			//设置画笔颜色
			gs.setColor(Color.pink);
			// 设置偏移量，不设置可能导致解析出错  
            int pixoff = 2; 
			
			//正式绘制  根据内容绘制
			byte[] contentByte = content.getBytes("utf-8");
			//二维数组
			boolean[][] codesOut = qrcode.calQrcode(contentByte);
			//拿到二维码里面的内容进行判断
			for (int i = 0; i < codesOut.length; i++) {
				for (int j = 0; j < codesOut.length; j++) {
					if(codesOut[j][i]){
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3); 
					}
				}
			}
			gs.dispose();
			
			//文件写出
			File imageFile = new File(imgPath);
			ImageIO.write(bf, "png", imageFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		QRcodeImg("这是一个版本为7*7的二维码",
				"C:/Users/Administrator/Desktop/shop/QRcode.png");
		//前面一个是要存储的信息，后面的是生成文件的路径
		System.out.println("文件已生成，请查看");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
