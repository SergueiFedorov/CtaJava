package EndPoint.Interfaces;

import java.util.Objects;

/**
 * Created by sfedo on 10/29/2016.
 */
public interface IDataSource {
    void AddParameter(String name, Object value);
    void ClearParameters();
    String Execute() throws Exception;
}
