/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.database.implementations;

import com.consilienceventures.clubhouse.database.DAO.EntityDAO;
import com.consilienceventures.clubhouse.database.interfaces.IDAOContract;
import com.consilienceventures.clubhouse.model.Project;
import com.consilienceventures.clubhouse.model.Story;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ruben
 */
public class ProjectDAOImpl extends EntityDAO implements IDAOContract<Project, Serializable>{ 

    @Override
    public void persist(Project entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Project entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Project findById(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Project entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void batchLoad(List<Project> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findDistinct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
