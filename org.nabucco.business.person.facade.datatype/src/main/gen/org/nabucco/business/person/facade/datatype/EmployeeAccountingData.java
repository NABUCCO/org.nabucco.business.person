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
import org.nabucco.framework.base.facade.datatype.Amount;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * EmployeeAccountingData
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-06-14
 */
public class EmployeeAccountingData extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m0,1;", "l0,255;u0,n;m0,1;",
            "l0,255;u0,n;m0,1;", "l0,255;u0,n;m0,1;", "m0,1;", "l0,255;u0,n;m0,1;", "l0,255;u0,n;m0,1;",
            "l0,255;u0,n;m0,1;", "m0,1;", "m0,1;", "m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String NATIONALINSURANCENUMBER = "nationalInsuranceNumber";

    public static final String TAXIDENTIFICATIONNUMBER = "taxIdentificationNumber";

    public static final String HEALTHINSURANCECOMPANY = "healthInsuranceCompany";

    public static final String FINANCEOFFICE = "financeOffice";

    public static final String TAXCATEGORY = "taxCategory";

    public static final String TAXFACTOR = "taxFactor";

    public static final String CHILDALLOWANCE = "childAllowance";

    public static final String FIXDEDUCTIONS = "fixDeductions";

    public static final String COLLECTIVEAGREEMENT = "collectiveAgreement";

    public static final String PAYGRADE = "payGrade";

    public static final String REGIONCODE = "regionCode";

    public static final String GENERALPAYBONUS = "generalPayBonus";

    public static final String ALLOWANCEGUARANTEE = "allowanceGuarantee";

    private Name nationalInsuranceNumber;

    private Name taxIdentificationNumber;

    private Name healthInsuranceCompany;

    private Name financeOffice;

    private Code taxCategory;

    private Long taxCategoryRefId;

    protected static final String TAXCATEGORY_CODEPATH = "nabucco.business.accounting.taxcategory";

    private Name taxFactor;

    private Name childAllowance;

    private Name fixDeductions;

    private Code collectiveAgreement;

    private Long collectiveAgreementRefId;

    protected static final String COLLECTIVEAGREEMENT_CODEPATH = "nabucco.business.accounting.collectiveagreement";

    private Code payGrade;

    private Long payGradeRefId;

    protected static final String PAYGRADE_CODEPATH = "nabucco.business.accounting.paygrade";

    private Code regionCode;

    private Long regionCodeRefId;

    protected static final String REGIONCODE_CODEPATH = "nabucco.business.regioncode";

    private Amount generalPayBonus;

    private Amount allowanceGuarantee;

    /** Constructs a new EmployeeAccountingData instance. */
    public EmployeeAccountingData() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the EmployeeAccountingData.
     */
    protected void cloneObject(EmployeeAccountingData clone) {
        super.cloneObject(clone);
        if ((this.getNationalInsuranceNumber() != null)) {
            clone.setNationalInsuranceNumber(this.getNationalInsuranceNumber().cloneObject());
        }
        if ((this.getTaxIdentificationNumber() != null)) {
            clone.setTaxIdentificationNumber(this.getTaxIdentificationNumber().cloneObject());
        }
        if ((this.getHealthInsuranceCompany() != null)) {
            clone.setHealthInsuranceCompany(this.getHealthInsuranceCompany().cloneObject());
        }
        if ((this.getFinanceOffice() != null)) {
            clone.setFinanceOffice(this.getFinanceOffice().cloneObject());
        }
        if ((this.getTaxCategory() != null)) {
            clone.setTaxCategory(this.getTaxCategory().cloneObject());
        }
        if ((this.getTaxCategoryRefId() != null)) {
            clone.setTaxCategoryRefId(this.getTaxCategoryRefId());
        }
        if ((this.getTaxFactor() != null)) {
            clone.setTaxFactor(this.getTaxFactor().cloneObject());
        }
        if ((this.getChildAllowance() != null)) {
            clone.setChildAllowance(this.getChildAllowance().cloneObject());
        }
        if ((this.getFixDeductions() != null)) {
            clone.setFixDeductions(this.getFixDeductions().cloneObject());
        }
        if ((this.getCollectiveAgreement() != null)) {
            clone.setCollectiveAgreement(this.getCollectiveAgreement().cloneObject());
        }
        if ((this.getCollectiveAgreementRefId() != null)) {
            clone.setCollectiveAgreementRefId(this.getCollectiveAgreementRefId());
        }
        if ((this.getPayGrade() != null)) {
            clone.setPayGrade(this.getPayGrade().cloneObject());
        }
        if ((this.getPayGradeRefId() != null)) {
            clone.setPayGradeRefId(this.getPayGradeRefId());
        }
        if ((this.getRegionCode() != null)) {
            clone.setRegionCode(this.getRegionCode().cloneObject());
        }
        if ((this.getRegionCodeRefId() != null)) {
            clone.setRegionCodeRefId(this.getRegionCodeRefId());
        }
        if ((this.getGeneralPayBonus() != null)) {
            clone.setGeneralPayBonus(this.getGeneralPayBonus().cloneObject());
        }
        if ((this.getAllowanceGuarantee() != null)) {
            clone.setAllowanceGuarantee(this.getAllowanceGuarantee().cloneObject());
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
        propertyMap.put(NATIONALINSURANCENUMBER, PropertyDescriptorSupport.createBasetype(NATIONALINSURANCENUMBER,
                Name.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(TAXIDENTIFICATIONNUMBER, PropertyDescriptorSupport.createBasetype(TAXIDENTIFICATIONNUMBER,
                Name.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(HEALTHINSURANCECOMPANY, PropertyDescriptorSupport.createBasetype(HEALTHINSURANCECOMPANY,
                Name.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(FINANCEOFFICE,
                PropertyDescriptorSupport.createBasetype(FINANCEOFFICE, Name.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(TAXCATEGORY, PropertyDescriptorSupport.createDatatype(TAXCATEGORY, Code.class, 7,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT, TAXCATEGORY_CODEPATH));
        propertyMap.put(TAXFACTOR,
                PropertyDescriptorSupport.createBasetype(TAXFACTOR, Name.class, 8, PROPERTY_CONSTRAINTS[5], false));
        propertyMap
                .put(CHILDALLOWANCE, PropertyDescriptorSupport.createBasetype(CHILDALLOWANCE, Name.class, 9,
                        PROPERTY_CONSTRAINTS[6], false));
        propertyMap
                .put(FIXDEDUCTIONS, PropertyDescriptorSupport.createBasetype(FIXDEDUCTIONS, Name.class, 10,
                        PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(COLLECTIVEAGREEMENT, PropertyDescriptorSupport.createDatatype(COLLECTIVEAGREEMENT, Code.class,
                11, PROPERTY_CONSTRAINTS[8], false, PropertyAssociationType.COMPONENT, COLLECTIVEAGREEMENT_CODEPATH));
        propertyMap.put(PAYGRADE, PropertyDescriptorSupport.createDatatype(PAYGRADE, Code.class, 12,
                PROPERTY_CONSTRAINTS[9], false, PropertyAssociationType.COMPONENT, PAYGRADE_CODEPATH));
        propertyMap.put(REGIONCODE, PropertyDescriptorSupport.createDatatype(REGIONCODE, Code.class, 13,
                PROPERTY_CONSTRAINTS[10], false, PropertyAssociationType.COMPONENT, REGIONCODE_CODEPATH));
        propertyMap.put(GENERALPAYBONUS, PropertyDescriptorSupport.createBasetype(GENERALPAYBONUS, Amount.class, 14,
                PROPERTY_CONSTRAINTS[11], false));
        propertyMap.put(ALLOWANCEGUARANTEE, PropertyDescriptorSupport.createBasetype(ALLOWANCEGUARANTEE, Amount.class,
                15, PROPERTY_CONSTRAINTS[12], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(NATIONALINSURANCENUMBER),
                this.nationalInsuranceNumber, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(TAXIDENTIFICATIONNUMBER),
                this.taxIdentificationNumber, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(HEALTHINSURANCECOMPANY),
                this.healthInsuranceCompany, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(FINANCEOFFICE),
                this.financeOffice, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(TAXCATEGORY),
                this.getTaxCategory(), this.taxCategoryRefId));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(TAXFACTOR), this.taxFactor,
                null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(CHILDALLOWANCE),
                this.childAllowance, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(FIXDEDUCTIONS),
                this.fixDeductions, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(COLLECTIVEAGREEMENT),
                this.getCollectiveAgreement(), this.collectiveAgreementRefId));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(PAYGRADE), this.getPayGrade(),
                this.payGradeRefId));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(REGIONCODE),
                this.getRegionCode(), this.regionCodeRefId));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(GENERALPAYBONUS),
                this.generalPayBonus, null));
        properties.add(super.createProperty(EmployeeAccountingData.getPropertyDescriptor(ALLOWANCEGUARANTEE),
                this.allowanceGuarantee, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NATIONALINSURANCENUMBER) && (property.getType() == Name.class))) {
            this.setNationalInsuranceNumber(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TAXIDENTIFICATIONNUMBER) && (property.getType() == Name.class))) {
            this.setTaxIdentificationNumber(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(HEALTHINSURANCECOMPANY) && (property.getType() == Name.class))) {
            this.setHealthInsuranceCompany(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FINANCEOFFICE) && (property.getType() == Name.class))) {
            this.setFinanceOffice(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TAXCATEGORY) && (property.getType() == Code.class))) {
            this.setTaxCategory(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TAXFACTOR) && (property.getType() == Name.class))) {
            this.setTaxFactor(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CHILDALLOWANCE) && (property.getType() == Name.class))) {
            this.setChildAllowance(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FIXDEDUCTIONS) && (property.getType() == Name.class))) {
            this.setFixDeductions(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(COLLECTIVEAGREEMENT) && (property.getType() == Code.class))) {
            this.setCollectiveAgreement(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PAYGRADE) && (property.getType() == Code.class))) {
            this.setPayGrade(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(REGIONCODE) && (property.getType() == Code.class))) {
            this.setRegionCode(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(GENERALPAYBONUS) && (property.getType() == Amount.class))) {
            this.setGeneralPayBonus(((Amount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ALLOWANCEGUARANTEE) && (property.getType() == Amount.class))) {
            this.setAllowanceGuarantee(((Amount) property.getInstance()));
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
        final EmployeeAccountingData other = ((EmployeeAccountingData) obj);
        if ((this.nationalInsuranceNumber == null)) {
            if ((other.nationalInsuranceNumber != null))
                return false;
        } else if ((!this.nationalInsuranceNumber.equals(other.nationalInsuranceNumber)))
            return false;
        if ((this.taxIdentificationNumber == null)) {
            if ((other.taxIdentificationNumber != null))
                return false;
        } else if ((!this.taxIdentificationNumber.equals(other.taxIdentificationNumber)))
            return false;
        if ((this.healthInsuranceCompany == null)) {
            if ((other.healthInsuranceCompany != null))
                return false;
        } else if ((!this.healthInsuranceCompany.equals(other.healthInsuranceCompany)))
            return false;
        if ((this.financeOffice == null)) {
            if ((other.financeOffice != null))
                return false;
        } else if ((!this.financeOffice.equals(other.financeOffice)))
            return false;
        if ((this.taxCategory == null)) {
            if ((other.taxCategory != null))
                return false;
        } else if ((!this.taxCategory.equals(other.taxCategory)))
            return false;
        if ((this.taxCategoryRefId == null)) {
            if ((other.taxCategoryRefId != null))
                return false;
        } else if ((!this.taxCategoryRefId.equals(other.taxCategoryRefId)))
            return false;
        if ((this.taxFactor == null)) {
            if ((other.taxFactor != null))
                return false;
        } else if ((!this.taxFactor.equals(other.taxFactor)))
            return false;
        if ((this.childAllowance == null)) {
            if ((other.childAllowance != null))
                return false;
        } else if ((!this.childAllowance.equals(other.childAllowance)))
            return false;
        if ((this.fixDeductions == null)) {
            if ((other.fixDeductions != null))
                return false;
        } else if ((!this.fixDeductions.equals(other.fixDeductions)))
            return false;
        if ((this.collectiveAgreement == null)) {
            if ((other.collectiveAgreement != null))
                return false;
        } else if ((!this.collectiveAgreement.equals(other.collectiveAgreement)))
            return false;
        if ((this.collectiveAgreementRefId == null)) {
            if ((other.collectiveAgreementRefId != null))
                return false;
        } else if ((!this.collectiveAgreementRefId.equals(other.collectiveAgreementRefId)))
            return false;
        if ((this.payGrade == null)) {
            if ((other.payGrade != null))
                return false;
        } else if ((!this.payGrade.equals(other.payGrade)))
            return false;
        if ((this.payGradeRefId == null)) {
            if ((other.payGradeRefId != null))
                return false;
        } else if ((!this.payGradeRefId.equals(other.payGradeRefId)))
            return false;
        if ((this.regionCode == null)) {
            if ((other.regionCode != null))
                return false;
        } else if ((!this.regionCode.equals(other.regionCode)))
            return false;
        if ((this.regionCodeRefId == null)) {
            if ((other.regionCodeRefId != null))
                return false;
        } else if ((!this.regionCodeRefId.equals(other.regionCodeRefId)))
            return false;
        if ((this.generalPayBonus == null)) {
            if ((other.generalPayBonus != null))
                return false;
        } else if ((!this.generalPayBonus.equals(other.generalPayBonus)))
            return false;
        if ((this.allowanceGuarantee == null)) {
            if ((other.allowanceGuarantee != null))
                return false;
        } else if ((!this.allowanceGuarantee.equals(other.allowanceGuarantee)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.nationalInsuranceNumber == null) ? 0 : this.nationalInsuranceNumber
                .hashCode()));
        result = ((PRIME * result) + ((this.taxIdentificationNumber == null) ? 0 : this.taxIdentificationNumber
                .hashCode()));
        result = ((PRIME * result) + ((this.healthInsuranceCompany == null) ? 0 : this.healthInsuranceCompany
                .hashCode()));
        result = ((PRIME * result) + ((this.financeOffice == null) ? 0 : this.financeOffice.hashCode()));
        result = ((PRIME * result) + ((this.taxCategory == null) ? 0 : this.taxCategory.hashCode()));
        result = ((PRIME * result) + ((this.taxCategoryRefId == null) ? 0 : this.taxCategoryRefId.hashCode()));
        result = ((PRIME * result) + ((this.taxFactor == null) ? 0 : this.taxFactor.hashCode()));
        result = ((PRIME * result) + ((this.childAllowance == null) ? 0 : this.childAllowance.hashCode()));
        result = ((PRIME * result) + ((this.fixDeductions == null) ? 0 : this.fixDeductions.hashCode()));
        result = ((PRIME * result) + ((this.collectiveAgreement == null) ? 0 : this.collectiveAgreement.hashCode()));
        result = ((PRIME * result) + ((this.collectiveAgreementRefId == null) ? 0 : this.collectiveAgreementRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.payGrade == null) ? 0 : this.payGrade.hashCode()));
        result = ((PRIME * result) + ((this.payGradeRefId == null) ? 0 : this.payGradeRefId.hashCode()));
        result = ((PRIME * result) + ((this.regionCode == null) ? 0 : this.regionCode.hashCode()));
        result = ((PRIME * result) + ((this.regionCodeRefId == null) ? 0 : this.regionCodeRefId.hashCode()));
        result = ((PRIME * result) + ((this.generalPayBonus == null) ? 0 : this.generalPayBonus.hashCode()));
        result = ((PRIME * result) + ((this.allowanceGuarantee == null) ? 0 : this.allowanceGuarantee.hashCode()));
        return result;
    }

    @Override
    public EmployeeAccountingData cloneObject() {
        EmployeeAccountingData clone = new EmployeeAccountingData();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getNationalInsuranceNumber.
     *
     * @return the Name.
     */
    public Name getNationalInsuranceNumber() {
        return this.nationalInsuranceNumber;
    }

    /**
     * Missing description at method setNationalInsuranceNumber.
     *
     * @param nationalInsuranceNumber the Name.
     */
    public void setNationalInsuranceNumber(Name nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    /**
     * Missing description at method setNationalInsuranceNumber.
     *
     * @param nationalInsuranceNumber the String.
     */
    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        if ((this.nationalInsuranceNumber == null)) {
            if ((nationalInsuranceNumber == null)) {
                return;
            }
            this.nationalInsuranceNumber = new Name();
        }
        this.nationalInsuranceNumber.setValue(nationalInsuranceNumber);
    }

    /**
     * Missing description at method getTaxIdentificationNumber.
     *
     * @return the Name.
     */
    public Name getTaxIdentificationNumber() {
        return this.taxIdentificationNumber;
    }

    /**
     * Missing description at method setTaxIdentificationNumber.
     *
     * @param taxIdentificationNumber the Name.
     */
    public void setTaxIdentificationNumber(Name taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    /**
     * Missing description at method setTaxIdentificationNumber.
     *
     * @param taxIdentificationNumber the String.
     */
    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        if ((this.taxIdentificationNumber == null)) {
            if ((taxIdentificationNumber == null)) {
                return;
            }
            this.taxIdentificationNumber = new Name();
        }
        this.taxIdentificationNumber.setValue(taxIdentificationNumber);
    }

    /**
     * Missing description at method getHealthInsuranceCompany.
     *
     * @return the Name.
     */
    public Name getHealthInsuranceCompany() {
        return this.healthInsuranceCompany;
    }

    /**
     * Missing description at method setHealthInsuranceCompany.
     *
     * @param healthInsuranceCompany the Name.
     */
    public void setHealthInsuranceCompany(Name healthInsuranceCompany) {
        this.healthInsuranceCompany = healthInsuranceCompany;
    }

    /**
     * Missing description at method setHealthInsuranceCompany.
     *
     * @param healthInsuranceCompany the String.
     */
    public void setHealthInsuranceCompany(String healthInsuranceCompany) {
        if ((this.healthInsuranceCompany == null)) {
            if ((healthInsuranceCompany == null)) {
                return;
            }
            this.healthInsuranceCompany = new Name();
        }
        this.healthInsuranceCompany.setValue(healthInsuranceCompany);
    }

    /**
     * Missing description at method getFinanceOffice.
     *
     * @return the Name.
     */
    public Name getFinanceOffice() {
        return this.financeOffice;
    }

    /**
     * Missing description at method setFinanceOffice.
     *
     * @param financeOffice the Name.
     */
    public void setFinanceOffice(Name financeOffice) {
        this.financeOffice = financeOffice;
    }

    /**
     * Missing description at method setFinanceOffice.
     *
     * @param financeOffice the String.
     */
    public void setFinanceOffice(String financeOffice) {
        if ((this.financeOffice == null)) {
            if ((financeOffice == null)) {
                return;
            }
            this.financeOffice = new Name();
        }
        this.financeOffice.setValue(financeOffice);
    }

    /**
     * Missing description at method setTaxCategory.
     *
     * @param taxCategory the Code.
     */
    public void setTaxCategory(Code taxCategory) {
        this.taxCategory = taxCategory;
        if ((taxCategory != null)) {
            this.setTaxCategoryRefId(taxCategory.getId());
        } else {
            this.setTaxCategoryRefId(null);
        }
    }

    /**
     * Missing description at method getTaxCategory.
     *
     * @return the Code.
     */
    public Code getTaxCategory() {
        return this.taxCategory;
    }

    /**
     * Getter for the TaxCategoryRefId.
     *
     * @return the Long.
     */
    public Long getTaxCategoryRefId() {
        return this.taxCategoryRefId;
    }

    /**
     * Setter for the TaxCategoryRefId.
     *
     * @param taxCategoryRefId the Long.
     */
    public void setTaxCategoryRefId(Long taxCategoryRefId) {
        this.taxCategoryRefId = taxCategoryRefId;
    }

    /**
     * Missing description at method getTaxFactor.
     *
     * @return the Name.
     */
    public Name getTaxFactor() {
        return this.taxFactor;
    }

    /**
     * Missing description at method setTaxFactor.
     *
     * @param taxFactor the Name.
     */
    public void setTaxFactor(Name taxFactor) {
        this.taxFactor = taxFactor;
    }

    /**
     * Missing description at method setTaxFactor.
     *
     * @param taxFactor the String.
     */
    public void setTaxFactor(String taxFactor) {
        if ((this.taxFactor == null)) {
            if ((taxFactor == null)) {
                return;
            }
            this.taxFactor = new Name();
        }
        this.taxFactor.setValue(taxFactor);
    }

    /**
     * Missing description at method getChildAllowance.
     *
     * @return the Name.
     */
    public Name getChildAllowance() {
        return this.childAllowance;
    }

    /**
     * Missing description at method setChildAllowance.
     *
     * @param childAllowance the Name.
     */
    public void setChildAllowance(Name childAllowance) {
        this.childAllowance = childAllowance;
    }

    /**
     * Missing description at method setChildAllowance.
     *
     * @param childAllowance the String.
     */
    public void setChildAllowance(String childAllowance) {
        if ((this.childAllowance == null)) {
            if ((childAllowance == null)) {
                return;
            }
            this.childAllowance = new Name();
        }
        this.childAllowance.setValue(childAllowance);
    }

    /**
     * Missing description at method getFixDeductions.
     *
     * @return the Name.
     */
    public Name getFixDeductions() {
        return this.fixDeductions;
    }

    /**
     * Missing description at method setFixDeductions.
     *
     * @param fixDeductions the Name.
     */
    public void setFixDeductions(Name fixDeductions) {
        this.fixDeductions = fixDeductions;
    }

    /**
     * Missing description at method setFixDeductions.
     *
     * @param fixDeductions the String.
     */
    public void setFixDeductions(String fixDeductions) {
        if ((this.fixDeductions == null)) {
            if ((fixDeductions == null)) {
                return;
            }
            this.fixDeductions = new Name();
        }
        this.fixDeductions.setValue(fixDeductions);
    }

    /**
     * Missing description at method setCollectiveAgreement.
     *
     * @param collectiveAgreement the Code.
     */
    public void setCollectiveAgreement(Code collectiveAgreement) {
        this.collectiveAgreement = collectiveAgreement;
        if ((collectiveAgreement != null)) {
            this.setCollectiveAgreementRefId(collectiveAgreement.getId());
        } else {
            this.setCollectiveAgreementRefId(null);
        }
    }

    /**
     * Missing description at method getCollectiveAgreement.
     *
     * @return the Code.
     */
    public Code getCollectiveAgreement() {
        return this.collectiveAgreement;
    }

    /**
     * Getter for the CollectiveAgreementRefId.
     *
     * @return the Long.
     */
    public Long getCollectiveAgreementRefId() {
        return this.collectiveAgreementRefId;
    }

    /**
     * Setter for the CollectiveAgreementRefId.
     *
     * @param collectiveAgreementRefId the Long.
     */
    public void setCollectiveAgreementRefId(Long collectiveAgreementRefId) {
        this.collectiveAgreementRefId = collectiveAgreementRefId;
    }

    /**
     * Missing description at method setPayGrade.
     *
     * @param payGrade the Code.
     */
    public void setPayGrade(Code payGrade) {
        this.payGrade = payGrade;
        if ((payGrade != null)) {
            this.setPayGradeRefId(payGrade.getId());
        } else {
            this.setPayGradeRefId(null);
        }
    }

    /**
     * Missing description at method getPayGrade.
     *
     * @return the Code.
     */
    public Code getPayGrade() {
        return this.payGrade;
    }

    /**
     * Getter for the PayGradeRefId.
     *
     * @return the Long.
     */
    public Long getPayGradeRefId() {
        return this.payGradeRefId;
    }

    /**
     * Setter for the PayGradeRefId.
     *
     * @param payGradeRefId the Long.
     */
    public void setPayGradeRefId(Long payGradeRefId) {
        this.payGradeRefId = payGradeRefId;
    }

    /**
     * Missing description at method setRegionCode.
     *
     * @param regionCode the Code.
     */
    public void setRegionCode(Code regionCode) {
        this.regionCode = regionCode;
        if ((regionCode != null)) {
            this.setRegionCodeRefId(regionCode.getId());
        } else {
            this.setRegionCodeRefId(null);
        }
    }

    /**
     * Missing description at method getRegionCode.
     *
     * @return the Code.
     */
    public Code getRegionCode() {
        return this.regionCode;
    }

    /**
     * Getter for the RegionCodeRefId.
     *
     * @return the Long.
     */
    public Long getRegionCodeRefId() {
        return this.regionCodeRefId;
    }

    /**
     * Setter for the RegionCodeRefId.
     *
     * @param regionCodeRefId the Long.
     */
    public void setRegionCodeRefId(Long regionCodeRefId) {
        this.regionCodeRefId = regionCodeRefId;
    }

    /**
     * Missing description at method getGeneralPayBonus.
     *
     * @return the Amount.
     */
    public Amount getGeneralPayBonus() {
        return this.generalPayBonus;
    }

    /**
     * Missing description at method setGeneralPayBonus.
     *
     * @param generalPayBonus the Amount.
     */
    public void setGeneralPayBonus(Amount generalPayBonus) {
        this.generalPayBonus = generalPayBonus;
    }

    /**
     * Missing description at method setGeneralPayBonus.
     *
     * @param generalPayBonus the java.math.BigDecimal.
     */
    public void setGeneralPayBonus(java.math.BigDecimal generalPayBonus) {
        if ((this.generalPayBonus == null)) {
            if ((generalPayBonus == null)) {
                return;
            }
            this.generalPayBonus = new Amount();
        }
        this.generalPayBonus.setValue(generalPayBonus);
    }

    /**
     * Missing description at method getAllowanceGuarantee.
     *
     * @return the Amount.
     */
    public Amount getAllowanceGuarantee() {
        return this.allowanceGuarantee;
    }

    /**
     * Missing description at method setAllowanceGuarantee.
     *
     * @param allowanceGuarantee the Amount.
     */
    public void setAllowanceGuarantee(Amount allowanceGuarantee) {
        this.allowanceGuarantee = allowanceGuarantee;
    }

    /**
     * Missing description at method setAllowanceGuarantee.
     *
     * @param allowanceGuarantee the java.math.BigDecimal.
     */
    public void setAllowanceGuarantee(java.math.BigDecimal allowanceGuarantee) {
        if ((this.allowanceGuarantee == null)) {
            if ((allowanceGuarantee == null)) {
                return;
            }
            this.allowanceGuarantee = new Amount();
        }
        this.allowanceGuarantee.setValue(allowanceGuarantee);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(EmployeeAccountingData.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(EmployeeAccountingData.class).getAllProperties();
    }

    /**
     * Getter for the TaxCategoryCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getTaxCategoryCodePath() {
        return new CodePath(TAXCATEGORY_CODEPATH);
    }

    /**
     * Getter for the CollectiveAgreementCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCollectiveAgreementCodePath() {
        return new CodePath(COLLECTIVEAGREEMENT_CODEPATH);
    }

    /**
     * Getter for the PayGradeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getPayGradeCodePath() {
        return new CodePath(PAYGRADE_CODEPATH);
    }

    /**
     * Getter for the RegionCodeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getRegionCodeCodePath() {
        return new CodePath(REGIONCODE_CODEPATH);
    }
}
