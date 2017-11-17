/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Juan Carlos Tejeda
 */
public interface Managment <Modelo>{
    public boolean create(Modelo m);
    public boolean delete(Object key);
    public boolean update(Modelo m);    
    public Modelo read(Object key);
    public List<Modelo> readAll();
}
