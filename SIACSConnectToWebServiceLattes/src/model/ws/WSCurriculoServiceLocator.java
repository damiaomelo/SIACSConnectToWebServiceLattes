/**
 * WSCurriculoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model.ws;

public class WSCurriculoServiceLocator extends org.apache.axis.client.Service implements model.ws.WSCurriculoService {

    public WSCurriculoServiceLocator() {
    }


    public WSCurriculoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSCurriculoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSCurriculoPort
    private java.lang.String WSCurriculoPort_address = "http://10.0.1.48:8080/srvcurriculo/WSCurriculo";

    public java.lang.String getWSCurriculoPortAddress() {
        return WSCurriculoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSCurriculoPortWSDDServiceName = "WSCurriculoPort";

    public java.lang.String getWSCurriculoPortWSDDServiceName() {
        return WSCurriculoPortWSDDServiceName;
    }

    public void setWSCurriculoPortWSDDServiceName(java.lang.String name) {
        WSCurriculoPortWSDDServiceName = name;
    }

    public model.ws.WSCurriculoPortType getWSCurriculoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSCurriculoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSCurriculoPort(endpoint);
    }

    public model.ws.WSCurriculoPortType getWSCurriculoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            model.ws.WSCurriculoBindingStub _stub = new model.ws.WSCurriculoBindingStub(portAddress, this);
            _stub.setPortName(getWSCurriculoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSCurriculoPortEndpointAddress(java.lang.String address) {
        WSCurriculoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (model.ws.WSCurriculoPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                model.ws.WSCurriculoBindingStub _stub = new model.ws.WSCurriculoBindingStub(new java.net.URL(WSCurriculoPort_address), this);
                _stub.setPortName(getWSCurriculoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSCurriculoPort".equals(inputPortName)) {
            return getWSCurriculoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.servico.repositorio.cnpq.br/", "WSCurriculo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.servico.repositorio.cnpq.br/", "WSCurriculoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSCurriculoPort".equals(portName)) {
            setWSCurriculoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
