package org.perso.litby2.services.entities;

import org.perso.litby2.entities.Role;
import org.perso.litby2.entities.RoleId;
import org.perso.litby2.entities.User;
import org.perso.litby2.models.dto.userDto.UserAddRoleDto;
import org.perso.litby2.models.dto.userDto.UserCreateDto;
import org.perso.litby2.models.dto.userDto.UserReadDto;
import org.perso.litby2.repositories.IRoleRepository;
import org.perso.litby2.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public UserReadDto createUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setCreatedAt(LocalDateTime.now());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        userRepository.save(user);

        Role role = new Role();
        RoleId roleId = new RoleId();
        roleId.setUserId(user.getId());
        roleId.setRoleName("ROLE_ADMIN");
        role.setId(roleId);

        roleRepository.save(role);

        user.getRoles().add(role);

        return new UserReadDto(user);
    }

    public List<UserReadDto> getAll() {
        return userRepository.findAll().stream().map(UserReadDto::new).collect(Collectors.toList());
    }

    public UserReadDto addRole(UserAddRoleDto userAddRoleDto) {
        User user = userRepository.getOne(userAddRoleDto.getUserId());
        Role role = new Role();
        RoleId roleId = new RoleId();
        roleId.setUserId(user.getId());
        roleId.setRoleName(userAddRoleDto.getRole().name());
        role.setId(roleId);

        roleRepository.save(role);

        user.getRoles().add(role);
        return new UserReadDto(user);
    }

    public UserReadDto get(Long id) {
        return new UserReadDto(userRepository.getOne(id));
    }
}
