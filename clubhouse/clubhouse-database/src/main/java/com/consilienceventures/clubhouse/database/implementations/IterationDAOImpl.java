/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.database.implementations;

import com.consilienceventures.clubhouse.database.DAO.EntityDAO;
import com.consilienceventures.clubhouse.database.interfaces.IDAOContract;
import com.consilienceventures.clubhouse.model.Iteration;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ruben
 */
public class IterationDAOImpl extends EntityDAO implements IDAOContract<Iteration, Serializable>{ 

    @Override
    public void persist(Iteration entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Iteration entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iteration findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iteration entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Iteration> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void batchLoad(List<Iteration> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Iteration> findDistinct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
