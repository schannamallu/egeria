/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.accessservices.discoveryengine.rest;

import com.fasterxml.jackson.annotation.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * DiscoveryEngineOMASAPIRequestBody provides a common header for Discovery Engine OMAS request bodies for its REST API.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = NewDiscoveryEngineRequestBody.class,           name = "NewDiscoveryEngineRequestBody"),
                @JsonSubTypes.Type(value = NewDiscoveryServiceRequestBody.class,          name = "NewDiscoveryServiceRequestBody"),
                @JsonSubTypes.Type(value = DiscoveryServiceRegistrationRequestBody.class, name = "DiscoveryServiceRegistrationRequestBody"),
                @JsonSubTypes.Type(value = DeleteRequestBody.class,                       name = "DeleteRequestBody"),
                @JsonSubTypes.Type(value = NullRequestBody.class,                         name = "NullRequestBody")
        })
public abstract class DiscoveryEngineOMASAPIRequestBody implements java.io.Serializable
{
    private static final long    serialVersionUID = 1L;


    /**
     * Default constructor
     */
    public DiscoveryEngineOMASAPIRequestBody()
    {
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public DiscoveryEngineOMASAPIRequestBody(DiscoveryEngineOMASAPIRequestBody template)
    {
    }


    /**
     * JSON-like toString
     *
     * @return string containing the class name
     */
    @Override
    public String toString()
    {
        return "DiscoveryEngineOMASAPIRequestBody{}";
    }
}
