package com.cr.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRCodeController {
	private static void createORcode() throws UnsupportedEncodingException, IOException {
        Qrcode qrcode=new Qrcode();
        qrcode.setQrcodeErrorCorrect('M'); //纠错等级L M Q H
        qrcode.setQrcodeEncodeMode('B'); //N:数字，A:a-Z ,B:其他字符
        int version = 7;
        qrcode.setQrcodeVersion(version);
        String qrData="www.baidu.com";
        byte data[]=qrData.getBytes("gb2312");
        int width = 67+12*(version-1);
        int hight = 67+12*(version-1);
        BufferedImage bufferedImage=new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d=bufferedImage.createGraphics();
        graphics2d.setBackground(Color.white);
        graphics2d.setColor(Color.black);
        graphics2d.clearRect(0, 0, width, hight);
        int pixoff=2; //偏移量
        if (data.length>0 && data.length<120) {
            boolean[][] s=qrcode.calQrcode(data);
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        graphics2d.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
                    }
                }
            }
        }
        graphics2d.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage, "png", new File("D:/360/imag.png"));
    }
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		createORcode();
	}
}
