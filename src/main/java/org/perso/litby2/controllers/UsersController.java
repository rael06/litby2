package org.perso.litby2.controllers;

import org.perso.litby2.models.dto.userDto.UserAddRoleDto;
import org.perso.litby2.models.dto.userDto.UserCreateDto;
import org.perso.litby2.models.dto.userDto.UserReadDto;
import org.perso.litby2.services.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserReadDto> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.createUser(userCreateDto));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UserReadDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<UserReadDto> get(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user " + id + " not found");
        } catch (Exception e1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e1.getLocalizedMessage());
        }
    }

    @PostMapping("add-role")
    @ResponseBody
    public ResponseEntity<UserReadDto> addRole(@Valid @RequestBody UserAddRoleDto userAddRoleDto) {
        return ResponseEntity.ok(userService.addRole(userAddRoleDto));
    }

}
