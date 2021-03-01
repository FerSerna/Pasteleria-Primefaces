package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Estadosdeenvio.class)
public class Estadosdeenvio_ { 

    public static volatile SingularAttribute<Estadosdeenvio, String> estadoEnvio;
    public static volatile CollectionAttribute<Estadosdeenvio, Envios> enviosCollection;
    public static volatile SingularAttribute<Estadosdeenvio, Integer> id;
    public static volatile SingularAttribute<Estadosdeenvio, Integer> status;

}