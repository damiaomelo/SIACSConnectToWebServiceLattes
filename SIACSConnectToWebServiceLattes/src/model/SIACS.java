package model;

import model.business.CurriculoCompactado;
import model.business.CurriculoCompactadoPorUsuario;
import model.business.DataAtualizacaoCV;
import model.business.DataAtualizacaoCVPorUsuario;
import model.business.EndPoint;
import model.business.IdentificadorCNPq;
import model.business.IdentificadorCNPqPorUsuario;
import model.business.OcorrenciaCV;
import model.business.OcorrenciaCVPorUsuario;
import model.ws.ManagerWS;
import model.form.GetCurriculoCompactadoForm;
import model.form.GetCurriculoCompactadoPorUsuarioForm;
import model.form.GetDataAtualizacaoCVForm;
import model.form.GetDataAtualizacaoCVPorUsuarioForm;
import model.form.GetIdentificadorCNPqForm;
import model.form.GetIdentificadorCNPqPorUsuarioForm;
import model.form.GetOcorrenciaCVForm;
import model.form.GetOcorrenciaCVPorUsuarioForm;
import model.form.SetEndpointForm;
import model.util.CreateDirectoryAndInputFiles;
import model.util.Mensagem;

public class SIACS {
	
	private static SIACS singleton = null;
	public static SIACS getInstance() {
		Mensagem.setErroAtual(Mensagem.SEM_ERRO);
		if(singleton == null){
			return new SIACS();
		}
		return singleton;
	}
	
	private SIACS(){}
	
	ManagerWS managerWS = ManagerWS.getInstance();

	//#1
	public String getDataAtualizacaoCVPorUsuario(GetDataAtualizacaoCVPorUsuarioForm gDACVPUForm) {
		String resultado = null;
		if ( (gDACVPUForm.getId().trim().equals("")) && (gDACVPUForm.getLogin().trim().equals("")) ) {
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{		
			DataAtualizacaoCVPorUsuario d = new DataAtualizacaoCVPorUsuario();
			d.setId(gDACVPUForm.getId());
			d.setLogin(gDACVPUForm.getLogin());
			resultado = managerWS.getDataAtualizacaoCVPorUsuario(d); 
		}
		return resultado; 
	}

	//#2
	public String getDataAtualizacaoCV(GetDataAtualizacaoCVForm gDACVForm) {
		String resultado = null;
		if ( (gDACVForm.getId().trim().equals(""))) {
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{		
			DataAtualizacaoCV d = new DataAtualizacaoCV();
			d.setId(gDACVForm.getId());
			resultado = managerWS.getDataAtualizacaoCV(d); 
		}
		return resultado; 
	}
	
	//3
	public byte[] getCurriculoCompactadoPorUsuario(GetCurriculoCompactadoPorUsuarioForm gCCPorUsuarioForm) {
		byte[] resultado = null;
		if(gCCPorUsuarioForm.getId().trim().equals("") && (gCCPorUsuarioForm.getLogin().trim().equals("")) ){
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			CurriculoCompactadoPorUsuario c = new CurriculoCompactadoPorUsuario();
			c.setId(gCCPorUsuarioForm.getId());
			c.setLogin(gCCPorUsuarioForm.getLogin());
			resultado = managerWS.getCurriculoCompactadoPorUsuario(c);
		}
		return resultado;
	}
	
	//4
	public byte[] getCurriculoCompactado(GetCurriculoCompactadoForm gCCForm) {
		byte[] resultado = null;
		if(gCCForm.getId().trim().equals("")){
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			CurriculoCompactado c = new CurriculoCompactado();
			c.setId(gCCForm.getId());
			resultado = managerWS.getCurriculoCompactado(c);
		}
		return resultado;
	}
	
	//5
	public String getIdentificadorCNPqPorUsuario(GetIdentificadorCNPqPorUsuarioForm gICPUForm) {
		String resultado = null;
		if ( (gICPUForm.getCpf().trim().equals("")) && (gICPUForm.getNome_completo().trim().equals("")) && (gICPUForm.getDt_nascimento().trim().equals("")) && (gICPUForm.getLogin().trim().equals(""))) {
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			IdentificadorCNPqPorUsuario i = new IdentificadorCNPqPorUsuario();
			i.setCpf(gICPUForm.getCpf());
			i.setNome_completo(gICPUForm.getNome_completo());
			i.setDt_nascimento(gICPUForm.getDt_nascimento());
			i.setLogin(gICPUForm.getLogin());
			resultado = managerWS.getIdentificadorCNPQPorUsuario(i);
		}
		return resultado;
	}	
	
	//#6
	public String getIdentificadorCNPq(GetIdentificadorCNPqForm gICForm) {
		String resultado = null;
		if ( (gICForm.getCpf().trim().equals("")) && (gICForm.getNome_completo().trim().equals("")) && (gICForm.getDt_nascimento().trim().equals(""))){
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			IdentificadorCNPq i = new IdentificadorCNPq();
			i.setCpf(gICForm.getCpf());
			i.setNome_completo(gICForm.getNome_completo());
			i.setDt_nascimento(gICForm.getDt_nascimento());
			resultado = managerWS.getIdentificadorCNPQ(i);			
		}
		return resultado;
	}

	//7
	public String getOcorrenciaPorUsuarioCV(GetOcorrenciaCVPorUsuarioForm gOCVPorUsuarioForm) {
		String resultado = null;
		if(gOCVPorUsuarioForm.getId().trim().equals("") && gOCVPorUsuarioForm.getLogin().trim().equals("") ){
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			OcorrenciaCVPorUsuario o = new OcorrenciaCVPorUsuario(); 
			o.setId(gOCVPorUsuarioForm.getId());
			o.setLogin(gOCVPorUsuarioForm.getLogin());
			resultado = managerWS.getOcorrenciaCVPorUsuario(o);
		}
		return resultado;
	}	
	
	//8
	public String getOcorrenciaCV(GetOcorrenciaCVForm gOCVForm) {
		String resultado = null;
		if(gOCVForm.getId().trim().equals("")){
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			OcorrenciaCV o = new OcorrenciaCV(); 
			o.setId(gOCVForm.getId());
			resultado = managerWS.getOcorrenciaCV(o);
		}
		return resultado;
	}
	
	//#9
	public int setEndPoint(SetEndpointForm sEForm){
		if(sEForm.getEndPoint().trim().equals("")){
			Mensagem.setErroAtual(Mensagem.CAMPOS_NAO_PODEM_FICAR_EM_BRANCO);
		}else{
			EndPoint e = new EndPoint();
			e.setEndPoint(sEForm.getEndPoint());
			managerWS.setEndPoint(e);
		}
		return Mensagem.getErroAtual();
	}
	
	public void inputFileInDirectory(String name_file, byte[] retornoByte){
		CreateDirectoryAndInputFiles cD = new CreateDirectoryAndInputFiles();
		cD.inputFileInDirectory(name_file, retornoByte);
	}
}

