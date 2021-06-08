/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.interfaces;

import com.consilienceventures.clubhouse.database.implementations.StoryDAOImpl;

/**
 *
 * @author ruben
 */
public interface IClubhouseBroker {
    
    void setup();

   StoryDAOImpl getStoryDAO();
}
