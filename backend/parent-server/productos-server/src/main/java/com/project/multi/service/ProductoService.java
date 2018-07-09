package com.project.multi.service;

import com.project.multi.vo.FacturaJson;
import com.project.multi.vo.ProductoJson;
import com.project.multi.vo.ResultFacturaJson;
import com.project.multi.vo.ResultProductoJson;

/**
 * The Interface ProductoService.
 */
public interface ProductoService {
	
	/**
	 * Obtener productos.
	 *
	 * @return the result producto json
	 */
	ResultProductoJson obtenerProductos();
	
	/**
	 * Obtener producto por id.
	 *
	 * @param id the id
	 * @return the result producto json
	 */
	ResultProductoJson obtenerProductoPorId(Long id);
	
	/**
	 * Borrar producto.
	 *
	 * @param id the id
	 * @return the result producto json
	 */
	ResultProductoJson borrarProducto(Long id);

	/**
	 * Actualizar producto.
	 *
	 * @param productoJson the producto json
	 * @return the result producto json
	 */
	ResultProductoJson actualizarProducto(ProductoJson productoJson);

	/**
	 * Guardar producto.
	 *
	 * @param productoJson the producto json
	 * @return the result producto json
	 */
	ResultProductoJson guardarProducto(ProductoJson productoJson);

	/**
	 * Obtener factura
	 *
	 * @param facturaJson the factura json
	 * @return the result factura json
	 */
	ResultFacturaJson getFactura(FacturaJson facturaJson);
}
