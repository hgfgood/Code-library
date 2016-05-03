
package com.abc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.abc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddResponse_QNAME = new QName("http://cn.hgf.com/", "addResponse");
    private final static QName _Add_QNAME = new QName("http://cn.hgf.com/", "add");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.abc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add_Type }
     * 
     */
    public Add_Type createAdd_Type() {
        return new Add_Type();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cn.hgf.com/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cn.hgf.com/", name = "add")
    public JAXBElement<Add_Type> createAdd(Add_Type value) {
        return new JAXBElement<Add_Type>(_Add_QNAME, Add_Type.class, null, value);
    }

}
