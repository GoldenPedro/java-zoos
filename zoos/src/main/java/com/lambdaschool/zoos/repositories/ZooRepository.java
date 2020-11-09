package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.views.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * The CRUD repository connecting Zoos to the rest of the application
 */
public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    /**
     * Finds the zoos whose name includes the given substring, case insensitive
     *
     * @param name The substring (String) you wish to search for
     * @return An ArrayList of Zoos that you are seeking
     */
    ArrayList<Zoo> findByZoonameContainingIgnoringCase(String name);
}
