package cl.awakelab.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "institucion_salud")
public class InstitucionSalud {
    @Id
    @Column(name = "id_inst_salud")
    private int idInstPrevision;
    @Column
    private String descripcion;
    @Column(name = "porc_dcto")
    private float porcDcto;

    @OneToMany(mappedBy = "instSalud")
    List<Trabajador> listaTrabajadoresSalud;
    //relacion inst. salud - liquidacion
    @OneToMany(mappedBy = "idInstSalud")
    List<Liquidacion> liquidacionSalud;

}
