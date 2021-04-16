package org.perso.litby2.models.dto.userDto;

import org.perso.litby2.entities.User;
import org.perso.litby2.models.dto.IDtoConverter;
import org.perso.litby2.models.dto.roleDto.RoleReadDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserReadDto implements IDtoConverter<User> {
    private Long id;
    private String username;
    private List<RoleReadDto> roles;

    public UserReadDto(User user) {
        fromEntity(user);
    }

    public void fromEntity(User user) {
        id = user.getId();
        username = user.getUsername();
        roles = user.getRoles().stream().map(RoleReadDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RoleReadDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleReadDto> roles) {
        this.roles = roles;
    }
}
