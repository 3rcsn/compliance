package org.ercsn.compliance.infrastructure.persistence.repository;

import org.ercsn.compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CompanyEntityRepository extends CrudRepository<CompanyEntity, UUID> {
}
