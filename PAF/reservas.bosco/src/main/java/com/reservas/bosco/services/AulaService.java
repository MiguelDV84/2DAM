package com.reservas.bosco.services;

import com.reservas.bosco.entities.Aula;
import com.reservas.bosco.repositories.IAulaRepository;
import com.reservas.bosco.utils.ClassUtil;
import com.reservas.bosco.utils.CopyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AulaService implements IAulaService {

    private final IAulaRepository aulaRepository;
    private final ClassUtil classUtil = new ClassUtil();

    @Transactional(readOnly = true)
    @Override
    public List<Aula> findAll() {
        return aulaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Aula> findById(Long id) {
        return aulaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aula> findByCapacidad(int capacidad) {
        return aulaRepository.findByCapacidad(capacidad)
                .stream()
                .filter(a -> a.getCapacidad() == capacidad)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aula> findAulasEsDeOrdenadores(boolean esAulaDeOrdenadores) {
        return aulaRepository.findByEsAulaDeOrdenador(esAulaDeOrdenadores)
                .stream()
                .filter(a -> a.isEsAulaDeOrdenador() == esAulaDeOrdenadores)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Aula> findReserveOfAula(Long idReserva) {
        return aulaRepository.findReserveOfAula(idReserva);
    }

    @Override
    public Optional<Aula> deleteAula(Long id) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    aulaRepository.delete(aula);
                    return aula;
                });
    }

    @Override
    public Optional<Aula> insertAula(Aula aula) {
        return Optional.of(aulaRepository.save(aula));
    }


    @Override
    public Optional<Aula> updateAula(Long id, Aula updatedAula) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    CopyProperties.copyProperties(aula, updatedAula);
                    return aulaRepository.save(aula);
                });
    }

}