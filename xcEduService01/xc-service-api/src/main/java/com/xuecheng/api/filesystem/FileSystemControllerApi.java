package com.xuecheng.api.filesystem;

import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "文件管理接口")
public interface FileSystemControllerApi {

    @ApiOperation("上传文件")
    public UploadFileResult upload(MultipartFile file, String filetag, String businesskey, String metadata);


}
