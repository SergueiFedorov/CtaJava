package EndPoint.Converters;

import EndPoint.Interfaces.IXmlConverter;
import Models.Route;
import Models.Train;
import Tools.RouteHelper;
import Tools.XML.XMLParsingTools;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sfedo on 10/29/2016.
 */
public class XMLToRouteConverter implements IXmlConverter<Route> {

    @Override
    public Collection<Route> Convert(String XML, String parentNodeName) throws Exception {

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new InputSource(new StringReader(XML)));
        //NodeList nodes = document.getElementsByTagName(parentNodeName);

        Node allNodes = document.getFirstChild();

        Route route = new Route ();
        Node routeNode = document.getElementsByTagName("route").item(0);
        NodeList nodes = routeNode.getChildNodes();
        String lineName = XMLParsingTools.ExtractAttribute (routeNode, "name");

        route.setTrainRoute(RouteHelper.GetTrainRouteEnum (lineName));

        ArrayList<Train> parsedTrains = new ArrayList<>();
        for (int x = 0; x < nodes.getLength(); x++)
        {
            Node node = nodes.item(x);
            Train newTrain = new Train();
            newTrain.setDestinationName(XMLParsingTools.ExtractValue(node, "destNm"));
            newTrain.setRunNumber(XMLParsingTools.ParseUShort(XMLParsingTools.ExtractValue(node, "rn")));
            newTrain.setDestinationStopNumber(XMLParsingTools.ParseUShort(XMLParsingTools.ExtractValue(node, "destSt")));
            newTrain.setApproaching(XMLParsingTools.ParseBool(XMLParsingTools.ExtractValue(node, "isApp")));
            newTrain.setDelayed(XMLParsingTools.ParseBool(XMLParsingTools.ExtractValue(node, "isDly")));
            newTrain.setHeadingDegrees(XMLParsingTools.ParseInt(XMLParsingTools.ExtractValue(node, "heading")));
            newTrain.setTrainLongitude(XMLParsingTools.ParseDecimal(XMLParsingTools.ExtractValue(node, "lon")));
            newTrain.setTrainLatitude(XMLParsingTools.ParseDecimal(XMLParsingTools.ExtractValue(node, "lon")));
            newTrain.setTrainDirection(XMLParsingTools.ParseInt(XMLParsingTools.ExtractValue(node, "trDr")));
            newTrain.setPredicationGeneratedTime(XMLParsingTools.ParseDateTime(XMLParsingTools.ExtractValue(node, "prdt")));
            newTrain.setPredicatedArrival(XMLParsingTools.ParseDateTime(XMLParsingTools.ExtractValue(node, "arrT")));
            newTrain.setNextStationID(XMLParsingTools.ParseUShort(XMLParsingTools.ExtractValue(node, "nextStaId")));
            newTrain.setNextStopID(XMLParsingTools.ParseUShort(XMLParsingTools.ExtractValue(node, "nextStpId")));
            newTrain.setNextStationName(XMLParsingTools.ExtractValue(node, "nextStaNm"));
            newTrain.setFlags(XMLParsingTools.ExtractValue(node, "flags"));
            parsedTrains.add(0, newTrain);

        }

        route.setTrains(parsedTrains);
        List<Route> routes = new ArrayList<>();
        routes.add(0, route);

        return routes;
    }
}
