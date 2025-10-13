package com.reservas.bosco.controllers;

import com.reservas.bosco.repositories.IAulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AulaController {
    @Autowired
    IAulaRepository aulaRepository;



}
