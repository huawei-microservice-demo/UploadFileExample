package com.huawei.cse.houseapp.customer.service;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import com.alibaba.fastjson.JSON;
//import com.server.edu.welcomeservice.entity.TaskTemplate;
//import com.server.edu.welcomeservice.entity.common.ResultData;
//import com.server.edu.welcomeservice.service.TaskTemplateService;

import java.io.IOException;
import java.io.InputStream;

/**
 * 任务模板 接口类
 * 
 * @author tengzhou
 * @since 2018年6月7日16:34:19
 */
@RestSchema(schemaId = "TaskTemplateController")
@RequestMapping(path = "/taskTemplate")
public class TaskTemplateController
{
//    @Autowired
//    private TaskTemplateService taskTemplateService;
    
    private Logger LOG = LoggerFactory.getLogger(TaskTemplateController.class);
    
    /**
     * 上传任务
     * 
     * @param requestParam 任务对象
     * @return 结果集
     */
    @PostMapping(value = "/uploadTaskTemplate", consumes = MediaType.MULTIPART_FORM_DATA)
    @ResponseBody
    public String uploadTaskTemplate(
        @RequestPart(name = "file") MultipartFile multipartFile,
        @RequestPart(name = "templateName") String templateName)
    {
//        ResultData<Integer> resultData = new ResultData<>(200, "呵呵2", 1);
        LOG.info("start uploadTaskTemplate " + templateName);
        
//        String json = JSON.toJSONString(resultData);
        try (InputStream is1 = multipartFile.getInputStream()) {
            String content1 = IOUtils.toString(is1);
            System.out.println(content1);
            return multipartFile.getOriginalFilename() + ":" + content1;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


//    @RequestMapping(value = "/uploadTaskTemplate1",method = RequestMethod.POST,produces = MediaType.MULTIPART_FORM_DATA)
//    @ResponseBody
//    public String uploadTaskTemplate1(
//        @RequestParam("file") MultipartFile multipartFile,
//        @RequestParam("templateName") String templateName)
//    {
//        ResultData<Integer> resultData = new ResultData<>(200, "呵呵1", 1);
//        LOG.info("start uploadTaskTemplate " + templateName);
//        System.out.println(multipartFile);
//
//        String json = JSON.toJSONString(resultData);
//        return json;
//    }
    
    /**
     * 添加任务
     * 
     * @param requestParam 任务对象
     * @return 结果集
     */
//    @RequestMapping(value = "/addTaskTemplate", method = RequestMethod.POST)
//    @ResponseBody
//    public String addTaskTemplate(@RequestBody TaskTemplate requestParam)
//    {
//        LOG.info(
//            "start addTaskTemplate requestParam：" + requestParam.toString());
//        ResultData<Integer> resultData =
//            taskTemplateService.addTaskTemplate(requestParam);
//        String json = JSON.toJSONString(resultData);
//        return json;
//    }
}
