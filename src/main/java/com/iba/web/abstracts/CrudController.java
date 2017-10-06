package com.iba.web.abstracts;

import com.iba.models.BaseModel;
import com.iba.services.interfaces.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudController <T extends BaseModel> {

    private BaseService<T> baseService;

    public CrudController(BaseService<T> baseService)
    {
        this.baseService = baseService;
    }


    @ApiOperation(value = "Save model to database", protocols = "https")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody T model)
    {
        String id = baseService.save(model);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @ApiOperation(value = "Update model", protocols = "https")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody T model, @PathVariable String id)
    {
       baseService.update(model);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete model with certain ID", protocols = "https")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id)
    {
       baseService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Get all models", protocols = "https")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<T>> getAll()
    {
        List<T> list = (List<T>)baseService.getAll();
        return new ResponseEntity<List<T>>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Get model with certain ID", protocols = "https")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> get(@PathVariable String id)
    {
        T model = (T)baseService.getbyId(id);
        return new ResponseEntity<T>(model, HttpStatus.OK);
    }

}
