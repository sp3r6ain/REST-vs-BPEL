
package niceview;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b05 
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "NiceViewService", targetNamespace = "urn:NiceView", wsdlLocation = "file:/C:/Users/Diego/Documents/NetBeansProjects/softwaredev/NiceViewSoap/NiceView/src/conf/xml-resources/web-services/NiceView/wsdl/NiceView.wsdl")
public class NiceViewService
    extends Service
{

    private final static URL NICEVIEWSERVICE_WSDL_LOCATION;
    private final static WebServiceException NICEVIEWSERVICE_EXCEPTION;
    private final static QName NICEVIEWSERVICE_QNAME = new QName("urn:NiceView", "NiceViewService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Diego/Documents/NetBeansProjects/softwaredev/NiceViewSoap/NiceView/src/conf/xml-resources/web-services/NiceView/wsdl/NiceView.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NICEVIEWSERVICE_WSDL_LOCATION = url;
        NICEVIEWSERVICE_EXCEPTION = e;
    }

    public NiceViewService() {
        super(__getWsdlLocation(), NICEVIEWSERVICE_QNAME);
    }

    public NiceViewService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns NiceViewPortType
     */
    @WebEndpoint(name = "NiceViewPortTypeBindingPort")
    public NiceViewPortType getNiceViewPortTypeBindingPort() {
        return super.getPort(new QName("urn:NiceView", "NiceViewPortTypeBindingPort"), NiceViewPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NiceViewPortType
     */
    @WebEndpoint(name = "NiceViewPortTypeBindingPort")
    public NiceViewPortType getNiceViewPortTypeBindingPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:NiceView", "NiceViewPortTypeBindingPort"), NiceViewPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NICEVIEWSERVICE_EXCEPTION!= null) {
            throw NICEVIEWSERVICE_EXCEPTION;
        }
        return NICEVIEWSERVICE_WSDL_LOCATION;
    }

}
