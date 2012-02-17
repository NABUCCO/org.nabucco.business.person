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
import org.nabucco.business.person.facade.datatype.Absence;
import org.nabucco.business.person.facade.datatype.BankAccount;
import org.nabucco.business.person.facade.datatype.EmployeeAccountingData;
import org.nabucco.business.person.facade.datatype.EmployeeContractData;
import org.nabucco.business.person.facade.datatype.EmployeeRole;
import org.nabucco.business.person.facade.datatype.PersonCharacteristic;
import org.nabucco.business.person.facade.datatype.PersonCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Employee
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class Employee extends PersonCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final PersonCharacteristicType CHARACTERISTICTYPE_DEFAULT = PersonCharacteristicType.EMPLOYEE;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m1,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "m1,1;", "m0,n;", "m0,1;", "m0,1;", "m0,1;", "m0,n;" };

    public static final String EMPLOYEEID = "employeeId";

    public static final String EMPLOYEEDSINCE = "employeedSince";

    public static final String EMPLOYEEDTILL = "employeedTill";

    public static final String WORKEXPERIENCESINCE = "workExperienceSince";

    public static final String EMPLOYEESTATUS = "employeeStatus";

    public static final String ROLELIST = "roleList";

    public static final String ACCOUNTINGDATA = "accountingData";

    public static final String CONTRACTDATA = "contractData";

    public static final String BANKACCOUNT = "bankAccount";

    public static final String ABSENCELIST = "absenceList";

    private FunctionalIdentifier employeeId;

    private Date employeedSince;

    private Date employeedTill;

    private Date workExperienceSince;

    private Code employeeStatus;

    private Long employeeStatusRefId;

    protected static final String EMPLOYEESTATUS_CODEPATH = "nabucco.business.person.employee.employeestatus";

    private NabuccoList<EmployeeRole> roleList;

    private EmployeeAccountingData accountingData;

    private EmployeeContractData contractData;

    private BankAccount bankAccount;

    /** The absences of the employee */
    private NabuccoList<Absence> absenceList;

    /** Constructs a new Employee instance. */
    public Employee() {
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
     * @param clone the Employee.
     */
    protected void cloneObject(Employee clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getEmployeeId() != null)) {
            clone.setEmployeeId(this.getEmployeeId().cloneObject());
        }
        if ((this.getEmployeedSince() != null)) {
            clone.setEmployeedSince(this.getEmployeedSince().cloneObject());
        }
        if ((this.getEmployeedTill() != null)) {
            clone.setEmployeedTill(this.getEmployeedTill().cloneObject());
        }
        if ((this.getWorkExperienceSince() != null)) {
            clone.setWorkExperienceSince(this.getWorkExperienceSince().cloneObject());
        }
        if ((this.getEmployeeStatus() != null)) {
            clone.setEmployeeStatus(this.getEmployeeStatus().cloneObject());
        }
        if ((this.getEmployeeStatusRefId() != null)) {
            clone.setEmployeeStatusRefId(this.getEmployeeStatusRefId());
        }
        if ((this.roleList != null)) {
            clone.roleList = this.roleList.cloneCollection();
        }
        if ((this.getAccountingData() != null)) {
            clone.setAccountingData(this.getAccountingData().cloneObject());
        }
        if ((this.getContractData() != null)) {
            clone.setContractData(this.getContractData().cloneObject());
        }
        if ((this.getBankAccount() != null)) {
            clone.setBankAccount(this.getBankAccount().cloneObject());
        }
        if ((this.absenceList != null)) {
            clone.absenceList = this.absenceList.cloneCollection();
        }
    }

    /**
     * Getter for the RoleListJPA.
     *
     * @return the List<EmployeeRole>.
     */
    List<EmployeeRole> getRoleListJPA() {
        if ((this.roleList == null)) {
            this.roleList = new NabuccoListImpl<EmployeeRole>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<EmployeeRole>) this.roleList).getDelegate();
    }

    /**
     * Setter for the RoleListJPA.
     *
     * @param roleList the List<EmployeeRole>.
     */
    void setRoleListJPA(List<EmployeeRole> roleList) {
        if ((this.roleList == null)) {
            this.roleList = new NabuccoListImpl<EmployeeRole>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<EmployeeRole>) this.roleList).setDelegate(roleList);
    }

    /**
     * Getter for the AbsenceListJPA.
     *
     * @return the List<Absence>.
     */
    List<Absence> getAbsenceListJPA() {
        if ((this.absenceList == null)) {
            this.absenceList = new NabuccoListImpl<Absence>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<Absence>) this.absenceList).getDelegate();
    }

    /**
     * Setter for the AbsenceListJPA.
     *
     * @param absenceList the List<Absence>.
     */
    void setAbsenceListJPA(List<Absence> absenceList) {
        if ((this.absenceList == null)) {
            this.absenceList = new NabuccoListImpl<Absence>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<Absence>) this.absenceList).setDelegate(absenceList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(PersonCharacteristic.class).getPropertyMap());
        propertyMap.put(EMPLOYEEID, PropertyDescriptorSupport.createBasetype(EMPLOYEEID, FunctionalIdentifier.class, 6,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap
                .put(EMPLOYEEDSINCE, PropertyDescriptorSupport.createBasetype(EMPLOYEEDSINCE, Date.class, 7,
                        PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(EMPLOYEEDTILL,
                PropertyDescriptorSupport.createBasetype(EMPLOYEEDTILL, Date.class, 8, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(WORKEXPERIENCESINCE, PropertyDescriptorSupport.createBasetype(WORKEXPERIENCESINCE, Date.class,
                9, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(EMPLOYEESTATUS, PropertyDescriptorSupport.createDatatype(EMPLOYEESTATUS, Code.class, 10,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT, EMPLOYEESTATUS_CODEPATH));
        propertyMap.put(ROLELIST, PropertyDescriptorSupport.createCollection(ROLELIST, EmployeeRole.class, 11,
                PROPERTY_CONSTRAINTS[5], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(ACCOUNTINGDATA, PropertyDescriptorSupport.createDatatype(ACCOUNTINGDATA,
                EmployeeAccountingData.class, 12, PROPERTY_CONSTRAINTS[6], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(CONTRACTDATA, PropertyDescriptorSupport.createDatatype(CONTRACTDATA,
                EmployeeContractData.class, 13, PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(BANKACCOUNT, PropertyDescriptorSupport.createDatatype(BANKACCOUNT, BankAccount.class, 14,
                PROPERTY_CONSTRAINTS[8], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(ABSENCELIST, PropertyDescriptorSupport.createCollection(ABSENCELIST, Absence.class, 15,
                PROPERTY_CONSTRAINTS[9], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Employee.getPropertyDescriptor(EMPLOYEEID), this.employeeId, null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(EMPLOYEEDSINCE), this.employeedSince, null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(EMPLOYEEDTILL), this.employeedTill, null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(WORKEXPERIENCESINCE),
                this.workExperienceSince, null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(EMPLOYEESTATUS), this.getEmployeeStatus(),
                this.employeeStatusRefId));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(ROLELIST), this.roleList, null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(ACCOUNTINGDATA), this.getAccountingData(),
                null));
        properties
                .add(super.createProperty(Employee.getPropertyDescriptor(CONTRACTDATA), this.getContractData(), null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(BANKACCOUNT), this.getBankAccount(), null));
        properties.add(super.createProperty(Employee.getPropertyDescriptor(ABSENCELIST), this.absenceList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(EMPLOYEEID) && (property.getType() == FunctionalIdentifier.class))) {
            this.setEmployeeId(((FunctionalIdentifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EMPLOYEEDSINCE) && (property.getType() == Date.class))) {
            this.setEmployeedSince(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EMPLOYEEDTILL) && (property.getType() == Date.class))) {
            this.setEmployeedTill(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(WORKEXPERIENCESINCE) && (property.getType() == Date.class))) {
            this.setWorkExperienceSince(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EMPLOYEESTATUS) && (property.getType() == Code.class))) {
            this.setEmployeeStatus(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ROLELIST) && (property.getType() == EmployeeRole.class))) {
            this.roleList = ((NabuccoList<EmployeeRole>) property.getInstance());
            return true;
        } else if ((property.getName().equals(ACCOUNTINGDATA) && (property.getType() == EmployeeAccountingData.class))) {
            this.setAccountingData(((EmployeeAccountingData) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CONTRACTDATA) && (property.getType() == EmployeeContractData.class))) {
            this.setContractData(((EmployeeContractData) property.getInstance()));
            return true;
        } else if ((property.getName().equals(BANKACCOUNT) && (property.getType() == BankAccount.class))) {
            this.setBankAccount(((BankAccount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ABSENCELIST) && (property.getType() == Absence.class))) {
            this.absenceList = ((NabuccoList<Absence>) property.getInstance());
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
        final Employee other = ((Employee) obj);
        if ((this.employeeId == null)) {
            if ((other.employeeId != null))
                return false;
        } else if ((!this.employeeId.equals(other.employeeId)))
            return false;
        if ((this.employeedSince == null)) {
            if ((other.employeedSince != null))
                return false;
        } else if ((!this.employeedSince.equals(other.employeedSince)))
            return false;
        if ((this.employeedTill == null)) {
            if ((other.employeedTill != null))
                return false;
        } else if ((!this.employeedTill.equals(other.employeedTill)))
            return false;
        if ((this.workExperienceSince == null)) {
            if ((other.workExperienceSince != null))
                return false;
        } else if ((!this.workExperienceSince.equals(other.workExperienceSince)))
            return false;
        if ((this.employeeStatus == null)) {
            if ((other.employeeStatus != null))
                return false;
        } else if ((!this.employeeStatus.equals(other.employeeStatus)))
            return false;
        if ((this.employeeStatusRefId == null)) {
            if ((other.employeeStatusRefId != null))
                return false;
        } else if ((!this.employeeStatusRefId.equals(other.employeeStatusRefId)))
            return false;
        if ((this.accountingData == null)) {
            if ((other.accountingData != null))
                return false;
        } else if ((!this.accountingData.equals(other.accountingData)))
            return false;
        if ((this.contractData == null)) {
            if ((other.contractData != null))
                return false;
        } else if ((!this.contractData.equals(other.contractData)))
            return false;
        if ((this.bankAccount == null)) {
            if ((other.bankAccount != null))
                return false;
        } else if ((!this.bankAccount.equals(other.bankAccount)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.employeeId == null) ? 0 : this.employeeId.hashCode()));
        result = ((PRIME * result) + ((this.employeedSince == null) ? 0 : this.employeedSince.hashCode()));
        result = ((PRIME * result) + ((this.employeedTill == null) ? 0 : this.employeedTill.hashCode()));
        result = ((PRIME * result) + ((this.workExperienceSince == null) ? 0 : this.workExperienceSince.hashCode()));
        result = ((PRIME * result) + ((this.employeeStatus == null) ? 0 : this.employeeStatus.hashCode()));
        result = ((PRIME * result) + ((this.employeeStatusRefId == null) ? 0 : this.employeeStatusRefId.hashCode()));
        result = ((PRIME * result) + ((this.accountingData == null) ? 0 : this.accountingData.hashCode()));
        result = ((PRIME * result) + ((this.contractData == null) ? 0 : this.contractData.hashCode()));
        result = ((PRIME * result) + ((this.bankAccount == null) ? 0 : this.bankAccount.hashCode()));
        return result;
    }

    @Override
    public Employee cloneObject() {
        Employee clone = new Employee();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getEmployeeId.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Missing description at method setEmployeeId.
     *
     * @param employeeId the FunctionalIdentifier.
     */
    public void setEmployeeId(FunctionalIdentifier employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Missing description at method setEmployeeId.
     *
     * @param employeeId the String.
     */
    public void setEmployeeId(String employeeId) {
        if ((this.employeeId == null)) {
            if ((employeeId == null)) {
                return;
            }
            this.employeeId = new FunctionalIdentifier();
        }
        this.employeeId.setValue(employeeId);
    }

    /**
     * Missing description at method getEmployeedSince.
     *
     * @return the Date.
     */
    public Date getEmployeedSince() {
        return this.employeedSince;
    }

    /**
     * Missing description at method setEmployeedSince.
     *
     * @param employeedSince the Date.
     */
    public void setEmployeedSince(Date employeedSince) {
        this.employeedSince = employeedSince;
    }

    /**
     * Missing description at method setEmployeedSince.
     *
     * @param employeedSince the java.util.Date.
     */
    public void setEmployeedSince(java.util.Date employeedSince) {
        if ((this.employeedSince == null)) {
            if ((employeedSince == null)) {
                return;
            }
            this.employeedSince = new Date();
        }
        this.employeedSince.setValue(employeedSince);
    }

    /**
     * Missing description at method getEmployeedTill.
     *
     * @return the Date.
     */
    public Date getEmployeedTill() {
        return this.employeedTill;
    }

    /**
     * Missing description at method setEmployeedTill.
     *
     * @param employeedTill the Date.
     */
    public void setEmployeedTill(Date employeedTill) {
        this.employeedTill = employeedTill;
    }

    /**
     * Missing description at method setEmployeedTill.
     *
     * @param employeedTill the java.util.Date.
     */
    public void setEmployeedTill(java.util.Date employeedTill) {
        if ((this.employeedTill == null)) {
            if ((employeedTill == null)) {
                return;
            }
            this.employeedTill = new Date();
        }
        this.employeedTill.setValue(employeedTill);
    }

    /**
     * Missing description at method getWorkExperienceSince.
     *
     * @return the Date.
     */
    public Date getWorkExperienceSince() {
        return this.workExperienceSince;
    }

    /**
     * Missing description at method setWorkExperienceSince.
     *
     * @param workExperienceSince the Date.
     */
    public void setWorkExperienceSince(Date workExperienceSince) {
        this.workExperienceSince = workExperienceSince;
    }

    /**
     * Missing description at method setWorkExperienceSince.
     *
     * @param workExperienceSince the java.util.Date.
     */
    public void setWorkExperienceSince(java.util.Date workExperienceSince) {
        if ((this.workExperienceSince == null)) {
            if ((workExperienceSince == null)) {
                return;
            }
            this.workExperienceSince = new Date();
        }
        this.workExperienceSince.setValue(workExperienceSince);
    }

    /**
     * Missing description at method setEmployeeStatus.
     *
     * @param employeeStatus the Code.
     */
    public void setEmployeeStatus(Code employeeStatus) {
        this.employeeStatus = employeeStatus;
        if ((employeeStatus != null)) {
            this.setEmployeeStatusRefId(employeeStatus.getId());
        } else {
            this.setEmployeeStatusRefId(null);
        }
    }

    /**
     * Missing description at method getEmployeeStatus.
     *
     * @return the Code.
     */
    public Code getEmployeeStatus() {
        return this.employeeStatus;
    }

    /**
     * Getter for the EmployeeStatusRefId.
     *
     * @return the Long.
     */
    public Long getEmployeeStatusRefId() {
        return this.employeeStatusRefId;
    }

    /**
     * Setter for the EmployeeStatusRefId.
     *
     * @param employeeStatusRefId the Long.
     */
    public void setEmployeeStatusRefId(Long employeeStatusRefId) {
        this.employeeStatusRefId = employeeStatusRefId;
    }

    /**
     * Missing description at method getRoleList.
     *
     * @return the NabuccoList<EmployeeRole>.
     */
    public NabuccoList<EmployeeRole> getRoleList() {
        if ((this.roleList == null)) {
            this.roleList = new NabuccoListImpl<EmployeeRole>(NabuccoCollectionState.INITIALIZED);
        }
        return this.roleList;
    }

    /**
     * Missing description at method setAccountingData.
     *
     * @param accountingData the EmployeeAccountingData.
     */
    public void setAccountingData(EmployeeAccountingData accountingData) {
        this.accountingData = accountingData;
    }

    /**
     * Missing description at method getAccountingData.
     *
     * @return the EmployeeAccountingData.
     */
    public EmployeeAccountingData getAccountingData() {
        return this.accountingData;
    }

    /**
     * Missing description at method setContractData.
     *
     * @param contractData the EmployeeContractData.
     */
    public void setContractData(EmployeeContractData contractData) {
        this.contractData = contractData;
    }

    /**
     * Missing description at method getContractData.
     *
     * @return the EmployeeContractData.
     */
    public EmployeeContractData getContractData() {
        return this.contractData;
    }

    /**
     * Missing description at method setBankAccount.
     *
     * @param bankAccount the BankAccount.
     */
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Missing description at method getBankAccount.
     *
     * @return the BankAccount.
     */
    public BankAccount getBankAccount() {
        return this.bankAccount;
    }

    /**
     * The absences of the employee
     *
     * @return the NabuccoList<Absence>.
     */
    public NabuccoList<Absence> getAbsenceList() {
        if ((this.absenceList == null)) {
            this.absenceList = new NabuccoListImpl<Absence>(NabuccoCollectionState.INITIALIZED);
        }
        return this.absenceList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Employee.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Employee.class).getAllProperties();
    }

    /**
     * Getter for the EmployeeStatusCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getEmployeeStatusCodePath() {
        return new CodePath(EMPLOYEESTATUS_CODEPATH);
    }
}
