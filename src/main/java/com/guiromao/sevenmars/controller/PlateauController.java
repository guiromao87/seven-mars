package com.guiromao.sevenmars.controller;

import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.model.dto.PlateauDto;
import com.guiromao.sevenmars.model.dto.ProbeDto;
import com.guiromao.sevenmars.model.form.NewLimitPlateauForm;
import com.guiromao.sevenmars.service.PlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plateau")
public class PlateauController {

    @Autowired
    private PlateauService plateauService;

    @PostMapping
    public ResponseEntity<PlateauDto> register(@RequestBody @Valid NewLimitPlateauForm newLimitPlateauForm) {
        Limit limit = newLimitPlateauForm.toLimit();
        Plateau plateauWithLimit = this.plateauService.register(limit);
        return ResponseEntity.ok(new PlateauDto(plateauWithLimit));
    }

    @GetMapping
    public ResponseEntity<List<ProbeDto>> probe() {

        Map<String, Probe> probes = plateauService.getProbes();

        if(probes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(ProbeDto.toProbesDto(probes));
    }
}
