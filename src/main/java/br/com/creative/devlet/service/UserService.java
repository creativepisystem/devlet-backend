package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.ChangePasswordModel;
import br.com.creative.devlet.model.UserModel;
import br.com.creative.devlet.security.SecurityUser;

import java.util.List;
import java.util.Optional;


public interface UserService {
    BussinessException OLD_PASSWORD_DONT_MATCH_EXCEPTION = new BussinessException("Old Password don't match");
    BussinessException NEW_PASSWORD_DONT_MATCH_EXCEPTION = new BussinessException("Passwords don't match");
    BussinessException USER_NOT_FOUND_EXCEPTION  = new BussinessException("User not found");

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    UserModel getMe(SecurityUser user);

    void changePassword(SecurityUser user,ChangePasswordModel model) throws BussinessException;
}
