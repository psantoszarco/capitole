package com.project.multi.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.project.multi.vo.FacturaJson;
import com.project.multi.vo.ResultFacturaJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.multi.entities.Producto;
import com.project.multi.repository.ProductRepository;
import com.project.multi.service.ProductoService;
import com.project.multi.utils.Constants;
import com.project.multi.utils.Utils;
import com.project.multi.vo.ProductoJson;
import com.project.multi.vo.ResultProductoJson;


/**
 * The Class ProductoServiceImpl.
 */
@Service
public class ProductoServiceImpl implements ProductoService{
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/* (non-Javadoc)
	 * @see com.curso.angular4.apicurso.service.ProductoService#obtenerProductos()
	 */
	@Override
	public ResultProductoJson obtenerProductos() {
		
		ResultProductoJson result = new ResultProductoJson();
		List<ProductoJson> lstProdJson = new ArrayList<>();
		List<Producto> lstProductos = productRepository.findAll();
		for(Producto producto : lstProductos){
			lstProdJson.add(Utils.mapProductoJson(producto));
		}
		result.setLstProductos(lstProdJson);
		result.setCode(Constants.CODE_200);
		result.setStatus(Constants.SUCCESS);
		result.setMessage(String.format("Se han recuperado %s productos",lstProdJson.size()));
		return result;
	}

	/* (non-Javadoc)
	 * @see com.curso.angular4.apicurso.service.ProductoService#obtenerProductoPorId(java.lang.Long)
	 */
	public ResultProductoJson obtenerProductoPorId(Long id) {
		ResultProductoJson result = new ResultProductoJson();
		List<ProductoJson> lstProdJson = new ArrayList<>();
		try {
			Producto producto = productRepository.findOne(id);
			if(null != producto){
				lstProdJson.add(Utils.mapProductoJson(producto));
				result.setCode(Constants.CODE_200);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(String.format("Se ha recuperado el producto con el id %s",id));
			}else{
				result.setCode(Constants.CODE_404);
				result.setStatus(Constants.ERROR);
				result.setMessage(String.format("El producto correspondiente al id %s no está disponible",id));
			}
		} catch (NumberFormatException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El id %s no tiene un formato válido",id));
		} 
		result.setLstProductos(lstProdJson);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.curso.angular4.apicurso.service.ProductoService#borrarProducto(java.lang.Long)
	 */
	@Transactional
	public ResultProductoJson borrarProducto(Long id) {
		ResultProductoJson result = new ResultProductoJson();
		try {
			Producto producto = productRepository.findOne(id);
			if(null != producto){
				productRepository.delete(producto);
				result.setCode(Constants.CODE_200);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(String.format("Se ha eliminado el producto con el id %s",id));
			}else{
				result.setCode(Constants.CODE_404);
				result.setStatus(Constants.ERROR);
				result.setMessage(String.format("El producto correspondiente al id %s no está disponible",id));
			}
		} catch (NumberFormatException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El id %s no tiene un formato válido",id));
		} 
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.curso.angular4.apicurso.service.ProductoService#actualizarProducto(com.curso.angular4.apicurso.ProductoJson)
	 */
	@Transactional
	public ResultProductoJson actualizarProducto(ProductoJson productoJson) {
		ResultProductoJson result = new ResultProductoJson();
			Producto producto = productRepository.findOne(productoJson.getId());
			if(null != producto){
				producto.setDescription(productoJson.getDescription());
				producto.setNombre(productoJson.getNombre());
				producto.setPrecio(productoJson.getPrecio());
				producto.setImagen(productoJson.getImagen());
				productRepository.save(producto);
				result.setCode(Constants.CODE_200);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(String.format("Se ha actualizado el producto con el id %s",productoJson.getId()));
			}else{
				result.setCode(Constants.CODE_404);
				result.setStatus(Constants.ERROR);
				result.setMessage(String.format("El producto con id %s no se ha modificado correctamente",productoJson.getId()));
			}
			
		return result;
	}

	/* (non-Javadoc)
	 * @see com.curso.angular4.apicurso.service.ProductoService#guardarProducto(com.curso.angular4.apicurso.ProductoJson)
	 */
	@Transactional
	public ResultProductoJson guardarProducto(ProductoJson productoJson) {
		ResultProductoJson result = new ResultProductoJson();
		List<ProductoJson> lstProdJson = new ArrayList<>();
			Producto producto = new Producto();
			producto.setDescription(productoJson.getDescription());
			producto.setNombre(productoJson.getNombre());
			producto.setPrecio(productoJson.getPrecio());
			producto.setImagen(productoJson.getImagen());
			productRepository.save(producto);
			productoJson.setId(producto.getId());
			lstProdJson.add(productoJson);
			result.setLstProductos(lstProdJson);
			result.setCode(Constants.CODE_200);
			result.setStatus(Constants.SUCCESS);
			result.setMessage(String.format("Se ha insertado correctamente el producto con el id %s",productoJson.getId()));
			
		return result;
	}

	@Override
	public ResultFacturaJson getFactura(FacturaJson facturaJson) {

		ResultFacturaJson result = new ResultFacturaJson();
		result.setCode(Constants.CODE_200);
		result.setStatus(Constants.SUCCESS);
		result.setName(facturaJson.getName()+" "+facturaJson.getApellidos());
		result.setEmail(facturaJson.getEmail());
		if (facturaJson.getTeléfonos().size() > 0){
			result.setLstProductos(facturaJson.getTeléfonos().stream().map(t -> Utils.mapProductoJson(productRepository.findOne(Long.valueOf(t)))).collect(Collectors.toList()));
			result.setTotal(result.getLstProductos().stream().mapToDouble(i -> Double.valueOf(i.getPrecio())).sum());
		}

		return result;
	}


}
