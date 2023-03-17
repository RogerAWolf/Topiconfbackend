package nl.topicus.topiconfbackend.security.persisitence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.topicus.topiconfbackend.security.Authority;
import nl.topicus.topiconfbackend.security.AuthorityName;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
