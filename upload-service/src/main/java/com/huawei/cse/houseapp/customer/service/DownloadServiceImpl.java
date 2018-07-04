package com.huawei.cse.houseapp.customer.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by j00347529 on 2018/5/31.
 */
@RestSchema(schemaId = "download")
@RequestMapping(path = "/")
public class DownloadServiceImpl {

    @GetMapping(path = "/entityResource")
    @ApiOperation(value = "get city by state", notes = "该接口提供用户新增项目数据，参数说明：baseProject项目基础信息（projectAddress项目所在地址，projectContacts项目联系人，projectDesc项目描述（非必需参数），" +
            "projectLat项目纬度，projectLogoId项目logo的id（非必需参数），projectLon项目经度，projectName项目名，" +
            "projectPhone项目联系电话，projectViewId项目鸟瞰图id，sceneId项目所述场景id，regionId项目所属行政区域id），" +
            "fileIdList项目附件id集合（非必需参数），调用返回新建项目信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = File.class, message = ""),
    })
    public ResponseEntity<Resource> entityResource(String content) throws IOException {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=getentityResource.txt")
                .body(new ByteArrayResource(content.getBytes(StandardCharsets.UTF_8)));
    }

    @PostMapping(path = "/entityResource")
    @ApiResponses({
            @ApiResponse(code = 200, response = File.class, message = ""),
    })
    public ResponseEntity<Resource> download(String content) throws IOException {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=postentityResource.txt")
                .body(new ByteArrayResource(content.getBytes(StandardCharsets.UTF_8)));
    }

    @GetMapping(path = "/downloadxlsx")
    @ApiOperation(value = "get city by state", notes = " test for excel")
    @ApiResponses({
            @ApiResponse(code = 200, response = File.class, message = ""),
    })
    public ResponseEntity<Resource> downloadxlsx(String content) throws IOException {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/file-xlsx")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=downloadxlsx.xlsx")
                .body(new ByteArrayResource(content.getBytes(StandardCharsets.UTF_8)));
    }
}
