package com.xuecheng.manage_course.dao;

import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.domain.system.SysDictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testCourseBaseRepository(){
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if(optional.isPresent()){
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }

    }

    @Test
    public void testCourseMapper(){
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);

    }
    @Test
    public void testFindByPAge(){
        PageHelper.startPage(1,1);
        com.github.pagehelper.Page<CourseBase> page = courseMapper.findByPage();
        System.out.println(page);
    }
    @Test
    public void testSave(){
        CourseBase courseBase = new CourseBase();
        courseBase.setId("1123");
        courseBase.setName("测试1213");
        courseBase.setMt("1123");
        courseBase.setGrade("1123");
        courseBase.setStudymodel("1123");
        courseBase.setSt("1123");
        //courseMapper.add(courseBase);
        CourseBase save = courseBaseRepository.save(courseBase);
        System.out.println(save);
    }
    @Test
    public void testFindList(){
        List<CategoryNode> list = courseMapper.findList();
        System.out.println(list);

    }
    @Autowired
    private SysDictionaryRepository sysDictionaryRepository;
    @Test
    public void testGetByType(){
        List<SysDictionary> all = sysDictionaryRepository.findByDType("100");
        System.out.println(all);
    }
}
