/**
* Package with which the persistence of the mappers is accessed
**/
package com.eps.Appointments.mappers;
/**
* Imports of java
*/
import java.util.List;
/**
* Imports of mapstruct
*/
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
* Imports of Appointments
*/
import com.eps.Appointments.DTOs.DoctorDTO;
import com.eps.Appointments.persistance.entities.Doctor;
import com.eps.Appointments.persistance.entities.Headquarter;
/**
* public name interface DoctorMapper
* @mapper geographic information system (GIS)
**/
@Mapper(componentModel = "spring", uses = {HeadquarterMapper.class, SpecializationMapper.class})
public interface DoctorMapper {

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.password", target = "password")
    @Mapping(source = "user.rol", target = "rol")
    @Mapping(source = "name_doctor", target = "name_doctor")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "headquarter", target = "headquarterId")
    @Mapping(source = "specialization", target = "specializationList")
    DoctorDTO toDoctorDTO (Doctor doctor);
    
    default int mapHeadquarter(Headquarter headquarter){
        return headquarter.getId();
    }
    
    default Headquarter mapHeadquarter(int id){
        Headquarter h= new Headquarter();
        h.setId(id);
        return h;
    }

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Doctor toDoctor (DoctorDTO doctor);

    List<DoctorDTO> toAdminDTOs(List<Doctor> admin);
}
