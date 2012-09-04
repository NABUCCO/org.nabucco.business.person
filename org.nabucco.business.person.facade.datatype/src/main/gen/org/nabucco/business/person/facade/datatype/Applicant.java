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
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Applicant
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-05-24
 */
public class Applicant extends PersonCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final PersonCharacteristicType CHARACTERISTICTYPE_DEFAULT = PersonCharacteristicType.APPLICANT;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,255;u0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    public static final String CREATEDDATE = "createdDate";

    public static final String POOL = "pool";

    public static final String AVAILABILITYDATE = "availabilityDate";

    public static final String UNEMPLOYEDSINCE = "unemployedSince";

    public static final String PREFERREDLOCATION = "preferredLocation";

    public static final String APPLICANTSTATUS = "applicantStatus";

    public static final String SOURCECHANNEL = "sourceChannel";

    public static final String SOURCECHANNELTYPE = "sourceChannelType";

    /** Date of creating of applicant in system */
    private Date createdDate;

    /** The applicant should be saved in pool */
    private Flag pool;

    private Date availabilityDate;

    private Date unemployedSince;

    private Name preferredLocation;

    private Code applicantStatus;

    private Long applicantStatusRefId;

    protected static final String APPLICANTSTATUS_CODEPATH = "nabucco.business.person.applicant.status";

    private Code sourceChannel;

    private Long sourceChannelRefId;

    protected static final String SOURCECHANNEL_CODEPATH = "nabucco.business.person.applicant.sourcechannel";

    private Code sourceChannelType;

    private Long sourceChannelTypeRefId;

    protected static final String SOURCECHANNELTYPE_CODEPATH = "nabucco.business.person.applicant.sourcechanneltype";

    /** Constructs a new Applicant instance. */
    public Applicant() {
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
     * @param clone the Applicant.
     */
    protected void cloneObject(Applicant clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getCreatedDate() != null)) {
            clone.setCreatedDate(this.getCreatedDate().cloneObject());
        }
        if ((this.getPool() != null)) {
            clone.setPool(this.getPool().cloneObject());
        }
        if ((this.getAvailabilityDate() != null)) {
            clone.setAvailabilityDate(this.getAvailabilityDate().cloneObject());
        }
        if ((this.getUnemployedSince() != null)) {
            clone.setUnemployedSince(this.getUnemployedSince().cloneObject());
        }
        if ((this.getPreferredLocation() != null)) {
            clone.setPreferredLocation(this.getPreferredLocation().cloneObject());
        }
        if ((this.getApplicantStatus() != null)) {
            clone.setApplicantStatus(this.getApplicantStatus().cloneObject());
        }
        if ((this.getApplicantStatusRefId() != null)) {
            clone.setApplicantStatusRefId(this.getApplicantStatusRefId());
        }
        if ((this.getSourceChannel() != null)) {
            clone.setSourceChannel(this.getSourceChannel().cloneObject());
        }
        if ((this.getSourceChannelRefId() != null)) {
            clone.setSourceChannelRefId(this.getSourceChannelRefId());
        }
        if ((this.getSourceChannelType() != null)) {
            clone.setSourceChannelType(this.getSourceChannelType().cloneObject());
        }
        if ((this.getSourceChannelTypeRefId() != null)) {
            clone.setSourceChannelTypeRefId(this.getSourceChannelTypeRefId());
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
        propertyMap.put(CREATEDDATE,
                PropertyDescriptorSupport.createBasetype(CREATEDDATE, Date.class, 6, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(POOL,
                PropertyDescriptorSupport.createBasetype(POOL, Flag.class, 7, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(AVAILABILITYDATE, PropertyDescriptorSupport.createBasetype(AVAILABILITYDATE, Date.class, 8,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(UNEMPLOYEDSINCE, PropertyDescriptorSupport.createBasetype(UNEMPLOYEDSINCE, Date.class, 9,
                PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(PREFERREDLOCATION, PropertyDescriptorSupport.createBasetype(PREFERREDLOCATION, Name.class, 10,
                PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(APPLICANTSTATUS, PropertyDescriptorSupport.createDatatype(APPLICANTSTATUS, Code.class, 11,
                PROPERTY_CONSTRAINTS[5], false, PropertyAssociationType.COMPONENT, APPLICANTSTATUS_CODEPATH));
        propertyMap.put(SOURCECHANNEL, PropertyDescriptorSupport.createDatatype(SOURCECHANNEL, Code.class, 12,
                PROPERTY_CONSTRAINTS[6], false, PropertyAssociationType.COMPONENT, SOURCECHANNEL_CODEPATH));
        propertyMap.put(SOURCECHANNELTYPE, PropertyDescriptorSupport.createDatatype(SOURCECHANNELTYPE, Code.class, 13,
                PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPONENT, SOURCECHANNELTYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(CREATEDDATE), this.createdDate, null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(POOL), this.pool, null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(AVAILABILITYDATE), this.availabilityDate,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(UNEMPLOYEDSINCE), this.unemployedSince,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PREFERREDLOCATION), this.preferredLocation,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(APPLICANTSTATUS),
                this.getApplicantStatus(), this.applicantStatusRefId));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(SOURCECHANNEL), this.getSourceChannel(),
                this.sourceChannelRefId));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(SOURCECHANNELTYPE),
                this.getSourceChannelType(), this.sourceChannelTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CREATEDDATE) && (property.getType() == Date.class))) {
            this.setCreatedDate(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(POOL) && (property.getType() == Flag.class))) {
            this.setPool(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(AVAILABILITYDATE) && (property.getType() == Date.class))) {
            this.setAvailabilityDate(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(UNEMPLOYEDSINCE) && (property.getType() == Date.class))) {
            this.setUnemployedSince(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFERREDLOCATION) && (property.getType() == Name.class))) {
            this.setPreferredLocation(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(APPLICANTSTATUS) && (property.getType() == Code.class))) {
            this.setApplicantStatus(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SOURCECHANNEL) && (property.getType() == Code.class))) {
            this.setSourceChannel(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SOURCECHANNELTYPE) && (property.getType() == Code.class))) {
            this.setSourceChannelType(((Code) property.getInstance()));
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
        final Applicant other = ((Applicant) obj);
        if ((this.createdDate == null)) {
            if ((other.createdDate != null))
                return false;
        } else if ((!this.createdDate.equals(other.createdDate)))
            return false;
        if ((this.pool == null)) {
            if ((other.pool != null))
                return false;
        } else if ((!this.pool.equals(other.pool)))
            return false;
        if ((this.availabilityDate == null)) {
            if ((other.availabilityDate != null))
                return false;
        } else if ((!this.availabilityDate.equals(other.availabilityDate)))
            return false;
        if ((this.unemployedSince == null)) {
            if ((other.unemployedSince != null))
                return false;
        } else if ((!this.unemployedSince.equals(other.unemployedSince)))
            return false;
        if ((this.preferredLocation == null)) {
            if ((other.preferredLocation != null))
                return false;
        } else if ((!this.preferredLocation.equals(other.preferredLocation)))
            return false;
        if ((this.applicantStatus == null)) {
            if ((other.applicantStatus != null))
                return false;
        } else if ((!this.applicantStatus.equals(other.applicantStatus)))
            return false;
        if ((this.applicantStatusRefId == null)) {
            if ((other.applicantStatusRefId != null))
                return false;
        } else if ((!this.applicantStatusRefId.equals(other.applicantStatusRefId)))
            return false;
        if ((this.sourceChannel == null)) {
            if ((other.sourceChannel != null))
                return false;
        } else if ((!this.sourceChannel.equals(other.sourceChannel)))
            return false;
        if ((this.sourceChannelRefId == null)) {
            if ((other.sourceChannelRefId != null))
                return false;
        } else if ((!this.sourceChannelRefId.equals(other.sourceChannelRefId)))
            return false;
        if ((this.sourceChannelType == null)) {
            if ((other.sourceChannelType != null))
                return false;
        } else if ((!this.sourceChannelType.equals(other.sourceChannelType)))
            return false;
        if ((this.sourceChannelTypeRefId == null)) {
            if ((other.sourceChannelTypeRefId != null))
                return false;
        } else if ((!this.sourceChannelTypeRefId.equals(other.sourceChannelTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.createdDate == null) ? 0 : this.createdDate.hashCode()));
        result = ((PRIME * result) + ((this.pool == null) ? 0 : this.pool.hashCode()));
        result = ((PRIME * result) + ((this.availabilityDate == null) ? 0 : this.availabilityDate.hashCode()));
        result = ((PRIME * result) + ((this.unemployedSince == null) ? 0 : this.unemployedSince.hashCode()));
        result = ((PRIME * result) + ((this.preferredLocation == null) ? 0 : this.preferredLocation.hashCode()));
        result = ((PRIME * result) + ((this.applicantStatus == null) ? 0 : this.applicantStatus.hashCode()));
        result = ((PRIME * result) + ((this.applicantStatusRefId == null) ? 0 : this.applicantStatusRefId.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannel == null) ? 0 : this.sourceChannel.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannelRefId == null) ? 0 : this.sourceChannelRefId.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannelType == null) ? 0 : this.sourceChannelType.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannelTypeRefId == null) ? 0 : this.sourceChannelTypeRefId
                .hashCode()));
        return result;
    }

    @Override
    public Applicant cloneObject() {
        Applicant clone = new Applicant();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Date of creating of applicant in system
     *
     * @return the Date.
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Date of creating of applicant in system
     *
     * @param createdDate the Date.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Date of creating of applicant in system
     *
     * @param createdDate the java.util.Date.
     */
    public void setCreatedDate(java.util.Date createdDate) {
        if ((this.createdDate == null)) {
            if ((createdDate == null)) {
                return;
            }
            this.createdDate = new Date();
        }
        this.createdDate.setValue(createdDate);
    }

    /**
     * The applicant should be saved in pool
     *
     * @return the Flag.
     */
    public Flag getPool() {
        return this.pool;
    }

    /**
     * The applicant should be saved in pool
     *
     * @param pool the Flag.
     */
    public void setPool(Flag pool) {
        this.pool = pool;
    }

    /**
     * The applicant should be saved in pool
     *
     * @param pool the Boolean.
     */
    public void setPool(Boolean pool) {
        if ((this.pool == null)) {
            if ((pool == null)) {
                return;
            }
            this.pool = new Flag();
        }
        this.pool.setValue(pool);
    }

    /**
     * Missing description at method getAvailabilityDate.
     *
     * @return the Date.
     */
    public Date getAvailabilityDate() {
        return this.availabilityDate;
    }

    /**
     * Missing description at method setAvailabilityDate.
     *
     * @param availabilityDate the Date.
     */
    public void setAvailabilityDate(Date availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    /**
     * Missing description at method setAvailabilityDate.
     *
     * @param availabilityDate the java.util.Date.
     */
    public void setAvailabilityDate(java.util.Date availabilityDate) {
        if ((this.availabilityDate == null)) {
            if ((availabilityDate == null)) {
                return;
            }
            this.availabilityDate = new Date();
        }
        this.availabilityDate.setValue(availabilityDate);
    }

    /**
     * Missing description at method getUnemployedSince.
     *
     * @return the Date.
     */
    public Date getUnemployedSince() {
        return this.unemployedSince;
    }

    /**
     * Missing description at method setUnemployedSince.
     *
     * @param unemployedSince the Date.
     */
    public void setUnemployedSince(Date unemployedSince) {
        this.unemployedSince = unemployedSince;
    }

    /**
     * Missing description at method setUnemployedSince.
     *
     * @param unemployedSince the java.util.Date.
     */
    public void setUnemployedSince(java.util.Date unemployedSince) {
        if ((this.unemployedSince == null)) {
            if ((unemployedSince == null)) {
                return;
            }
            this.unemployedSince = new Date();
        }
        this.unemployedSince.setValue(unemployedSince);
    }

    /**
     * Missing description at method getPreferredLocation.
     *
     * @return the Name.
     */
    public Name getPreferredLocation() {
        return this.preferredLocation;
    }

    /**
     * Missing description at method setPreferredLocation.
     *
     * @param preferredLocation the Name.
     */
    public void setPreferredLocation(Name preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    /**
     * Missing description at method setPreferredLocation.
     *
     * @param preferredLocation the String.
     */
    public void setPreferredLocation(String preferredLocation) {
        if ((this.preferredLocation == null)) {
            if ((preferredLocation == null)) {
                return;
            }
            this.preferredLocation = new Name();
        }
        this.preferredLocation.setValue(preferredLocation);
    }

    /**
     * Missing description at method setApplicantStatus.
     *
     * @param applicantStatus the Code.
     */
    public void setApplicantStatus(Code applicantStatus) {
        this.applicantStatus = applicantStatus;
        if ((applicantStatus != null)) {
            this.setApplicantStatusRefId(applicantStatus.getId());
        } else {
            this.setApplicantStatusRefId(null);
        }
    }

    /**
     * Missing description at method getApplicantStatus.
     *
     * @return the Code.
     */
    public Code getApplicantStatus() {
        return this.applicantStatus;
    }

    /**
     * Getter for the ApplicantStatusRefId.
     *
     * @return the Long.
     */
    public Long getApplicantStatusRefId() {
        return this.applicantStatusRefId;
    }

    /**
     * Setter for the ApplicantStatusRefId.
     *
     * @param applicantStatusRefId the Long.
     */
    public void setApplicantStatusRefId(Long applicantStatusRefId) {
        this.applicantStatusRefId = applicantStatusRefId;
    }

    /**
     * Missing description at method setSourceChannel.
     *
     * @param sourceChannel the Code.
     */
    public void setSourceChannel(Code sourceChannel) {
        this.sourceChannel = sourceChannel;
        if ((sourceChannel != null)) {
            this.setSourceChannelRefId(sourceChannel.getId());
        } else {
            this.setSourceChannelRefId(null);
        }
    }

    /**
     * Missing description at method getSourceChannel.
     *
     * @return the Code.
     */
    public Code getSourceChannel() {
        return this.sourceChannel;
    }

    /**
     * Getter for the SourceChannelRefId.
     *
     * @return the Long.
     */
    public Long getSourceChannelRefId() {
        return this.sourceChannelRefId;
    }

    /**
     * Setter for the SourceChannelRefId.
     *
     * @param sourceChannelRefId the Long.
     */
    public void setSourceChannelRefId(Long sourceChannelRefId) {
        this.sourceChannelRefId = sourceChannelRefId;
    }

    /**
     * Missing description at method setSourceChannelType.
     *
     * @param sourceChannelType the Code.
     */
    public void setSourceChannelType(Code sourceChannelType) {
        this.sourceChannelType = sourceChannelType;
        if ((sourceChannelType != null)) {
            this.setSourceChannelTypeRefId(sourceChannelType.getId());
        } else {
            this.setSourceChannelTypeRefId(null);
        }
    }

    /**
     * Missing description at method getSourceChannelType.
     *
     * @return the Code.
     */
    public Code getSourceChannelType() {
        return this.sourceChannelType;
    }

    /**
     * Getter for the SourceChannelTypeRefId.
     *
     * @return the Long.
     */
    public Long getSourceChannelTypeRefId() {
        return this.sourceChannelTypeRefId;
    }

    /**
     * Setter for the SourceChannelTypeRefId.
     *
     * @param sourceChannelTypeRefId the Long.
     */
    public void setSourceChannelTypeRefId(Long sourceChannelTypeRefId) {
        this.sourceChannelTypeRefId = sourceChannelTypeRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Applicant.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Applicant.class).getAllProperties();
    }

    /**
     * Getter for the ApplicantStatusCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getApplicantStatusCodePath() {
        return new CodePath(APPLICANTSTATUS_CODEPATH);
    }

    /**
     * Getter for the SourceChannelCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSourceChannelCodePath() {
        return new CodePath(SOURCECHANNEL_CODEPATH);
    }

    /**
     * Getter for the SourceChannelTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSourceChannelTypeCodePath() {
        return new CodePath(SOURCECHANNELTYPE_CODEPATH);
    }
}
