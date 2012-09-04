/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.person.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.person.facade.datatype.PersonCharacteristic;
import org.nabucco.business.person.facade.datatype.PersonCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ContactPerson
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-06-07
 */
public class ContactPerson extends PersonCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final PersonCharacteristicType CHARACTERISTICTYPE_DEFAULT = PersonCharacteristicType.CONTACT_PERSON;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m0,1;", "l0,255;u0,n;m0,1;" };

    public static final String DEPARTMENTINFO = "departmentInfo";

    public static final String ROLEINFO = "roleInfo";

    private Name departmentInfo;

    private Name roleInfo;

    /** Constructs a new ContactPerson instance. */
    public ContactPerson() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        characteristicType = CHARACTERISTICTYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the ContactPerson.
     */
    protected void cloneObject(ContactPerson clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getDepartmentInfo() != null)) {
            clone.setDepartmentInfo(this.getDepartmentInfo().cloneObject());
        }
        if ((this.getRoleInfo() != null)) {
            clone.setRoleInfo(this.getRoleInfo().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(PersonCharacteristic.class).getPropertyMap());
        propertyMap
                .put(DEPARTMENTINFO, PropertyDescriptorSupport.createBasetype(DEPARTMENTINFO, Name.class, 6,
                        PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ROLEINFO,
                PropertyDescriptorSupport.createBasetype(ROLEINFO, Name.class, 7, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ContactPerson.getPropertyDescriptor(DEPARTMENTINFO), this.departmentInfo,
                null));
        properties.add(super.createProperty(ContactPerson.getPropertyDescriptor(ROLEINFO), this.roleInfo, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(DEPARTMENTINFO) && (property.getType() == Name.class))) {
            this.setDepartmentInfo(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ROLEINFO) && (property.getType() == Name.class))) {
            this.setRoleInfo(((Name) property.getInstance()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final ContactPerson other = ((ContactPerson) obj);
        if ((this.departmentInfo == null)) {
            if ((other.departmentInfo != null))
                return false;
        } else if ((!this.departmentInfo.equals(other.departmentInfo)))
            return false;
        if ((this.roleInfo == null)) {
            if ((other.roleInfo != null))
                return false;
        } else if ((!this.roleInfo.equals(other.roleInfo)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.departmentInfo == null) ? 0 : this.departmentInfo.hashCode()));
        result = ((PRIME * result) + ((this.roleInfo == null) ? 0 : this.roleInfo.hashCode()));
        return result;
    }

    @Override
    public ContactPerson cloneObject() {
        ContactPerson clone = new ContactPerson();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getDepartmentInfo.
     *
     * @return the Name.
     */
    public Name getDepartmentInfo() {
        return this.departmentInfo;
    }

    /**
     * Missing description at method setDepartmentInfo.
     *
     * @param departmentInfo the Name.
     */
    public void setDepartmentInfo(Name departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    /**
     * Missing description at method setDepartmentInfo.
     *
     * @param departmentInfo the String.
     */
    public void setDepartmentInfo(String departmentInfo) {
        if ((this.departmentInfo == null)) {
            if ((departmentInfo == null)) {
                return;
            }
            this.departmentInfo = new Name();
        }
        this.departmentInfo.setValue(departmentInfo);
    }

    /**
     * Missing description at method getRoleInfo.
     *
     * @return the Name.
     */
    public Name getRoleInfo() {
        return this.roleInfo;
    }

    /**
     * Missing description at method setRoleInfo.
     *
     * @param roleInfo the Name.
     */
    public void setRoleInfo(Name roleInfo) {
        this.roleInfo = roleInfo;
    }

    /**
     * Missing description at method setRoleInfo.
     *
     * @param roleInfo the String.
     */
    public void setRoleInfo(String roleInfo) {
        if ((this.roleInfo == null)) {
            if ((roleInfo == null)) {
                return;
            }
            this.roleInfo = new Name();
        }
        this.roleInfo.setValue(roleInfo);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ContactPerson.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ContactPerson.class).getAllProperties();
    }
}
