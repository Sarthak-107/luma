package com.project.luma.service.impl;

import com.project.luma.dto.project.FileContentResponse;
import com.project.luma.dto.project.FileNode;
import com.project.luma.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userid) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
