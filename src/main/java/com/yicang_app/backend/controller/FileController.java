package com.yicang_app.backend.controller;

import com.yicang_app.backend.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * 文件控制器
 * @author linorman
 * @date 2023/04/19
 */
@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @param file
     * @param path
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("path") String path) {
        try {
            byte[] bytes = file.getBytes();
            fileService.saveFile(path, bytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving file: " + e.getMessage());
        }
        return ResponseEntity.ok().body("File uploaded successfully");
    }

    /**
     * 文件更新
     * @param path
     * @param file
     * @return
     */
    @PutMapping("/{path:.+}/update")
    public ResponseEntity<String> updateFile(@PathVariable String path,
                                             @RequestParam("file") MultipartFile file) {
        try {
            Optional<File> optionalFile = fileService.getFileByPath(path);
            if (optionalFile.isPresent()) {
                byte[] bytes = file.getBytes();
                fileService.updateFile(optionalFile.get(), bytes);
                return ResponseEntity.ok().body("File updated successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while updating file: " + e.getMessage());
        }
    }

    /**
     * 文件下载
     * @param path
     * @return
     */
    @GetMapping("/{path:.+}/download")
    public ResponseEntity<byte[]> getFile(@PathVariable String path) {
        Optional<File> optionalFile = fileService.getFileByPath(path);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            String contentType = URLConnection.guessContentTypeFromName(file.getName());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(file.getName(), StandardCharsets.UTF_8)
                    .build());
            try {
                byte[] data = FileUtils.readFileToByteArray(file);
                return ResponseEntity.ok().headers(headers).body(data);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(("Error occurred while reading file: " + e.getMessage()).getBytes());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


