package com.guiromao.sevenmars.controller;

import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.dto.LimitPlateauDto;
import com.guiromao.sevenmars.model.form.NewLimitPlateauForm;
import com.guiromao.sevenmars.service.PlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/plateau")
public class PlateauController {

    @Autowired
    private PlateauService plateauService;

    @PostMapping
    public ResponseEntity<LimitPlateauDto> register(@RequestBody @Valid NewLimitPlateauForm newLimitPlateauForm) {
        Limit limit = newLimitPlateauForm.toLimit();
        this.plateauService.register(limit);
        return ResponseEntity.ok(new LimitPlateauDto(limit));
    }
}
