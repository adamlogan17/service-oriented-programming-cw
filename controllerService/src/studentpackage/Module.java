
package studentpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for module complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="module">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mc" type="{http://studentPackage/}moduleCode" minOccurs="0"/>
 *         &lt;element name="academicYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mark" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "module", propOrder = {
    "mc",
    "academicYear",
    "mark"
})
public class Module {

    protected ModuleCode mc;
    protected String academicYear;
    protected double mark;

    /**
     * Gets the value of the mc property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleCode }
     *     
     */
    public ModuleCode getMc() {
        return mc;
    }

    /**
     * Sets the value of the mc property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleCode }
     *     
     */
    public void setMc(ModuleCode value) {
        this.mc = value;
    }

    /**
     * Gets the value of the academicYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcademicYear() {
        return academicYear;
    }

    /**
     * Sets the value of the academicYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcademicYear(String value) {
        this.academicYear = value;
    }

    /**
     * Gets the value of the mark property.
     * 
     */
    public double getMark() {
        return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     */
    public void setMark(double value) {
        this.mark = value;
    }

}
