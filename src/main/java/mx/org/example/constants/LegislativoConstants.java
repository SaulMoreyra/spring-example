package mx.org.example.constants;

import java.util.HashMap;
import java.util.Map;

public class LegislativoConstants {
	
	private LegislativoConstants() {
	    throw new IllegalStateException("Utility class");
	}


	public static Map<String, String> getOptions() {
		Map<String, String> secretarias = new HashMap<>();
		secretarias.put("Mesa Directiva", "");
		secretarias.put("JUCOPO", "");
		secretarias.put("Atenci�n a Grupos Vulnerables", "");
		secretarias.put("Educaci�n ", "");
		secretarias.put("Hacienda ", "");
		secretarias.put("Pueblos Ind�genas ", "");
		secretarias.put("Salud ", "");
		secretarias.put("Trabajo ", "");
		secretarias.put("Por partido pol�tico ", "");
		return secretarias;
	}

	public static Map<String, String> getPartidos() {
		Map<String, String> secretarias = new HashMap<>();
		secretarias.put("PAN", "");
		secretarias.put("PRI", "");
		secretarias.put("PRD", "");
		secretarias.put("PT ", "");
		secretarias.put("Partido Verde ", "");
		secretarias.put("Movimiento Ciudadano", "");
		secretarias.put("Morena", "");
		return secretarias;
	}

}
