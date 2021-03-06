/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.discoveryserver.server;

import java.util.HashMap;
import java.util.Map;

/**
 * DiscoveryServerInstanceMap provides the mapping between server name and the Java instances of the active services
 * for a server.
 *
 * The Java service instances for a server are defined by the configuration document.  When the server is initialized
 * the configuration document is read and the appropriate services are initialized.
 *
 * It is possible that multiple OMAG servers are initialized in a since JVM/process.   The role of this class is to
 * keep references to the service instances for each server so that when a request is made to a specific server,
 * it can be routed to the appropriate service instance.
 */
public class DiscoveryServerInstanceMap
{
    private static Map<String, DiscoveryServerInstance> instanceMap = new HashMap<>();



    /**
     * Add a new server instance to the server map.
     *
     * @param serverName name of the server
     * @param instance instance object
     */
    private static synchronized void  setNewInstanceForJVM(String                  serverName,
                                                           DiscoveryServerInstance instance)
    {
        instanceMap.put(serverName, instance);
    }


    /**
     * Return the instance for this server.
     *
     * @param serverName name of the server
     * @return DiscoveryServerInstance object
     */
    private static synchronized DiscoveryServerInstance getInstanceForJVM(String    serverName)
    {
        DiscoveryServerInstance instance = instanceMap.get(serverName);

        return instance;
    }


    /**
     * Remove the instance for this server.
     *
     * @param serverName name of the server
     */
    private static synchronized void removeInstanceForJVM(String   serverName)
    {
        instanceMap.remove(serverName);
    }


    /**
     * Constructor
     */
    public DiscoveryServerInstanceMap()
    {
    }


    /**
     * Add a new server instance to the server map.
     *
     * @param serverName name of the server
     * @param instance instance object
     */
    public void  setNewInstance(String                  serverName,
                                DiscoveryServerInstance instance)
    {
        DiscoveryServerInstanceMap.setNewInstanceForJVM(serverName, instance);
    }


    /**
     * Return the instance for this server.
     *
     * @param serverName name of the server
     * @return OMRSRepositoryServicesInstance object
     */
    public DiscoveryServerInstance getInstance(String    serverName)
    {
        return DiscoveryServerInstanceMap.getInstanceForJVM(serverName);
    }


    /**
     * Remove the instance for this server.
     *
     * @param serverName name of the server
     */
    public void removeInstance(String   serverName)
    {
        DiscoveryServerInstanceMap.removeInstanceForJVM(serverName);
    }
}
