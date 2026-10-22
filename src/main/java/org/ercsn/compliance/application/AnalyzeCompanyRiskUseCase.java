package org.ercsn.compliance.application;

import org.ercsn.compliance.domain.Company;
import org.ercsn.compliance.domain.ComplianceScreening;
import org.ercsn.compliance.infrastructure.rest.client.AntiMoneyLaunderingClient;
import org.ercsn.compliance.infrastructure.rest.client.SanctionClient;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeCompanyRiskUseCase {
    private final SanctionClient sanctionClient;
    private final AntiMoneyLaunderingClient antiMoneyLaunderingClient;

    public AnalyzeCompanyRiskUseCase(SanctionClient sanctionClient, AntiMoneyLaunderingClient antiMoneyLaunderingClient) {
        this.sanctionClient = sanctionClient;
        this.antiMoneyLaunderingClient = antiMoneyLaunderingClient;
    }

    public void execute (Company domain) {
        var sanctions = sanctionClient.getCompanyRisk(domain.getRegistrationNumber());
        var amlProfile = antiMoneyLaunderingClient.screening(domain.getRegistrationNumber());
    }
}
