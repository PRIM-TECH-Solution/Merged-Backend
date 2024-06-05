package com.group.security.service;

import com.group.security.entity.UserInfo;
import com.group.security.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// UserInfoService.java

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService; // Inject JwtService for token generation

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUsername(username);
        return userInfo.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public void addUser(UserInfo userInfo) {
        // Check if the user already exists
        UserInfo existingUser = userInfoRepository.findByEmail(userInfo.getEmail()).orElse(null);
        if (existingUser != null) {
            return;
        }

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getAllUser() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUser(Integer id) {
        return userInfoRepository.findById(id).orElse(null);
    }

    public UserInfo getUserByUsername(String username) {
        return userInfoRepository.findByUsername(username).orElse(null);
    }

    public String getUsernameById(Integer id) {
        UserInfo user = userInfoRepository.findById(id).orElse(null);
        if (user != null) {
            return user.getUsername();
        } else {
            return null;
        }
    }

    public String login(String username, String password) {
        UserDetails userDetails;
        try {
            userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                return "Invalid username or password";
            }

            UserInfo userInfo = userInfoRepository.findByUsername(username).orElse(null);
            if (userInfo == null) {
                return "Invalid username or password";
            }

            String token = jwtService.generateToken(
                    userInfo.getId().toString(), // Assuming id is of type Integer
                    userInfo.getRole(),
                    userInfo.getFirst_name(),
                    userInfo.getUsername(),
                    userInfo.getEmail(),
                    userInfo.getUser_id().toString()
            );
            return "Login successful.\nToken: " + token;
        } catch (UsernameNotFoundException e) {
            return "Invalid username or password";
        }
    }

    public List<UserInfo> getUserByRole(String role) {
        return null;
    }

    public boolean isEmailRegistered(String email) {
        // Check if the email exists in the database
        return userInfoRepository.findByEmail(email).isPresent();
    }
}
