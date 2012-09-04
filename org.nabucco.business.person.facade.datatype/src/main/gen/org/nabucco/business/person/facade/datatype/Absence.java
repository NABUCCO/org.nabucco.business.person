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
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
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
 * Absence<p/>The Absence of the employee<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-12-07
 */
public class Absence extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "m1,1;" };

    public static final String DATEFROM = "dateFrom";

    public static final String DATETO = "dateTo";

    public static final String ABSENCEREASON = "absenceReason";

    /** The begining date of the absence */
    private Date dateFrom;

    /** The Enddate of the absence */
    private Date dateTo;

    /** The absence reason */
    private Code absenceReason;

    private Long absenceReasonRefId;

    protected static final String ABSENCEREASON_CODEPATH = "nabucco.business.person.employee.absense.absencereason";

    /** Constructs a new Absence instance. */
    public Absence() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the Absence.
     */
    protected void cloneObject(Absence clone) {
        super.cloneObject(clone);
        if ((this.getDateFrom() != null)) {
            clone.setDateFrom(this.getDateFrom().cloneObject());
        }
        if ((this.getDateTo() != null)) {
            clone.setDateTo(this.getDateTo().cloneObject());
        }
        if ((this.getAbsenceReason() != null)) {
            clone.setAbsenceReason(this.getAbsenceReason().cloneObject());
        }
        if ((this.getAbsenceReasonRefId() != null)) {
            clone.setAbsenceReasonRefId(this.getAbsenceReasonRefId());
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
        propertyMap.put(DATEFROM,
                PropertyDescriptorSupport.createBasetype(DATEFROM, Date.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(DATETO,
                PropertyDescriptorSupport.createBasetype(DATETO, Date.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ABSENCEREASON, PropertyDescriptorSupport.createDatatype(ABSENCEREASON, Code.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, ABSENCEREASON_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Absence.getPropertyDescriptor(DATEFROM), this.dateFrom, null));
        properties.add(super.createProperty(Absence.getPropertyDescriptor(DATETO), this.dateTo, null));
        properties.add(super.createProperty(Absence.getPropertyDescriptor(ABSENCEREASON), this.getAbsenceReason(),
                this.absenceReasonRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(DATEFROM) && (property.getType() == Date.class))) {
            this.setDateFrom(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DATETO) && (property.getType() == Date.class))) {
            this.setDateTo(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ABSENCEREASON) && (property.getType() == Code.class))) {
            this.setAbsenceReason(((Code) property.getInstance()));
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
        final Absence other = ((Absence) obj);
        if ((this.dateFrom == null)) {
            if ((other.dateFrom != null))
                return false;
        } else if ((!this.dateFrom.equals(other.dateFrom)))
            return false;
        if ((this.dateTo == null)) {
            if ((other.dateTo != null))
                return false;
        } else if ((!this.dateTo.equals(other.dateTo)))
            return false;
        if ((this.absenceReason == null)) {
            if ((other.absenceReason != null))
                return false;
        } else if ((!this.absenceReason.equals(other.absenceReason)))
            return false;
        if ((this.absenceReasonRefId == null)) {
            if ((other.absenceReasonRefId != null))
                return false;
        } else if ((!this.absenceReasonRefId.equals(other.absenceReasonRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.dateFrom == null) ? 0 : this.dateFrom.hashCode()));
        result = ((PRIME * result) + ((this.dateTo == null) ? 0 : this.dateTo.hashCode()));
        result = ((PRIME * result) + ((this.absenceReason == null) ? 0 : this.absenceReason.hashCode()));
        result = ((PRIME * result) + ((this.absenceReasonRefId == null) ? 0 : this.absenceReasonRefId.hashCode()));
        return result;
    }

    @Override
    public Absence cloneObject() {
        Absence clone = new Absence();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The begining date of the absence
     *
     * @return the Date.
     */
    public Date getDateFrom() {
        return this.dateFrom;
    }

    /**
     * The begining date of the absence
     *
     * @param dateFrom the Date.
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * The begining date of the absence
     *
     * @param dateFrom the java.util.Date.
     */
    public void setDateFrom(java.util.Date dateFrom) {
        if ((this.dateFrom == null)) {
            if ((dateFrom == null)) {
                return;
            }
            this.dateFrom = new Date();
        }
        this.dateFrom.setValue(dateFrom);
    }

    /**
     * The Enddate of the absence
     *
     * @return the Date.
     */
    public Date getDateTo() {
        return this.dateTo;
    }

    /**
     * The Enddate of the absence
     *
     * @param dateTo the Date.
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * The Enddate of the absence
     *
     * @param dateTo the java.util.Date.
     */
    public void setDateTo(java.util.Date dateTo) {
        if ((this.dateTo == null)) {
            if ((dateTo == null)) {
                return;
            }
            this.dateTo = new Date();
        }
        this.dateTo.setValue(dateTo);
    }

    /**
     * The absence reason
     *
     * @param absenceReason the Code.
     */
    public void setAbsenceReason(Code absenceReason) {
        this.absenceReason = absenceReason;
        if ((absenceReason != null)) {
            this.setAbsenceReasonRefId(absenceReason.getId());
        } else {
            this.setAbsenceReasonRefId(null);
        }
    }

    /**
     * The absence reason
     *
     * @return the Code.
     */
    public Code getAbsenceReason() {
        return this.absenceReason;
    }

    /**
     * Getter for the AbsenceReasonRefId.
     *
     * @return the Long.
     */
    public Long getAbsenceReasonRefId() {
        return this.absenceReasonRefId;
    }

    /**
     * Setter for the AbsenceReasonRefId.
     *
     * @param absenceReasonRefId the Long.
     */
    public void setAbsenceReasonRefId(Long absenceReasonRefId) {
        this.absenceReasonRefId = absenceReasonRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Absence.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Absence.class).getAllProperties();
    }

    /**
     * Getter for the AbsenceReasonCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getAbsenceReasonCodePath() {
        return new CodePath(ABSENCEREASON_CODEPATH);
    }
}
