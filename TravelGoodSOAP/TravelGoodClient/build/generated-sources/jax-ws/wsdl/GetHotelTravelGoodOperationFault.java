
package wsdl;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "getHotelFault", targetNamespace = "http://travelGood.wsdl")
public class GetHotelTravelGoodOperationFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GetHotelFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public GetHotelTravelGoodOperationFault(String message, GetHotelFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public GetHotelTravelGoodOperationFault(String message, GetHotelFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: wsdl.GetHotelFault
     */
    public GetHotelFault getFaultInfo() {
        return faultInfo;
    }

}
