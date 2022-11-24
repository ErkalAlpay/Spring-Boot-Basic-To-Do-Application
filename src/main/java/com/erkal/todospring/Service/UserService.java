package com.erkal.todospring.Service;
import com.erkal.todospring.Dto.LoginFormDto;
import com.erkal.todospring.Dto.LoginResponse;
import com.erkal.todospring.Entity.Role;
import com.erkal.todospring.Entity.User;
import com.erkal.todospring.Repository.RoleRepository;
import com.erkal.todospring.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    public User saveUser(User user){
        log.info("Saving new user {} to the database", user.getUseremail());
        return userRepository.save(user);
    }


    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getRole());
        return roleRepository.save(role);
    }


    public void addRoleToUser(String useremail, String roleName) {
        log.info("Adding role to {} to user {} ", roleName, useremail);
        User user = userRepository.findByUseremail(useremail);
        Role role = roleRepository.findByRole(useremail);
        user.getRoles().add(role);

    }

    public void updateUser(String token){
        String useremail = jwtService.getTokenEmail(token);
        User user = getUser(useremail);
    }


    public User getUser(String useremail) {
        log.info("Fetching user {} ",useremail);
        return userRepository.findByUseremail(useremail);
    }

    public LoginResponse login(LoginFormDto loginDto){

        User dbUser = userRepository.findByUseremail(loginDto.getEmail());
        if(dbUser == null || !passwordEncoder.matches(loginDto.getPassword(),dbUser.getPassword()) ){
            throw new UsernameNotFoundException("kullanıcı adı veya şifre hatalı");
        }
       return new LoginResponse(jwtService.generateToken(loginDto.getEmail()));

    }


    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public User bCryptPassword(User user){
        String bCryptedPassword =   passwordEncoder.encode(user.getPassword());
        user.setPassword(bCryptedPassword);
        return user;

    }



}
