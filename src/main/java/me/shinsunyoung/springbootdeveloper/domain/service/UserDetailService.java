package me.shinsunyoung.springbootdeveloper.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.shinsunyoung.springbootdeveloper.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException((email)));
    }
}
