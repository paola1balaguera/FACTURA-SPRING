package com.FacturaDTO.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FacturaDTO.demo.Repository.Entities.Cliente;
import com.FacturaDTO.demo.Services.ClienteServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;



/*     1. declarar ruta principal
    2. instanciar servicio
    3. Mirar que subrutas necesitamos y las ponemos
    4. Cada ruta tiene un metodo. "/" -> listar
 */

// PRIMERO


@RestController // REST -> es una arquitectura de software que impone condiciones sobre cómo debe funcionar una API.
@RequestMapping("/clientes") // La ruta principal del controlador de como se buscara en la API
@AllArgsConstructor

public class ClienteController {



    //SEGUNDO
    private ClienteServices clienteServices;

    // GET,      POST,         PUT, 
    //  |          |            |
    // obtener  guardar        editar todo el objeto

    // PATCH,                          DELETE
    //   |                                |
    // editar una parte del objeto      eliminar

    //Controller -> servicio -> repositorio -> cliente


    //TERCERO

/* El implementa las operaciones del:  CRUD     
                                               
    create -> save  
     
    read -> findAll()

    update -> update

    delete -> delete

    Si implementas otros metodos en tus services debes implementarlos en controllers */

    @GetMapping("/")
    public List<Cliente> findAll() {
        return clienteServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> findAllById(@PathVariable Long id) {

         Map<String,Object> response=new HashMap<>();

         Cliente cliente = clienteServices.findById(id);

         if(cliente!=null){
            response.put("cliente",cliente);
            return new ResponseEntity<>(response,HttpStatus.OK);
         }else{
            response.put("mensaje",new String("No existe ningún cliente con ese id:"));
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
         }
    }
         

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Cliente cliente, BindingResult result) {

        Cliente clienteNew = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            clienteNew = clienteServices.save(cliente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El cliente ha sido creado con éxito");
        response.put("cliente", clienteNew);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Cliente cliente, BindingResult result,
            @PathVariable Long id) {

        Cliente clienteUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            clienteUpdate = clienteServices.update(id, cliente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el upate en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El cliente ha sido actualizado con éxito");
        response.put("cliente", clienteUpdate);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            clienteServices.deleteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente elimando con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    }


    


    
    






