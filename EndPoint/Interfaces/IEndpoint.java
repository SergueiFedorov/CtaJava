package EndPoint.Interfaces;

import java.util.Collection;

/**
 * Created by sfedo on 10/29/2016.
 */
public interface IEndpoint<Model, Parameters> {
    Collection<Model> Get(Parameters parameters) throws Exception;
}
