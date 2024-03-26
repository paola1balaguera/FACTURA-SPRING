package com.FacturaDTO.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FacturaDTO.demo.Repository.Entities.Producto;
import com.FacturaDTO.demo.Services.ProductoServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

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
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/productos")
@AllArgsConstructor

public class ProductoController {
    
    private ProductoServices productoServices;

    @GetMapping("/")
    public List<Producto> findAll() {
        return productoServices.findAll();
    }

    @PostMapping("/")

    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Producto producto, BindingResult result) {
    
/*         ResponseEntity<Map<String, Object>>: Especifica el tipo de respuesta que devuelve el método.
        En este caso, es un ResponseEntity que contiene un Map con claves de tipo 
        String y valores de tipo Object. */

        //@Valid: Es una anotación que se utiliza para validar el objeto Producto según las 
        //restricciones definidas en la clase. 
/* 
        @RequestBody: Indica que el objeto Producto se debe deserializar 
        a partir del cuerpo de la solicitud HTTP. */

/*         BindingResult result: Es un objeto que contiene los resultados de la 
        validación, incluidos los errores si la validación falla. */

        Producto productoNew = null;

        // se declara una nueva variabe null para guardar el nuevo objeto

        Map<String, Object> response = new

/*         Map<String, Object> response = new HashMap<>();: Se crea un nuevo Map que se utilizará para construir la 
        respuesta que se enviará al cliente. seu usa clave string y object */

        HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);

/*          List<String> errors = result.getFieldErrors() ...: En este bloque de código se construye una lista de mensajes
            de error a partir de los errores de validación del objeto BindingResult. 
            Se utiliza stream(), map() y collect() para transformar los errores de 
            validación en mensajes legibles para el usuario. */

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

            // si hay errores se devuelve esa respuesta

        //if (result.hasErrors()) { ... }: Este bloque de código verifica si hay errores de validación en el objeto
        }
        try {

            productoNew = productoServices.save(producto);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        
            //Se construye una respuesta a las exepciones si hay estas presentes
        }

        response.put("mensaje", "El cliente ha sido creado con éxito");
        response.put("cliente", productoNew);

        return new ResponseEntity<>(response, HttpStatus.OK);

        // da respuesta a la request


/*         En resumen, este método recibe un objeto Producto en la solicitud HTTP, 
        lo valida, intenta guardar el objeto en la base de datos y luego 
        construye una respuesta que contiene información sobre el resultado de la
        operación de guardado (por ejemplo, si se guardó correctamente o si hubo
        errores de validación). */

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            productoServices.deleteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido elimando con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
    
    



