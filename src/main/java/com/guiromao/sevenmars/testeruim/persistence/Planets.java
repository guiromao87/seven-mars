package com.guiromao.sevenmars.testeruim.persistence;

import java.util.Optional;

import com.guiromao.sevenmars.testeruim.model.Planet;

public interface Planets {

	void save(Planet planet);

	Optional<Planet> findById(int id);

}
