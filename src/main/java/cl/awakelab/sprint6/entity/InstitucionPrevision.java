package cl.awakelab.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(name = "id_inst_prevision")
    private int idInstPrevision;
    @Column
    private String descripcion;
    @Column(name = "porc_dcto")
    private float porcDcto;

    @OneToMany(mappedBy = "instPrevision") //nombre de parametro instanciado en entidad
    List<Trabajador> listaTrabajadoresPrev;

    @OneToMany(mappedBy = "idInstPrevision")
    List<Liquidacion> liquidacionPrevision;
}
