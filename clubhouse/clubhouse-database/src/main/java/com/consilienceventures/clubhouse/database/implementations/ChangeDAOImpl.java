/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.database.implementations;

import com.consilienceventures.clubhouse.database.DAO.EntityDAO;
import com.consilienceventures.clubhouse.database.interfaces.IDAOContract;
import com.consilienceventures.clubhouse.model.Change;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ruben
 */
public class ChangeDAOImpl extends EntityDAO implements IDAOContract<Change, Serializable> {

    @Override
    public void persist(Change entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Change entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Change findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Change entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Change> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void batchLoad(List<Change> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Change> findDistinct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
