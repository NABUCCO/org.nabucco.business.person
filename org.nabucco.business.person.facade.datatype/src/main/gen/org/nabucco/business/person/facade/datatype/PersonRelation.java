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
import org.nabucco.business.person.facade.datatype.PersonCharacteristic;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.relation.RelationType;

/**
 * PersonRelation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class PersonRelation extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m1,1;" };

    public static final String RELATIONTYPE = "relationType";

    public static final String FUNCTIONALTYPE = "functionalType";

    public static final String CHARACTERISTIC = "characteristic";

    private RelationType relationType;

    private Code functionalType;

    private Long functionalTypeRefId;

    protected static final String FUNCTIONALTYPE_CODEPATH = "nabucco.business.person.relationtype";

    private PersonCharacteristic characteristic;

    /** Constructs a new PersonRelation instance. */
    public PersonRelation() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PersonRelation.
     */
    protected void cloneObject(PersonRelation clone) {
        super.cloneObject(clone);
        clone.setRelationType(this.getRelationType());
        if ((this.getFunctionalType() != null)) {
            clone.setFunctionalType(this.getFunctionalType().cloneObject());
        }
        if ((this.getFunctionalTypeRefId() != null)) {
            clone.setFunctionalTypeRefId(this.getFunctionalTypeRefId());
        }
        if ((this.getCharacteristic() != null)) {
            clone.setCharacteristic(this.getCharacteristic().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(RELATIONTYPE, PropertyDescriptorSupport.createEnumeration(RELATIONTYPE, RelationType.class, 3,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(FUNCTIONALTYPE, PropertyDescriptorSupport.createDatatype(FUNCTIONALTYPE, Code.class, 4,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, FUNCTIONALTYPE_CODEPATH));
        propertyMap.put(CHARACTERISTIC, PropertyDescriptorSupport.createDatatype(CHARACTERISTIC,
                PersonCharacteristic.class, 5, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.AGGREGATION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PersonRelation.getPropertyDescriptor(RELATIONTYPE), this.getRelationType(),
                null));
        properties.add(super.createProperty(PersonRelation.getPropertyDescriptor(FUNCTIONALTYPE),
                this.getFunctionalType(), this.functionalTypeRefId));
        properties.add(super.createProperty(PersonRelation.getPropertyDescriptor(CHARACTERISTIC),
                this.getCharacteristic(), null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(RELATIONTYPE) && (property.getType() == RelationType.class))) {
            this.setRelationType(((RelationType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FUNCTIONALTYPE) && (property.getType() == Code.class))) {
            this.setFunctionalType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CHARACTERISTIC) && (property.getType() == PersonCharacteristic.class))) {
            this.setCharacteristic(((PersonCharacteristic) property.getInstance()));
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
        final PersonRelation other = ((PersonRelation) obj);
        if ((this.relationType == null)) {
            if ((other.relationType != null))
                return false;
        } else if ((!this.relationType.equals(other.relationType)))
            return false;
        if ((this.functionalType == null)) {
            if ((other.functionalType != null))
                return false;
        } else if ((!this.functionalType.equals(other.functionalType)))
            return false;
        if ((this.functionalTypeRefId == null)) {
            if ((other.functionalTypeRefId != null))
                return false;
        } else if ((!this.functionalTypeRefId.equals(other.functionalTypeRefId)))
            return false;
        if ((this.characteristic == null)) {
            if ((other.characteristic != null))
                return false;
        } else if ((!this.characteristic.equals(other.characteristic)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.relationType == null) ? 0 : this.relationType.hashCode()));
        result = ((PRIME * result) + ((this.functionalType == null) ? 0 : this.functionalType.hashCode()));
        result = ((PRIME * result) + ((this.functionalTypeRefId == null) ? 0 : this.functionalTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.characteristic == null) ? 0 : this.characteristic.hashCode()));
        return result;
    }

    @Override
    public PersonRelation cloneObject() {
        PersonRelation clone = new PersonRelation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getRelationType.
     *
     * @return the RelationType.
     */
    public RelationType getRelationType() {
        return this.relationType;
    }

    /**
     * Missing description at method setRelationType.
     *
     * @param relationType the RelationType.
     */
    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    /**
     * Missing description at method setRelationType.
     *
     * @param relationType the String.
     */
    public void setRelationType(String relationType) {
        if ((relationType == null)) {
            this.relationType = null;
        } else {
            this.relationType = RelationType.valueOf(relationType);
        }
    }

    /**
     * Missing description at method setFunctionalType.
     *
     * @param functionalType the Code.
     */
    public void setFunctionalType(Code functionalType) {
        this.functionalType = functionalType;
        if ((functionalType != null)) {
            this.setFunctionalTypeRefId(functionalType.getId());
        } else {
            this.setFunctionalTypeRefId(null);
        }
    }

    /**
     * Missing description at method getFunctionalType.
     *
     * @return the Code.
     */
    public Code getFunctionalType() {
        return this.functionalType;
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
     * Missing description at method setCharacteristic.
     *
     * @param characteristic the PersonCharacteristic.
     */
    public void setCharacteristic(PersonCharacteristic characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * Missing description at method getCharacteristic.
     *
     * @return the PersonCharacteristic.
     */
    public PersonCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PersonRelation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PersonRelation.class).getAllProperties();
    }

    /**
     * Getter for the FunctionalTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getFunctionalTypeCodePath() {
        return new CodePath(FUNCTIONALTYPE_CODEPATH);
    }
}
