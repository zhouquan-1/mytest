package com.xuecheng.manage_course.Controller;


import com.xuecheng.api.course.SysDictionaryControllerApi;
import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SysDictionary")
public class SysDictionaryController  implements SysDictionaryControllerApi {


    @Override
    public SysDictionary getByType(String type) {
        return null;
    }
}
