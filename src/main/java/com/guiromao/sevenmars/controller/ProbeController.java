package com.guiromao.sevenmars.controller;

import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.model.dto.ProbeDto;
import com.guiromao.sevenmars.model.form.NewProbeForm;
import com.guiromao.sevenmars.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbeService probeService;

    @PostMapping
    public ResponseEntity<ProbeDto> register(@RequestBody NewProbeForm newProbeForm) {
        Probe probe = newProbeForm.toProbe();
        return ResponseEntity.ok(new ProbeDto(probe));
    }
}
