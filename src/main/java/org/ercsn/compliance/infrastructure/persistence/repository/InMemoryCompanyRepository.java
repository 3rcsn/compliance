package org.ercsn.compliance.infrastructure.persistence.repository;

import org.ercsn.compliance.domain.Company;
import org.ercsn.compliance.domain.CompanyRepository;

public class InMemoryCompanyRepository implements CompanyRepository {
    private final CompanyEntityRepository repository;

    public InMemoryCompanyRepository(CompanyEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Company company) {

    }
}
