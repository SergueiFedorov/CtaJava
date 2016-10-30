package Tools;

import Enums.EnumTrainRoute;

/**
 * Created by sfedo on 10/29/2016.
 */
public class RouteHelper {

    public static String GetTrainRouteString(EnumTrainRoute route) throws Exception
    {
        switch (route)
        {
            case Red:
                return "Red";
            case Blue:
                return "Blue";
            case Brown:
                return "Brn";
            case Purple:
                return "P";
            case Green:
                return "G";
            case Orange:
                return "Org";
            case Pink:
                return "Pink";
            case Yellow:
                return "Y";
            default:
                throw new Exception("Cannot determine train route by enum");
        }
    }

    public static EnumTrainRoute GetTrainRouteEnum(String name) throws Exception
    {
        switch (name.toLowerCase())
        {
            case "red":
                return EnumTrainRoute.Red;
            case "blue":
                return EnumTrainRoute.Blue;
            case "brn":
                return EnumTrainRoute.Brown;
            case "p":
                return EnumTrainRoute.Purple;
            case "g":
                return EnumTrainRoute.Green;
            case "org":
                return EnumTrainRoute.Orange;
            case "pink":
                return EnumTrainRoute.Pink;
            case "y":
                return EnumTrainRoute.Yellow;
            default:
                throw new Exception ("Cannot determine train route by string");
        }
    }

}
