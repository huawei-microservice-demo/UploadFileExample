package com.huawei.cse.houseapp.customer.service;

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
}
