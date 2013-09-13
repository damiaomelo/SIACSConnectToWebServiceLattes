package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.GetIdentificadorCNPqForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class GetIdentificadorCNPq extends AbstractCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();
		
		String page = (String) request.getParameter("page");
		String frm_cpf = request.getParameter("frm_cpf");
		String frm_nome_completo = request.getParameter("frm_nome_completo");
		String frm_dt_nascimento = request.getParameter("frm_dt_nascimento");
		
		GetIdentificadorCNPqForm gICForm = new GetIdentificadorCNPqForm();
		gICForm.setCpf(frm_cpf);
		gICForm.setNome_completo(frm_nome_completo);
		gICForm.setDt_nascimento(frm_dt_nascimento);
		
		String retornoString = siacs.getIdentificadorCNPq(gICForm);
		
		request.setAttribute("retornoString", retornoString);
		request.setAttribute("retorno", Mensagem.getErroAtual());
		request.getRequestDispatcher(page).forward(request, response);
	}
}
