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
import org.nabucco.business.person.facade.datatype.PersonCharacteristicType;
import org.nabucco.business.person.facade.datatype.SalaryTimeframe;
import org.nabucco.framework.base.facade.datatype.Amount;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.mail.Body;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m1,1;",
            "l0,n;u0,n;m1,1;", "l0,255;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "m0,1;", "l0,n;u0,n;m0,1;",
            "l0,4000;u0,n;m0,1;", "m0,1;", "m1,1;", "m0,1;", "m0,1;" };

    public static final String AVAILABILITYDATE = "availabilityDate";

    public static final String UNEMPLOYEDSINCE = "unemployedSince";

    public static final String PLACEMENTVOUCHER = "placementVoucher";

    public static final String EMPLOYED = "employed";

    public static final String PREFERREDLOCATION = "preferredLocation";

    public static final String PREFERREDWORKINGHOURS = "preferredWorkingHours";

    public static final String PREFERREDSALARYTIMEFRAME = "preferredSalaryTimeframe";

    public static final String PREFERREDSALARYAMOUNT = "preferredSalaryAmount";

    public static final String SOURCECHANNELADDITIONALS = "sourceChannelAdditionals";

    public static final String PREFERREDSALARYAMOUNTCURRENCY = "preferredSalaryAmountCurrency";

    public static final String APPLICANTSTATUS = "applicantStatus";

    public static final String CLASSIFICATION = "classification";

    public static final String SOURCECHANNEL = "sourceChannel";

    private Date availabilityDate;

    private Date unemployedSince;

    private Flag placementVoucher;

    private Flag employed;

    private Name preferredLocation;

    private Number preferredWorkingHours;

    private SalaryTimeframe preferredSalaryTimeframe;

    private Amount preferredSalaryAmount;

    private Body sourceChannelAdditionals;

    private Code preferredSalaryAmountCurrency;

    private Long preferredSalaryAmountCurrencyRefId;

    protected static final String PREFERREDSALARYAMOUNTCURRENCY_CODEPATH = "nabucco.framework.currency";

    private Code applicantStatus;

    private Long applicantStatusRefId;

    protected static final String APPLICANTSTATUS_CODEPATH = "nabucco.business.person.applicant.status";

    private Code classification;

    private Long classificationRefId;

    protected static final String CLASSIFICATION_CODEPATH = "nabucco.business.person.applicant.classification";

    private Code sourceChannel;

    private Long sourceChannelRefId;

    protected static final String SOURCECHANNEL_CODEPATH = "nabucco.business.person.applicant.sourcechannel";

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
        if ((this.getAvailabilityDate() != null)) {
            clone.setAvailabilityDate(this.getAvailabilityDate().cloneObject());
        }
        if ((this.getUnemployedSince() != null)) {
            clone.setUnemployedSince(this.getUnemployedSince().cloneObject());
        }
        if ((this.getPlacementVoucher() != null)) {
            clone.setPlacementVoucher(this.getPlacementVoucher().cloneObject());
        }
        if ((this.getEmployed() != null)) {
            clone.setEmployed(this.getEmployed().cloneObject());
        }
        if ((this.getPreferredLocation() != null)) {
            clone.setPreferredLocation(this.getPreferredLocation().cloneObject());
        }
        if ((this.getPreferredWorkingHours() != null)) {
            clone.setPreferredWorkingHours(this.getPreferredWorkingHours().cloneObject());
        }
        clone.setPreferredSalaryTimeframe(this.getPreferredSalaryTimeframe());
        if ((this.getPreferredSalaryAmount() != null)) {
            clone.setPreferredSalaryAmount(this.getPreferredSalaryAmount().cloneObject());
        }
        if ((this.getSourceChannelAdditionals() != null)) {
            clone.setSourceChannelAdditionals(this.getSourceChannelAdditionals().cloneObject());
        }
        if ((this.getPreferredSalaryAmountCurrency() != null)) {
            clone.setPreferredSalaryAmountCurrency(this.getPreferredSalaryAmountCurrency().cloneObject());
        }
        if ((this.getPreferredSalaryAmountCurrencyRefId() != null)) {
            clone.setPreferredSalaryAmountCurrencyRefId(this.getPreferredSalaryAmountCurrencyRefId());
        }
        if ((this.getApplicantStatus() != null)) {
            clone.setApplicantStatus(this.getApplicantStatus().cloneObject());
        }
        if ((this.getApplicantStatusRefId() != null)) {
            clone.setApplicantStatusRefId(this.getApplicantStatusRefId());
        }
        if ((this.getClassification() != null)) {
            clone.setClassification(this.getClassification().cloneObject());
        }
        if ((this.getClassificationRefId() != null)) {
            clone.setClassificationRefId(this.getClassificationRefId());
        }
        if ((this.getSourceChannel() != null)) {
            clone.setSourceChannel(this.getSourceChannel().cloneObject());
        }
        if ((this.getSourceChannelRefId() != null)) {
            clone.setSourceChannelRefId(this.getSourceChannelRefId());
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
        propertyMap.put(AVAILABILITYDATE, PropertyDescriptorSupport.createBasetype(AVAILABILITYDATE, Date.class, 6,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(UNEMPLOYEDSINCE, PropertyDescriptorSupport.createBasetype(UNEMPLOYEDSINCE, Date.class, 7,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(PLACEMENTVOUCHER, PropertyDescriptorSupport.createBasetype(PLACEMENTVOUCHER, Flag.class, 8,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(EMPLOYED,
                PropertyDescriptorSupport.createBasetype(EMPLOYED, Flag.class, 9, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(PREFERREDLOCATION, PropertyDescriptorSupport.createBasetype(PREFERREDLOCATION, Name.class, 10,
                PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(PREFERREDWORKINGHOURS, PropertyDescriptorSupport.createBasetype(PREFERREDWORKINGHOURS,
                Number.class, 11, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(PREFERREDSALARYTIMEFRAME, PropertyDescriptorSupport.createEnumeration(PREFERREDSALARYTIMEFRAME,
                SalaryTimeframe.class, 12, PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(PREFERREDSALARYAMOUNT, PropertyDescriptorSupport.createBasetype(PREFERREDSALARYAMOUNT,
                Amount.class, 13, PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(SOURCECHANNELADDITIONALS, PropertyDescriptorSupport.createBasetype(SOURCECHANNELADDITIONALS,
                Body.class, 14, PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(PREFERREDSALARYAMOUNTCURRENCY, PropertyDescriptorSupport.createDatatype(
                PREFERREDSALARYAMOUNTCURRENCY, Code.class, 15, PROPERTY_CONSTRAINTS[9], false,
                PropertyAssociationType.COMPONENT, PREFERREDSALARYAMOUNTCURRENCY_CODEPATH));
        propertyMap.put(APPLICANTSTATUS, PropertyDescriptorSupport.createDatatype(APPLICANTSTATUS, Code.class, 16,
                PROPERTY_CONSTRAINTS[10], false, PropertyAssociationType.COMPONENT, APPLICANTSTATUS_CODEPATH));
        propertyMap.put(CLASSIFICATION, PropertyDescriptorSupport.createDatatype(CLASSIFICATION, Code.class, 17,
                PROPERTY_CONSTRAINTS[11], false, PropertyAssociationType.COMPONENT, CLASSIFICATION_CODEPATH));
        propertyMap.put(SOURCECHANNEL, PropertyDescriptorSupport.createDatatype(SOURCECHANNEL, Code.class, 18,
                PROPERTY_CONSTRAINTS[12], false, PropertyAssociationType.COMPONENT, SOURCECHANNEL_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(AVAILABILITYDATE), this.availabilityDate,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(UNEMPLOYEDSINCE), this.unemployedSince,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PLACEMENTVOUCHER), this.placementVoucher,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(EMPLOYED), this.employed, null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PREFERREDLOCATION), this.preferredLocation,
                null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PREFERREDWORKINGHOURS),
                this.preferredWorkingHours, null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PREFERREDSALARYTIMEFRAME),
                this.getPreferredSalaryTimeframe(), null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PREFERREDSALARYAMOUNT),
                this.preferredSalaryAmount, null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(SOURCECHANNELADDITIONALS),
                this.sourceChannelAdditionals, null));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(PREFERREDSALARYAMOUNTCURRENCY),
                this.getPreferredSalaryAmountCurrency(), this.preferredSalaryAmountCurrencyRefId));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(APPLICANTSTATUS),
                this.getApplicantStatus(), this.applicantStatusRefId));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(CLASSIFICATION), this.getClassification(),
                this.classificationRefId));
        properties.add(super.createProperty(Applicant.getPropertyDescriptor(SOURCECHANNEL), this.getSourceChannel(),
                this.sourceChannelRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(AVAILABILITYDATE) && (property.getType() == Date.class))) {
            this.setAvailabilityDate(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(UNEMPLOYEDSINCE) && (property.getType() == Date.class))) {
            this.setUnemployedSince(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PLACEMENTVOUCHER) && (property.getType() == Flag.class))) {
            this.setPlacementVoucher(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EMPLOYED) && (property.getType() == Flag.class))) {
            this.setEmployed(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFERREDLOCATION) && (property.getType() == Name.class))) {
            this.setPreferredLocation(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFERREDWORKINGHOURS) && (property.getType() == Number.class))) {
            this.setPreferredWorkingHours(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFERREDSALARYTIMEFRAME) && (property.getType() == SalaryTimeframe.class))) {
            this.setPreferredSalaryTimeframe(((SalaryTimeframe) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFERREDSALARYAMOUNT) && (property.getType() == Amount.class))) {
            this.setPreferredSalaryAmount(((Amount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SOURCECHANNELADDITIONALS) && (property.getType() == Body.class))) {
            this.setSourceChannelAdditionals(((Body) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFERREDSALARYAMOUNTCURRENCY) && (property.getType() == Code.class))) {
            this.setPreferredSalaryAmountCurrency(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(APPLICANTSTATUS) && (property.getType() == Code.class))) {
            this.setApplicantStatus(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CLASSIFICATION) && (property.getType() == Code.class))) {
            this.setClassification(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SOURCECHANNEL) && (property.getType() == Code.class))) {
            this.setSourceChannel(((Code) property.getInstance()));
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
        if ((this.placementVoucher == null)) {
            if ((other.placementVoucher != null))
                return false;
        } else if ((!this.placementVoucher.equals(other.placementVoucher)))
            return false;
        if ((this.employed == null)) {
            if ((other.employed != null))
                return false;
        } else if ((!this.employed.equals(other.employed)))
            return false;
        if ((this.preferredLocation == null)) {
            if ((other.preferredLocation != null))
                return false;
        } else if ((!this.preferredLocation.equals(other.preferredLocation)))
            return false;
        if ((this.preferredWorkingHours == null)) {
            if ((other.preferredWorkingHours != null))
                return false;
        } else if ((!this.preferredWorkingHours.equals(other.preferredWorkingHours)))
            return false;
        if ((this.preferredSalaryTimeframe == null)) {
            if ((other.preferredSalaryTimeframe != null))
                return false;
        } else if ((!this.preferredSalaryTimeframe.equals(other.preferredSalaryTimeframe)))
            return false;
        if ((this.preferredSalaryAmount == null)) {
            if ((other.preferredSalaryAmount != null))
                return false;
        } else if ((!this.preferredSalaryAmount.equals(other.preferredSalaryAmount)))
            return false;
        if ((this.sourceChannelAdditionals == null)) {
            if ((other.sourceChannelAdditionals != null))
                return false;
        } else if ((!this.sourceChannelAdditionals.equals(other.sourceChannelAdditionals)))
            return false;
        if ((this.preferredSalaryAmountCurrency == null)) {
            if ((other.preferredSalaryAmountCurrency != null))
                return false;
        } else if ((!this.preferredSalaryAmountCurrency.equals(other.preferredSalaryAmountCurrency)))
            return false;
        if ((this.preferredSalaryAmountCurrencyRefId == null)) {
            if ((other.preferredSalaryAmountCurrencyRefId != null))
                return false;
        } else if ((!this.preferredSalaryAmountCurrencyRefId.equals(other.preferredSalaryAmountCurrencyRefId)))
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
        if ((this.classification == null)) {
            if ((other.classification != null))
                return false;
        } else if ((!this.classification.equals(other.classification)))
            return false;
        if ((this.classificationRefId == null)) {
            if ((other.classificationRefId != null))
                return false;
        } else if ((!this.classificationRefId.equals(other.classificationRefId)))
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
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.availabilityDate == null) ? 0 : this.availabilityDate.hashCode()));
        result = ((PRIME * result) + ((this.unemployedSince == null) ? 0 : this.unemployedSince.hashCode()));
        result = ((PRIME * result) + ((this.placementVoucher == null) ? 0 : this.placementVoucher.hashCode()));
        result = ((PRIME * result) + ((this.employed == null) ? 0 : this.employed.hashCode()));
        result = ((PRIME * result) + ((this.preferredLocation == null) ? 0 : this.preferredLocation.hashCode()));
        result = ((PRIME * result) + ((this.preferredWorkingHours == null) ? 0 : this.preferredWorkingHours.hashCode()));
        result = ((PRIME * result) + ((this.preferredSalaryTimeframe == null) ? 0 : this.preferredSalaryTimeframe
                .hashCode()));
        result = ((PRIME * result) + ((this.preferredSalaryAmount == null) ? 0 : this.preferredSalaryAmount.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannelAdditionals == null) ? 0 : this.sourceChannelAdditionals
                .hashCode()));
        result = ((PRIME * result) + ((this.preferredSalaryAmountCurrency == null) ? 0
                : this.preferredSalaryAmountCurrency.hashCode()));
        result = ((PRIME * result) + ((this.preferredSalaryAmountCurrencyRefId == null) ? 0
                : this.preferredSalaryAmountCurrencyRefId.hashCode()));
        result = ((PRIME * result) + ((this.applicantStatus == null) ? 0 : this.applicantStatus.hashCode()));
        result = ((PRIME * result) + ((this.applicantStatusRefId == null) ? 0 : this.applicantStatusRefId.hashCode()));
        result = ((PRIME * result) + ((this.classification == null) ? 0 : this.classification.hashCode()));
        result = ((PRIME * result) + ((this.classificationRefId == null) ? 0 : this.classificationRefId.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannel == null) ? 0 : this.sourceChannel.hashCode()));
        result = ((PRIME * result) + ((this.sourceChannelRefId == null) ? 0 : this.sourceChannelRefId.hashCode()));
        return result;
    }

    @Override
    public Applicant cloneObject() {
        Applicant clone = new Applicant();
        this.cloneObject(clone);
        return clone;
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
     * Missing description at method getPlacementVoucher.
     *
     * @return the Flag.
     */
    public Flag getPlacementVoucher() {
        return this.placementVoucher;
    }

    /**
     * Missing description at method setPlacementVoucher.
     *
     * @param placementVoucher the Flag.
     */
    public void setPlacementVoucher(Flag placementVoucher) {
        this.placementVoucher = placementVoucher;
    }

    /**
     * Missing description at method setPlacementVoucher.
     *
     * @param placementVoucher the Boolean.
     */
    public void setPlacementVoucher(Boolean placementVoucher) {
        if ((this.placementVoucher == null)) {
            if ((placementVoucher == null)) {
                return;
            }
            this.placementVoucher = new Flag();
        }
        this.placementVoucher.setValue(placementVoucher);
    }

    /**
     * Missing description at method getEmployed.
     *
     * @return the Flag.
     */
    public Flag getEmployed() {
        return this.employed;
    }

    /**
     * Missing description at method setEmployed.
     *
     * @param employed the Flag.
     */
    public void setEmployed(Flag employed) {
        this.employed = employed;
    }

    /**
     * Missing description at method setEmployed.
     *
     * @param employed the Boolean.
     */
    public void setEmployed(Boolean employed) {
        if ((this.employed == null)) {
            if ((employed == null)) {
                return;
            }
            this.employed = new Flag();
        }
        this.employed.setValue(employed);
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
     * Missing description at method getPreferredWorkingHours.
     *
     * @return the Number.
     */
    public Number getPreferredWorkingHours() {
        return this.preferredWorkingHours;
    }

    /**
     * Missing description at method setPreferredWorkingHours.
     *
     * @param preferredWorkingHours the Number.
     */
    public void setPreferredWorkingHours(Number preferredWorkingHours) {
        this.preferredWorkingHours = preferredWorkingHours;
    }

    /**
     * Missing description at method setPreferredWorkingHours.
     *
     * @param preferredWorkingHours the Integer.
     */
    public void setPreferredWorkingHours(Integer preferredWorkingHours) {
        if ((this.preferredWorkingHours == null)) {
            if ((preferredWorkingHours == null)) {
                return;
            }
            this.preferredWorkingHours = new Number();
        }
        this.preferredWorkingHours.setValue(preferredWorkingHours);
    }

    /**
     * Missing description at method getPreferredSalaryTimeframe.
     *
     * @return the SalaryTimeframe.
     */
    public SalaryTimeframe getPreferredSalaryTimeframe() {
        return this.preferredSalaryTimeframe;
    }

    /**
     * Missing description at method setPreferredSalaryTimeframe.
     *
     * @param preferredSalaryTimeframe the SalaryTimeframe.
     */
    public void setPreferredSalaryTimeframe(SalaryTimeframe preferredSalaryTimeframe) {
        this.preferredSalaryTimeframe = preferredSalaryTimeframe;
    }

    /**
     * Missing description at method setPreferredSalaryTimeframe.
     *
     * @param preferredSalaryTimeframe the String.
     */
    public void setPreferredSalaryTimeframe(String preferredSalaryTimeframe) {
        if ((preferredSalaryTimeframe == null)) {
            this.preferredSalaryTimeframe = null;
        } else {
            this.preferredSalaryTimeframe = SalaryTimeframe.valueOf(preferredSalaryTimeframe);
        }
    }

    /**
     * Missing description at method getPreferredSalaryAmount.
     *
     * @return the Amount.
     */
    public Amount getPreferredSalaryAmount() {
        return this.preferredSalaryAmount;
    }

    /**
     * Missing description at method setPreferredSalaryAmount.
     *
     * @param preferredSalaryAmount the Amount.
     */
    public void setPreferredSalaryAmount(Amount preferredSalaryAmount) {
        this.preferredSalaryAmount = preferredSalaryAmount;
    }

    /**
     * Missing description at method setPreferredSalaryAmount.
     *
     * @param preferredSalaryAmount the java.math.BigDecimal.
     */
    public void setPreferredSalaryAmount(java.math.BigDecimal preferredSalaryAmount) {
        if ((this.preferredSalaryAmount == null)) {
            if ((preferredSalaryAmount == null)) {
                return;
            }
            this.preferredSalaryAmount = new Amount();
        }
        this.preferredSalaryAmount.setValue(preferredSalaryAmount);
    }

    /**
     * Missing description at method getSourceChannelAdditionals.
     *
     * @return the Body.
     */
    public Body getSourceChannelAdditionals() {
        return this.sourceChannelAdditionals;
    }

    /**
     * Missing description at method setSourceChannelAdditionals.
     *
     * @param sourceChannelAdditionals the Body.
     */
    public void setSourceChannelAdditionals(Body sourceChannelAdditionals) {
        this.sourceChannelAdditionals = sourceChannelAdditionals;
    }

    /**
     * Missing description at method setSourceChannelAdditionals.
     *
     * @param sourceChannelAdditionals the String.
     */
    public void setSourceChannelAdditionals(String sourceChannelAdditionals) {
        if ((this.sourceChannelAdditionals == null)) {
            if ((sourceChannelAdditionals == null)) {
                return;
            }
            this.sourceChannelAdditionals = new Body();
        }
        this.sourceChannelAdditionals.setValue(sourceChannelAdditionals);
    }

    /**
     * Missing description at method setPreferredSalaryAmountCurrency.
     *
     * @param preferredSalaryAmountCurrency the Code.
     */
    public void setPreferredSalaryAmountCurrency(Code preferredSalaryAmountCurrency) {
        this.preferredSalaryAmountCurrency = preferredSalaryAmountCurrency;
        if ((preferredSalaryAmountCurrency != null)) {
            this.setPreferredSalaryAmountCurrencyRefId(preferredSalaryAmountCurrency.getId());
        } else {
            this.setPreferredSalaryAmountCurrencyRefId(null);
        }
    }

    /**
     * Missing description at method getPreferredSalaryAmountCurrency.
     *
     * @return the Code.
     */
    public Code getPreferredSalaryAmountCurrency() {
        return this.preferredSalaryAmountCurrency;
    }

    /**
     * Getter for the PreferredSalaryAmountCurrencyRefId.
     *
     * @return the Long.
     */
    public Long getPreferredSalaryAmountCurrencyRefId() {
        return this.preferredSalaryAmountCurrencyRefId;
    }

    /**
     * Setter for the PreferredSalaryAmountCurrencyRefId.
     *
     * @param preferredSalaryAmountCurrencyRefId the Long.
     */
    public void setPreferredSalaryAmountCurrencyRefId(Long preferredSalaryAmountCurrencyRefId) {
        this.preferredSalaryAmountCurrencyRefId = preferredSalaryAmountCurrencyRefId;
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
     * Missing description at method setClassification.
     *
     * @param classification the Code.
     */
    public void setClassification(Code classification) {
        this.classification = classification;
        if ((classification != null)) {
            this.setClassificationRefId(classification.getId());
        } else {
            this.setClassificationRefId(null);
        }
    }

    /**
     * Missing description at method getClassification.
     *
     * @return the Code.
     */
    public Code getClassification() {
        return this.classification;
    }

    /**
     * Getter for the ClassificationRefId.
     *
     * @return the Long.
     */
    public Long getClassificationRefId() {
        return this.classificationRefId;
    }

    /**
     * Setter for the ClassificationRefId.
     *
     * @param classificationRefId the Long.
     */
    public void setClassificationRefId(Long classificationRefId) {
        this.classificationRefId = classificationRefId;
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
     * Getter for the PreferredSalaryAmountCurrencyCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getPreferredSalaryAmountCurrencyCodePath() {
        return new CodePath(PREFERREDSALARYAMOUNTCURRENCY_CODEPATH);
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
     * Getter for the ClassificationCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getClassificationCodePath() {
        return new CodePath(CLASSIFICATION_CODEPATH);
    }

    /**
     * Getter for the SourceChannelCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSourceChannelCodePath() {
        return new CodePath(SOURCECHANNEL_CODEPATH);
    }
}
