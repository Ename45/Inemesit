package data.repository;

import data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository{
    private int count;
    List<User> allUsers = new ArrayList<>();

    @Override
    public String saveUser(User user) {
        boolean savedUser = user.getId() != null;
        if (savedUser) update(user);

        else saveNewUser(user);
        return "Saved successfully";
    }

    @Override
    public int saveUserNed(User user) {
        boolean savedUser = user.getId() != 0;
        if (savedUser) update(user);

        else saveNewUser(user);
        return u;
    }

    private void saveNewUser(User user) {
        UUID id = generateId();
        user.setId(id);
        allUsers.add(user);
//        count++;
    }

    private void update(User user) {
        User savedUser = findById(user.getId());
        int indexOfSavedUser = allUsers.indexOf(savedUser);
        allUsers.set(indexOfSavedUser, user);
//                     OR
//        allUsers.remove(savedUser);
//        allUsers.add(user);
    }

    private UUID generateId(){
        return UUID.randomUUID();
    }

    @Override
    public int countUsers() {
        return allUsers.size();
    }

    @Override
    public User findById(UUID id) {
        for (User user: allUsers) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(User user) {
        allUsers.remove(user);
    }

    @Override
    public void deleteUser(UUID id) {
        User foundUser = findById(id);
        deleteUser(foundUser);
    }

    @Override
    public String toString() {
        return "UserRepositoryImpl{" +
                "count=" + count +
                ", allUsers=" + allUsers +
                '}';
    }
}

