package com.scytalys.mytechnikon.controller;

import com.scytalys.mytechnikon.mapper.UserMapper;
import com.scytalys.mytechnikon.resource.UserResource;
import com.scytalys.mytechnikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody UserResource userResource) {

        return new ResponseEntity<>(userMapper.toResource(
                userService.create(userMapper.toDomain(userResource))), HttpStatus.CREATED);
    }

    @PutMapping
    public void updateUser(@RequestBody UserResource userResource) {
        userService.update(userMapper.toDomain(userResource));
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> findUsers() {
        return ResponseEntity.ok(userMapper.toResourceList(userService.findAll()));
    }

    @GetMapping(params = {"id"})
    public ResponseEntity<UserResource> findUserById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userMapper.toResource(userService.get(id)));
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<UserResource> findUserByTin(@RequestParam("tin") Long tin) {
        return ResponseEntity.ok(userMapper.toResource(userService.findByTin(tin)));
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<UserResource> findUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userMapper.toResource(userService.findByEmail(email)));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
