package by.tms.tkach.lesson48.mappers;

import by.tms.tkach.lesson48.dto.user.UserSimpleDTO;
import by.tms.tkach.lesson48.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserSimpleDTO toUserSimpleDTO(User user);
    List<UserSimpleDTO> toUserSimpleDTOList(List<User> users);
    User toUser(UserSimpleDTO userSimpleDto);
    List<User> toUserList(List<UserSimpleDTO> users);
}
