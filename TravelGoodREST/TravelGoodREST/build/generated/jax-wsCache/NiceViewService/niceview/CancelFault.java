
package niceview;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b05 
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "stringfault", targetNamespace = "http://xml.netbeans.org/schema/hotelschema")
public class CancelFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private String faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public CancelFault(String message, String faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public CancelFault(String message, String faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: java.lang.String
     */
    public String getFaultInfo() {
        return faultInfo;
    }

}
