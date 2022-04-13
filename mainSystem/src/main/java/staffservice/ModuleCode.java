
package staffservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moduleCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="moduleCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CSC1022"/>
 *     &lt;enumeration value="CSC1023"/>
 *     &lt;enumeration value="CSC1024"/>
 *     &lt;enumeration value="CSC1025"/>
 *     &lt;enumeration value="CSC1026"/>
 *     &lt;enumeration value="CSC1027"/>
 *     &lt;enumeration value="CSC1028"/>
 *     &lt;enumeration value="CSC1029"/>
 *     &lt;enumeration value="CSC1030"/>
 *     &lt;enumeration value="CSC1031"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "moduleCode", namespace = "http://staffService/")
@XmlEnum
public enum ModuleCode {

    @XmlEnumValue("CSC1022")
    CSC_1022("CSC1022"),
    @XmlEnumValue("CSC1023")
    CSC_1023("CSC1023"),
    @XmlEnumValue("CSC1024")
    CSC_1024("CSC1024"),
    @XmlEnumValue("CSC1025")
    CSC_1025("CSC1025"),
    @XmlEnumValue("CSC1026")
    CSC_1026("CSC1026"),
    @XmlEnumValue("CSC1027")
    CSC_1027("CSC1027"),
    @XmlEnumValue("CSC1028")
    CSC_1028("CSC1028"),
    @XmlEnumValue("CSC1029")
    CSC_1029("CSC1029"),
    @XmlEnumValue("CSC1030")
    CSC_1030("CSC1030"),
    @XmlEnumValue("CSC1031")
    CSC_1031("CSC1031");
    private final String value;

    ModuleCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ModuleCode fromValue(String v) {
        for (ModuleCode c: ModuleCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
