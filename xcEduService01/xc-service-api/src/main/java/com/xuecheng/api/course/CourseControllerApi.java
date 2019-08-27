package com.xuecheng.api.course;


import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.github.pagehelper.Page;

import java.util.List;


@Api(value = "课程管理接口", description = "课程管理接口，课程的查询，新增，修改")
public interface CourseControllerApi {

    @ApiOperation("分页查询课程")
    public Page<CourseBase> findByPage(int page, int size);

    @ApiOperation("增加课程")
    public AddCourseResult add(CourseBase courseBase);

    @ApiOperation("查询课程分类")
    public List<CategoryNode> findList();

    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId, String pic);

    @ApiOperation("获取课程基础信息")
    public CoursePic findCoursePic(String courseId);

    @ApiOperation("删除课程图片")
    public ResponseResult deleteCoursePic(String courseId);


}
