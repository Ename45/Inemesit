package service;

import dto.requests.SignUpRequest;

public interface UserService {
    String signUp(SignUpRequest signUpDetails);

    String signUpNed(SignUpRequest request);
}
