package Tools.XML;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by sfedo on 10/29/2016.
 */

public class XMLParsingTools
{
    public static Integer ParseUShort(String value)
    {
        return Integer.parseInt(value);
    }

    public static int ParseInt(String value)
    {
        return Integer.parseInt(value);
    }

    public static Boolean ParseBool(String value) throws Exception
    {
        if (!value.equals("1") && !value.equals("0"))
        {
            throw new Exception("Value passed to ParseBool is not 1 or 0. Value passed:" + value);
        }

        return value.equals("1");
    }

    //TODO: Make the string optional
    public static String ExtractValue(Node parent, String name)
    {
        NodeList children = parent.getChildNodes();
        for (int x = 0; x < children.getLength(); x++)
        {
            Node child = children.item(x);
            if (child.getNodeName().equals(name))
            {
                return child.getTextContent();
            }
        }
        return null;
    }

    public static String ExtractAttribute(Node element, String attributeName)
    {
        return element.getAttributes().getNamedItem(attributeName).getNodeValue();
    }

    public static BigDecimal ParseDecimal(String value)
    {
        return new BigDecimal(value);
    }

    public static LocalDateTime ParseDateTime(String value)
    {
        //Todo: needs clean up. Prone to format change crashes
        int year = Integer.parseInt(value.substring(0, 4));
        int month = Integer.parseInt(value.substring(4, 6));
        int day = Integer.parseInt(value.substring(6, 8));

        String[] timeSegments = value.substring(9, 17).split(":");

        int hour = Integer.parseInt(timeSegments[0]);
        int minute = Integer.parseInt(timeSegments[1]);
        int seconds = Integer.parseInt(timeSegments[2]);

        return LocalDateTime.of(year, month, day, hour, minute, seconds);
    }
}

