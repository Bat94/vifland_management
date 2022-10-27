package com.example.postviflandmanagement;

import com.example.postviflandmanagement.repository.UserRepository;
import com.example.postviflandmanagement.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class PostviflandmanagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PostviflandmanagementApplication.class, args);
    }
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
// Khi chương trình chạy
        // Insert vào csdl một user.
        User user = new User();
        user.setUserName("bat");
        user.setPassword(passwordEncoder.encode("bat"));
        userRepository.save(user);
        System.out.println(user);
    }
}
