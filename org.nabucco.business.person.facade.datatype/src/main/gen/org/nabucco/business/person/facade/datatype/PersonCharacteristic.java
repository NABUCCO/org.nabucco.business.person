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
import org.nabucco.business.person.facade.datatype.PersonCharacteristicType;
import org.nabucco.business.person.facade.datatype.PersonMaster;
import org.nabucco.business.person.facade.datatype.PersonRelation;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * PersonCharacteristic
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public abstract class PersonCharacteristic extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m0,n;" };

    public static final String CHARACTERISTICTYPE = "characteristicType";

    public static final String MASTER = "master";

    public static final String RELATIONLIST = "relationList";

    protected PersonCharacteristicType characteristicType;

    private PersonMaster master;

    private NabuccoList<PersonRelation> relationList;

    /** Constructs a new PersonCharacteristic instance. */
    public PersonCharacteristic() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PersonCharacteristic.
     */
    protected void cloneObject(PersonCharacteristic clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getMaster() != null)) {
            clone.setMaster(this.getMaster().cloneObject());
        }
        if ((this.relationList != null)) {
            clone.relationList = this.relationList.cloneCollection();
        }
    }

    /**
     * Getter for the RelationListJPA.
     *
     * @return the List<PersonRelation>.
     */
    List<PersonRelation> getRelationListJPA() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<PersonRelation>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<PersonRelation>) this.relationList).getDelegate();
    }

    /**
     * Setter for the RelationListJPA.
     *
     * @param relationList the List<PersonRelation>.
     */
    void setRelationListJPA(List<PersonRelation> relationList) {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<PersonRelation>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<PersonRelation>) this.relationList).setDelegate(relationList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(CHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(CHARACTERISTICTYPE,
                PersonCharacteristicType.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(MASTER, PropertyDescriptorSupport.createDatatype(MASTER, PersonMaster.class, 4,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.AGGREGATION));
        propertyMap.put(RELATIONLIST, PropertyDescriptorSupport.createCollection(RELATIONLIST, PersonRelation.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PersonCharacteristic.getPropertyDescriptor(CHARACTERISTICTYPE),
                this.getCharacteristicType(), null));
        properties
                .add(super.createProperty(PersonCharacteristic.getPropertyDescriptor(MASTER), this.getMaster(), null));
        properties.add(super.createProperty(PersonCharacteristic.getPropertyDescriptor(RELATIONLIST),
                this.relationList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CHARACTERISTICTYPE) && (property.getType() == PersonCharacteristicType.class))) {
            this.setCharacteristicType(((PersonCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MASTER) && (property.getType() == PersonMaster.class))) {
            this.setMaster(((PersonMaster) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELATIONLIST) && (property.getType() == PersonRelation.class))) {
            this.relationList = ((NabuccoList<PersonRelation>) property.getInstance());
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
        final PersonCharacteristic other = ((PersonCharacteristic) obj);
        if ((this.characteristicType == null)) {
            if ((other.characteristicType != null))
                return false;
        } else if ((!this.characteristicType.equals(other.characteristicType)))
            return false;
        if ((this.master == null)) {
            if ((other.master != null))
                return false;
        } else if ((!this.master.equals(other.master)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.characteristicType == null) ? 0 : this.characteristicType.hashCode()));
        result = ((PRIME * result) + ((this.master == null) ? 0 : this.master.hashCode()));
        return result;
    }

    @Override
    public abstract PersonCharacteristic cloneObject();

    /**
     * Missing description at method getCharacteristicType.
     *
     * @return the PersonCharacteristicType.
     */
    public PersonCharacteristicType getCharacteristicType() {
        return this.characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the PersonCharacteristicType.
     */
    public void setCharacteristicType(PersonCharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the String.
     */
    public void setCharacteristicType(String characteristicType) {
        if ((characteristicType == null)) {
            this.characteristicType = null;
        } else {
            this.characteristicType = PersonCharacteristicType.valueOf(characteristicType);
        }
    }

    /**
     * Missing description at method setMaster.
     *
     * @param master the PersonMaster.
     */
    public void setMaster(PersonMaster master) {
        this.master = master;
    }

    /**
     * Missing description at method getMaster.
     *
     * @return the PersonMaster.
     */
    public PersonMaster getMaster() {
        return this.master;
    }

    /**
     * Missing description at method getRelationList.
     *
     * @return the NabuccoList<PersonRelation>.
     */
    public NabuccoList<PersonRelation> getRelationList() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<PersonRelation>(NabuccoCollectionState.INITIALIZED);
        }
        return this.relationList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PersonCharacteristic.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PersonCharacteristic.class).getAllProperties();
    }
}
