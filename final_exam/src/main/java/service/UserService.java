package service;

import entity.User;
import lombok.AllArgsConstructor;
import repository.IUserRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class UserService implements IUserService {
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        try {
            return repository.findAll();
        } catch (SQLException exception) {
            return Collections.emptyList();
        }
    }
}
