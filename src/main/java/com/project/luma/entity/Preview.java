package com.project.luma.entity;

import com.project.luma.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Preview {
    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;
    PreviewStatus status;
    Instant createdAt;
    Instant startedAt;
    Instant deletedAt;
}
