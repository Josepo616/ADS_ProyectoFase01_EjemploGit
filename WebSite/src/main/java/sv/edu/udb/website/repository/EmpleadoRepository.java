package sv.edu.udb.website.repository;


import sv.edu.udb.website.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {}
