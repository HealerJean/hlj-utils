package com.hlj.util.Z007二维码.job.my;


import com.hlj.util.Z007二维码.QRcode.BufferedImageUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.URL;

/**
 * @Desc:
 * @Author HealerJean
 * @Date 2018/6/29  上午11:10.
 */
public class MainServiceZi {

    public static void main(String[] args) throws Exception {


        File file = new File("/Users/healerjean/Desktop/id.jpg");
        FileOutputStream outputStream = new FileOutputStream(file);

        BufferedImage urlimage = ImageIO.read(new URL("https://img.alicdn.com/imgextra/i1/3694212174/TB21Wb_jlsmBKNjSZFFXXcT9VXa_!!3694212174.jpg"));

        BufferedImage imageQR  = BufferedImageUtils.reduceImg(urlimage,375*2,375*2,null);

        URL u = new URL("http://admore.oss-cn-beijing.aliyuncs.com/admin/duodianyouhui/itemgood/6a4507a16213460ab3476a3204a9e5bc.png");

        BufferedImage titleLab = ImageIO.read(u);

        BufferedImage  ErWeiMaImage =  BufferedImageUtils.writeQRImg("http://admore.oss-cn-beijing.aliyuncs.com/duodian-youhui/index.html#/44",300,300,3);

        String title = "AAAAAAAAAAAAAA千妇恋-日本进口温和控油洗面奶30g";
        BigDecimal originPrice =new BigDecimal("88.9");
        BigDecimal  nowPrice  =new BigDecimal("39.9");
        BigDecimal couponPrice  =new BigDecimal("10");
        String description = "布衣不二旗舰店，之前推布衣不二旗舰店，";
        String lable = "包邮,七天无理由退换,新品爆款";


        CouponAdzoneFoodieTagZi couponAdzoneFoodieTag = new CouponAdzoneFoodieTagZi() ;



        //整体图合成
        BufferedImage temp = new BufferedImage(375, 677, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = temp.createGraphics();
        main.fillRect(0, 0, 375, 677);

        int lovelyImageWidth = 375*30,lovelyImageHeight =677*30 ;
        //话痨内容hualaoContent
        Graphics2D hualaoContent = temp.createGraphics();
        hualaoContent.setColor(new Color(37,37,37));
        Font hualaoContentFont = new Font("PingFang SC", Font.PLAIN, 14*30);
        hualaoContent.setFont(hualaoContentFont);
        hualaoContent.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

        FontMetrics fm = hualaoContent.getFontMetrics();

        int hualaoFirstLineWight = fm.stringWidth(couponAdzoneFoodieTag.getContent());



        if(hualaoFirstLineWight<=(311*30*2)) {
            lovelyImageWidth = 375*30;
            lovelyImageHeight = 677*30;
        }else if((hualaoFirstLineWight>311*30*2)&&hualaoFirstLineWight<=(311*30*3)) {
            lovelyImageWidth = 375*30;
            lovelyImageHeight = 707*30;
        }else if((hualaoFirstLineWight>311*30*3)) {
            lovelyImageWidth = 375*30;
            lovelyImageHeight = 730*30;
        }



        BufferedImage bufferedImage = ChartGraphicsZi.graphicsGenerationlovely(imageQR, ErWeiMaImage,titleLab,title,originPrice,nowPrice,couponPrice+"",description,lable, couponAdzoneFoodieTag,lovelyImageWidth,lovelyImageHeight);





        BufferedImage bufferedImageFinal =  BufferedImageUtils.reduceImg(bufferedImage, lovelyImageWidth/10, lovelyImageHeight/10, null);

        ImageIO.write(bufferedImageFinal, "jpg", outputStream);

    }
}




