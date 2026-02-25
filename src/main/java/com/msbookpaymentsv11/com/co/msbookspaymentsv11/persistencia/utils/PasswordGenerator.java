//DECLARACIÓN DE PAQUETES:
package com.msbookpaymentsv11.com.co.msbookspaymentsv11.persistencia.utils;

//IMPORTACIÓN DE LIBRERIAS:
import java.security.SecureRandom;

/**
* @Autor MARIA GABRIELA ZAPATA DIAZ.
* @Since 19/02/2026.
* Declaración de la utilidad para generar contraseñas aleatorias seguras
* al momento de registrar un nuevo usuario en el sistema.
*/
public class PasswordGenerator {
  
  //DECLARACIÓN DE LOS CARACTERES PERMITIDOS Y LA LONGITUD DE LA CONTRASEÑA:
  private static final String CHARS =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
  private static final int LENGTH = 12;
  
  /**
  * @Autor MARIA GABRIELA ZAPATA DIAZ.
  * @Since 19/02/2026.
  * @return String con la contraseña aleatoria generada de 12 caracteres.
  * Genera una contraseña aleatoria segura usando SecureRandom.
  */
  //MÉTODO PARA GENERAR UNA CONTRASEÑA ALEATORIA SEGURA:
  public static String generateRandomPassword() {
    SecureRandom random = new SecureRandom();
    StringBuilder password = new StringBuilder(LENGTH);
    
    for (int i = 0; i < LENGTH; i++) {
        password.append(CHARS.charAt(random.nextInt(CHARS.length())));
    }
    return password.toString();
  }
}
