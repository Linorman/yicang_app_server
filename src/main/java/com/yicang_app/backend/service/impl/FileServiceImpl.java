package com.yicang_app.backend.service.impl;

import com.yicang_app.backend.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * 文件服务实现类
 * @author linorman
 * @date 2023/03/30
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    public void saveFile(String path, byte[] data) throws IOException {
        File file = new File(path);
        FileUtils.writeByteArrayToFile(file, data);
    }

    public Optional<File> getFileByPath(String path) {
        File file = new File(path);
        if (file.exists()) {
            return Optional.of(file);
        } else {
            return Optional.empty();
        }
    }

    public void updateFile(File file, byte[] data) throws IOException {
        FileUtils.writeByteArrayToFile(file, data);
    }
}
