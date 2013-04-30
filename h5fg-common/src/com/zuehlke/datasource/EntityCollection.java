/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.datasource;

import com.zuehlke.datasource.Entity;
import java.util.List;

/**
 *
 * @author marcbaechinger
 */
public interface EntityCollection<E extends Entity> {
    public List<E> getCollection();
}
