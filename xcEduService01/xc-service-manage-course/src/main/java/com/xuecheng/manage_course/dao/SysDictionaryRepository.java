package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SysDictionaryRepository extends MongoRepository<SysDictionary,String> {
    //@Query(fields = "dType", value="#{type}")
    List<SysDictionary> findByDType(String type);
}
