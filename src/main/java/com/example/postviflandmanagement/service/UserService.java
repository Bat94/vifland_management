package com.example.postviflandmanagement.service;

import com.example.postviflandmanagement.model.ApiException;
import com.example.postviflandmanagement.user.CustomUserDetails;
import com.example.postviflandmanagement.user.User;
import com.example.postviflandmanagement.model.UserRequestDTO;
import com.example.postviflandmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> save(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setPassword(userRequestDTO.getPassWord());
        user.setPhone(userRequestDTO.getPhone());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public ResponseEntity<User> deleteUser(Long id) {
        User user = userRepository.getOne(id);
        if (user == null){
            throw new ApiException(HttpStatus.NOT_FOUND, "k dc null");
        }
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public UserDetails loadUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + userId)
        );

        return new CustomUserDetails(user);
    }
}
