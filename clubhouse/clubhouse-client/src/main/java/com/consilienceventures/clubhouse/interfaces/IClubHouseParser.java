/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consilienceventures.clubhouse.interfaces;

import com.consilienceventures.clubhouse.model.Iteration;
import java.text.ParseException;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author ruben
 */
public interface IClubHouseParser {
    
    
    public HashMap<UUID,Iteration> getIterations(String json) throws ParseException;
    
    
}
