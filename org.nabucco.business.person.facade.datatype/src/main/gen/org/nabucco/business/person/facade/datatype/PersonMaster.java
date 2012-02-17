/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.person.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.business.person.Person;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;

/**
 * PersonMaster
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class PersonMaster extends Person implements Datatype {

    private static final long serialVersionUID = 1L;

    private Long nationalityRefId;

    private Long birthcountryRefId;

    private Long religionRefId;

    private Long functionalTypeRefId;

    /** Constructs a new PersonMaster instance. */
    public PersonMaster() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PersonMaster.
     */
    protected void cloneObject(PersonMaster clone) {
        super.cloneObject(clone);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Person.class).getPropertyMap());
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PersonMaster.getPropertyDescriptor(NATIONALITY), this.getNationality(),
                this.nationalityRefId));
        properties.add(super.createProperty(PersonMaster.getPropertyDescriptor(BIRTHCOUNTRY), this.getBirthcountry(),
                this.birthcountryRefId));
        properties.add(super.createProperty(PersonMaster.getPropertyDescriptor(RELIGION), this.getReligion(),
                this.religionRefId));
        properties.add(super.createProperty(PersonMaster.getPropertyDescriptor(FUNCTIONALTYPE),
                this.getFunctionalType(), this.functionalTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
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
        final PersonMaster other = ((PersonMaster) obj);
        if ((this.nationalityRefId == null)) {
            if ((other.nationalityRefId != null))
                return false;
        } else if ((!this.nationalityRefId.equals(other.nationalityRefId)))
            return false;
        if ((this.birthcountryRefId == null)) {
            if ((other.birthcountryRefId != null))
                return false;
        } else if ((!this.birthcountryRefId.equals(other.birthcountryRefId)))
            return false;
        if ((this.religionRefId == null)) {
            if ((other.religionRefId != null))
                return false;
        } else if ((!this.religionRefId.equals(other.religionRefId)))
            return false;
        if ((this.functionalTypeRefId == null)) {
            if ((other.functionalTypeRefId != null))
                return false;
        } else if ((!this.functionalTypeRefId.equals(other.functionalTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.nationalityRefId == null) ? 0 : this.nationalityRefId.hashCode()));
        result = ((PRIME * result) + ((this.birthcountryRefId == null) ? 0 : this.birthcountryRefId.hashCode()));
        result = ((PRIME * result) + ((this.religionRefId == null) ? 0 : this.religionRefId.hashCode()));
        result = ((PRIME * result) + ((this.functionalTypeRefId == null) ? 0 : this.functionalTypeRefId.hashCode()));
        return result;
    }

    @Override
    public PersonMaster cloneObject() {
        PersonMaster clone = new PersonMaster();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Getter for the NationalityRefId.
     *
     * @return the Long.
     */
    public Long getNationalityRefId() {
        return this.nationalityRefId;
    }

    /**
     * Setter for the NationalityRefId.
     *
     * @param nationalityRefId the Long.
     */
    public void setNationalityRefId(Long nationalityRefId) {
        this.nationalityRefId = nationalityRefId;
    }

    /**
     * Setter for the Nationality.
     *
     * @param nationality the Code.
     */
    public void setNationality(Code nationality) {
        super.setNationality(nationality);
        if ((nationality != null)) {
            this.setNationalityRefId(nationality.getId());
        } else {
            this.setNationalityRefId(null);
        }
    }

    /**
     * Getter for the BirthcountryRefId.
     *
     * @return the Long.
     */
    public Long getBirthcountryRefId() {
        return this.birthcountryRefId;
    }

    /**
     * Setter for the BirthcountryRefId.
     *
     * @param birthcountryRefId the Long.
     */
    public void setBirthcountryRefId(Long birthcountryRefId) {
        this.birthcountryRefId = birthcountryRefId;
    }

    /**
     * Setter for the Birthcountry.
     *
     * @param birthcountry the Code.
     */
    public void setBirthcountry(Code birthcountry) {
        super.setBirthcountry(birthcountry);
        if ((birthcountry != null)) {
            this.setBirthcountryRefId(birthcountry.getId());
        } else {
            this.setBirthcountryRefId(null);
        }
    }

    /**
     * Getter for the ReligionRefId.
     *
     * @return the Long.
     */
    public Long getReligionRefId() {
        return this.religionRefId;
    }

    /**
     * Setter for the ReligionRefId.
     *
     * @param religionRefId the Long.
     */
    public void setReligionRefId(Long religionRefId) {
        this.religionRefId = religionRefId;
    }

    /**
     * Setter for the Religion.
     *
     * @param religion the Code.
     */
    public void setReligion(Code religion) {
        super.setReligion(religion);
        if ((religion != null)) {
            this.setReligionRefId(religion.getId());
        } else {
            this.setReligionRefId(null);
        }
    }

    /**
     * Getter for the FunctionalTypeRefId.
     *
     * @return the Long.
     */
    public Long getFunctionalTypeRefId() {
        return this.functionalTypeRefId;
    }

    /**
     * Setter for the FunctionalTypeRefId.
     *
     * @param functionalTypeRefId the Long.
     */
    public void setFunctionalTypeRefId(Long functionalTypeRefId) {
        this.functionalTypeRefId = functionalTypeRefId;
    }

    /**
     * Setter for the FunctionalType.
     *
     * @param functionalType the Code.
     */
    public void setFunctionalType(Code functionalType) {
        super.setFunctionalType(functionalType);
        if ((functionalType != null)) {
            this.setFunctionalTypeRefId(functionalType.getId());
        } else {
            this.setFunctionalTypeRefId(null);
        }
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PersonMaster.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PersonMaster.class).getAllProperties();
    }
}
