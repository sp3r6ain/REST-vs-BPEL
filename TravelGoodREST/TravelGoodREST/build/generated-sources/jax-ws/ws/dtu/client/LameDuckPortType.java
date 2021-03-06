
package ws.dtu.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b05 
 * Generated source version: 2.1
 * 
 */
@WebService(name = "LameDuckPortType", targetNamespace = "urn:LameDuck")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LameDuckPortType {


    /**
     * 
     * @param source
     * @param date
     * @param destination
     * @return
     *     returns ws.dtu.client.FlightList
     */
    @WebMethod
    @WebResult(name = "flightList", partName = "flightList")
    public FlightList getFlights(
        @WebParam(name = "Source", partName = "Source")
        String source,
        @WebParam(name = "destination", partName = "destination")
        String destination,
        @WebParam(name = "date", partName = "date")
        XMLGregorianCalendar date);

    /**
     * 
     * @param creditcard
     * @param bookingnumber
     * @return
     *     returns boolean
     * @throws BookFlightFault
     */
    @WebMethod
    @WebResult(name = "status", partName = "status")
    public boolean bookFlight(
        @WebParam(name = "bookingnumber", partName = "bookingnumber")
        int bookingnumber,
        @WebParam(name = "creditcard", partName = "creditcard")
        CreditCardInfoType creditcard)
        throws BookFlightFault
    ;

    /**
     * 
     * @param bookingnumber1
     * @param credircardinfo1
     * @param price1
     * @return
     *     returns boolean
     * @throws CancelFlightFaultMessage
     */
    @WebMethod
    @WebResult(name = "status1", partName = "status1")
    public boolean cancelFlight(
        @WebParam(name = "bookingnumber1", partName = "bookingnumber1")
        int bookingnumber1,
        @WebParam(name = "price1", partName = "price1")
        int price1,
        @WebParam(name = "credircardinfo1", partName = "credircardinfo1")
        CreditCardInfoType credircardinfo1)
        throws CancelFlightFaultMessage
    ;

}
