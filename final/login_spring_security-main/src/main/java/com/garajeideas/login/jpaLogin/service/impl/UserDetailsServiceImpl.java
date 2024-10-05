package com.garajeideas.login.jpaLogin.service.impl;

import com.garajeideas.login.jpaLogin.entity.SecurityUser;
import com.garajeideas.login.jpaLogin.entity.User;
import com.garajeideas.login.jpaLogin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;  // Inyección del codificador de contraseñas

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new SecurityUser(user);
    }

    // Método para guardar un nuevo usuario con contraseña codificada
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // Codifica la contraseña
        userRepository.save(user);  // Guarda el usuario en la base de datos
    }

    // Método para verificar si un nombre de usuario ya existe
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;  // Retorna true si el usuario ya existe
    }
}

