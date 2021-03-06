/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.subjectarea;

/**
 * The SubjectArea Open Metadata Access Service (OMAS).
 */
public interface SubjectArea
{
    /**
     * Get the subject area glossary API class - use this class to issue glossary calls.
     * @return subject area glossary API class
     */
   SubjectAreaGlossary getSubjectAreaGlossary();
    /**
     * Get the subject area term API class - use this class to issue term calls.
     * @return subject area term API class
     */
   SubjectAreaTerm getSubjectAreaTerm();
    /**
     * Get the subject area category API class - use this class to issue category calls.
     * @return subject area category API class
     */
   SubjectAreaCategory getSubjectAreaCategory();
    /**
     * Get the subject area relationship API class - use this class to issue relationship calls.
     * @return subject area relationship API class
     */
   SubjectAreaRelationship getSubjectAreaRelationship();
    /**
     * Get the subject area graph API class - use this class to issue graph calls.
     * @return subject area graph API class
     */
   SubjectAreaGraph getSubjectAreaGraph();
    /**
     * Server Name under which this request is performed, this is used in multi tenanting to identify the tenant
     * @return serverName name of the server
     */
    String getServerName();
    /**
     * Base url used to issue Rest calls
     * @return base url
     */
    String getOmasServerUrl();
}