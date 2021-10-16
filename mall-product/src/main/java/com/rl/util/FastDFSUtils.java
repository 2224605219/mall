package com.rl.util;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.stereotype.Component;

/**   FastDFS工具类
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/8/15 9:08
 */
@Component
public class FastDFSUtils {

    private static String configPath = "D:\\IDEA\\MyFiles\\mall\\mall-product\\src\\main\\resources\\client.conf";

    public static String upload(byte[] fileBuffer,String exName){
        String[] uploadFilePath = new String[0];
        try {
            //加载配置文件
            ClientGlobal.init(configPath);

            //创建trackerClient
            TrackerClient trackerClient = new TrackerClient();

            //通过trackerClient获取TrackerServer
            TrackerServer trackerServer = trackerClient.getConnection();

            //创建storageClient
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,storageServer);

            NameValuePair[] nameValuePairs = new NameValuePair[]{new NameValuePair("item_id","1")};
            //上传文件
            uploadFilePath = storageClient.upload_file(fileBuffer, exName, nameValuePairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadFilePath[0]+"/"+uploadFilePath[1];
    }

}
