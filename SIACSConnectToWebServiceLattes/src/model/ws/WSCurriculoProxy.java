package model.ws;

public class WSCurriculoProxy implements model.ws.WSCurriculoPortType {
  private String _endpoint = null;
  private model.ws.WSCurriculoPortType wSCurriculoPortType = null;
  
  public WSCurriculoProxy() {
    _initWSCurriculoProxy();
  }
  
  public WSCurriculoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSCurriculoProxy();
  }
  
  private void _initWSCurriculoProxy() {
    try {
      wSCurriculoPortType = (new model.ws.WSCurriculoServiceLocator()).getWSCurriculoPort();
      if (wSCurriculoPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSCurriculoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSCurriculoPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSCurriculoPortType != null)
      ((javax.xml.rpc.Stub)wSCurriculoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public model.ws.WSCurriculoPortType getWSCurriculo_PortType() {
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType;
  }
  
  public byte[] getCurriculoCompactado(java.lang.String id) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getCurriculoCompactado(id);
  }
  
  public byte[] getCurriculoCompactadoPorUsuario(java.lang.String id, java.lang.String login) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getCurriculoCompactadoPorUsuario(id, login);
  }
  
  public java.lang.String getDataAtualizacaoCV(java.lang.String id) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getDataAtualizacaoCV(id);
  }
  
  public java.lang.String getDataAtualizacaoCVPorUsuario(java.lang.String id, java.lang.String login) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getDataAtualizacaoCVPorUsuario(id, login);
  }
  
  public java.lang.String getIdentificadorCNPq(java.lang.String cpf, java.lang.String nomeCompleto, java.lang.String dataNascimento) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getIdentificadorCNPq(cpf, nomeCompleto, dataNascimento);
  }
  
  public java.lang.String getIdentificadorCNPqPorUsuario(java.lang.String cpf, java.lang.String nomeCompleto, java.lang.String dataNascimento, java.lang.String login) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getIdentificadorCNPqPorUsuario(cpf, nomeCompleto, dataNascimento, login);
  }
  
  public java.lang.String getOcorrenciaCV(java.lang.String id) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getOcorrenciaCV(id);
  }
  
  public java.lang.String getOcorrenciaCVPorUsuario(java.lang.String id, java.lang.String login) throws java.rmi.RemoteException{
    if (wSCurriculoPortType == null)
      _initWSCurriculoProxy();
    return wSCurriculoPortType.getOcorrenciaCVPorUsuario(id, login);
  }
  
  
}