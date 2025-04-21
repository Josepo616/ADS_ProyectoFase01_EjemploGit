package sv.edu.udb.website.controller;


import sv.edu.udb.website.model.Empleado;
import sv.edu.udb.website.repository.EmpleadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpleadoController {

    private final EmpleadoRepository repo;

    public EmpleadoController(EmpleadoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", repo.findAll());
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        repo.save(empleado);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
