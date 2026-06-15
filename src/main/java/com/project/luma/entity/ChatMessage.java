package com.project.luma.entity;

import com.project.luma.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    MessageRole messageRole;
    String toolCalls; //Json Array of tools called
    Integer tokensUsed;
    Instant createdAt;
}
