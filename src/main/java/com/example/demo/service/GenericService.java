package com.example.demo.service;

import java.util.List;

public interface GenericService <T>{
    /**
     * @param t
     * @return
     */
     T create(T t);

    /**
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * @return
     */
    List<T> findAll();

    /**
     * @param t
     * @return
     */
    T update(T t);

    /**
     * @param id
     * @return
     */
    Long deleteById(Long id);
}
