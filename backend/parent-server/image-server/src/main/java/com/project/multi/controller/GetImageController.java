package com.project.multi.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.HttpHeaders;
import com.project.multi.json.FileUploadJson;
import com.project.multi.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class GetImageController.
 */
@Api
@RestController
@RequestMapping("/images")
public class GetImageController {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/** The uploaded folder. */
	@Value("${url.uploader.folder}")
	private String UPLOADED_FOLDER;
	
	
	/**
	 * Función para recuperar la imagen de la carpeta especificada en la propiedad url.uploader.folder
	 *
	 * @param filename the filename
	 * @return the file
	 */
	@ApiOperation(value = "getFile", nickname = "getFile",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/uploads/{filename:.+}")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(@PathVariable("filename") String filename) {
		
		log.debug("GetImageController - INICIO ::  getFile() -- Nombre del fichero = "+filename);
		byte[] array = null;
		try(InputStream file = new FileInputStream(UPLOADED_FOLDER+filename)){
			array = IOUtils.toByteArray(file);
		} catch (IOException e) {
			log.error("Error al recuperar la imagen ",e);
		} 
		
		log.debug("GetImageController - FIN ::  getFile() -- Nombre del fichero = "+filename);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
				.body(array);
	}
	
	
	/**
	 * Método para realizar la subida de la imagen del producto a la carpeta especificada en la propiedad url.uploader.folder
	 *
	 * @param file the file
	 * @return the file upload json
	 */
	@ApiOperation(value = "singleFileUpload", nickname = "singleFileUpload",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
	@PostMapping("/upload-file")
    public FileUploadJson singleFileUpload(@RequestParam(value="file",required=true) MultipartFile file) {

		log.debug("ApiCursoController - INICIO ::  singleFileUpload() -- Nombre del fichero = "+file.getOriginalFilename());
		
		FileUploadJson result = new FileUploadJson();
		String nombre = "file-".concat(String.valueOf(new Date().getTime()).concat("-").concat(file.getOriginalFilename()));
        try {
        	
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + nombre);

			Path parentDir = path.getParent();
			if (!Files.exists(parentDir)) {
				Files.createDirectories(parentDir);
			}

            Files.write(path, bytes);
            result.setCode(Constants.CODE_200);
            result.setMessage("El archivo se ha subido correctamente");
            result.setStatus(Constants.SUCCESS);
            result.setFilename(nombre);
            log.debug("Se ha subido correctamente el fichero a: "+UPLOADED_FOLDER + nombre);
        } catch (IOException e) {
        	result.setCode(Constants.CODE_404);
            result.setMessage("El archivo no se ha subido correctamente");
            result.setStatus(Constants.ERROR);
            result.setFilename(file.getOriginalFilename());
            log.error("Se ha producido un error al subir el fichero :",e);
        }
        
        log.debug("ApiCursoController - FIN ::  singleFileUpload() -- Nombre del fichero = "+file.getOriginalFilename());

        return result;
    }

}
