package mx.org.example.constants;

import java.util.HashMap;
import java.util.Map;

public class EjecutivoConstants {
	
	private EjecutivoConstants() {
	    throw new IllegalStateException("Utility class");
	}

	
	public static Map<String, String> getSecretarias() {
		Map<String, String> secretarias = new HashMap<>();
		secretarias.put("Oficina de la presidencia", "");
		secretarias.put("Hacienda y Cr�dito P�blico", "");
		secretarias.put("Bienestar", "");
		secretarias.put("SEP", "");
		secretarias.put("SADER", "");
		secretarias.put("SCT", "");
		secretarias.put("SFP", "");
		secretarias.put("Salud", "");
		secretarias.put("STPS", "");
		secretarias.put("SEDATU", "");
		return secretarias;
	}

	public static Map<String, String> getEstados() {
		Map<String, String> secretarias = new HashMap<>();
		secretarias.put("Aguascalientes", "");
		secretarias.put("Baja California", "");
		secretarias.put("Baja California Sur", "");
		secretarias.put("Campeche", "");
		secretarias.put("Coahuila ", "");
		secretarias.put("Colima", "");
		secretarias.put("Chiapas", "");
		secretarias.put("Chihuahua", "");
		secretarias.put("Ciudad de M�xico", "");
		secretarias.put("Durango", "");
		secretarias.put("Guanajuato", "");
		secretarias.put("Guerrero", "");
		secretarias.put("Hidalgo", "");
		secretarias.put("Jalisco", "");
		secretarias.put("M�xico", "");
		secretarias.put("Michoac�n ", "");
		secretarias.put("Morelos", "");
		secretarias.put("Nayarit", "");
		secretarias.put("Nuevo Le�n", "");
		secretarias.put("Oaxaca", "");
		secretarias.put("Puebla", "");
		secretarias.put("Quer�taro", "");
		secretarias.put("Quintana Roo", "");
		secretarias.put("San Luis Potos�", "");
		secretarias.put("Sinaloa", "");
		secretarias.put("Sonora", "");
		secretarias.put("Tabasco", "");
		secretarias.put("Tamaulipas", "");
		secretarias.put("Tlaxcala", "");
		secretarias.put("Veracruz", "");
		secretarias.put("Yucat�n", "");
		secretarias.put("Zacatecas", "");
		return secretarias;
	}
}
