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
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * BankAccount
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-06-14
 */
public class BankAccount extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m0,1;", "l0,255;u0,n;m0,1;",
            "l0,255;u0,n;p[0-9];m0,1;", "l0,255;u0,n;p[0-9];m0,1;", "l0,n;u0,n;m0,1;", "l0,255;u0,n;p[0-9];m0,1;",
            "l0,255;u0,n;p[0-9];m0,1;" };

    public static final String INSTITUTENAME = "instituteName";

    public static final String ACCOUNTHOLDER = "accountHolder";

    public static final String INSTITUTENUMBER = "instituteNumber";

    public static final String ACCOUNTNUMBER = "accountNumber";

    public static final String IBANBICMODE = "ibanBicMode";

    public static final String IBAN = "iban";

    public static final String BIC = "bic";

    private Name instituteName;

    private Name accountHolder;

    private Name instituteNumber;

    private Name accountNumber;

    private Flag ibanBicMode;

    private Name iban;

    private Name bic;

    /** Constructs a new BankAccount instance. */
    public BankAccount() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the BankAccount.
     */
    protected void cloneObject(BankAccount clone) {
        super.cloneObject(clone);
        if ((this.getInstituteName() != null)) {
            clone.setInstituteName(this.getInstituteName().cloneObject());
        }
        if ((this.getAccountHolder() != null)) {
            clone.setAccountHolder(this.getAccountHolder().cloneObject());
        }
        if ((this.getInstituteNumber() != null)) {
            clone.setInstituteNumber(this.getInstituteNumber().cloneObject());
        }
        if ((this.getAccountNumber() != null)) {
            clone.setAccountNumber(this.getAccountNumber().cloneObject());
        }
        if ((this.getIbanBicMode() != null)) {
            clone.setIbanBicMode(this.getIbanBicMode().cloneObject());
        }
        if ((this.getIban() != null)) {
            clone.setIban(this.getIban().cloneObject());
        }
        if ((this.getBic() != null)) {
            clone.setBic(this.getBic().cloneObject());
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
        propertyMap.put(INSTITUTENAME,
                PropertyDescriptorSupport.createBasetype(INSTITUTENAME, Name.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ACCOUNTHOLDER,
                PropertyDescriptorSupport.createBasetype(ACCOUNTHOLDER, Name.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(INSTITUTENUMBER, PropertyDescriptorSupport.createBasetype(INSTITUTENUMBER, Name.class, 5,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(ACCOUNTNUMBER,
                PropertyDescriptorSupport.createBasetype(ACCOUNTNUMBER, Name.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(IBANBICMODE,
                PropertyDescriptorSupport.createBasetype(IBANBICMODE, Flag.class, 7, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(IBAN,
                PropertyDescriptorSupport.createBasetype(IBAN, Name.class, 8, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(BIC,
                PropertyDescriptorSupport.createBasetype(BIC, Name.class, 9, PROPERTY_CONSTRAINTS[6], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties
                .add(super.createProperty(BankAccount.getPropertyDescriptor(INSTITUTENAME), this.instituteName, null));
        properties
                .add(super.createProperty(BankAccount.getPropertyDescriptor(ACCOUNTHOLDER), this.accountHolder, null));
        properties.add(super.createProperty(BankAccount.getPropertyDescriptor(INSTITUTENUMBER), this.instituteNumber,
                null));
        properties
                .add(super.createProperty(BankAccount.getPropertyDescriptor(ACCOUNTNUMBER), this.accountNumber, null));
        properties.add(super.createProperty(BankAccount.getPropertyDescriptor(IBANBICMODE), this.ibanBicMode, null));
        properties.add(super.createProperty(BankAccount.getPropertyDescriptor(IBAN), this.iban, null));
        properties.add(super.createProperty(BankAccount.getPropertyDescriptor(BIC), this.bic, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(INSTITUTENAME) && (property.getType() == Name.class))) {
            this.setInstituteName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ACCOUNTHOLDER) && (property.getType() == Name.class))) {
            this.setAccountHolder(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(INSTITUTENUMBER) && (property.getType() == Name.class))) {
            this.setInstituteNumber(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ACCOUNTNUMBER) && (property.getType() == Name.class))) {
            this.setAccountNumber(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(IBANBICMODE) && (property.getType() == Flag.class))) {
            this.setIbanBicMode(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(IBAN) && (property.getType() == Name.class))) {
            this.setIban(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(BIC) && (property.getType() == Name.class))) {
            this.setBic(((Name) property.getInstance()));
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
        final BankAccount other = ((BankAccount) obj);
        if ((this.instituteName == null)) {
            if ((other.instituteName != null))
                return false;
        } else if ((!this.instituteName.equals(other.instituteName)))
            return false;
        if ((this.accountHolder == null)) {
            if ((other.accountHolder != null))
                return false;
        } else if ((!this.accountHolder.equals(other.accountHolder)))
            return false;
        if ((this.instituteNumber == null)) {
            if ((other.instituteNumber != null))
                return false;
        } else if ((!this.instituteNumber.equals(other.instituteNumber)))
            return false;
        if ((this.accountNumber == null)) {
            if ((other.accountNumber != null))
                return false;
        } else if ((!this.accountNumber.equals(other.accountNumber)))
            return false;
        if ((this.ibanBicMode == null)) {
            if ((other.ibanBicMode != null))
                return false;
        } else if ((!this.ibanBicMode.equals(other.ibanBicMode)))
            return false;
        if ((this.iban == null)) {
            if ((other.iban != null))
                return false;
        } else if ((!this.iban.equals(other.iban)))
            return false;
        if ((this.bic == null)) {
            if ((other.bic != null))
                return false;
        } else if ((!this.bic.equals(other.bic)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.instituteName == null) ? 0 : this.instituteName.hashCode()));
        result = ((PRIME * result) + ((this.accountHolder == null) ? 0 : this.accountHolder.hashCode()));
        result = ((PRIME * result) + ((this.instituteNumber == null) ? 0 : this.instituteNumber.hashCode()));
        result = ((PRIME * result) + ((this.accountNumber == null) ? 0 : this.accountNumber.hashCode()));
        result = ((PRIME * result) + ((this.ibanBicMode == null) ? 0 : this.ibanBicMode.hashCode()));
        result = ((PRIME * result) + ((this.iban == null) ? 0 : this.iban.hashCode()));
        result = ((PRIME * result) + ((this.bic == null) ? 0 : this.bic.hashCode()));
        return result;
    }

    @Override
    public BankAccount cloneObject() {
        BankAccount clone = new BankAccount();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getInstituteName.
     *
     * @return the Name.
     */
    public Name getInstituteName() {
        return this.instituteName;
    }

    /**
     * Missing description at method setInstituteName.
     *
     * @param instituteName the Name.
     */
    public void setInstituteName(Name instituteName) {
        this.instituteName = instituteName;
    }

    /**
     * Missing description at method setInstituteName.
     *
     * @param instituteName the String.
     */
    public void setInstituteName(String instituteName) {
        if ((this.instituteName == null)) {
            if ((instituteName == null)) {
                return;
            }
            this.instituteName = new Name();
        }
        this.instituteName.setValue(instituteName);
    }

    /**
     * Missing description at method getAccountHolder.
     *
     * @return the Name.
     */
    public Name getAccountHolder() {
        return this.accountHolder;
    }

    /**
     * Missing description at method setAccountHolder.
     *
     * @param accountHolder the Name.
     */
    public void setAccountHolder(Name accountHolder) {
        this.accountHolder = accountHolder;
    }

    /**
     * Missing description at method setAccountHolder.
     *
     * @param accountHolder the String.
     */
    public void setAccountHolder(String accountHolder) {
        if ((this.accountHolder == null)) {
            if ((accountHolder == null)) {
                return;
            }
            this.accountHolder = new Name();
        }
        this.accountHolder.setValue(accountHolder);
    }

    /**
     * Missing description at method getInstituteNumber.
     *
     * @return the Name.
     */
    public Name getInstituteNumber() {
        return this.instituteNumber;
    }

    /**
     * Missing description at method setInstituteNumber.
     *
     * @param instituteNumber the Name.
     */
    public void setInstituteNumber(Name instituteNumber) {
        this.instituteNumber = instituteNumber;
    }

    /**
     * Missing description at method setInstituteNumber.
     *
     * @param instituteNumber the String.
     */
    public void setInstituteNumber(String instituteNumber) {
        if ((this.instituteNumber == null)) {
            if ((instituteNumber == null)) {
                return;
            }
            this.instituteNumber = new Name();
        }
        this.instituteNumber.setValue(instituteNumber);
    }

    /**
     * Missing description at method getAccountNumber.
     *
     * @return the Name.
     */
    public Name getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Missing description at method setAccountNumber.
     *
     * @param accountNumber the Name.
     */
    public void setAccountNumber(Name accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Missing description at method setAccountNumber.
     *
     * @param accountNumber the String.
     */
    public void setAccountNumber(String accountNumber) {
        if ((this.accountNumber == null)) {
            if ((accountNumber == null)) {
                return;
            }
            this.accountNumber = new Name();
        }
        this.accountNumber.setValue(accountNumber);
    }

    /**
     * Missing description at method getIbanBicMode.
     *
     * @return the Flag.
     */
    public Flag getIbanBicMode() {
        return this.ibanBicMode;
    }

    /**
     * Missing description at method setIbanBicMode.
     *
     * @param ibanBicMode the Flag.
     */
    public void setIbanBicMode(Flag ibanBicMode) {
        this.ibanBicMode = ibanBicMode;
    }

    /**
     * Missing description at method setIbanBicMode.
     *
     * @param ibanBicMode the Boolean.
     */
    public void setIbanBicMode(Boolean ibanBicMode) {
        if ((this.ibanBicMode == null)) {
            if ((ibanBicMode == null)) {
                return;
            }
            this.ibanBicMode = new Flag();
        }
        this.ibanBicMode.setValue(ibanBicMode);
    }

    /**
     * Missing description at method getIban.
     *
     * @return the Name.
     */
    public Name getIban() {
        return this.iban;
    }

    /**
     * Missing description at method setIban.
     *
     * @param iban the Name.
     */
    public void setIban(Name iban) {
        this.iban = iban;
    }

    /**
     * Missing description at method setIban.
     *
     * @param iban the String.
     */
    public void setIban(String iban) {
        if ((this.iban == null)) {
            if ((iban == null)) {
                return;
            }
            this.iban = new Name();
        }
        this.iban.setValue(iban);
    }

    /**
     * Missing description at method getBic.
     *
     * @return the Name.
     */
    public Name getBic() {
        return this.bic;
    }

    /**
     * Missing description at method setBic.
     *
     * @param bic the Name.
     */
    public void setBic(Name bic) {
        this.bic = bic;
    }

    /**
     * Missing description at method setBic.
     *
     * @param bic the String.
     */
    public void setBic(String bic) {
        if ((this.bic == null)) {
            if ((bic == null)) {
                return;
            }
            this.bic = new Name();
        }
        this.bic.setValue(bic);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(BankAccount.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(BankAccount.class).getAllProperties();
    }
}
