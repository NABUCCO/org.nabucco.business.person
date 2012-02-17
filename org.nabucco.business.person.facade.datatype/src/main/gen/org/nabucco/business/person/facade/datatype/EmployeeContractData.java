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
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
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
 * EmployeeContractData
 *
 * @version 1.1
 * @author Raffael Bieniek, PRODYNA AG, 2011-06-20
 */
public class EmployeeContractData extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;", "m0,1;", "l0,n;u0,n;m0,1;", "l0,255;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    public static final String EMPLOYMENTRELATIONSHIP = "employmentRelationship";

    public static final String CONTRACTLIMITATIONCODE = "contractLimitationCode";

    public static final String CONTRACTLIMITATIONDATE = "contractLimitationDate";

    public static final String CONTRACTLIMITATIONREASON = "contractLimitationReason";

    public static final String SEVERELYHANDICAPPED = "severelyHandicapped";

    public static final String UNEMPLOYEDSINCE = "unemployedSince";

    public static final String UNEMPLOYEDBEFORE = "unemployedBefore";

    public static final String JOBROLEACTIVITYCODE = "jobRoleActivityCode";

    public static final String JOBROLEGRADUATIONCODE = "jobRoleGraduationCode";

    public static final String JOBROLEFINALDEGREECODE = "jobRoleFinalDegreeCode";

    public static final String WORKINGHOURSWEEK = "workingHoursWeek";

    private Code employmentRelationship;

    private Long employmentRelationshipRefId;

    protected static final String EMPLOYMENTRELATIONSHIP_CODEPATH = "nabucco.business.person.employee.employmentrelationship";

    private Code contractLimitationCode;

    private Long contractLimitationCodeRefId;

    protected static final String CONTRACTLIMITATIONCODE_CODEPATH = "nabucco.business.person.employee.contractlimitationcode";

    private Date contractLimitationDate;

    private Name contractLimitationReason;

    private Flag severelyHandicapped;

    private Date unemployedSince;

    private Flag unemployedBefore;

    private Code jobRoleActivityCode;

    private Long jobRoleActivityCodeRefId;

    protected static final String JOBROLEACTIVITYCODE_CODEPATH = "nabucco.business.person.employee.jobroleactivitycode";

    private Code jobRoleGraduationCode;

    private Long jobRoleGraduationCodeRefId;

    protected static final String JOBROLEGRADUATIONCODE_CODEPATH = "nabucco.business.person.employee.jobrolegraduationcode";

    private Code jobRoleFinalDegreeCode;

    private Long jobRoleFinalDegreeCodeRefId;

    protected static final String JOBROLEFINALDEGREECODE_CODEPATH = "nabucco.business.person.employee.jobrolefinaldegreecode";

    private Code workingHoursWeek;

    private Long workingHoursWeekRefId;

    protected static final String WORKINGHOURSWEEK_CODEPATH = "nabucco.business.person.employee.workinghoursweek";

    /** Constructs a new EmployeeContractData instance. */
    public EmployeeContractData() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the EmployeeContractData.
     */
    protected void cloneObject(EmployeeContractData clone) {
        super.cloneObject(clone);
        if ((this.getEmploymentRelationship() != null)) {
            clone.setEmploymentRelationship(this.getEmploymentRelationship().cloneObject());
        }
        if ((this.getEmploymentRelationshipRefId() != null)) {
            clone.setEmploymentRelationshipRefId(this.getEmploymentRelationshipRefId());
        }
        if ((this.getContractLimitationCode() != null)) {
            clone.setContractLimitationCode(this.getContractLimitationCode().cloneObject());
        }
        if ((this.getContractLimitationCodeRefId() != null)) {
            clone.setContractLimitationCodeRefId(this.getContractLimitationCodeRefId());
        }
        if ((this.getContractLimitationDate() != null)) {
            clone.setContractLimitationDate(this.getContractLimitationDate().cloneObject());
        }
        if ((this.getContractLimitationReason() != null)) {
            clone.setContractLimitationReason(this.getContractLimitationReason().cloneObject());
        }
        if ((this.getSeverelyHandicapped() != null)) {
            clone.setSeverelyHandicapped(this.getSeverelyHandicapped().cloneObject());
        }
        if ((this.getUnemployedSince() != null)) {
            clone.setUnemployedSince(this.getUnemployedSince().cloneObject());
        }
        if ((this.getUnemployedBefore() != null)) {
            clone.setUnemployedBefore(this.getUnemployedBefore().cloneObject());
        }
        if ((this.getJobRoleActivityCode() != null)) {
            clone.setJobRoleActivityCode(this.getJobRoleActivityCode().cloneObject());
        }
        if ((this.getJobRoleActivityCodeRefId() != null)) {
            clone.setJobRoleActivityCodeRefId(this.getJobRoleActivityCodeRefId());
        }
        if ((this.getJobRoleGraduationCode() != null)) {
            clone.setJobRoleGraduationCode(this.getJobRoleGraduationCode().cloneObject());
        }
        if ((this.getJobRoleGraduationCodeRefId() != null)) {
            clone.setJobRoleGraduationCodeRefId(this.getJobRoleGraduationCodeRefId());
        }
        if ((this.getJobRoleFinalDegreeCode() != null)) {
            clone.setJobRoleFinalDegreeCode(this.getJobRoleFinalDegreeCode().cloneObject());
        }
        if ((this.getJobRoleFinalDegreeCodeRefId() != null)) {
            clone.setJobRoleFinalDegreeCodeRefId(this.getJobRoleFinalDegreeCodeRefId());
        }
        if ((this.getWorkingHoursWeek() != null)) {
            clone.setWorkingHoursWeek(this.getWorkingHoursWeek().cloneObject());
        }
        if ((this.getWorkingHoursWeekRefId() != null)) {
            clone.setWorkingHoursWeekRefId(this.getWorkingHoursWeekRefId());
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
        propertyMap.put(EMPLOYMENTRELATIONSHIP, PropertyDescriptorSupport.createDatatype(EMPLOYMENTRELATIONSHIP,
                Code.class, 3, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT,
                EMPLOYMENTRELATIONSHIP_CODEPATH));
        propertyMap.put(CONTRACTLIMITATIONCODE, PropertyDescriptorSupport.createDatatype(CONTRACTLIMITATIONCODE,
                Code.class, 4, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT,
                CONTRACTLIMITATIONCODE_CODEPATH));
        propertyMap.put(CONTRACTLIMITATIONDATE, PropertyDescriptorSupport.createBasetype(CONTRACTLIMITATIONDATE,
                Date.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(CONTRACTLIMITATIONREASON, PropertyDescriptorSupport.createBasetype(CONTRACTLIMITATIONREASON,
                Name.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(SEVERELYHANDICAPPED, PropertyDescriptorSupport.createBasetype(SEVERELYHANDICAPPED, Flag.class,
                7, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(UNEMPLOYEDSINCE, PropertyDescriptorSupport.createBasetype(UNEMPLOYEDSINCE, Date.class, 8,
                PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(UNEMPLOYEDBEFORE, PropertyDescriptorSupport.createBasetype(UNEMPLOYEDBEFORE, Flag.class, 9,
                PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(JOBROLEACTIVITYCODE, PropertyDescriptorSupport.createDatatype(JOBROLEACTIVITYCODE, Code.class,
                10, PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPONENT, JOBROLEACTIVITYCODE_CODEPATH));
        propertyMap.put(JOBROLEGRADUATIONCODE, PropertyDescriptorSupport.createDatatype(JOBROLEGRADUATIONCODE,
                Code.class, 11, PROPERTY_CONSTRAINTS[8], false, PropertyAssociationType.COMPONENT,
                JOBROLEGRADUATIONCODE_CODEPATH));
        propertyMap.put(JOBROLEFINALDEGREECODE, PropertyDescriptorSupport.createDatatype(JOBROLEFINALDEGREECODE,
                Code.class, 12, PROPERTY_CONSTRAINTS[9], false, PropertyAssociationType.COMPONENT,
                JOBROLEFINALDEGREECODE_CODEPATH));
        propertyMap.put(WORKINGHOURSWEEK, PropertyDescriptorSupport.createDatatype(WORKINGHOURSWEEK, Code.class, 13,
                PROPERTY_CONSTRAINTS[10], false, PropertyAssociationType.COMPONENT, WORKINGHOURSWEEK_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(EMPLOYMENTRELATIONSHIP),
                this.getEmploymentRelationship(), this.employmentRelationshipRefId));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(CONTRACTLIMITATIONCODE),
                this.getContractLimitationCode(), this.contractLimitationCodeRefId));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(CONTRACTLIMITATIONDATE),
                this.contractLimitationDate, null));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(CONTRACTLIMITATIONREASON),
                this.contractLimitationReason, null));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(SEVERELYHANDICAPPED),
                this.severelyHandicapped, null));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(UNEMPLOYEDSINCE),
                this.unemployedSince, null));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(UNEMPLOYEDBEFORE),
                this.unemployedBefore, null));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(JOBROLEACTIVITYCODE),
                this.getJobRoleActivityCode(), this.jobRoleActivityCodeRefId));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(JOBROLEGRADUATIONCODE),
                this.getJobRoleGraduationCode(), this.jobRoleGraduationCodeRefId));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(JOBROLEFINALDEGREECODE),
                this.getJobRoleFinalDegreeCode(), this.jobRoleFinalDegreeCodeRefId));
        properties.add(super.createProperty(EmployeeContractData.getPropertyDescriptor(WORKINGHOURSWEEK),
                this.getWorkingHoursWeek(), this.workingHoursWeekRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(EMPLOYMENTRELATIONSHIP) && (property.getType() == Code.class))) {
            this.setEmploymentRelationship(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONTRACTLIMITATIONCODE) && (property.getType() == Code.class))) {
            this.setContractLimitationCode(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONTRACTLIMITATIONDATE) && (property.getType() == Date.class))) {
            this.setContractLimitationDate(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONTRACTLIMITATIONREASON) && (property.getType() == Name.class))) {
            this.setContractLimitationReason(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SEVERELYHANDICAPPED) && (property.getType() == Flag.class))) {
            this.setSeverelyHandicapped(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(UNEMPLOYEDSINCE) && (property.getType() == Date.class))) {
            this.setUnemployedSince(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(UNEMPLOYEDBEFORE) && (property.getType() == Flag.class))) {
            this.setUnemployedBefore(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(JOBROLEACTIVITYCODE) && (property.getType() == Code.class))) {
            this.setJobRoleActivityCode(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(JOBROLEGRADUATIONCODE) && (property.getType() == Code.class))) {
            this.setJobRoleGraduationCode(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(JOBROLEFINALDEGREECODE) && (property.getType() == Code.class))) {
            this.setJobRoleFinalDegreeCode(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(WORKINGHOURSWEEK) && (property.getType() == Code.class))) {
            this.setWorkingHoursWeek(((Code) property.getInstance()));
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
        final EmployeeContractData other = ((EmployeeContractData) obj);
        if ((this.employmentRelationship == null)) {
            if ((other.employmentRelationship != null))
                return false;
        } else if ((!this.employmentRelationship.equals(other.employmentRelationship)))
            return false;
        if ((this.employmentRelationshipRefId == null)) {
            if ((other.employmentRelationshipRefId != null))
                return false;
        } else if ((!this.employmentRelationshipRefId.equals(other.employmentRelationshipRefId)))
            return false;
        if ((this.contractLimitationCode == null)) {
            if ((other.contractLimitationCode != null))
                return false;
        } else if ((!this.contractLimitationCode.equals(other.contractLimitationCode)))
            return false;
        if ((this.contractLimitationCodeRefId == null)) {
            if ((other.contractLimitationCodeRefId != null))
                return false;
        } else if ((!this.contractLimitationCodeRefId.equals(other.contractLimitationCodeRefId)))
            return false;
        if ((this.contractLimitationDate == null)) {
            if ((other.contractLimitationDate != null))
                return false;
        } else if ((!this.contractLimitationDate.equals(other.contractLimitationDate)))
            return false;
        if ((this.contractLimitationReason == null)) {
            if ((other.contractLimitationReason != null))
                return false;
        } else if ((!this.contractLimitationReason.equals(other.contractLimitationReason)))
            return false;
        if ((this.severelyHandicapped == null)) {
            if ((other.severelyHandicapped != null))
                return false;
        } else if ((!this.severelyHandicapped.equals(other.severelyHandicapped)))
            return false;
        if ((this.unemployedSince == null)) {
            if ((other.unemployedSince != null))
                return false;
        } else if ((!this.unemployedSince.equals(other.unemployedSince)))
            return false;
        if ((this.unemployedBefore == null)) {
            if ((other.unemployedBefore != null))
                return false;
        } else if ((!this.unemployedBefore.equals(other.unemployedBefore)))
            return false;
        if ((this.jobRoleActivityCode == null)) {
            if ((other.jobRoleActivityCode != null))
                return false;
        } else if ((!this.jobRoleActivityCode.equals(other.jobRoleActivityCode)))
            return false;
        if ((this.jobRoleActivityCodeRefId == null)) {
            if ((other.jobRoleActivityCodeRefId != null))
                return false;
        } else if ((!this.jobRoleActivityCodeRefId.equals(other.jobRoleActivityCodeRefId)))
            return false;
        if ((this.jobRoleGraduationCode == null)) {
            if ((other.jobRoleGraduationCode != null))
                return false;
        } else if ((!this.jobRoleGraduationCode.equals(other.jobRoleGraduationCode)))
            return false;
        if ((this.jobRoleGraduationCodeRefId == null)) {
            if ((other.jobRoleGraduationCodeRefId != null))
                return false;
        } else if ((!this.jobRoleGraduationCodeRefId.equals(other.jobRoleGraduationCodeRefId)))
            return false;
        if ((this.jobRoleFinalDegreeCode == null)) {
            if ((other.jobRoleFinalDegreeCode != null))
                return false;
        } else if ((!this.jobRoleFinalDegreeCode.equals(other.jobRoleFinalDegreeCode)))
            return false;
        if ((this.jobRoleFinalDegreeCodeRefId == null)) {
            if ((other.jobRoleFinalDegreeCodeRefId != null))
                return false;
        } else if ((!this.jobRoleFinalDegreeCodeRefId.equals(other.jobRoleFinalDegreeCodeRefId)))
            return false;
        if ((this.workingHoursWeek == null)) {
            if ((other.workingHoursWeek != null))
                return false;
        } else if ((!this.workingHoursWeek.equals(other.workingHoursWeek)))
            return false;
        if ((this.workingHoursWeekRefId == null)) {
            if ((other.workingHoursWeekRefId != null))
                return false;
        } else if ((!this.workingHoursWeekRefId.equals(other.workingHoursWeekRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.employmentRelationship == null) ? 0 : this.employmentRelationship
                .hashCode()));
        result = ((PRIME * result) + ((this.employmentRelationshipRefId == null) ? 0 : this.employmentRelationshipRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.contractLimitationCode == null) ? 0 : this.contractLimitationCode
                .hashCode()));
        result = ((PRIME * result) + ((this.contractLimitationCodeRefId == null) ? 0 : this.contractLimitationCodeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.contractLimitationDate == null) ? 0 : this.contractLimitationDate
                .hashCode()));
        result = ((PRIME * result) + ((this.contractLimitationReason == null) ? 0 : this.contractLimitationReason
                .hashCode()));
        result = ((PRIME * result) + ((this.severelyHandicapped == null) ? 0 : this.severelyHandicapped.hashCode()));
        result = ((PRIME * result) + ((this.unemployedSince == null) ? 0 : this.unemployedSince.hashCode()));
        result = ((PRIME * result) + ((this.unemployedBefore == null) ? 0 : this.unemployedBefore.hashCode()));
        result = ((PRIME * result) + ((this.jobRoleActivityCode == null) ? 0 : this.jobRoleActivityCode.hashCode()));
        result = ((PRIME * result) + ((this.jobRoleActivityCodeRefId == null) ? 0 : this.jobRoleActivityCodeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.jobRoleGraduationCode == null) ? 0 : this.jobRoleGraduationCode.hashCode()));
        result = ((PRIME * result) + ((this.jobRoleGraduationCodeRefId == null) ? 0 : this.jobRoleGraduationCodeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.jobRoleFinalDegreeCode == null) ? 0 : this.jobRoleFinalDegreeCode
                .hashCode()));
        result = ((PRIME * result) + ((this.jobRoleFinalDegreeCodeRefId == null) ? 0 : this.jobRoleFinalDegreeCodeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.workingHoursWeek == null) ? 0 : this.workingHoursWeek.hashCode()));
        result = ((PRIME * result) + ((this.workingHoursWeekRefId == null) ? 0 : this.workingHoursWeekRefId.hashCode()));
        return result;
    }

    @Override
    public EmployeeContractData cloneObject() {
        EmployeeContractData clone = new EmployeeContractData();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setEmploymentRelationship.
     *
     * @param employmentRelationship the Code.
     */
    public void setEmploymentRelationship(Code employmentRelationship) {
        this.employmentRelationship = employmentRelationship;
        if ((employmentRelationship != null)) {
            this.setEmploymentRelationshipRefId(employmentRelationship.getId());
        } else {
            this.setEmploymentRelationshipRefId(null);
        }
    }

    /**
     * Missing description at method getEmploymentRelationship.
     *
     * @return the Code.
     */
    public Code getEmploymentRelationship() {
        return this.employmentRelationship;
    }

    /**
     * Getter for the EmploymentRelationshipRefId.
     *
     * @return the Long.
     */
    public Long getEmploymentRelationshipRefId() {
        return this.employmentRelationshipRefId;
    }

    /**
     * Setter for the EmploymentRelationshipRefId.
     *
     * @param employmentRelationshipRefId the Long.
     */
    public void setEmploymentRelationshipRefId(Long employmentRelationshipRefId) {
        this.employmentRelationshipRefId = employmentRelationshipRefId;
    }

    /**
     * Missing description at method setContractLimitationCode.
     *
     * @param contractLimitationCode the Code.
     */
    public void setContractLimitationCode(Code contractLimitationCode) {
        this.contractLimitationCode = contractLimitationCode;
        if ((contractLimitationCode != null)) {
            this.setContractLimitationCodeRefId(contractLimitationCode.getId());
        } else {
            this.setContractLimitationCodeRefId(null);
        }
    }

    /**
     * Missing description at method getContractLimitationCode.
     *
     * @return the Code.
     */
    public Code getContractLimitationCode() {
        return this.contractLimitationCode;
    }

    /**
     * Getter for the ContractLimitationCodeRefId.
     *
     * @return the Long.
     */
    public Long getContractLimitationCodeRefId() {
        return this.contractLimitationCodeRefId;
    }

    /**
     * Setter for the ContractLimitationCodeRefId.
     *
     * @param contractLimitationCodeRefId the Long.
     */
    public void setContractLimitationCodeRefId(Long contractLimitationCodeRefId) {
        this.contractLimitationCodeRefId = contractLimitationCodeRefId;
    }

    /**
     * Missing description at method getContractLimitationDate.
     *
     * @return the Date.
     */
    public Date getContractLimitationDate() {
        return this.contractLimitationDate;
    }

    /**
     * Missing description at method setContractLimitationDate.
     *
     * @param contractLimitationDate the Date.
     */
    public void setContractLimitationDate(Date contractLimitationDate) {
        this.contractLimitationDate = contractLimitationDate;
    }

    /**
     * Missing description at method setContractLimitationDate.
     *
     * @param contractLimitationDate the java.util.Date.
     */
    public void setContractLimitationDate(java.util.Date contractLimitationDate) {
        if ((this.contractLimitationDate == null)) {
            if ((contractLimitationDate == null)) {
                return;
            }
            this.contractLimitationDate = new Date();
        }
        this.contractLimitationDate.setValue(contractLimitationDate);
    }

    /**
     * Missing description at method getContractLimitationReason.
     *
     * @return the Name.
     */
    public Name getContractLimitationReason() {
        return this.contractLimitationReason;
    }

    /**
     * Missing description at method setContractLimitationReason.
     *
     * @param contractLimitationReason the Name.
     */
    public void setContractLimitationReason(Name contractLimitationReason) {
        this.contractLimitationReason = contractLimitationReason;
    }

    /**
     * Missing description at method setContractLimitationReason.
     *
     * @param contractLimitationReason the String.
     */
    public void setContractLimitationReason(String contractLimitationReason) {
        if ((this.contractLimitationReason == null)) {
            if ((contractLimitationReason == null)) {
                return;
            }
            this.contractLimitationReason = new Name();
        }
        this.contractLimitationReason.setValue(contractLimitationReason);
    }

    /**
     * Missing description at method getSeverelyHandicapped.
     *
     * @return the Flag.
     */
    public Flag getSeverelyHandicapped() {
        return this.severelyHandicapped;
    }

    /**
     * Missing description at method setSeverelyHandicapped.
     *
     * @param severelyHandicapped the Flag.
     */
    public void setSeverelyHandicapped(Flag severelyHandicapped) {
        this.severelyHandicapped = severelyHandicapped;
    }

    /**
     * Missing description at method setSeverelyHandicapped.
     *
     * @param severelyHandicapped the Boolean.
     */
    public void setSeverelyHandicapped(Boolean severelyHandicapped) {
        if ((this.severelyHandicapped == null)) {
            if ((severelyHandicapped == null)) {
                return;
            }
            this.severelyHandicapped = new Flag();
        }
        this.severelyHandicapped.setValue(severelyHandicapped);
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
     * Missing description at method getUnemployedBefore.
     *
     * @return the Flag.
     */
    public Flag getUnemployedBefore() {
        return this.unemployedBefore;
    }

    /**
     * Missing description at method setUnemployedBefore.
     *
     * @param unemployedBefore the Flag.
     */
    public void setUnemployedBefore(Flag unemployedBefore) {
        this.unemployedBefore = unemployedBefore;
    }

    /**
     * Missing description at method setUnemployedBefore.
     *
     * @param unemployedBefore the Boolean.
     */
    public void setUnemployedBefore(Boolean unemployedBefore) {
        if ((this.unemployedBefore == null)) {
            if ((unemployedBefore == null)) {
                return;
            }
            this.unemployedBefore = new Flag();
        }
        this.unemployedBefore.setValue(unemployedBefore);
    }

    /**
     * Missing description at method setJobRoleActivityCode.
     *
     * @param jobRoleActivityCode the Code.
     */
    public void setJobRoleActivityCode(Code jobRoleActivityCode) {
        this.jobRoleActivityCode = jobRoleActivityCode;
        if ((jobRoleActivityCode != null)) {
            this.setJobRoleActivityCodeRefId(jobRoleActivityCode.getId());
        } else {
            this.setJobRoleActivityCodeRefId(null);
        }
    }

    /**
     * Missing description at method getJobRoleActivityCode.
     *
     * @return the Code.
     */
    public Code getJobRoleActivityCode() {
        return this.jobRoleActivityCode;
    }

    /**
     * Getter for the JobRoleActivityCodeRefId.
     *
     * @return the Long.
     */
    public Long getJobRoleActivityCodeRefId() {
        return this.jobRoleActivityCodeRefId;
    }

    /**
     * Setter for the JobRoleActivityCodeRefId.
     *
     * @param jobRoleActivityCodeRefId the Long.
     */
    public void setJobRoleActivityCodeRefId(Long jobRoleActivityCodeRefId) {
        this.jobRoleActivityCodeRefId = jobRoleActivityCodeRefId;
    }

    /**
     * Missing description at method setJobRoleGraduationCode.
     *
     * @param jobRoleGraduationCode the Code.
     */
    public void setJobRoleGraduationCode(Code jobRoleGraduationCode) {
        this.jobRoleGraduationCode = jobRoleGraduationCode;
        if ((jobRoleGraduationCode != null)) {
            this.setJobRoleGraduationCodeRefId(jobRoleGraduationCode.getId());
        } else {
            this.setJobRoleGraduationCodeRefId(null);
        }
    }

    /**
     * Missing description at method getJobRoleGraduationCode.
     *
     * @return the Code.
     */
    public Code getJobRoleGraduationCode() {
        return this.jobRoleGraduationCode;
    }

    /**
     * Getter for the JobRoleGraduationCodeRefId.
     *
     * @return the Long.
     */
    public Long getJobRoleGraduationCodeRefId() {
        return this.jobRoleGraduationCodeRefId;
    }

    /**
     * Setter for the JobRoleGraduationCodeRefId.
     *
     * @param jobRoleGraduationCodeRefId the Long.
     */
    public void setJobRoleGraduationCodeRefId(Long jobRoleGraduationCodeRefId) {
        this.jobRoleGraduationCodeRefId = jobRoleGraduationCodeRefId;
    }

    /**
     * Missing description at method setJobRoleFinalDegreeCode.
     *
     * @param jobRoleFinalDegreeCode the Code.
     */
    public void setJobRoleFinalDegreeCode(Code jobRoleFinalDegreeCode) {
        this.jobRoleFinalDegreeCode = jobRoleFinalDegreeCode;
        if ((jobRoleFinalDegreeCode != null)) {
            this.setJobRoleFinalDegreeCodeRefId(jobRoleFinalDegreeCode.getId());
        } else {
            this.setJobRoleFinalDegreeCodeRefId(null);
        }
    }

    /**
     * Missing description at method getJobRoleFinalDegreeCode.
     *
     * @return the Code.
     */
    public Code getJobRoleFinalDegreeCode() {
        return this.jobRoleFinalDegreeCode;
    }

    /**
     * Getter for the JobRoleFinalDegreeCodeRefId.
     *
     * @return the Long.
     */
    public Long getJobRoleFinalDegreeCodeRefId() {
        return this.jobRoleFinalDegreeCodeRefId;
    }

    /**
     * Setter for the JobRoleFinalDegreeCodeRefId.
     *
     * @param jobRoleFinalDegreeCodeRefId the Long.
     */
    public void setJobRoleFinalDegreeCodeRefId(Long jobRoleFinalDegreeCodeRefId) {
        this.jobRoleFinalDegreeCodeRefId = jobRoleFinalDegreeCodeRefId;
    }

    /**
     * Missing description at method setWorkingHoursWeek.
     *
     * @param workingHoursWeek the Code.
     */
    public void setWorkingHoursWeek(Code workingHoursWeek) {
        this.workingHoursWeek = workingHoursWeek;
        if ((workingHoursWeek != null)) {
            this.setWorkingHoursWeekRefId(workingHoursWeek.getId());
        } else {
            this.setWorkingHoursWeekRefId(null);
        }
    }

    /**
     * Missing description at method getWorkingHoursWeek.
     *
     * @return the Code.
     */
    public Code getWorkingHoursWeek() {
        return this.workingHoursWeek;
    }

    /**
     * Getter for the WorkingHoursWeekRefId.
     *
     * @return the Long.
     */
    public Long getWorkingHoursWeekRefId() {
        return this.workingHoursWeekRefId;
    }

    /**
     * Setter for the WorkingHoursWeekRefId.
     *
     * @param workingHoursWeekRefId the Long.
     */
    public void setWorkingHoursWeekRefId(Long workingHoursWeekRefId) {
        this.workingHoursWeekRefId = workingHoursWeekRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(EmployeeContractData.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(EmployeeContractData.class).getAllProperties();
    }

    /**
     * Getter for the EmploymentRelationshipCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getEmploymentRelationshipCodePath() {
        return new CodePath(EMPLOYMENTRELATIONSHIP_CODEPATH);
    }

    /**
     * Getter for the ContractLimitationCodeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getContractLimitationCodeCodePath() {
        return new CodePath(CONTRACTLIMITATIONCODE_CODEPATH);
    }

    /**
     * Getter for the JobRoleActivityCodeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getJobRoleActivityCodeCodePath() {
        return new CodePath(JOBROLEACTIVITYCODE_CODEPATH);
    }

    /**
     * Getter for the JobRoleGraduationCodeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getJobRoleGraduationCodeCodePath() {
        return new CodePath(JOBROLEGRADUATIONCODE_CODEPATH);
    }

    /**
     * Getter for the JobRoleFinalDegreeCodeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getJobRoleFinalDegreeCodeCodePath() {
        return new CodePath(JOBROLEFINALDEGREECODE_CODEPATH);
    }

    /**
     * Getter for the WorkingHoursWeekCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getWorkingHoursWeekCodePath() {
        return new CodePath(WORKINGHOURSWEEK_CODEPATH);
    }
}
