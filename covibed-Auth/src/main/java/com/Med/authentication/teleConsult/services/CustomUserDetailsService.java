package com.Med.authentication.teleConsult.services;

import javax.persistence.Transient;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Med.authentication.teleConsult.dao.RoleRepository;
import com.Med.authentication.teleConsult.dao.UserRepository;
import com.Med.authentication.teleConsult.model.Role;
import com.Med.authentication.teleConsult.model.User;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String input) {
        // User user = userRepository.findByUsername(input);
        System.out.println("=====> Finding email = " + input);
//        User user = userRepository.findByEmail(input);
        User user = userRepository.findByUsername(input);

        if (user == null) {
            System.out.println("===> User with email='" + input + "' not found  !!!!");
            throw new BadCredentialsException("Bad credentials");
        }
        new AccountStatusUserDetailsChecker().check(user);



//


        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

//    public User saveOrUpdate(User user) {
//
//        if (!user.userHasRole()) {
//            System.out.println("==> Setting User Role");
//            Role role = roleRepository.getRoleById(2);
//            //user.setRole(role);
////            user.setPassword("{bcrypt}"+user.getPassword());
//            user.setPassword(user.getPassword());
//
//        }
//
//        return userRepository.save(user);
//    }

    public User Update(User user) {

        user.setPassword(passwordEncoder(user.getPassword()));

        return userRepository.save(user);
    }

    public String passwordEncoder(String pwd) {
        String encodedPwd = "", strpwd = "";
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        encodedPwd = encoder.encode(pwd);

        System.out.println("---------------------> [" + pwd + "] / [" + encodedPwd + "]");
        return encodedPwd;
    }

}
