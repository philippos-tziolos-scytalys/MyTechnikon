package com.scytalys.mytechnikon.controller;

import com.scytalys.mytechnikon.mapper.UserMapper;
import com.scytalys.mytechnikon.resource.UserResource;
import com.scytalys.mytechnikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<UserResource> addUser(@RequestBody UserResource userResource) {

        return new ResponseEntity<>(userMapper.toResource(
                userService.create(userMapper.toDomain(userResource))), HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserResource> searchUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userMapper.toResource(userService.get(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/tin/{tin}")
    public ResponseEntity<UserResource> searchUserByTin(@PathVariable("tin") Long tin) {
        return new ResponseEntity<>(userMapper.toResource(userService.findByTin(tin)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/email/{email}")
    public ResponseEntity<UserResource> searchUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userMapper.toResource(userService.findByEmail(email)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") final Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserResource userResource) {
        userService.update(userMapper.toDomain(userResource));
    }
}
