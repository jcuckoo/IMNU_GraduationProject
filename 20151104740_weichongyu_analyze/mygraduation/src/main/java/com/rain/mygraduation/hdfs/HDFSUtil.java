package com.rain.mygraduation.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

public class HDFSUtil {

    FileSystem fs = null;



//    这是先行运行的函数，在其他函数运行之前，将配置写好
    @Before
    public void init() throws Exception{

        //读取classpath下的xxx-site.xml 配置文件，并解析其内容，封装到conf对象中
//        可以将core-site.xml导入到项目中
        Configuration conf = new Configuration();

        //也可以在代码中对conf中的配置信息进行手动设置，会覆盖掉配置文件中的读取的值
        conf.set("fs.defaultFS", "hdfs://hmaster:9000/");

        //根据配置信息，去获取一个具体文件系统的客户端操作实例对象
        fs = FileSystem.get(new URI("hdfs://hmaster:9000/"),conf,"hadoop");

    }



    /**
     * 上传文件，比较底层的写法
     *
     * @throws Exception
     */
    @Test
    public void upload_old() throws Exception {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://hmaster:9000/");

        FileSystem fs = FileSystem.get(conf);

        Path dst = new Path("hdfs://hmaster:9000/data/sample.txt");

        FSDataOutputStream os = fs.create(dst);

        FileInputStream is = new FileInputStream("/Users/rain/Downloads/sample.txt");

        IOUtils.copy(is, os);


    }

    /**
     * 上传文件，封装好的写法
     * @throws Exception
     * @throws IOException
     */
    @Test
    public void upload() throws Exception, IOException{

//        前面为上传文件的路径，后面是HDFS中的路径和文件的新名称
        fs.copyFromLocalFile(new Path("/Users/rain/Downloads/sample.txt"), new Path("hdfs://hmaster:9000/data/test.txt"));

    }


    /**
     * 下载文件
     * @throws Exception
     * @throws IllegalArgumentException
     */
    @Test
    public void download() throws Exception {
//      前面是HDFS中文件的路径，后面是要下载到本地的路径以及名称
        fs.copyToLocalFile(new Path("hdfs://hmaster:9000/sample.txt"), new Path("/Users/rain/Downloads/sample.txt"));

    }

    /**
     * 查看文件信息
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws FileNotFoundException
     *
     */
    @Test
    public void listFiles() throws FileNotFoundException, IllegalArgumentException, IOException {

        // listFiles列出的是文件信息，而且提供递归遍历
        RemoteIterator<LocatedFileStatus> files = fs.listFiles(new Path("/data"), true);

        while(files.hasNext()){

            LocatedFileStatus file = files.next();
            Path filePath = file.getPath();
            String fileName = filePath.getName();
            System.out.println(fileName);

        }

        System.out.println("---------------------------------");

        //listStatus 可以列出文件和文件夹的信息，但是不提供自带的递归遍历
        FileStatus[] listStatus = fs.listStatus(new Path("/data"));
        for(FileStatus status: listStatus){

            String name = status.getPath().getName();
            System.out.println(name + (status.isDirectory()?" is dir":" is file"));

        }

    }

    /**
     * 创建文件夹
     * @throws Exception
     * @throws IllegalArgumentException
     */
    @Test
    public void mkdir() throws IllegalArgumentException, Exception {

        fs.mkdirs(new Path("/data/test"));


    }

    /**
     * 删除文件或文件夹
     * @throws IOException
     * @throws IllegalArgumentException
     */
    @Test
    public void rm() throws IllegalArgumentException, IOException {

        fs.delete(new Path("/data/test"), true);

    }


    public static void main(String[] args) throws Exception {


    }



}
