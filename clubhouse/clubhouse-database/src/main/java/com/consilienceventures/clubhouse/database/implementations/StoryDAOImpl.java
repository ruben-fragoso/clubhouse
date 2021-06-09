/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.database.implementations;

import com.consilienceventures.clubhouse.database.DAO.EntityDAO;
import com.consilienceventures.clubhouse.database.interfaces.IDAOContract;
import com.consilienceventures.clubhouse.model.Story;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ruben
 */
public class StoryDAOImpl extends EntityDAO implements IDAOContract<Story, Serializable>{ 

    @Override
    public void persist(Story entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Story entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Story findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Story entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Story> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void batchLoad(List<Story> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Story> findDistinct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
