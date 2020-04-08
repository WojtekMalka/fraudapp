package pl.wojtekmalka.fraudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wojtekmalka.fraudapp.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    void deleteAllByNIP(int NIP);

    void deleteAllByCompanyId(long companyId);
}
