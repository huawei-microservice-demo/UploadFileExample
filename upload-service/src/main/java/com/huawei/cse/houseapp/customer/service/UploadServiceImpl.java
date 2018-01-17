package com.huawei.cse.houseapp.customer.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.servicecomb.provider.rest.common.RestSchema;

@RestSchema(schemaId = "upload")
@RequestMapping(path = "/")
public class UploadServiceImpl {
  @PostMapping(path = "/upload", produces = MediaType.TEXT_PLAIN_VALUE)
  public String fileUpload(@RequestPart(name = "file1") MultipartFile file1,
      @RequestPart(name = "someFile") Part file2) {
    return _fileUpload(file1, file2);
  }

  private String _fileUpload(MultipartFile file1, Part file2) {
    try (InputStream is1 = file1.getInputStream(); InputStream is2 = file2.getInputStream()) {
      String content1 = IOUtils.toString(is1);
      String content2 = IOUtils.toString(is2);
      return file1.getOriginalFilename() + ":" + content1 + "\n" +
          file2.getSubmittedFileName() + ":" + content2;
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
