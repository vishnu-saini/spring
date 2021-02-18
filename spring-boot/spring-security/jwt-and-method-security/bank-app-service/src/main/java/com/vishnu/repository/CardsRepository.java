package com.vishnu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.vishnu.model.Cards;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

	@PreAuthorize("hasRole('ROOT')")
	List<Cards> findByCustomerId(int customerId);

}
