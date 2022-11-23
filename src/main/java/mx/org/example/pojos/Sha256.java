package mx.org.example.pojos;

public class Sha256 {
	
	private Sha256() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String encrytp(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}