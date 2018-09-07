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

@WebServlet(
        name = "estatico",
        description = "Sirve contenido estatico",
		urlPatterns = {"*.js", "*.css", "b*.map", "*.css.map","*.json", "*.ttf", "*.eot", "*.svg", "*.woff", "*.woff2", "*.jpg", "*.png"}
)
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = -5638878150300253558L;
	public static final Logger logger = Logger.getLogger("FileServlet");


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Use a ServletOutputStream because we may pass binary information
		ServletOutputStream out = res.getOutputStream();

		// Get the file to view
//		String file = req.getPathTranslated();
		String file = getServletContext().getRealPath("/" + req.getServletPath());
		
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
