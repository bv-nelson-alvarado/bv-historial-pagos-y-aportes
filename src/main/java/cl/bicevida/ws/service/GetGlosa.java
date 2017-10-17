
package cl.bicevida.ws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getGlosa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getGlosa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rutDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGlosa", propOrder = {
    "rutDv",
    "numeroContrato"
})
public class GetGlosa {

    protected String rutDv;
    protected String numeroContrato;

    /**
     * Obtiene el valor de la propiedad rutDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutDv() {
        return rutDv;
    }

    /**
     * Define el valor de la propiedad rutDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutDv(String value) {
        this.rutDv = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroContrato() {
        return numeroContrato;
    }

    /**
     * Define el valor de la propiedad numeroContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroContrato(String value) {
        this.numeroContrato = value;
    }

}
