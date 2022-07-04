package upc.edu.examenfinal.hospedaje.command.application.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedajeRepository extends JpaRepository<Hospedaje, String> {
}
