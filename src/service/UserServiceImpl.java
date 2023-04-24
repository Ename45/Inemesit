package service;

import data.models.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImpl;
import dto.requests.SignUpRequest;

public class UserServiceImpl implements UserService{

    private final UserRepository person = new UserRepositoryImpl();

    @Override
    public String signUp(SignUpRequest signUpDetails) {
        User user = new User();
        user.setEmail(signUpDetails.getEmail());
        user.setPassword(signUpDetails.getPassword());

        person.saveUser(user);

        return "Sign Up Successful";
    }

    public String signUpNed(SignUpRequest signUpDetails) {
        User user = new User();
        user.setEmail(signUpDetails.getEmail());
        user.setPassword(signUpDetails.getPassword());

        return person.saveUserNed(user).toString();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "person=" + person +
                '}';
    }


}
