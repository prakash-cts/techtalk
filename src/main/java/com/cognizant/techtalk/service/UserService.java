package com.cognizant.techtalk.service;

import com.cognizant.techtalk.models.User;
import com.cognizant.techtalk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final String COGNIZANT_REGEX = "^[A-Za-z.]+@cognizant.com$";
    private static final String VALID = "valid";
    private static final String INVALID = "invalid";

    @Autowired
    private UserRepository userRepository;

    public String save(User user){
        if(isValidEmail(user.getEmail()) && checkIfUserAlreadyExists(user.getEmail())){
            userRepository.save(user);
            return VALID;
        }
        return INVALID;

    }
    public String validateUser(User user){
        Optional<User> userWithGivenEmail = userRepository.findByEmail(user.getEmail());
        if(userWithGivenEmail.isPresent()
                && user.equals(userWithGivenEmail.get())){
            return VALID;
        }
        return INVALID;
    }
    public String getRegex(){
        return COGNIZANT_REGEX;
    }
    private boolean isValidEmail(String email){

        return true;
//        Pattern pattern = Pattern.compile(COGNIZANT_REGEX);
//        return pattern.matcher(CharBuffer.wrap(email)).matches();
    }
    private boolean checkIfUserAlreadyExists(String email) {
        Optional<User> userWithGivenEmail = userRepository.findByEmail(email);
        return userWithGivenEmail.isPresent();
    }
}
