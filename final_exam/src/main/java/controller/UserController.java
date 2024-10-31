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

    public User findById(int id) {
        return service.findById(id);
    }

    public User findByEmailAndPassword(String email, String password) {
        return service.findByEmailAndPassword(email, password);
    }

    public int create(String fullName, String email) {
        return service.create(fullName, email);
    }

    public int deleteById(int id) {
        return service.deleteById(id);
    }
}
