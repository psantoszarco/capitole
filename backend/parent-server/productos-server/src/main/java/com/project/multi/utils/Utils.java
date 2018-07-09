/*
 * Microservicio para la gestión de productos
 */
package com.project.multi.utils;

import com.project.multi.entities.Producto;
import com.project.multi.vo.ProductoJson;

/**
 * The Class Utils.
 */
public class Utils {
	
	/**
	 * Map producto json.
	 *
	 * @param producto the producto
	 * @return the producto json
	 */
	public static ProductoJson mapProductoJson(Producto producto){
		
		ProductoJson prodJson = new ProductoJson();
		prodJson.setId(producto.getId());
		prodJson.setDescription(producto.getDescription());
		prodJson.setNombre(producto.getNombre());
		prodJson.setPrecio(producto.getPrecio());
		prodJson.setImagen(producto.getImagen());
		
		return prodJson;
	}

}
