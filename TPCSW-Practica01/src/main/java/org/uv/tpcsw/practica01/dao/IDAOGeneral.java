package org.uv.tpcsw.practica01.dao;

import java.util.List;

public interface IDAOGeneral<T,ID> {
       public boolean save(T pojo);
       public boolean delete(T pojo);
       public boolean update(T pojo,ID id);
       public List<T> findAll();
       public T findById(ID id);       
}
