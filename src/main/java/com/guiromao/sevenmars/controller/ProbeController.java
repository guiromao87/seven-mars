package com.guiromao.sevenmars.controller;

import com.guiromao.sevenmars.model.Moviment;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.model.dto.ProbeDto;
import com.guiromao.sevenmars.model.form.NewProbeForm;
import com.guiromao.sevenmars.service.PlateauService;
import com.guiromao.sevenmars.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbeService probeService;

    @Autowired
    private PlateauService plateauService;

    @PostMapping
    public ResponseEntity<ProbeDto> register(@RequestBody @Valid NewProbeForm newProbeForm) {
        Probe probe = newProbeForm.toProbe();
        this.plateauService.register(probe);
        return ResponseEntity.ok(new ProbeDto(probe));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProbeDto> probe(@PathVariable String name) {
        Optional<Probe> probeOptional = plateauService.findProbeBy(name);

        if(probeOptional.isPresent())
            return ResponseEntity.ok(new ProbeDto(probeOptional.get()));

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProbeDto>> probe() {
        Map<String, Probe> probes = plateauService.getProbes();

        if(probes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ProbeDto.toProbesDto(probes));
    }

    @PutMapping("/{name}")
    public ResponseEntity<ProbeDto> move(@PathVariable String name,
                                         @RequestBody List<Moviment> moviments) {
        Probe probe = this.probeService.move(name, moviments);
        return ResponseEntity.ok(new ProbeDto(probe));
    }
}