package it.universita.dao.interfaces;

import java.util.ArrayList;

/**
 * Created by roberto on 29/11/2017.
 */
public interface IBaseDAO<T> {

    //findById
    T findById(int id);

    //findAll
    ArrayList<T> findAll();
}
