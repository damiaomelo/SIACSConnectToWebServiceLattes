package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.GetOcorrenciaCVPorUsuarioForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class GetOcorrenciaCVPorUsuario extends AbstractCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();
		
		String page = (String) request.getParameter("page");
		String frm_id = request.getParameter("frm_id");
		String frm_login = request.getParameter("frm_login");
		
		GetOcorrenciaCVPorUsuarioForm gOCVPorUsuarioForm = new GetOcorrenciaCVPorUsuarioForm();
		gOCVPorUsuarioForm.setId(frm_id);
		gOCVPorUsuarioForm.setLogin(frm_login);
		
		String retornoString = siacs.getOcorrenciaPorUsuarioCV(gOCVPorUsuarioForm);
		
		request.setAttribute("retornoString", retornoString);
		request.setAttribute("retorno", Mensagem.getErroAtual());
		request.getRequestDispatcher(page).forward(request, response);
	}
}
