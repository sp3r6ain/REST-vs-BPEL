/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.asked;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wsdl.AddFlightRequest;
import wsdl.AddFlightResponse;
import wsdl.AddFlightTravelGoodFault;
import wsdl.AddHotelRequest;
import wsdl.AddHotelResponse;
import wsdl.AddHotelTravelGoodFault;
import wsdl.BookItineraryRequest;
import wsdl.BookItineraryResponse;
import wsdl.BookItineraryTravelGoodFault;
import wsdl.CancelItineraryFault;
import wsdl.CreateItineraryRequest;
import wsdl.CreateItineraryResponse;
import wsdl.CreditCardInfoType;
import wsdl.ExpirationDateType;
import wsdl.Flight;
import wsdl.FlightList;
import wsdl.GetFlightRequest;
import wsdl.GetFlightTravelGoodOperationFault;
import wsdl.GetHotelRequest;
import wsdl.GetHotelTravelGoodOperationFault;
import wsdl.GetItineraryRequest;
import wsdl.GetItineraryResponse;
import wsdl.Hotel;
import wsdl.Hotellist;

/**
 *
 * @author Alina GHERMAN<alinagherman@hotmail.fr>
 */
public class TestB {


    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
   
  @Test
    public void testB() throws Exception{
        //create itinerary
        CreateItineraryRequest request = new CreateItineraryRequest();
        request.setCustomerID("13");
        CreateItineraryResponse response = createItineraryTravelGoodOperation(request);
        assertNotNull(request);
        assertFalse(response.getItineraryID().isEmpty());
        

        //get a list of flights**********************************************
        DatatypeFactory dataFactory = null;
        
            dataFactory = DatatypeFactory.newInstance();
        
        GetFlightRequest getFlightInput = new GetFlightRequest();
        getFlightInput.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
        getFlightInput.setFlightDestinationPoint("MAD");
        getFlightInput.setFlightStartPoint("CPH");
        getFlightInput.setItineraryID(response.getItineraryID());

        FlightList result = new FlightList();

            result = getFlightTravelGoodOperation(getFlightInput);
            //*****************************FLIGHT 1**************************************
            //****************************************************************************
            //test recived flight**************************************
            assertEquals(result.getFlightInformation().size(), 1);
            assertEquals(result.getFlightInformation().get(0).getAirline(), "SAS");
            assertEquals(result.getFlightInformation().get(0).getBookingNumber(), 1);
            assertEquals(result.getFlightInformation().get(0).getPrice(), 100);
            assertEquals(result.getFlightInformation().get(0).getFlight().getDestinationAirport(), "MAD");
            assertEquals(result.getFlightInformation().get(0).getFlight().getStartAirport(), "CPH");
            //create and add the flight**************************************
            Flight f = new Flight();
            f.setStartAirport(result.getFlightInformation().get(0).getFlight().getStartAirport());
            f.setDestinationAirport(result.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f.setCarrier(result.getFlightInformation().get(0).getFlight().getCarrier());
            f.setLandingTimetim(result.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f.setLiftOffDate(result.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f.setLiftOffTime(result.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo = new AddFlightRequest.FlightInfo();
            flightInfo.setBookingNumber(result.getFlightInformation().get(0).getBookingNumber());
            flightInfo.setFlight(f);
            flightInfo.setPrice(result.getFlightInformation().get(0).getPrice());
            flightInfo.setAirline(result.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight = new AddFlightRequest();
            requestAddFlight.setItineraryID(response.getItineraryID());
            requestAddFlight.setFlightInfo(flightInfo);
            AddFlightResponse responseAddFlight;      
            responseAddFlight = addFlightTravelGoodOperation(requestAddFlight);
            assertNotNull(responseAddFlight);
            assertTrue(responseAddFlight.isAddFlightConfirmation());       
            //*****************************HOTEL 1**************************************
            //****************************************************************************            
            //get hotel*******************************************************
           
            //add hotel**************************************
            Hotel h = new Hotel();
            h.setAddress("Lorient booking should fail");
            h.setBooknumber(45612);
            h.setCity("Wrong Lorient");
            h.setEndperiod(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
            h.setGuarantee(false);
            h.setName("This is a name");
            h.setPrice(100);
            h.setReservationService("This is a reservation service");
            h.setStartperiod(dataFactory.newXMLGregorianCalendarDate(2013, 12, 19, 0));
            AddHotelRequest requestAddHotels = new AddHotelRequest();
            requestAddHotels.setItineraryID(response.getItineraryID());
            requestAddHotels.setHotelInfo(h);
            AddHotelResponse responseAddHotel1;
            responseAddHotel1 = addHotelTravelGoodlOperation(requestAddHotels);           
            assertNotNull(responseAddHotel1);
            assertTrue(responseAddHotel1.isAddHotelConfirmation()); 
            //*****************************FLIGHT 2**************************************
            //****************************************************************************            
            //get flight****************************************************
            GetFlightRequest getFlightInput1 = new GetFlightRequest();
            getFlightInput1.setFlightDate(dataFactory.newXMLGregorianCalendarDate(2013, 12, 30, 0));
            getFlightInput1.setFlightDestinationPoint("ABC");
            getFlightInput1.setFlightStartPoint("DEF");
            getFlightInput1.setItineraryID(response.getItineraryID());
            FlightList result1 = new FlightList();
            result1 = getFlightTravelGoodOperation(getFlightInput1);
            assertEquals(result1.getFlightInformation().size(), 2);
            assertEquals(result1.getFlightInformation().get(0).getAirline(), "Ryanair");
            assertEquals(result1.getFlightInformation().get(0).getBookingNumber(), 2);
            assertEquals(result1.getFlightInformation().get(0).getPrice(), 200);
            assertEquals(result1.getFlightInformation().get(0).getFlight().getDestinationAirport(), "ABC");
            assertEquals(result1.getFlightInformation().get(0).getFlight().getStartAirport(), "DEF");
            //create and add the flight*************************************
            Flight f1 = new Flight();
            f1.setStartAirport(result1.getFlightInformation().get(0).getFlight().getStartAirport());
            f1.setDestinationAirport(result1.getFlightInformation().get(0).getFlight().getDestinationAirport());
            f1.setCarrier(result1.getFlightInformation().get(0).getFlight().getCarrier());
            f1.setLandingTimetim(result1.getFlightInformation().get(0).getFlight().getLandingTimetim());
            f1.setLiftOffDate(result1.getFlightInformation().get(0).getFlight().getLiftOffDate());
            f1.setLiftOffTime(result1.getFlightInformation().get(0).getFlight().getLiftOffTime());
            AddFlightRequest.FlightInfo flightInfo1 = new AddFlightRequest.FlightInfo();
            flightInfo1.setBookingNumber(result1.getFlightInformation().get(0).getBookingNumber());
            flightInfo1.setFlight(f1);
            flightInfo1.setPrice(result1.getFlightInformation().get(0).getPrice());
            flightInfo1.setAirline(result1.getFlightInformation().get(0).getAirline());
            AddFlightRequest requestAddFlight1 = new AddFlightRequest();
            requestAddFlight1.setItineraryID(response.getItineraryID());
            requestAddFlight1.setFlightInfo(flightInfo1);
            AddFlightResponse responseAddFlight1;
            responseAddFlight1 = addFlightTravelGoodOperation(requestAddFlight1);
            assertNotNull(responseAddFlight1);
            assertEquals(true, responseAddFlight1.isAddFlightConfirmation());

            //*****************************GET ITINERARY**************************************
            //**************************************************************************** 
            //ask for itinerary*****************************************
            GetItineraryRequest requestItinerary = new GetItineraryRequest();
            requestItinerary.setItineraryID(response.getItineraryID());     
            GetItineraryResponse responseItinerary = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary);
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus());
            assertEquals("unconfirmed", responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Wrong Lorient",responseItinerary.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 

          
             //*****************************BOOK ITINERARY should fail**************************************
            //*****************************************Second booking= hotel**************************** 
            BookItineraryRequest requestBook = new BookItineraryRequest();
            requestBook.setItineraryID(response.getItineraryID());
            CreditCardInfoType card =  new CreditCardInfoType();

             card.setName("Anne Strandberg");
             card.setNumber("50408816");
             ExpirationDateType edate = new ExpirationDateType();
             edate.setMonth(5);
             edate.setYear(9);
             card.setExpirationDate(edate);
             requestBook.setCreditCardInformation(card);
             BookItineraryResponse responseBook;
             responseBook =null;
             try{
                responseBook = bookItineraryTravelGoodOperation(requestBook);
                fail("It should have failed");
             }catch(BookItineraryTravelGoodFault e){
                 
             }
             
             //*****************************GET ITINERARY**************************************
            //**************************************************************************** 

            GetItineraryResponse responseItinerary1 = getItineraryOperation(requestItinerary);
            assertNotNull(responseItinerary1);
            assertEquals("unconfirmed", responseItinerary1.getItinerary().getItineraryStatus());
            assertEquals("cancelled", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getFlightStatus());
            assertEquals("cancelled", responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getFlightStatus()); 
            assertEquals("unconfirmed", responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getHotelStatus());
            assertEquals(1, responseItinerary1.getItinerary().getHotelListRoot().getHotelList().size());
            assertEquals(2, responseItinerary1.getItinerary().getFlightListRoot().getFlightList().size());
            assertEquals(100,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getPrice()); 
            assertEquals(200,responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getPrice()); 
            assertEquals("SAS",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(0).getAirline()); 
            assertEquals("Ryanair",responseItinerary1.getItinerary().getFlightListRoot().getFlightList().get(1).getAirline()); 
            assertEquals("Wrong Lorient",responseItinerary1.getItinerary().getHotelListRoot().getHotelList().get(0).getCity()); 
            
          
    }
  
    private static AddFlightResponse addFlightTravelGoodOperation(wsdl.AddFlightRequest addFlightInput) throws AddFlightTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addFlightTravelGoodOperation(addFlightInput);
    }

    private static AddHotelResponse addHotelTravelGoodlOperation(wsdl.AddHotelRequest addHotelInput) throws AddHotelTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.addHotelTravelGoodlOperation(addHotelInput);
    }

    private static BookItineraryResponse bookItineraryTravelGoodOperation(wsdl.BookItineraryRequest bookItineraryInput) throws BookItineraryTravelGoodFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.bookItineraryTravelGoodOperation(bookItineraryInput);
    }

    private static boolean cancelItineraryOperation(wsdl.CancelItineraryRequest cancelInput) throws CancelItineraryFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.cancelItineraryOperation(cancelInput);
    }

    private static CreateItineraryResponse createItineraryTravelGoodOperation(wsdl.CreateItineraryRequest createItineraryInput) {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.createItineraryTravelGoodOperation(createItineraryInput);
    }

    private static FlightList getFlightTravelGoodOperation(wsdl.GetFlightRequest getFlightInput) throws GetFlightTravelGoodOperationFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getFlightTravelGoodOperation(getFlightInput);
    }

    private static Hotellist getHotelTravelGoodOperation(wsdl.GetHotelRequest getHotelInput) throws GetHotelTravelGoodOperationFault {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getHotelTravelGoodOperation(getHotelInput);
    }

    private static GetItineraryResponse getItineraryOperation(wsdl.GetItineraryRequest getItineraryInput) {
        wsdl.TravelGoodWsdlService service = new wsdl.TravelGoodWsdlService();
        wsdl.TravelGoodWsdlPortType port = service.getTravelGoodWsdlPortTypeBindingPort();
        return port.getItineraryOperation(getItineraryInput);
    }

}
