package com.guiromao.sevenmars.testeruim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guiromao.sevenmars.testeruim.dto.InputDTO;
import com.guiromao.sevenmars.testeruim.model.Probe;
import com.guiromao.sevenmars.testeruim.service.ProbeService;

@Controller
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {
	@Autowired
	private ProbeService probeService;

	@PostMapping
    public ResponseEntity<List<Probe>> register(@RequestBody InputDTO inputDto) {
        return ResponseEntity.ok(probeService.landProbes(inputDto));
    }
}
