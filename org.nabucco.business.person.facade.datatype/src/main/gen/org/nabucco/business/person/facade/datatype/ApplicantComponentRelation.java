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

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * ApplicantComponentRelation
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-05-24
 */
public class ApplicantComponentRelation extends ComponentRelation<Applicant> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new ApplicantComponentRelation instance. */
    protected ApplicantComponentRelation() {
        super();
    }

    /**
     * Constructs a new ApplicantComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public ApplicantComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the Applicant.
     */
    public Applicant getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the Applicant.
     */
    public void setTarget(Applicant target) {
        super.setTarget(target);
    }

    @Override
    public ApplicantComponentRelation cloneObject() {
        ApplicantComponentRelation clone = new ApplicantComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
