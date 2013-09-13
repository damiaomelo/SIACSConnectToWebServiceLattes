package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.GetCurriculoCompactadoPorUsuarioForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class GetCurriculoCompactadoPorUsuario extends AbstractCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();
		
		String page = (String) request.getParameter("page");
		String frm_id = request.getParameter("frm_id");
		String frm_login = request.getParameter("frm_login");
		String name_file = request.getParameter("frm_id");
		
		GetCurriculoCompactadoPorUsuarioForm gCCPorUsuarioForm = new GetCurriculoCompactadoPorUsuarioForm();
		gCCPorUsuarioForm.setId(frm_id);
		gCCPorUsuarioForm.setLogin(frm_login);
		
		byte[] retornoByte = siacs.getCurriculoCompactadoPorUsuario(gCCPorUsuarioForm);

		if(retornoByte != null && retornoByte.length > 0){
			siacs.inputFileInDirectory(name_file, retornoByte);
		}		
		
		request.setAttribute("retornoByte", retornoByte);
		request.setAttribute("retorno", Mensagem.getErroAtual());
		request.getRequestDispatcher(page).forward(request, response);
	}

}
