package ar.gov.sedronar.aplicacion.services.implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.github.junrar.exception.RarException;

import ar.gov.sedronar.aplicacion.services.interfaces.FileUploadService;
import ar.gov.sedronar.aplicacion.util.ConfigProperties;
import ar.gov.sedronar.util.app.AppResponse;

/**
 * Created by TMR on 08/02/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class FileUploadServiceImpl implements FileUploadService {
    private final String UPLOADED_FILE_PATH = ConfigProperties.getInstance().getFilePath();

    private String fileName;

    @Override
    public Response uploadFile(MultipartFormDataInput input) {
        try {
            if (!pathExists())
                return Response.status(200).entity(new AppResponse(AppResponse.ERROR, "La ruta destino para guardar el archivo no existe (comuníquese con el administrador)")).build();
            
            //agregar procesamiento...
            return Response.status(200).entity(new AppResponse()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(200).entity(new AppResponse(AppResponse.ERROR, e.getMessage())).build();
        }
    }

    public boolean pathExists(){
        Path path = Paths.get(UPLOADED_FILE_PATH);
        return Files.exists(path);
    }

    /**
     * header sample
     * {
     * 	Content-Type=[image/png],
     * 	Content-Disposition=[form-data; name="file"; filename="filename.extension"]
     * }
     **/
    //get uploaded filename, is there a easy way in RESTEasy?
    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

    //save to somewhere
    private boolean writeFile(byte[] content, Integer idHistorial) throws IOException, RarException {
        String fileNameWithoutExtension = getFileNameWithoutExtension(fileName) + "/";
        String zipFolder = UPLOADED_FILE_PATH + idHistorial + "_" + fileNameWithoutExtension;
        String zipPath = zipFolder + fileName;
        FileUtils.writeByteArrayToFile(new File(zipPath), content);

        boolean containsSql = false;
        return containsSql;
    }

    private String getFileNameWithoutExtension(String filename){
        return filename.contains(".") ? filename.substring(0,filename.lastIndexOf(".")) : filename;
    }

}
