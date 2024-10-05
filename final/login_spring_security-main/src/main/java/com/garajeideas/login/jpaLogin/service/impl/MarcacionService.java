package com.garajeideas.login.jpaLogin.service.impl;

import com.garajeideas.login.jpaLogin.entity.Marcacion;
import com.garajeideas.login.jpaLogin.repository.MarcacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MarcacionService {

    private final MarcacionRepository marcacionRepository;

    public Marcacion registrarMarcacion(Long userId, String tipo) {
        Marcacion marcacion = new Marcacion();
        marcacion.setUserId(userId);
        marcacion.setFechaHora(LocalDateTime.now());
        marcacion.setTipo(tipo);

        return marcacionRepository.save(marcacion);
    }
}
