package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.SetEndpointForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class SetEndPoint extends AbstractCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();

		String page = (String) request.getParameter("page");
		String frm_endpoint = request.getParameter("form_endpoint");
		
		int retorno = Mensagem.SEM_ERRO;
	
		SetEndpointForm sEForm =  new SetEndpointForm();
		sEForm.setEndPoint(frm_endpoint);
		
		retorno =  siacs.setEndPoint(sEForm);
		if (retorno != Mensagem.SEM_ERRO)
				page = "operacoes/setendpoint.jsp";
		
		request.setAttribute("retorno", retorno);
		request.getRequestDispatcher(page).forward(request, response);
	}
		
}


