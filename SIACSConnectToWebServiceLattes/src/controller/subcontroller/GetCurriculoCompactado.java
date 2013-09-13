package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.GetCurriculoCompactadoForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class GetCurriculoCompactado extends AbstractCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();
		
		String page = (String) request.getParameter("page");
		String frm_id = request.getParameter("frm_id");
		String name_file = request.getParameter("frm_id");
		
		GetCurriculoCompactadoForm gCCForm = new GetCurriculoCompactadoForm();
		gCCForm.setId(frm_id);
		
		byte[] retornoByte = siacs.getCurriculoCompactado(gCCForm);
		
		if(retornoByte != null && retornoByte.length > 0){
			siacs.inputFileInDirectory(name_file, retornoByte);
		}
           
		request.setAttribute("retorno", Mensagem.getErroAtual());
		request.getRequestDispatcher(page).forward(request, response);
	}

}
