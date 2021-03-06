
package cl.bicevida.ws.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para responseServiceTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="responseServiceTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pagosYAportesWs" type="{http://service.ws.bicevida.cl/}pagosYAportesWsVO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="urlReporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseServiceTO", propOrder = {
    "pagosYAportesWs",
    "urlReporte"
})
public class ResponseServiceTO {

    @XmlElement(nillable = true)
    protected List<PagosYAportesWsVO> pagosYAportesWs;
    protected String urlReporte;

    /**
     * Gets the value of the pagosYAportesWs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pagosYAportesWs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPagosYAportesWs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PagosYAportesWsVO }
     * 
     * 
     */
    public List<PagosYAportesWsVO> getPagosYAportesWs() {
        if (pagosYAportesWs == null) {
            pagosYAportesWs = new ArrayList<PagosYAportesWsVO>();
        }
        return this.pagosYAportesWs;
    }

    /**
     * Obtiene el valor de la propiedad urlReporte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlReporte() {
        return urlReporte;
    }

    /**
     * Define el valor de la propiedad urlReporte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlReporte(String value) {
        this.urlReporte = value;
    }

}
