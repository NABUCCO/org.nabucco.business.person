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
package org.nabucco.business.person.facade.message.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ContactPersonSearchRq<p/>Search message for ContactPerson<p/>
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-06-07
 */
public class ContactPersonSearchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String BIRTHDAYFROM = "birthdayFrom";

    public static final String BIRTHDAYTILL = "birthdayTill";

    private Date birthdayFrom;

    private Date birthdayTill;

    /** Constructs a new ContactPersonSearchRq instance. */
    public ContactPersonSearchRq() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(BIRTHDAYFROM,
                PropertyDescriptorSupport.createBasetype(BIRTHDAYFROM, Date.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(BIRTHDAYTILL,
                PropertyDescriptorSupport.createBasetype(BIRTHDAYTILL, Date.class, 1, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ContactPersonSearchRq.getPropertyDescriptor(BIRTHDAYFROM),
                this.birthdayFrom));
        properties.add(super.createProperty(ContactPersonSearchRq.getPropertyDescriptor(BIRTHDAYTILL),
                this.birthdayTill));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(BIRTHDAYFROM) && (property.getType() == Date.class))) {
            this.setBirthdayFrom(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(BIRTHDAYTILL) && (property.getType() == Date.class))) {
            this.setBirthdayTill(((Date) property.getInstance()));
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
        final ContactPersonSearchRq other = ((ContactPersonSearchRq) obj);
        if ((this.birthdayFrom == null)) {
            if ((other.birthdayFrom != null))
                return false;
        } else if ((!this.birthdayFrom.equals(other.birthdayFrom)))
            return false;
        if ((this.birthdayTill == null)) {
            if ((other.birthdayTill != null))
                return false;
        } else if ((!this.birthdayTill.equals(other.birthdayTill)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.birthdayFrom == null) ? 0 : this.birthdayFrom.hashCode()));
        result = ((PRIME * result) + ((this.birthdayTill == null) ? 0 : this.birthdayTill.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getBirthdayFrom.
     *
     * @return the Date.
     */
    public Date getBirthdayFrom() {
        return this.birthdayFrom;
    }

    /**
     * Missing description at method setBirthdayFrom.
     *
     * @param birthdayFrom the Date.
     */
    public void setBirthdayFrom(Date birthdayFrom) {
        this.birthdayFrom = birthdayFrom;
    }

    /**
     * Missing description at method getBirthdayTill.
     *
     * @return the Date.
     */
    public Date getBirthdayTill() {
        return this.birthdayTill;
    }

    /**
     * Missing description at method setBirthdayTill.
     *
     * @param birthdayTill the Date.
     */
    public void setBirthdayTill(Date birthdayTill) {
        this.birthdayTill = birthdayTill;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ContactPersonSearchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ContactPersonSearchRq.class).getAllProperties();
    }
}
