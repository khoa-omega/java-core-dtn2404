package controller;

import entity.User;
import lombok.AllArgsConstructor;
import service.IUserService;

import java.util.List;

@AllArgsConstructor
public class UserController {
    private IUserService service;

    public List<User> findAll() {
        return service.findAll();
    }
}
