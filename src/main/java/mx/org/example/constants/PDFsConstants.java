package mx.org.example.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDFsConstants {
	
	private PDFsConstants() {
	    throw new IllegalStateException("Utility class");
	}

	public static List<Map<String, Object>> getPDFs() {
		List<Map<String, Object>> pdfs = new ArrayList<>();
		Map<String, Object> pdf1 = new HashMap<>();
		pdf1.put("name", "Alejandra Salgado");
		pdf1.put("url", "www.google.com");
		pdf1.put("idPartido", 1);
		pdf1.put("secretaria ", 1);

		Map<String, Object> pdf2 = new HashMap<>();
		pdf2.put("name", "Pedro Salgado");
		pdf2.put("url", "www.google.com");
		pdf2.put("idPartido", 1);
		pdf2.put("secretaria ", 1);

		pdfs.add(pdf1);
		pdfs.add(pdf2);
		pdfs.add(pdf1);
		pdfs.add(pdf2);

		return pdfs;
	}
}
