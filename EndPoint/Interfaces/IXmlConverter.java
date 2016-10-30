package EndPoint.Interfaces;

import java.util.Collection;

/**
 * Created by sfedo on 10/29/2016.
 */
public interface IXmlConverter<T> {
    Collection<T> Convert(String XML, String parentNodeName) throws Exception;
}
