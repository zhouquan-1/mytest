package com.xuecheng.filesystem.controller;

import com.xuecheng.api.filesystem.FileSystemControllerApi;
import com.xuecheng.filesystem.service.FileSystemService;
import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import com.xuecheng.framework.model.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi{
    @Autowired
    FileSystemService fileSystemService;

    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "filetag",required = true) String filetag,
                                   @RequestParam(value = "businesskey",required = false) String businesskey,
                                   @RequestParam(value = "metadata",required = false) String metadata)
    {
        return fileSystemService.upload(file,filetag,businesskey,metadata);
    }



}
