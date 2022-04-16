
package studentpackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for student complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="student">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enrolledMcs" type="{http://studentPackage/}moduleCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enrolledModules" type="{http://studentPackage/}module" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "student", propOrder = {
    "id",
    "enrolledMcs",
    "enrolledModules"
})
public class Student {

    protected int id;
    @XmlElement(nillable = true)
    protected List<ModuleCode> enrolledMcs;
    @XmlElement(nillable = true)
    protected List<Module> enrolledModules;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the enrolledMcs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enrolledMcs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnrolledMcs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleCode }
     * 
     * 
     */
    public List<ModuleCode> getEnrolledMcs() {
        if (enrolledMcs == null) {
            enrolledMcs = new ArrayList<ModuleCode>();
        }
        return this.enrolledMcs;
    }

    /**
     * Gets the value of the enrolledModules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enrolledModules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnrolledModules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Module }
     * 
     * 
     */
    public List<Module> getEnrolledModules() {
        if (enrolledModules == null) {
            enrolledModules = new ArrayList<Module>();
        }
        return this.enrolledModules;
    }

}
