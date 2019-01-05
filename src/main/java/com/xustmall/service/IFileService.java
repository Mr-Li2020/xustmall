package com.xustmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
* @Description:    用来处理文件
* @Author:         liningbo
* @CreateDate:     2019/1/4 23:52
* @UpdateUser:     liningbo
* @UpdateDate:     2019/1/4 23:52
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface IFileService {
    String upload(MultipartFile file, String path);
}
