package com.project.luma.service;

import com.project.luma.dto.project.FileContentResponse;
import com.project.luma.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userid);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
