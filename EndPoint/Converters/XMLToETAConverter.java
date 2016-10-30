package EndPoint.Converters;

import EndPoint.Interfaces.IXmlConverter;
import Models.ETA;
import Tools.XML.XMLParsingTools;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class XMLToETAConverter implements IXmlConverter<ETA> {

    public Collection<ETA> Convert(String XML, String parentNodeName) throws Exception
    {

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new ByteArrayInputStream(XML.getBytes()));
        NodeList nodes  = document.getElementsByTagName("eta");
        //NodeList nodes = parent.getChildNodes();

        ArrayList<ETA> parsedETA = new ArrayList<>();
        for (int x = 0; x < nodes.getLength(); x++)
        {
            Node node = nodes.item(x);
            ETA eta = new ETA();
            eta.setPredicatedArrival(XMLParsingTools.ParseDateTime(XMLParsingTools.ExtractValue(node, "arrT")));
            eta.setDestinationName(XMLParsingTools.ExtractValue(node, "destNm"));
            eta.setStationID(XMLParsingTools.ParseUShort(XMLParsingTools.ExtractValue(node, "destSt")));
            eta.setFlags(XMLParsingTools.ExtractValue(node, "flags"));
            eta.setApproaching(XMLParsingTools.ParseBool(XMLParsingTools.ExtractValue(node, "isApp")));
            eta.setDelayed(XMLParsingTools.ParseBool(XMLParsingTools.ExtractValue(node, "isDly")));
            eta.setFaultDetected(XMLParsingTools.ParseBool(XMLParsingTools.ExtractValue(node, "isFlt")));
            eta.setLivePrediction(XMLParsingTools.ParseBool(XMLParsingTools.ExtractValue(node, "isSch")));
            eta.setPredicationGeneratedTime(XMLParsingTools.ParseDateTime(XMLParsingTools.ExtractValue(node, "prdt")));
            eta.setRunNumber(XMLParsingTools.ParseInt(XMLParsingTools.ExtractValue(node, "rn")));
            eta.setRouteName(XMLParsingTools.ExtractValue(node, "rt"));
            eta.setStationID(XMLParsingTools.ParseUShort(XMLParsingTools.ExtractValue(node, "staId")));
            eta.setStationDescription(XMLParsingTools.ExtractValue(node, "stpDe"));
            eta.setStopID(XMLParsingTools.ParseInt(XMLParsingTools.ExtractValue(node, "stpId")));
            eta.setRouteDirectionCode(XMLParsingTools.ParseInt(XMLParsingTools.ExtractValue(node, "trDr")));

            parsedETA.add(0, eta);

        }

        return parsedETA;
    }

}
