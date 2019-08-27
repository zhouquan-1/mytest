package com.xuecheng.manage_course.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.domain.course.response.CourseCode;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import com.xuecheng.manage_course.dao.CourseBaseRepository;
import com.xuecheng.manage_course.dao.CourseMapper;
import com.xuecheng.manage_course.dao.CoursePicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseBaseRepository courseBaseRepository;

    public Page<CourseBase> findByPage(int page, int size){
        PageHelper.startPage(page,size);
        Page<CourseBase> byPage = courseMapper.findByPage();
        return byPage;

    }

    public AddCourseResult add(CourseBase courseBase) {
        if(courseBase==null){
            ExceptionCast.cast(CourseCode.COURSE_IS_NULL);
        }
        courseBaseRepository.save(courseBase);
        return new AddCourseResult(CourseCode.SUCCESS,courseBase.getId());
    }

    public List<CategoryNode> findList() {
        return courseMapper.findList();
    }

    @Autowired
    private CoursePicRepository coursePicRepository;
    @Transactional
    public ResponseResult saveCoursePic(String courseId, String pic){
        Optional<CoursePic> optional = coursePicRepository.findById(courseId);
        CoursePic coursePic=null;
        if(optional.isPresent()){
            coursePic = optional.get();
        }
        if(coursePic==null){
            coursePic=new CoursePic();
        }
        coursePic.setCourseid(courseId);
        coursePic.setPic(pic);
        coursePicRepository.save(coursePic);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public CoursePic findCoursePic(String courseId) {
        Optional<CoursePic> optional = coursePicRepository.findById(courseId);
        if(optional==null){
            return null;
        }
        return optional.get();
    }
    @Transactional
    public ResponseResult deleteCoursePic(String courseId) {
        CoursePic coursePic = findCoursePic(courseId);
        if(coursePic==null){
            return new ResponseResult(CommonCode.FAIL);
        }
        coursePicRepository.deleteById(courseId);
        return new ResponseResult((CommonCode.SUCCESS));
    }
}
