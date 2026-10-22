package org.ercsn.compliance.application;

import org.ercsn.compliance.domain.Company;
import org.ercsn.compliance.domain.CompanyRepository;
import org.ercsn.compliance.domain.CompliancePolicy;
import org.ercsn.compliance.domain.ComplianceScreening;
import org.ercsn.compliance.infrastructure.rest.client.AntiMoneyLaunderingClient;
import org.ercsn.compliance.infrastructure.rest.client.SanctionClient;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeCompanyRiskUseCase {
    private final SanctionClient sanctionClient;
    private final AntiMoneyLaunderingClient antiMoneyLaunderingClient;
    private final CompanyRepository companyRepository;

    public AnalyzeCompanyRiskUseCase(SanctionClient sanctionClient,
                                     AntiMoneyLaunderingClient antiMoneyLaunderingClient,
                                     CompanyRepository companyRepository
    ) {
        this.sanctionClient = sanctionClient;
        this.antiMoneyLaunderingClient = antiMoneyLaunderingClient;
        this.companyRepository = companyRepository;
    }

    public void execute (Company company) {
        var sanctions = sanctionClient.getCompanyRisk(company.getRegistrationNumber()).toDomain();
        var amlProfile = antiMoneyLaunderingClient.screening(company.getRegistrationNumber()).toDomain();

        var screening = new ComplianceScreening(sanctions, amlProfile);
        var riskAssessment = CompliancePolicy.evaluate(screening);

        company.applyRiskAssessment(riskAssessment);
        companyRepository.save(company);
    }
}
