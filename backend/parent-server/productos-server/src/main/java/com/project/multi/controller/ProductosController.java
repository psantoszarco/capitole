package com.project.multi.controller;


import com.project.multi.vo.FacturaJson;
import com.project.multi.vo.ResultFacturaJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.multi.service.ProductoService;
import com.project.multi.vo.ProductoJson;
import com.project.multi.vo.ResultProductoJson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(path = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductosController {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductoService productoService;
	
	/**
	 * Método de obtención de los productos disponibles
	 *
	 * @return the productos
	 */
	@ApiOperation(value = "productos", nickname = "productos",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@GetMapping("/productos")
	public ResultProductoJson getProductos() {

		log.debug("ApiCursoController - getProductos()");
		return productoService.obtenerProductos();
	}
	
	/**
	 * Método para obtener el detalle de un producto
	 *
	 * @param id the id
	 * @return the product byid
	 */
	@ApiOperation(value = "getProductByid", nickname = "getProductByid",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/producto/{id}")
	public ResultProductoJson getProductByid(@PathVariable(value="id",required=true) Long id) {

		log.debug("ApiCursoController - getProductByid()  id = "+id);
		return productoService.obtenerProductoPorId(id);
	}
	
	/**
	 * Método para borrar un producto
	 *
	 * @param id the id
	 * @return the result producto json
	 */
	@ApiOperation(value = "borrarProducto", nickname = "borrarProducto",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/delete-producto/{id}")
	public ResultProductoJson borrarProducto(@PathVariable(value="id",required=true) Long id) {

		log.debug("ApiCursoController - borrarProducto()  id = "+id);
		return productoService.borrarProducto(id);
	}
	
	/**
	 * Método para actualizar un producto.
	 *
	 * @param productoJson the producto json
	 * @return the result producto json
	 */
	@ApiOperation(value = "actualizarProducto", nickname = "actualizarProducto",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/update-producto")
	public ResultProductoJson actualizarProducto(@RequestBody ProductoJson productoJson) {

		log.debug("ApiCursoController - actualizarProducto()  id = "+productoJson.getId());
		return productoService.actualizarProducto(productoJson);
	}
	
	/**
	 * Método para guardar un producto.
	 *
	 * @param productoJson the producto json
	 * @return the result producto json
	 */
	@ApiOperation(value = "guardarProducto", nickname = "guardarProducto",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/save-producto")
	public ResultProductoJson guardarProducto(@RequestBody ProductoJson productoJson) {

		log.debug("ApiCursoController - guardarProducto()  id = "+productoJson.getId());
		return productoService.guardarProducto(productoJson);
	}

	/**
	 * Método para obtener una facturación.
	 *
	 * @param facturaJson the factura json
	 * @return the result factura json
	 */
	@ApiOperation(value = "getFactura", nickname = "getFactura",response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")
	})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/get-factura")
	public ResultFacturaJson getFactura(@RequestBody FacturaJson facturaJson) {

		log.debug("ApiCursoController - getFactura()  id = "+facturaJson.getName());
		return productoService.getFactura(facturaJson);
	}
	
}
