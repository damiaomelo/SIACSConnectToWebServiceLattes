package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.Operacao;
import model.util.Mensagem;

import controller.AbstractCommand;

public class VerificarOperacao extends AbstractCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frm_operacao =  request.getParameter("comboBoxOperacao");
		
		Operacao op = new Operacao(frm_operacao);
		
		Mensagem.setErroAtual(Mensagem.SEM_ERRO);
		int retorno =  Mensagem.SEM_ERRO;
		
		//validation
		if(op.getNome().equals("getDataAtualizacaoCVPorUsuario")){
			op.setPage(Operacao.PAGE_GET_DATA_ATUALIZACAO_CV_POR_USUARIO);
		}else if(op.getNome().equals("getDataAtualizacaoCV")){
			op.setPage(Operacao.PAGE_GET_DATA_ATUALIZACAO_CV);
		}else if(op.getNome().equals("getCurriculoCompactadoPorUsuario")){
			op.setPage(Operacao.PAGE_GET_CURRICULO_COMPACTADO_POR_USUARIO);
		}else if (op.getNome().equals("getCurriculoCompactado")){
			op.setPage(Operacao.PAGE_GET_CURRICULO_COMPACTADO);
		}else if (op.getNome().equals("getIdentificadorCNPqPorUsuario")){
			op.setPage(Operacao.PAGE_GET_IDENTIFICADOR_CNPQ_POR_USUARIO);
		}else if (op.getNome().equals("getIdentificadorCNPq")){
			op.setPage(Operacao.PAGE_GET_IDENTIFICADOR_CNPQ);
		}else if (op.getNome().equals("getOcorrenciaCVPorUsuario")){
			op.setPage(Operacao.PAGE_GET_OCORRENCIA_CV_POR_USUARIO);
		}else if(op.getNome().equals("getOcorrenciaCV")){
			op.setPage(Operacao.PAGE_GET_OCORRENCIA_CV);
		}else if(op.getNome().equals("setEndpoint")){
			op.setPage(Operacao.PAGE_SET_ENDPOINT);
		}else{
			Mensagem.setErroAtual(Mensagem.SELECIONE_UMA_OPCAO);
			op.setPage(Operacao.PAGE_INDEX);
		}
		
		retorno = Mensagem.getErroAtual();
		request.setAttribute("retorno", retorno);
		request.getRequestDispatcher(op.getPage()).forward(request, response);

		
	}

}
