package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * The entry point for clients to access user data
 */
@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    /**
     * Returns a list of all zoos
     * <br>Example: <a href="http://localhost:2019/zoos/zoos">http://localhost:2019/zoos/zoos</a>
     *
     * @return JSON list of all zoos with a status of OK
     * @see ZooService#findAll() ZooService#findAll()
     */
    @GetMapping(value = "/zoos",
        produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(),
            HttpStatus.OK);
    }


    /**
     * Returns a single zoo based off a zoo id number
     * <br>Example: <a href="http://localhost:2019/zoos/zoo/7">http://localhost:2019/zoos/zoo/7</a>
     *
     * @param id The primary key of the zoo you seek
     * @return JSON object of the zoo you seek
     * @see ZooService#findZooById(long) ZooService.findZooById(long)
     */
    @GetMapping(value = "/zoo/{id}",
        produces = {"application/json"})
    public ResponseEntity<?> findZooById(
        @PathVariable
            long id)
    {
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z,
            HttpStatus.OK);
    }


    /**
     * Given a complete Zoo Object, create a new Zoo record and accompanying telephone numbers and animal zoo combinations
     * <br>Example: <a href="http://localhost:2019/zoos/zoo">http://localhost:2019/zoos/zoo</a>
     *
     * @param newZoo A complete new zoo to add including telephone numbers and animal.
     *               Animals must already exist.
     * @return A location header with the URI to the newly created zoo and a status of CREATED
     * @throws URISyntaxException Exception if something does not work in creating the location header
     * @see ZooService#save(Zoo) ZooService.save(Zoo)
     */
    @PostMapping(value = "/zoo",
        consumes = {"application/json"})
    public ResponseEntity<?> addNewZoo(
        @Valid
        @RequestBody
            Zoo newZoo) throws URISyntaxException
    {
        // nullify the zoo id
        newZoo.setZooid(0);
        newZoo = zooService.save(newZoo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{zooid}")
            .buildAndExpand(newZoo.getZooid())
            .toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null,
            responseHeaders,
            HttpStatus.CREATED);
    }


    /**
     * Given a complete Zoo Object
     * Given the zoo id, primary key, is in the zoo table,
     * replace the Zoo record , zoo animal combinations and telephone records.
     * <br> Example: <a href="http://localhost:2019/zoos/zoo/2">http://localhost:2019/zoos/zoo/15</a>
     *
     * @param updateZoo A complete Zoo including all telephones and animals to be used to
     *                  replace the Zoo. Animal types must already exist.
     * @param id        The primary key of the zoo you wish to replace.
     * @return status of OK
     * @see ZooService#save(Zoo) ZooService.save(Zoo)
     */
    @PutMapping(value = "/zoo/{id}",
        consumes = {"application/json"})
    public ResponseEntity<?> putUpdateZoo(
        @RequestBody
            Zoo updateZoo,
        @PathVariable
            long id)
    {
        updateZoo.setZooid(id);
        zooService.save(updateZoo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Updates the zoo record associated with the given id with the provided data. Only the provided fields are affected.
     * If an telephone number list or zoo animal combination list is given, it replaces the list.
     * <br> Example: <a href="http://localhost:2019/zoos/zoo/7">http://localhost:2019/zoos/zoo/7</a>
     *
     * @param updateZoo An object containing values for just the fields that are being updated. All other fields are left NULL.
     * @param id        The primary key of the user you wish to update.
     * @return A status of OK
     * @see ZooService#update(Zoo) ZooService.update(Zoo)
     */
    @PatchMapping(value = "/zoo/{id}",
        consumes = {"application/json"})
    public ResponseEntity<?> patchUpdateUser(
        @RequestBody
            Zoo updateZoo,
        @PathVariable
            long id)
    {
        updateZoo.setZooid(id);
        zooService.update(updateZoo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a given zoo along with associated telephone numbers and zoo animal combinations
     * <br>Example: <a href="http://localhost:2019/zoos/zoo/14">http://localhost:2019/zoos/zoo/14</a>
     *
     * @param id the primary key of the zoo you wish to delete
     * @return Status of OK
     */
    @DeleteMapping(value = "/zoo/{id}")
    public ResponseEntity<?> deleteZoo(
        @PathVariable
            long id)
    {
        zooService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
