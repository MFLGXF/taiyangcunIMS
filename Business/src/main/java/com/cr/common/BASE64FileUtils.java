package com.cr.common;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * ClassName: BASE64FileUtils <br/>
 * Reason: Base64与文件互转. <br/>
 * date: 2017年8月25日 下午7:05:51 <br/>
 *
 * @author pengzhengming
 * @version
 * @since JDK 1.8
 */
@SuppressWarnings("restriction")
public class BASE64FileUtils{

    /**
     *
     * 文件转化成base64字符串. <br/>
     *
     * @author pengzhengming
     * @param filePath 文件路径
     * @return
     * @since JDK 1.8
     */
    public static String getStr(String filePath) {
        // 将文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取文件字节数组
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }catch (IOException e){
           
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    /**
    *
    * 文件转化成base64字符串. <br/>
    *
    * @author pengzhengming
    * @param filePath 文件路径
    * @return
    * @since JDK 1.8
    */
   public static String getStr(byte[] b) {
       // 对字节数组Base64编码
       BASE64Encoder encoder = new BASE64Encoder();
       // 返回Base64编码过的字节数组字符串
       return encoder.encode(b);
   }

    /**
     *
     * 文件转化成base64字符串. <br/>
     *
     * @author pengzhengming
     * @param fileUrl 文件http地址
     * @return
     * @since JDK 1.8
     */
    public static String getStrRemote(String fileUrl) {
        // 将文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream inStream = null;
        byte[] data = null;
        // 读取文件字节数组
        try {
            // new一个URL对象
            URL url = new URL(fileUrl);
            // 打开链接
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            // 通过输入流获取文件数据
            inStream = conn.getInputStream();
            // 得到文件的二进制数据，以二进制封装得到数据，具有通用性
            data = readInputStream(inStream);
        } catch (Exception e){
           
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    /**
     *
     * base64字符串转化成文件. <br/>
     *
     * @author pengzhengming
     * @param str
     * @param filePath
     * @return
     * @since JDK 1.8
     */
    public static Boolean generateFile(String str, String filePath) {
        // 对字节数组字符串进行Base64解码并生成文件
        Boolean Flag = false;
        // 文件数据为空
        if (str == null)
            return Flag;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(str);

            for(int i=0;i<b.length;++i){
                if(b[i]<0){
                    b[i]+=256;
                }
            }
            // 生成文件
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
            Flag = true;
        } catch (Exception e) {
            
        }
        return Flag;
    }

    /**
     *
     * base64字符串转化成文件. <br/>
     *
     * @author pengzhengming
     * @param imgStr
     * @return
     * @since JDK 1.8
     */
    public static byte[] generateImage(String str) {
        // 对字节数组字符串进行Base64解码并生成文件
        byte[] b = new byte[]{};
        // 文件数据为空
        if (str == null)
            return b;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            //b = Base64.decodeBase64(str);
            b = decoder.decodeBuffer(str);
            for(int i=0;i<b.length;++i){
                if(b[i]<0){
                    b[i]+=256;
                }
            }
        } catch (Exception e) {
            
        }
        return b;
    }

    /**
     *
     * 读取输入流<br/>
     *
     * @author pengzhengming
     * @param inStream
     * @return
     * @throws Exception
     * @since JDK 1.8
     */
    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // 创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        // 每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        // 使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inStream.close();
        // 把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
