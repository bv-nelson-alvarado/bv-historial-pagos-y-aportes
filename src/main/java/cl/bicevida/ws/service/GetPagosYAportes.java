
package cl.bicevida.ws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getPagosYAportes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getPagosYAportes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rutDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="poliza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaDesde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPagosYAportes", propOrder = {
    "rutDv",
    "poliza",
    "fechaDesde",
    "fechaHasta"
})
public class GetPagosYAportes {

    protected String rutDv;
    protected String poliza;
    protected String fechaDesde;
    protected String fechaHasta;

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
     * Obtiene el valor de la propiedad poliza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoliza() {
        return poliza;
    }

    /**
     * Define el valor de la propiedad poliza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoliza(String value) {
        this.poliza = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDesde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Define el valor de la propiedad fechaDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDesde(String value) {
        this.fechaDesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHasta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Define el valor de la propiedad fechaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaHasta(String value) {
        this.fechaHasta = value;
    }

}
