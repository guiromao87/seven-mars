package com.guiromao.sevenmars.testeruim.persistence;

import java.util.Optional;

import com.guiromao.sevenmars.testeruim.model.Probe;

public interface Probes {

	void save(Probe probe);

	Optional<Probe> findById(int id);

}
