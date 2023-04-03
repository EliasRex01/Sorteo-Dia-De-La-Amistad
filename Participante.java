public class Participante {
    private String nombre;
    private String apellido;
    private long numeroTelefono;
    private String email;
    private String preferencia;

    public Participante(String nombre, String apellido, long numeroTelefono, String email, String preferencia) throws Exception {
        validarNombre(nombre);
        validarApellido(apellido);
        validarNumeroTelefono(numeroTelefono);
        validarEmail(email);
        validarPreferencia(preferencia);

        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.preferencia = preferencia;
    }

    public static void validarNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre del participante es obligatorio");
        }
    }

    public static void validarApellido(String apellido) throws Exception {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new Exception("El apellido del participante es obligatorio");
        }
    }

    public static void validarNumeroTelefono(long numeroTelefono) throws Exception {
        String regex = "^\\+?\\d{2}?\\s?\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.valueOf(numeroTelefono));
        if (!matcher.matches()) {
            throw new Exception("El número de teléfono debe tener el formato adecuado");
        }
    }

    public static void validarEmail(String email) throws Exception {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new Exception("El correo electrónico debe tener el formato adecuado");
        }
    }

    public static void validarPreferencia(String preferencia) throws Exception {
        if (preferencia == null || preferencia.trim().isEmpty()) {
            throw new Exception("La preferencia del participante es obligatoria");
        }
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception {
        validarApellido(apellido);
        this.apellido = apellido;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(long numeroTelefono) throws Exception {
        validarNumeroTelefono(numeroTelefono);
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        validarEmail(email);
        this.email = email;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) throws Exception {
        validarPreferencia(preferencia);
        this.preferencia = preferencia;
    }
    
     @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numerodetelefono=" + numeroTelefono +
                ", email='" + email + ", preferencia=" + preferencia;
    }
    

}
