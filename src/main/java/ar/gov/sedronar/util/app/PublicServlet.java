package ar.gov.sedronar.util.app;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by TMR on 31/08/2018.
 */
@WebServlet(
        name = "accesoPublico",
        description = "Sirve contenido público",
        urlPatterns = {"/publico/*", "/publico/*.js", "/publico/*.css", "/publico/*.map", "/publico/*.css.map","/publico/*.json", "/publico/*.ttf", "/publico/*.eot", "/publico/*.svg", "/publico/*.woff", "/publico/*.woff2", "/publico/*.jpg", "/publico/*.png"}
)
public class PublicServlet extends HttpServlet {
    private static final long serialVersionUID = -8307786248873262964L;
    public static final Logger logger = Logger.getLogger("PublicServlet");


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Use a ServletOutputStream because we may pass binary information
        ServletOutputStream out = res.getOutputStream();

        // Get the file to view
//		String file = req.getPathTranslated();
        String file = null;
        if ( "/".equals(req.getPathInfo()) ){req.getPathInfo();// /assets/...
            file = getServletContext().getRealPath("/index.html" );
        }else{
            file = getServletContext().getRealPath("/" + req.getPathInfo());
        }

        // No file, nothing to view
        if (file == null) {
            out.println("No file to view");
            return;
        }

        // Get and set the type of the file
        String contentType = getServletContext().getMimeType(file);
        res.setContentType(contentType);

        // Return the file
        try {
            returnFile(file, out);
        } catch (FileNotFoundException e) {
            out.println("File not found");
            e.printStackTrace();
            logger.log(Level.INFO, "ruta fallida: " + file);
        } catch (IOException e) {
            out.println("Problem sending file: " + e.getMessage());
        }
    }


    // Send the contents of the file to the output stream
    public void returnFile(String filename, OutputStream out)
            throws FileNotFoundException, IOException {
        // A FileInputStream is for bytes
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            byte[] buf = new byte[4 * 1024];  // 4K buffer
            int bytesRead;
            while ((bytesRead = fis.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }
        }
        finally {
            if (fis != null) fis.close();
        }
    }

}
