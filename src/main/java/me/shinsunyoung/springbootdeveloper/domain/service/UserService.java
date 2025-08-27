package me.shinsunyoung.springbootdeveloper.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.shinsunyoung.springbootdeveloper.domain.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.domain.repository.UserRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(
                User.builder().email(dto.getEmail())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                        .build()).getId();
    }
}
