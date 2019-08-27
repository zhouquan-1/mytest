package com.xuecheng.manage_course.Controller;


import com.github.pagehelper.Page;
import com.xuecheng.api.course.CourseControllerApi;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.domain.course.response.CourseCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi {
    @Autowired
    private CourseService courseService;

    @Override
    @GetMapping("/findByPage/{page}/{size}")
    public Page<CourseBase> findByPage(@PathVariable int page, @PathVariable int size) {

        return courseService.findByPage(page, size);
    }

    @Override
    @PostMapping("/add")
    public AddCourseResult add(@RequestBody CourseBase courseBase) {

        return courseService.add(courseBase);
    }

    @Override
    @GetMapping("/findList")
    public List<CategoryNode> findList() {
        return courseService.findList();
    }

    @Override
    @PostMapping("/coursePic/add")
    public ResponseResult addCoursePic(@RequestParam(value = "courseId") String courseId,
                                       @RequestParam(value = "pic") String pic) {
        return courseService.saveCoursePic(courseId, pic);
    }

    @Override
    @GetMapping("/coursePic/find/{courseId}")
    public CoursePic findCoursePic(@PathVariable("courseId") String courseId) {
        return courseService.findCoursePic(courseId);
    }

    @Override
    @GetMapping("/coursePic/delete/{courseId}")
    public ResponseResult deleteCoursePic(@PathVariable String courseId) {
        return courseService.deleteCoursePic(courseId);
    }
}
