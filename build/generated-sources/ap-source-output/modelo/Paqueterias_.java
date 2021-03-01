package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Paqueterias.class)
public class Paqueterias_ { 

    public static volatile SingularAttribute<Paqueterias, BigDecimal> latitud;
    public static volatile SingularAttribute<Paqueterias, BigDecimal> longitud;
    public static volatile CollectionAttribute<Paqueterias, Envios> enviosCollection;
    public static volatile SingularAttribute<Paqueterias, Integer> id;
    public static volatile SingularAttribute<Paqueterias, String> nombreEmpresa;
    public static volatile SingularAttribute<Paqueterias, String> rutaImagenLogo;
    public static volatile SingularAttribute<Paqueterias, Integer> status;

}