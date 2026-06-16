package com.project.luma.error;


import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class BadRequestException extends RuntimeException {
    String resourceName;
    String resourceId;

}
