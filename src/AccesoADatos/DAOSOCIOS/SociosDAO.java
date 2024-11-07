package AccesoADatos.DAOSOCIOS;

import AccesoADatos.DAOSOCIOS.exceptions.NonUniqueRecordException;


public class SociosDAO {

    public SocioDTO getSocioById() {

        // Simulación de acceso a datos

        return new SocioDTO();
    }

    public SocioDTO getSocioByDNI() throws NonUniqueRecordException {
        throw new NonUniqueRecordException("Not implemented");

    }

}
