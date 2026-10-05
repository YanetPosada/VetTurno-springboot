package com.veturno.veturno.service;

import com.veturno.veturno.dto.AuthResponse;
import com.veturno.veturno.dto.LoginRequest;
import com.veturno.veturno.dto.RegistroRequest;
import com.veturno.veturno.model.Rol;
import com.veturno.veturno.model.Usuario;
import com.veturno.veturno.repository.UsuarioRepository;
import com.veturno.veturno.security.JwtService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse registrar(
            RegistroRequest request) {

        if (usuarioRepository.existsByEmail(
                request.getEmail())) {

            throw new RuntimeException(
                    "El correo ya está registrado");
        }

        Usuario usuario = new Usuario();

        usuario.setEmail(request.getEmail());

        usuario.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        usuario.setRol(Rol.USER);

        usuarioRepository.save(usuario);

        String token =
                jwtService.generateToken(
                        usuario.getEmail());

        return new AuthResponse(token);
    }

    public AuthResponse login(
            LoginRequest request) {

        Usuario usuario =
                usuarioRepository
                        .findByEmail(
                                request.getEmail())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Usuario no encontrado"));

        boolean passwordCorrecta =
                passwordEncoder.matches(
                        request.getPassword(),
                        usuario.getPassword());

        if (!passwordCorrecta) {

            throw new RuntimeException(
                    "Credenciales inválidas");
        }

        String token =
                jwtService.generateToken(
                        usuario.getEmail());

        return new AuthResponse(token);
    }
}
