package mx.com.curso.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public String formatearFecha(Date fecha) {
		SimpleDateFormat a = new SimpleDateFormat("yyy/mm/dd hh:mi:ss");
		return a.format(fecha);
	}
	
}
