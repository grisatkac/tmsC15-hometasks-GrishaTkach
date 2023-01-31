package by.tms.tkach.lesson48.services;


import by.tms.tkach.lesson48.dto.DTO;
import java.util.List;

public interface CrudService<T extends DTO> {

    T save(T value);
    List<T> findAll();
    T findById(Long id);
    T update(T value);
    void delete(Long id);
}
