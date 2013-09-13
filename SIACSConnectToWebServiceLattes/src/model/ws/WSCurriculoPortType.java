/**
 * WSCurriculoPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model.ws;

public interface WSCurriculoPortType extends java.rmi.Remote {
    public byte[] getCurriculoCompactado(java.lang.String id) throws java.rmi.RemoteException;
    public byte[] getCurriculoCompactadoPorUsuario(java.lang.String id, java.lang.String login) throws java.rmi.RemoteException;
    public java.lang.String getDataAtualizacaoCV(java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String getDataAtualizacaoCVPorUsuario(java.lang.String id, java.lang.String login) throws java.rmi.RemoteException;
    public java.lang.String getIdentificadorCNPq(java.lang.String cpf, java.lang.String nomeCompleto, java.lang.String dataNascimento) throws java.rmi.RemoteException;
    public java.lang.String getIdentificadorCNPqPorUsuario(java.lang.String cpf, java.lang.String nomeCompleto, java.lang.String dataNascimento, java.lang.String login) throws java.rmi.RemoteException;
    public java.lang.String getOcorrenciaCV(java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String getOcorrenciaCVPorUsuario(java.lang.String id, java.lang.String login) throws java.rmi.RemoteException;
}
