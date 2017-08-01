package com.hxh.util;

import org.apache.commons.net.ftp.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by think on 2015/4/7.
 */
public class FtpUtil {

    public static PropertiesUtil pu = new PropertiesUtil("ftp.properties");

    /**
     * 获得连接-FTP方式
     * @param hostName FTP服务器地址
     * @param port FTP服务器端口
     * @param userName FTP登录用户名
     * @param passWord FTP登录密码
     * @return FTPClient
     */
    public static FTPClient getConnectionFTP(String hostName, int port, String userName, String passWord) {
        //创建FTPClient对象
        FTPClient ftp = new FTPClient();





        try {
            //连接FTP服务器
            ftp.connect(hostName, port);
            //下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            //登录ftp
            ftp.login(userName, passWord);
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                // System.out.println("连接服务器失败");
            }
            //  System.out.println("登陆服务器成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     * 关闭连接-FTP方式
     * @param ftp FTPClient对象
     * @return boolean
     */
    public static boolean closeFTP(FTPClient ftp) {
        if (ftp.isConnected()) {
            try {
                ftp.disconnect();
                //System.out.println("ftp已经关闭");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 上传文件-FTP方式
     * @param fileName 文件名
     * @param inputStream 文件输入流
     * @return boolean
     */
    public static String uploadFile(String fileName, InputStream inputStream) {
        FTPClient ftp = getConnectionFTP(pu.getValue("hostName"),Integer.parseInt(pu.getValue("port")), pu.getValue("userName"), pu.getValue("passWord"));
        //String fullUrl = new String("");
        try {
            String path  = File.separator;
            FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表
            String fileSuff = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
            String dateFormat = format.format(new Date());
            // 文件名yyMMdd+UUID.xxx形式
            fileName = dateFormat + UUID.randomUUID().toString()+fileSuff;
            fileName = changeName(fileName, fs);
            //将上传文件存储到指定目录
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
            ftp.storeFile(fileName, inputStream);
            //关闭输入流
            inputStream.close();
            //退出ftp
            ftp.logout();
            //表示上传成功
            //fullUrl = path+File.separator+fileName;
            // System.out.println("上传成功。。。。。。"+fileName	);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeFTP(ftp);
        }
        return fileName;
    }

    /**
     * 判断是否有重名文件
     * @param fileName
     * @param fs
     * @return
     */
    public static boolean isFileNameExist(String fileName, FTPFile[] fs) {
        for (int i = 0; i < fs.length; i++) {
            FTPFile ff = fs[i];
            if (ff.getName().equals(fileName)) {
                return true; //如果存在返回 正确信号
            }
        }
        return false; //如果不存在返回错误信号
    }

    /**
     * 根据重名判断的结果 生成新的文件的名称
     * @param fileName
     * @param fs
     * @return
     */
    public static String changeName(String fileName, FTPFile[] fs) {
        int n = 0;
        while (isFileNameExist(fileName.toString(), fs)) {
            n++;
            String a = "[" + n + "]";
            int b = fileName.lastIndexOf(".");//最后一出现小数点的位置
            int c = fileName.lastIndexOf("[");//最后一次"["出现的位置
            if (c < 0) {
                c = b;
            }
            StringBuffer name = new StringBuffer(fileName.substring(0, c));//文件的名字
            StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));//后缀的名称
            fileName = name.append(a) + "." + suffix;
        }
        return fileName.toString();
    }

    /**
     * 下载文件到本地
     * @param fileName 本地文件名称
     * @param localPath 本里存储路径
     * @return boolean
     */
    public static boolean downFile(String fileName, String localPath) {
        FTPClient ftp = getConnectionFTP(pu.getValue("hostName"),Integer.parseInt(pu.getValue("port")), pu.getValue("userName"), pu.getValue("passWord"));
        boolean     downSign = true;
        String path = "/usr/share/ftpfile/";
            try{

//        FTPClient ftp = new FTPClient();
//        boolean downSign = false;
//        try {
//            // ftp登录用户名
//            String userName = "hxh";
//            // ftp登录密码
//            String userPassword = "50d6d4b4-783c-47f9-938d-214c8fa68f6d";
//            // ftp地址:直接IP地址
//            String server = "120.24.65.16";
//            // 创建的文件
//
//            // 指定写入的目录
//            String path = "/usr/share/ftpfile/";
//
//
//
//
//
//
//            int reply;
//            //1.连接服务器
//
//            ftp.connect(server);
            ftp.enterLocalPassiveMode();
            //2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
//            ftp.login(userName, userPassword);

            ftp.changeWorkingDirectory(path);// 转移到FTP服务器目录


//            FTPFile[] fs = ftp.listFiles();
//            for (FTPFile ff : fs) {
//                //解决中文乱码问题，两次解码
////                byte[] bytes=ff.getName().getBytes("iso-8859-1");
////                String fn=new String(bytes,"utf8");
//                if (ff.getName().equals(fileName)) {
//                    //6.写操作，将其写入到本地文件中
//                    File localFile = new File(localPath + ff.getName());
//                    OutputStream is = new FileOutputStream(localFile);
//                    ftp.retrieveFile(ff.getName(), is);
//                    is.flush();
//                    is.close();
//                }
//            }



            String[] fsn = ftp.listNames(fileName); //查询文件是否存在
            if (fsn.length != 0) {
                File file = new File(localPath);
                if (!file.exists()) {
                    file.mkdir();
                }
                File localFile = new File(localPath + fileName);
                OutputStream outputStream = new FileOutputStream(localFile);
                //将文件保存到输出流outputStream中
                ftp.retrieveFile(fileName, outputStream);
                outputStream.flush();
                outputStream.close();
            }
                else
                downSign =false;
            ftp.logout();
//            downSign = true;


        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            closeFTP(ftp);
        }
        return downSign;
    }

    /**
     * 删除当前日期以前的FTP文件
     * @param fileDate 文件日期前缀
     * @return boolean
     */
    public static boolean delFile(String fileDate) {
        FTPClient ftp = getConnectionFTP(pu.getValue("hostName"),Integer.parseInt(pu.getValue("port")), pu.getValue("userName"), pu.getValue("passWord"));
        boolean downSign = false;
        try {
            String [] fileNames = ftp.listNames();
            if (fileNames.length > 0) {
                for (String fileName : fileNames) {
                    String prefix = fileName.substring(0,6);
                    if (fileDate.compareTo(prefix) > 0) {
                        ftp.deleteFile(fileName);
                    }
                }
            }
            ftp.logout();
            downSign = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeFTP(ftp);
        }
        return downSign;
    }

}
