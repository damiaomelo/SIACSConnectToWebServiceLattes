package model.ws;

import model.business.CurriculoCompactado;
import model.business.CurriculoCompactadoPorUsuario;
import model.business.DataAtualizacaoCV;
import model.business.DataAtualizacaoCVPorUsuario;
import model.business.EndPoint;
import model.business.IdentificadorCNPq;
import model.business.IdentificadorCNPqPorUsuario;
import model.business.OcorrenciaCV;
import model.business.OcorrenciaCVPorUsuario;
import model.util.Mensagem;

public class ManagerWS {
	private static ManagerWS singleton = null;	
	
	private WSCurriculoProxy wscurriculopsroxy;
	
	public static ManagerWS getInstance() {
		if (singleton == null) {
			singleton = new ManagerWS();
		}
		return singleton;
	}

	private ManagerWS(){
		wscurriculopsroxy = new WSCurriculoProxy();
	}

	//#1
	public String getDataAtualizacaoCVPorUsuario(DataAtualizacaoCVPorUsuario d) {
		String temp;
		try{
			temp = wscurriculopsroxy.getDataAtualizacaoCVPorUsuario(d.getId(), d.getLogin());
		}catch(Exception e){
			temp = e.getMessage();
		}
		return temp;
	}
	
	//#2
	public String getDataAtualizacaoCV(DataAtualizacaoCV d) {
		String temp;
		try{
			temp = wscurriculopsroxy.getDataAtualizacaoCV(d.getId());
		}catch(Exception e){
			temp = e.getMessage();
		}
		return temp;
	}

	//3
	public byte[] getCurriculoCompactadoPorUsuario(CurriculoCompactadoPorUsuario c){
		byte[] temp;
		try{
			temp = wscurriculopsroxy.getCurriculoCompactadoPorUsuario(c.getId(), c.getLogin());
		}catch (Exception e) {
			temp =  null;
		}
		return temp;
	}
	
	//4
	public byte[] getCurriculoCompactado(CurriculoCompactado c){
		byte[] temp;
		try{
			temp = wscurriculopsroxy.getCurriculoCompactado(c.getId());
		}catch (Exception e) {
			temp = null;
		}
		return temp;
	}
	
	//5
	public String getIdentificadorCNPQPorUsuario(IdentificadorCNPqPorUsuario i) {
		String temp;
		try{
			temp = wscurriculopsroxy.getIdentificadorCNPqPorUsuario(i.getCpf(), i.getNome_completo(), i.getDt_nascimento(), i.getLogin());
		}catch(Exception e){
			temp = e.getMessage();
		}	
		return temp;
	}
	
	//#6
	public String getIdentificadorCNPQ(IdentificadorCNPq i) {
		String temp;
		try{
			temp = wscurriculopsroxy.getIdentificadorCNPq(i.getCpf(), i.getNome_completo(), i.getDt_nascimento());
		}catch(Exception e){
			temp = e.getMessage();
		}	
		return temp;
	}

	//#7
	public String getOcorrenciaCVPorUsuario(OcorrenciaCVPorUsuario o) {
		String temp;
		try{
			temp = wscurriculopsroxy.getOcorrenciaCVPorUsuario(o.getId(), o.getLogin());
		}catch(Exception e){
			temp = e.getMessage();
		}	
		return temp;
	}
	
	//#8
	public String getOcorrenciaCV(OcorrenciaCV o) {
		String temp;
		try{
			temp = wscurriculopsroxy.getOcorrenciaCV(o.getId());
		}catch(Exception e){
			temp = e.getMessage();
		}	
		return temp;
	}
	
	//#9
	public int setEndPoint(EndPoint e){
		wscurriculopsroxy.setEndpoint(e.getEndPoint());
		Mensagem.setErroAtual(Mensagem.SEM_ERRO);
		return Mensagem.getErroAtual();
	}
	
	
}
