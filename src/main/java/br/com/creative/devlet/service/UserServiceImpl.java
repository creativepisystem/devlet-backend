package br.com.creative.devlet.service;

import br.com.creative.devlet.config.TimeProvider;
import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.enums.EnumEnterpriseType;
import br.com.creative.devlet.enums.EnumRole;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.*;
import br.com.creative.devlet.repo.UserRepository;
import br.com.creative.devlet.security.SecurityUser;
import br.com.creative.devlet.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PersonService personService;

    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserModel getUserById(Long id) throws BussinessException {
        Optional<User> user = userRepository.findById(id);
        USER_NOT_FOUND_EXCEPTION.thrownIf(!user.isPresent());
        return user.map(u->{
            UserModel model = new UserModel();
            model.setId(u.getId());
            model.setEmail(u.getEmail());
            model.setUsername(u.getUsername());
            return model;
        }).get();
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll().stream().map(user->{
            UserModel model = new UserModel();
            model.setId(user.getId());
            model.setEmail(user.getEmail());
            model.setUsername(user.getUsername());
            return model;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void createUserPF(PostUserPFModel model) throws BussinessException {
        verifyUser(model);
        PersonService.NON_UNIQUE_CPF_EXCEPTION
                .thrownIf(personService.findByCpf(model.getCpf()).isPresent());
        Person person = new Person();
        person.setName(model.getName());
        person.setCpf(Utils.removeMask(model.getCpf()));
        User user = convertPostUserModelToEntity(model);
        user.setRole(EnumRole.DEVELOPER);
        user = userRepository.save(user);
        person.setId(user.getId());
        person.setUser(user);
        personService.save(person);

    }

    private User convertPostUserModelToEntity(PostUserModel model){
        User user = new User();
        user.setEmail(model.getEmail());
        user.setEnabled(false);
        user.setUsername(model.getUsername());
        user.setName(model.getName());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }
    @Transactional
    @Override
    public void createUserPJ(PostUserPJModel model) throws BussinessException {
        verifyUser(model);
        EnterpriseService.NON_UNIQUE_CNPJ_EXCEPTION
                .thrownIf(enterpriseService.findByCnpj(model.getCnpj()).isPresent());
        Enterprise enterprise = new Enterprise();
        enterprise.setName(model.getName());
        enterprise.setCnpj(Utils.removeMask(model.getCnpj()));
        enterprise.setType(EnumEnterpriseType.DEVELOPER);
        enterprise.setEnabled(false);
        User user = convertPostUserModelToEntity(model);
        user.setRole(EnumRole.ADMIN);
        userRepository.save(user);
        enterprise.setUser(user);
        enterpriseService.save(enterprise);
    }

    @Override
    public User updateUser(PostUserModel user) {
        return null;
    }

    private void verifyUser(PostUserModel model) throws BussinessException {
        PASSWORD_CONFIRMATION_DOESNT_MATCH_PASSWORD_EXCEPTION.thrownIf(!model.getConfirmPassword().equals(model.getPassword()));
        NON_UNIQUE_EMAIL_EXCEPTION.thrownIf(userRepository.findByEmail(model.getEmail()).isPresent());
        USER_ALREADY_EXISTS_EXCEPTION.thrownIf(userRepository.findByUsername(model.getUsername()).isPresent());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserModel findByUsername(String username) throws BussinessException {
        Optional<User> user = userRepository.findByUsername(username);
        USER_NOT_FOUND_EXCEPTION.thrownIf(!user.isPresent());
        return user.map(u->{
            UserModel model = new UserModel();
            model.setId(u.getId());
            model.setEmail(u.getEmail());
            model.setUsername(u.getUsername());
            return model;
        }).get();
    }

    @Override
    public UserModel getMe(SecurityUser user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setEmail(user.getEmail());
        model.setUsername(user.getUsername());
        return model;
    }

    @Override
    @Transactional
    public void changePassword(SecurityUser user,ChangePasswordModel model) throws BussinessException {
        NEW_PASSWORD_DONT_MATCH_EXCEPTION.thrownIf(!model.getNewPassword().equals(model.getConfirmNewPassword()));
        Optional<User> optionalUser = userRepository.findById(user.getId());
        USER_NOT_FOUND_EXCEPTION.thrownIf(!optionalUser.isPresent());
        User entity = optionalUser.get();
        OLD_PASSWORD_DONT_MATCH_EXCEPTION.thrownIf(!passwordEncoder.matches(model.getOldPassword(),entity.getPassword()));
        entity.setPassword(passwordEncoder.encode(model.getNewPassword()));
        userRepository.save(entity);
    }

    public User convertModelToEntity(UserAndPersonModel model){
        User entity = new User();

        if (model.getId() != null) {
            entity.setId(model.getId());
        }
        entity.setUsername(model.getUsername());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setEnabled(true);

        return entity;
    }
}
