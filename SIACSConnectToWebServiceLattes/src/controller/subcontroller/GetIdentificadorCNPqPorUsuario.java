package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.GetIdentificadorCNPqPorUsuarioForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class GetIdentificadorCNPqPorUsuario  extends AbstractCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();
		
		String page = (String) request.getParameter("page");
		String frm_cpf = request.getParameter("frm_cpf");
		String frm_nome_completo = request.getParameter("frm_nome_completo");
		String frm_dt_nascimento = request.getParameter("frm_dt_nascimento");
		String frm_login = request.getParameter("frm_login");
		
		GetIdentificadorCNPqPorUsuarioForm gICPUForm = new GetIdentificadorCNPqPorUsuarioForm();
		gICPUForm.setCpf(frm_cpf);
		gICPUForm.setNome_completo(frm_nome_completo);
		gICPUForm.setDt_nascimento(frm_dt_nascimento);
		gICPUForm.setLogin(frm_login);
		
		String retornoString = siacs.getIdentificadorCNPqPorUsuario(gICPUForm);
		
		request.setAttribute("retornoString", retornoString);
		request.setAttribute("retorno", Mensagem.getErroAtual());
		request.getRequestDispatcher(page).forward(request, response);
	}
}
