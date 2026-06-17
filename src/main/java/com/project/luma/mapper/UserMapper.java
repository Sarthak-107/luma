package com.project.luma.mapper;

import com.project.luma.dto.auth.SignupRequest;
import com.project.luma.dto.auth.UserProfileResponse;
import com.project.luma.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest request);

    UserProfileResponse toUserProfileResponse(User user);

}
