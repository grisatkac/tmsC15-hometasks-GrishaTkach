package by.tms.tkach.repositories;

import java.util.Map;

public interface Repository<T>  {

    void generateEntitiesForRepository();

    Map<Long, T> getRepository();
}
