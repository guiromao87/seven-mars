package com.guiromao.sevenmars.controller;

import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.model.dto.ProbeDto;
import com.guiromao.sevenmars.model.form.NewProbeForm;
import com.guiromao.sevenmars.service.PlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private PlateauService plateauService;

    @PostMapping
    public ResponseEntity<ProbeDto> register(@RequestBody @Valid NewProbeForm newProbeForm) {
        Probe probe = newProbeForm.toProbe();
        this.plateauService.register(probe);
        return ResponseEntity.ok(new ProbeDto(probe));
    }

    @GetMapping
    public ResponseEntity<ProbeDto> probe() {
        Optional<Probe> probeOptional = plateauService.getProbe();

        if(probeOptional.isPresent())
            return ResponseEntity.ok(new ProbeDto(probeOptional.get()));

        return ResponseEntity.noContent().build();
    }
}
