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
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * EmployeeRole
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class EmployeeRole extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m1,1;" };

    public static final String ROLE = "role";

    public static final String ROLETYPE = "roleType";

    public static final String MATURITYTYPE = "maturityType";

    private Code role;

    private Long roleRefId;

    protected static final String ROLE_CODEPATH = "nabucco.business.person.employeerole.role";

    private Code roleType;

    private Long roleTypeRefId;

    protected static final String ROLETYPE_CODEPATH = "nabucco.business.person.employeerole.roletype";

    private Code maturityType;

    private Long maturityTypeRefId;

    protected static final String MATURITYTYPE_CODEPATH = "nabucco.business.person.employeerole.maturitytype";

    /** Constructs a new EmployeeRole instance. */
    public EmployeeRole() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the EmployeeRole.
     */
    protected void cloneObject(EmployeeRole clone) {
        super.cloneObject(clone);
        if ((this.getRole() != null)) {
            clone.setRole(this.getRole().cloneObject());
        }
        if ((this.getRoleRefId() != null)) {
            clone.setRoleRefId(this.getRoleRefId());
        }
        if ((this.getRoleType() != null)) {
            clone.setRoleType(this.getRoleType().cloneObject());
        }
        if ((this.getRoleTypeRefId() != null)) {
            clone.setRoleTypeRefId(this.getRoleTypeRefId());
        }
        if ((this.getMaturityType() != null)) {
            clone.setMaturityType(this.getMaturityType().cloneObject());
        }
        if ((this.getMaturityTypeRefId() != null)) {
            clone.setMaturityTypeRefId(this.getMaturityTypeRefId());
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
        propertyMap.put(ROLE, PropertyDescriptorSupport.createDatatype(ROLE, Code.class, 3, PROPERTY_CONSTRAINTS[0],
                false, PropertyAssociationType.COMPONENT, ROLE_CODEPATH));
        propertyMap.put(ROLETYPE, PropertyDescriptorSupport.createDatatype(ROLETYPE, Code.class, 4,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, ROLETYPE_CODEPATH));
        propertyMap.put(MATURITYTYPE, PropertyDescriptorSupport.createDatatype(MATURITYTYPE, Code.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, MATURITYTYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(EmployeeRole.getPropertyDescriptor(ROLE), this.getRole(), this.roleRefId));
        properties.add(super.createProperty(EmployeeRole.getPropertyDescriptor(ROLETYPE), this.getRoleType(),
                this.roleTypeRefId));
        properties.add(super.createProperty(EmployeeRole.getPropertyDescriptor(MATURITYTYPE), this.getMaturityType(),
                this.maturityTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ROLE) && (property.getType() == Code.class))) {
            this.setRole(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ROLETYPE) && (property.getType() == Code.class))) {
            this.setRoleType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MATURITYTYPE) && (property.getType() == Code.class))) {
            this.setMaturityType(((Code) property.getInstance()));
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
        final EmployeeRole other = ((EmployeeRole) obj);
        if ((this.role == null)) {
            if ((other.role != null))
                return false;
        } else if ((!this.role.equals(other.role)))
            return false;
        if ((this.roleRefId == null)) {
            if ((other.roleRefId != null))
                return false;
        } else if ((!this.roleRefId.equals(other.roleRefId)))
            return false;
        if ((this.roleType == null)) {
            if ((other.roleType != null))
                return false;
        } else if ((!this.roleType.equals(other.roleType)))
            return false;
        if ((this.roleTypeRefId == null)) {
            if ((other.roleTypeRefId != null))
                return false;
        } else if ((!this.roleTypeRefId.equals(other.roleTypeRefId)))
            return false;
        if ((this.maturityType == null)) {
            if ((other.maturityType != null))
                return false;
        } else if ((!this.maturityType.equals(other.maturityType)))
            return false;
        if ((this.maturityTypeRefId == null)) {
            if ((other.maturityTypeRefId != null))
                return false;
        } else if ((!this.maturityTypeRefId.equals(other.maturityTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.role == null) ? 0 : this.role.hashCode()));
        result = ((PRIME * result) + ((this.roleRefId == null) ? 0 : this.roleRefId.hashCode()));
        result = ((PRIME * result) + ((this.roleType == null) ? 0 : this.roleType.hashCode()));
        result = ((PRIME * result) + ((this.roleTypeRefId == null) ? 0 : this.roleTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.maturityType == null) ? 0 : this.maturityType.hashCode()));
        result = ((PRIME * result) + ((this.maturityTypeRefId == null) ? 0 : this.maturityTypeRefId.hashCode()));
        return result;
    }

    @Override
    public EmployeeRole cloneObject() {
        EmployeeRole clone = new EmployeeRole();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setRole.
     *
     * @param role the Code.
     */
    public void setRole(Code role) {
        this.role = role;
        if ((role != null)) {
            this.setRoleRefId(role.getId());
        } else {
            this.setRoleRefId(null);
        }
    }

    /**
     * Missing description at method getRole.
     *
     * @return the Code.
     */
    public Code getRole() {
        return this.role;
    }

    /**
     * Getter for the RoleRefId.
     *
     * @return the Long.
     */
    public Long getRoleRefId() {
        return this.roleRefId;
    }

    /**
     * Setter for the RoleRefId.
     *
     * @param roleRefId the Long.
     */
    public void setRoleRefId(Long roleRefId) {
        this.roleRefId = roleRefId;
    }

    /**
     * Missing description at method setRoleType.
     *
     * @param roleType the Code.
     */
    public void setRoleType(Code roleType) {
        this.roleType = roleType;
        if ((roleType != null)) {
            this.setRoleTypeRefId(roleType.getId());
        } else {
            this.setRoleTypeRefId(null);
        }
    }

    /**
     * Missing description at method getRoleType.
     *
     * @return the Code.
     */
    public Code getRoleType() {
        return this.roleType;
    }

    /**
     * Getter for the RoleTypeRefId.
     *
     * @return the Long.
     */
    public Long getRoleTypeRefId() {
        return this.roleTypeRefId;
    }

    /**
     * Setter for the RoleTypeRefId.
     *
     * @param roleTypeRefId the Long.
     */
    public void setRoleTypeRefId(Long roleTypeRefId) {
        this.roleTypeRefId = roleTypeRefId;
    }

    /**
     * Missing description at method setMaturityType.
     *
     * @param maturityType the Code.
     */
    public void setMaturityType(Code maturityType) {
        this.maturityType = maturityType;
        if ((maturityType != null)) {
            this.setMaturityTypeRefId(maturityType.getId());
        } else {
            this.setMaturityTypeRefId(null);
        }
    }

    /**
     * Missing description at method getMaturityType.
     *
     * @return the Code.
     */
    public Code getMaturityType() {
        return this.maturityType;
    }

    /**
     * Getter for the MaturityTypeRefId.
     *
     * @return the Long.
     */
    public Long getMaturityTypeRefId() {
        return this.maturityTypeRefId;
    }

    /**
     * Setter for the MaturityTypeRefId.
     *
     * @param maturityTypeRefId the Long.
     */
    public void setMaturityTypeRefId(Long maturityTypeRefId) {
        this.maturityTypeRefId = maturityTypeRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(EmployeeRole.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(EmployeeRole.class).getAllProperties();
    }

    /**
     * Getter for the RoleCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getRoleCodePath() {
        return new CodePath(ROLE_CODEPATH);
    }

    /**
     * Getter for the RoleTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getRoleTypeCodePath() {
        return new CodePath(ROLETYPE_CODEPATH);
    }

    /**
     * Getter for the MaturityTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getMaturityTypeCodePath() {
        return new CodePath(MATURITYTYPE_CODEPATH);
    }
}
