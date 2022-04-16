
package staffpackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for academicStaffMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="academicStaffMember">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taughtMcs" type="{http://staffPackage/}moduleCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taughtModules" type="{http://staffPackage/}module" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "academicStaffMember", propOrder = {
    "id",
    "taughtMcs",
    "taughtModules"
})
public class AcademicStaffMember {

    protected int id;
    @XmlElement(nillable = true)
    protected List<ModuleCode> taughtMcs;
    @XmlElement(nillable = true)
    protected List<Module> taughtModules;

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
     * Gets the value of the taughtMcs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taughtMcs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaughtMcs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleCode }
     * 
     * 
     */
    public List<ModuleCode> getTaughtMcs() {
        if (taughtMcs == null) {
            taughtMcs = new ArrayList<ModuleCode>();
        }
        return this.taughtMcs;
    }

    /**
     * Gets the value of the taughtModules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taughtModules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaughtModules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Module }
     * 
     * 
     */
    public List<Module> getTaughtModules() {
        if (taughtModules == null) {
            taughtModules = new ArrayList<Module>();
        }
        return this.taughtModules;
    }

}
