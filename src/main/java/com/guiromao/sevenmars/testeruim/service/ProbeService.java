package com.guiromao.sevenmars.testeruim.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import com.guiromao.sevenmars.testeruim.dto.InputDTO;
import com.guiromao.sevenmars.testeruim.dto.ProbeDTO;
import com.guiromao.sevenmars.testeruim.model.Command;
import com.guiromao.sevenmars.testeruim.model.Direction;
import com.guiromao.sevenmars.testeruim.model.Planet;
import com.guiromao.sevenmars.testeruim.model.Probe;
import com.guiromao.sevenmars.testeruim.persistence.Planets;
import com.guiromao.sevenmars.testeruim.persistence.Probes;

@Service
public class ProbeService {
	@Autowired
	private Planets planets;
	@Autowired
	private Probes probes;
	
	public List<Probe> landProbes(InputDTO input) {
		Planet planet = concertPlanet(input);
		planets.save(planet);
		
		List<Probe> convertedProbes = convertAndMoveProbes(input, planet);
		convertedProbes.forEach(probe -> probes.save(probe));
		
		return convertedProbes;
	}
	
	@VisibleForTesting
	void applyCommandToProbe(Probe probe, char command) {
		switch (command) {
			case Command.L:
				turnProbeLeft(probe);
				break;
			case Command.R:
				turnProbeRight(probe);
				break;
			case Command.M:
				moveProbeForward(probe);
				break;
		}
	}

	@VisibleForTesting
	void moveProbeForward(Probe probe) {
		int newX = probe.getX();
		int newY = probe.getY();
		switch (probe.getDirection()) {
			case Direction.N:
				newY++;
				break;
			case Direction.W:
				newX--;
				break;
			case Direction.S:
				newY--;
				break;
			case Direction.E:
				newX++;
				break;
		}
		probe.setX(newX);
		probe.setY(newY);
	}

	@VisibleForTesting
	private void turnProbeLeft(Probe probe) {
		char newDirection = Direction.N;
		switch (probe.getDirection()) {
			case Direction.N:
				newDirection = Direction.W;
				break;
			case Direction.W:
				newDirection = Direction.S;
				break;
			case Direction.S:
				newDirection = Direction.E;
				break;
			case Direction.E:
				newDirection = Direction.N;
				break;
		}
		probe.setDirection(newDirection);
	}
	
	@VisibleForTesting
	void turnProbeRight(Probe probe) {
		char newDirection = Direction.N;
		switch (probe.getDirection()) {
			case Direction.N:
				newDirection = Direction.E;
				break;
			case Direction.E:
				newDirection = Direction.S;
				break;
			case Direction.S:
				newDirection = Direction.W;
				break;
			case Direction.W:
				newDirection = Direction.N;
				break;
		}
		probe.setDirection(newDirection);
	}
	
	private List<Probe> convertAndMoveProbes(InputDTO input, Planet planet) {
		return input.getProbes()
						.stream().map(probeDto -> {
							Probe probe = convertProbe(probeDto, planet);
							moveProbeWithAllCommands(probe, probeDto);
							return probe;
						}).collect(Collectors.toList());
	}

	private void moveProbeWithAllCommands(Probe probe, ProbeDTO probeDTO) {
		for (char command : probeDTO.getCommands().toCharArray()) {
			applyCommandToProbe(probe, command);
		}
	}
	
	private Probe convertProbe(ProbeDTO probeDto, Planet planet) {
		Probe probe = new Probe();
		probe.setPlanet(planet);
		probe.setX(probeDto.getX());
		probe.setY(probeDto.getY());
		probe.setDirection(probeDto.getDirection());
		return probe;
	}
	
	private Planet concertPlanet(InputDTO input) {
		Planet planet = new Planet();
		planet.setHeight(input.getHeight());
		planet.setWidth(input.getWidth());
		return planet;
	}
}
