package com.iba.web.abstracts;

import com.iba.models.BaseModel;
import com.iba.services.interfaces.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudController <T extends BaseModel> {

    public abstract BaseService<T> getService();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody T model)
    {
        String id = getService().save(model);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody T model, @PathVariable String id)
    {
        getService().update(model);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id)
    {
        getService().delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<T>> getAll()
    {
        List<T> list = (List<T>)getService().getAll();
        return new ResponseEntity<List<T>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> get(@PathVariable String id)
    {
        T model = (T) getService().getbyId(id);
        return new ResponseEntity<T>(model, HttpStatus.OK);
    }

}
