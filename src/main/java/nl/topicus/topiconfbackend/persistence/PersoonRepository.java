package nl.topicus.topiconfbackend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.topicus.topiconfbackend.domain.Persoon;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoonRepository extends JpaRepository<Persoon, Long> {
    Persoon findByEmail(String email);
}

