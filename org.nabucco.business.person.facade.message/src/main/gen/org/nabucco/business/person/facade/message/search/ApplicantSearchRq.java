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
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ApplicantSearchRq<p/>Search message for Applicant<p/>
 *
 * @version 1.2
 * @author Raffael Bieniek, Holger Librenz, PRODYNA AG, 2011-07-19
 */
public class ApplicantSearchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l3,12;u0,n;m0,1;",
            "l3,12;u0,n;m0,n;", "l3,32;u0,n;m0,n;" };

    public static final String ID = "id";

    public static final String MASTERID = "masterId";

    public static final String OWNER = "owner";

    public static final String OWNERLIST = "ownerList";

    public static final String USERIDLIST = "userIdList";

    private Identifier id;

    private Identifier masterId;

    /** Branch */
    private Owner owner;

    /** Region mapped to Branch */
    private NabuccoList<Owner> ownerList;

    /** CostUnit mapped to userId */
    private NabuccoList<UserId> userIdList;

    /** Constructs a new ApplicantSearchRq instance. */
    public ApplicantSearchRq() {
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
        propertyMap.put(ID,
                PropertyDescriptorSupport.createBasetype(ID, Identifier.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap
                .put(MASTERID, PropertyDescriptorSupport.createBasetype(MASTERID, Identifier.class, 1,
                        PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(OWNER,
                PropertyDescriptorSupport.createBasetype(OWNER, Owner.class, 2, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(OWNERLIST, PropertyDescriptorSupport.createCollection(OWNERLIST, Owner.class, 3,
                PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(USERIDLIST, PropertyDescriptorSupport.createCollection(USERIDLIST, UserId.class, 4,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ApplicantSearchRq.getPropertyDescriptor(ID), this.id));
        properties.add(super.createProperty(ApplicantSearchRq.getPropertyDescriptor(MASTERID), this.masterId));
        properties.add(super.createProperty(ApplicantSearchRq.getPropertyDescriptor(OWNER), this.owner));
        properties.add(super.createProperty(ApplicantSearchRq.getPropertyDescriptor(OWNERLIST), this.ownerList));
        properties.add(super.createProperty(ApplicantSearchRq.getPropertyDescriptor(USERIDLIST), this.userIdList));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ID) && (property.getType() == Identifier.class))) {
            this.setId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MASTERID) && (property.getType() == Identifier.class))) {
            this.setMasterId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(OWNER) && (property.getType() == Owner.class))) {
            this.setOwner(((Owner) property.getInstance()));
            return true;
        } else if ((property.getName().equals(OWNERLIST) && (property.getType() == Owner.class))) {
            this.ownerList = ((NabuccoList<Owner>) property.getInstance());
            return true;
        } else if ((property.getName().equals(USERIDLIST) && (property.getType() == UserId.class))) {
            this.userIdList = ((NabuccoList<UserId>) property.getInstance());
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
        final ApplicantSearchRq other = ((ApplicantSearchRq) obj);
        if ((this.id == null)) {
            if ((other.id != null))
                return false;
        } else if ((!this.id.equals(other.id)))
            return false;
        if ((this.masterId == null)) {
            if ((other.masterId != null))
                return false;
        } else if ((!this.masterId.equals(other.masterId)))
            return false;
        if ((this.owner == null)) {
            if ((other.owner != null))
                return false;
        } else if ((!this.owner.equals(other.owner)))
            return false;
        if ((this.ownerList == null)) {
            if ((other.ownerList != null))
                return false;
        } else if ((!this.ownerList.equals(other.ownerList)))
            return false;
        if ((this.userIdList == null)) {
            if ((other.userIdList != null))
                return false;
        } else if ((!this.userIdList.equals(other.userIdList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((PRIME * result) + ((this.masterId == null) ? 0 : this.masterId.hashCode()));
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
        result = ((PRIME * result) + ((this.ownerList == null) ? 0 : this.ownerList.hashCode()));
        result = ((PRIME * result) + ((this.userIdList == null) ? 0 : this.userIdList.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getId.
     *
     * @return the Identifier.
     */
    public Identifier getId() {
        return this.id;
    }

    /**
     * Missing description at method setId.
     *
     * @param id the Identifier.
     */
    public void setId(Identifier id) {
        this.id = id;
    }

    /**
     * Missing description at method getMasterId.
     *
     * @return the Identifier.
     */
    public Identifier getMasterId() {
        return this.masterId;
    }

    /**
     * Missing description at method setMasterId.
     *
     * @param masterId the Identifier.
     */
    public void setMasterId(Identifier masterId) {
        this.masterId = masterId;
    }

    /**
     * Branch
     *
     * @return the Owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * Branch
     *
     * @param owner the Owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Region mapped to Branch
     *
     * @return the NabuccoList<Owner>.
     */
    public NabuccoList<Owner> getOwnerList() {
        if ((this.ownerList == null)) {
            this.ownerList = new NabuccoListImpl<Owner>(NabuccoCollectionState.INITIALIZED);
        }
        return this.ownerList;
    }

    /**
     * CostUnit mapped to userId
     *
     * @return the NabuccoList<UserId>.
     */
    public NabuccoList<UserId> getUserIdList() {
        if ((this.userIdList == null)) {
            this.userIdList = new NabuccoListImpl<UserId>(NabuccoCollectionState.INITIALIZED);
        }
        return this.userIdList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ApplicantSearchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ApplicantSearchRq.class).getAllProperties();
    }
}
