package com.Languajes;

import java.net.URL;


/**
 * Clase que maneja las properties relacionadas con el idioma por defecto y los soportados.
 * Atributos:
 * 
 * 	- translate-path-prefix : Es la primer parte de la ruta de donde tomara el properties.
 * 	- default_lang : Es el lenguaje por defecto que utiliza la aplicacion. Se obtiene del properties. 
 * 	- translate_path : Es la concatenacion del lenguaje con la translate_path
 * 	- supported_lang : Array que tiene los lenguajes soportados. Por cada uno de estos debe de haber un archivo en la ruta de los translates
 */

public class Languajes {
	// Atributos
	static String translate_path_prefix = "";
	static String translate_path = "";
	static String default_lang = "";
	static String[] supported_lang = null;
	
	/**
	 * Constructor
	 * Obtiene del archivo .properties:
	 * 	translate-path-prefix y lo guarda en la variable translate_path_prefix
	 * 	default-lang y lo guarda en la variable default_lang
	 *  supported-lang y lo guarda en la variable supported_lang
	 */
	/*
	public Languajes() {
		final PropertyInfo[] propertyNdefault = {
				new PropertyInfo_String("translate-path-prefix", null),
				new PropertyInfo_String("default-lang", null),
				new PropertyInfo_String("supported-lang", null), };

		URL propFilename = PropertiesHelper.getTypicalPropertiesURL(this
				.getClass());

		Object[] objPropiedades = PropertiesHelper.getAllValues(propFilename,
				propertyNdefault);
		
		// En este caso translate_path_prefix es (por ejemplo) isf.web.translates.translate_
		translate_path_prefix = ((String) objPropiedades[0]);
		// El default_lang es por ejemplo "es"
		default_lang = ((String) objPropiedades[1]);
		String supported_langAux = ((String) objPropiedades[2]);	
		
		supported_lang = supported_langAux.split(",");	
		
		// por lo que el translate path queda isf.web.translates.translate_es, que es efectivamente de donde toma las traducciones
		translate_path = translate_path_prefix + default_lang;
	}
	*/

	/**
	 * Métodos de acceso y modificación
	 * */	
	public String getTranslate_path() {
		return translate_path;
	}

	public void setTranslate_path(String translate_path) {
		Languajes.translate_path = translate_path;
	}

	public static String getDefault_lang() {
		return default_lang;
	}

	public static void setDefault_lang(String default_lang) {
		Languajes.default_lang = default_lang;
	}

	public static String[] getSupported_lang() {
		return supported_lang;
	}

	public static void setSupported_lang(String[] supported_lang) {
		Languajes.supported_lang = supported_lang;
	}
}
