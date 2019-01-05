package com.xustmall.service.Impl;

import com.google.common.collect.Lists;
import com.xustmall.service.IFileService;
import com.xustmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        //获取扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);
        File fileDir = new File(path);
        if(!fileDir.exists()){
            //赋予该文件夹写操作的权限
            fileDir.setWritable(true);
            //逐层创建文件夹  与linux一样
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try{
            file.transferTo(targetFile);
            //文件上传成功
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除文件夹
            targetFile.delete();
        }catch (Exception e){
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }
}
