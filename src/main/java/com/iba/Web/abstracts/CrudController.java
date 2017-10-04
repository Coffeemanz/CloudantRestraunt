package com.iba.Web.abstracts;

import com.iba.Models.BaseModel;
import com.iba.Services.interfaces.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudController <T extends BaseModel> {

    protected abstract BaseService<T> getService();

    protected ResponseEntity<String> save(T model)
    {
        String id = getService().save(model);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    protected ResponseEntity update(T model)
    {
        getService().update(model);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    protected ResponseEntity delete(@PathVariable String id)
    {
        getService().delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    protected ResponseEntity<List<T>> getAll()
    {
        List<T> list = (List<T>)getService().getAll();
        return new ResponseEntity<List<T>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    protected ResponseEntity<T> get(@PathVariable String id)
    {
        T model = (T) getService().getbyId(id);
        return new ResponseEntity<T>(model, HttpStatus.OK);
    }

}
