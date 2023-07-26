package cl.awakelab.sprint6.service.serviceimpl;

import cl.awakelab.sprint6.entity.Empleador;
import cl.awakelab.sprint6.repository.IEmpleadorRepository;
import cl.awakelab.sprint6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {
    @Autowired
    IEmpleadorRepository objIEmpleadorRepo;
    @Override
    public List<Empleador> listarEmpleador() {
        return objIEmpleadorRepo.findAll();
    }

    @Override
    public Empleador crearEmpleador(Empleador empleador) {
        return objIEmpleadorRepo.save(empleador);
    }

    @Override
    public Empleador buscarEmpleadorPorId(int idEmpleador) {

        return objIEmpleadorRepo.findById(idEmpleador).orElseThrow(()->new NoSuchElementException("Empleador no encontado"));
    }

    @Override
    public Empleador actualizarEmpleador(int idEmpleador,Empleador empleador) {
        Empleador empleador1 = this.buscarEmpleadorPorId(idEmpleador);
        // se debe ingrear la linea de el run??
        empleador1.setNombre(empleador.getNombre());
        empleador1.setApellido1(empleador.getApellido1());
        empleador1.setApellido2(empleador.getApellido2());
        empleador1.setDireccion(empleador.getDireccion());
        empleador1.setEmail(empleador.getEmail());
        empleador1.setUsuario(empleador.getUsuario());
        empleador1.setTelefono(empleador.getTelefono());
        return objIEmpleadorRepo.save(empleador1);
    }

    @Override
    public void eliminarEmpleadorPorId(int idEmpleador) {
        objIEmpleadorRepo.deleteById(idEmpleador);

    }
}
