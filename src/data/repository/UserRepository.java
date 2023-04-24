package data.repository;

import data.models.User;

import java.util.UUID;

public interface UserRepository {
    String saveUser(User person);

    int countUsers();

    User findById(UUID id);

    void deleteUser(User user);

    void deleteUser(UUID id);

    UUID saveUserNed(User user);
}

